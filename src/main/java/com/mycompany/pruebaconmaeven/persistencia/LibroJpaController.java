package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public LibroJpaController() {
        emf = Persistence.createEntityManagerFactory("PruebaPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = libro.getId_libro();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getId_libro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
            Query q = em.createQuery(cq);
            q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            List <Libro> listaLibros = q.getResultList();
            for (Libro lib: listaLibros){
                em.refresh(lib);
            }
            
            return listaLibros;
        } finally {
              em.close();  
            }
        }

    public Libro findLibro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /* Método que crea una consulta JPQL para traer un libro desde ld BD con pregunta parcial o exacta -> estado actual: no usable/corregir
    public List<Libro> searchByCodeOrTitle(String terminoBusqueda){
        EntityManager em = getEntityManager();
        List<Libro> libros = null;
        
        String terminoLike = "%"+terminoBusqueda.toUpperCase()+"%";
        
        try {
            String jpql = "SELECT l FROM Libro l WHERE l.codigoLibro = :terminoExacto OR UPPER(l.tituloLibro) LIKE :terminoParcial";
            TypedQuery<Libro> consulta = em.createQuery(jpql, Libro.class);
            
            consulta.setParameter("terminoExacto", terminoBusqueda);
            consulta.setParameter("terminoParcial", terminoLike);
            
            libros = consulta.getResultList();
        } catch (Exception e) {
            
        }finally{
            if(em != null){
                em.close();
            }
        }
        return libros;
    }
    */ 
    
    public boolean codigoLibroExsiteEnBD(int codigoLibro){
        EntityManager em = getEntityManager();
        Long count =0L;
        
        try {
            String jpql = "SELECT COUNT(l) FROM Libro l WHERE l.codigo_libro = :codigoRegis";
            TypedQuery<Long> consulta = em.createQuery(jpql,Long.class);
            consulta.setParameter("codigoRegis", codigoLibro);

            count = consulta.getSingleResult();
            return count>0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar existencia del libro: " + e.getMessage(), "Error de Persistencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally {
            if (em != null) {
                em.close();
            }
        }   
    }
    
    /*
    *   Este método retorna el id de un libro con sólo conocer su código.
    */
    public Integer traerIdPorCodigoLibro(String codigoLibroRegis) {
        EntityManager em = getEntityManager();
        Integer idLibro = null;
        
        try {
            Query query = em.createQuery("SELECT l.id_libro FROM Libro l WHERE l.codigo_libro = :codigoLibroRegis");
            
            int codigoLibro = Integer.parseInt(codigoLibroRegis);
            query.setParameter("codigoLibroRegis", codigoLibro);
            idLibro = (Integer)query.getSingleResult();
        } catch (NoResultException e) {
            idLibro =null;
        } catch (Exception e){
            throw new RuntimeException("Error en la persistencia al buscar ID por código: " + codigoLibroRegis, e);
        }finally{
            if(em !=null){
                em.close();
            }
        }
        return idLibro;
    }

    
    
}
