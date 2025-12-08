
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.eclipse.persistence.exceptions.ValidationException;


public class EjemplarJpaController implements Serializable {
    
    public void showInformativeMessage(String message, String type, String title){
        JOptionPane opti = new JOptionPane(message);
        
        if(type.equals("Error")){
            opti.setMessageType(JOptionPane.ERROR_MESSAGE);
        }else if (type.equals("Info")){
            opti.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        
        JDialog dialog = opti.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public EjemplarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EjemplarJpaController() {
        emf = Persistence.createEntityManagerFactory("PruebaPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ejemplar ejemplar) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ejemplar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ejemplar ejemplar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ejemplar = em.merge(ejemplar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ejemplar.getId_ejemplar();
                if (findEjemplar(id) == null) {
                    throw new NonexistentEntityException("The ejemplar with id " + id + " no longer exists.");
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
            Ejemplar ejemplar;
            try {
                ejemplar = em.getReference(Ejemplar.class, id);
                ejemplar.getId_ejemplar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ejemplar with id " + id + " no longer exists.", enfe);
            }
            em.remove(ejemplar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ejemplar> findEjemplarEntities() {
        return findEjemplarEntities(true, -1, -1);
    }

    public List<Ejemplar> findEjemplarEntities(int maxResults, int firstResult) {
        return findEjemplarEntities(false, maxResults, firstResult);
    }

    private List<Ejemplar> findEjemplarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ejemplar.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ejemplar findEjemplar(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ejemplar.class, id);
        } finally {
            em.close();
        }
    }   

    public int getEjemplarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ejemplar> rt = cq.from(Ejemplar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void eliminarEjemplaresPorLibro(int idLibro) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            String jpql = "DELETE FROM Ejemplar e WHERE e.libro.id_libro = :idLibro";

            Query consulta = em.createQuery(jpql);
            consulta.setParameter("idLibro", idLibro);

            // Ejecutar la eliminación
            int registrosEliminados = consulta.executeUpdate();

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al eliminar ejemplares del libro ID " + idLibro, ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Ejemplar> findEjemplaresByLibro(int idLibro) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT e FROM Ejemplar e WHERE e.libro.id_libro = :idLibro");
            q.setParameter("idLibro", idLibro);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    /*
     *   diferencia = 5 - 10 -> diferencia = -5 -> significa que a los ejemplares en la bd hay que restarles 5. Es decir, eliminar 5 ejemplares
     *    diferencia = 9 - 3 -> diferencia = 6 -> significa que a los ejemplares de la bd hay que sumarle 6.
     *    diferencia = 2 - 2 -> diferencia = 0 -> no pueden haber 0 ejemplares de un libro
     */
    public void modificarEjemplaresP(Libro libro, String nuevaCantidadEjemplar)throws ValidationException, NonexistentEntityException {
        int ejemplaresCargados = libro.getEjemplareslist().size();
        int ejemplaresDeseados = Integer.parseInt(nuevaCantidadEjemplar);
        
        int diferencia = ejemplaresDeseados-ejemplaresCargados; 
        
        if (diferencia>0){
            Ejemplar ej = new Ejemplar(libro);
            for (int i=1; i<= diferencia;i++){
                create(ej);    
            }
            showInformativeMessage("!Edición completada", "Info", "Validación de datos");
        }else if (diferencia<0){
            int eAElminar = Math.abs(diferencia);
            List <Ejemplar> ejemplares = findEjemplaresByLibro(libro.getId_libro());
            
            int eliminados =0;
            for(Ejemplar ej: ejemplares){
                if(ej.getEstado()==1 && eliminados<eAElminar){
                    destroy(ej.getId_ejemplar());
                    
                    eliminados++;
                }
            }
            
            if(eliminados<eAElminar){
                showInformativeMessage("Solo se pudieron eliminar "+eliminados+" de "+eAElminar+"(Algunos están prstados)", "Info", "Datos parcialmente actualizados");
            }
        }   
    }
    
    public boolean LibroTieneEjemplaresDisponibles(String idLibroRegis){
        EntityManager em = getEntityManager();
        Long ejemplaresDisponibles = 0L;
        
        try {
            Query query = em.createQuery("SELECT COUNT(e) FROM Ejemplar e WHERE e.libro.id_libro = : idLibroRegis");
            query.setParameter("idLibroRegis", idLibroRegis);
            ejemplaresDisponibles = (Long)query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar disponibilidad de ejemplares para el ID: " + idLibroRegis, e);
        }finally{
            if(em !=null){
                em.close();
            }
        }
        return ejemplaresDisponibles>0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
