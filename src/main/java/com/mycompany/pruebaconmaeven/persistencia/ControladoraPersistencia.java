
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.logica.Prestamo;
import com.mycompany.pruebaconmaeven.logica.Usuario;
import com.mycompany.pruebaconmaeven.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.exceptions.ValidationException;

public class ControladoraPersistencia implements IControladoraPersistencia,IPrestamo,IUsuario,ILibro,IEjemplar{
    
    UsuarioJpaController controller1 = new UsuarioJpaController();
    LibroJpaController controller2 = new LibroJpaController();
    EjemplarJpaController controller3 = new EjemplarJpaController();
    PrestamoJpaController controller4 = new PrestamoJpaController();
    
    //----------------------------------------------------------------   Usuarios    ------------------------------------------------------
    @Override
    public void crearUsuario(Usuario user) {
        controller1.create(user);
    }

    @Override
    public void eliminarUsuario(int id) {
        try {
            controller1.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editarUsuario(Usuario user) {
        try {
            controller1.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario traerUsuario(int id) {
        return controller1.findUsuario(id);
    }

    @Override
    public ArrayList<Usuario> traerListaUsuarios() {
        
        List <Usuario> listaUsers = controller1.findUsuarioEntities();
        ArrayList <Usuario> arraylistUsers = new ArrayList<Usuario> (listaUsers);
        
        return arraylistUsers;
    }

    @Override
    public boolean existeUsuarioEnBD(String dni) {
        return controller1.existeUsuarioPorDni(dni);
    }
    
    @Override
    public boolean consultarEmailEnBD(String emailNuevo) {
        return controller1.existeUsuarioPorEmail(emailNuevo);
    }
    
    @Override
    public Integer traerIdPorDni(String dni) {
        return controller1.retornarIdPorDni(dni);
    }
    
    //----------------------------------------------------------------     Libro   --------------------------------------------------------
    @Override
    public void crearLibro(Libro libro) {
        controller2.create(libro);
    }

    @Override
    public void eliminarLibro(int id) {
        try {
            controller2.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editarLibro(Libro libro) {
        try {
            controller2.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Libro traerLibro(int id) {
        return controller2.findLibro(id);
    }

    @Override
    public ArrayList<Libro> traerListaLibros() {
        
        List<Libro> libroLista = controller2.findLibroEntities();
        ArrayList<Libro> listaLibros = new ArrayList<Libro> (libroLista);
        
        return listaLibros;
    }
    
    @Override
    public boolean existeCodigoLibroEnBD(int codigoLibro) {
        return controller2.codigoLibroExsiteEnBD(codigoLibro);
    }
    
    @Override
    public int traerIdPorCodigoLibro(String codigoLibro) {
        return controller2.traerIdPorCodigoLibro(codigoLibro);
    }
    
    //----------------------------------------------------------------    Ejemplar    -------------------------------------------------

    @Override
    public void crearEjemplar(Ejemplar ejemplar) {
        controller3.create(ejemplar);
    }
        
    @Override
    public void eliminarEjemplar(int id) {
        try {
            controller3.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editarEjemplar(Ejemplar ejemplar) {
        try {
            controller3.edit(ejemplar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Ejemplar traerEjemplar(int id) {
        return controller3.findEjemplar(id);
    }

    @Override
    public ArrayList<Ejemplar> traerListaEjemplares() {
        
        List<Ejemplar> listaEjemplar = controller3.findEjemplarEntities();
        ArrayList<Ejemplar> ejemList = new ArrayList<Ejemplar>(listaEjemplar);
        
        return ejemList;
    }
    
    @Override
    public void eliminarEjemplaresPorLibro(int idLibro){
        try {
            controller3.eliminarEjemplaresPorLibro(idLibro); 
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al eliminar ejemplares del libro ID " + idLibro, ex);
        }
    }
    
    
    @Override
    public List<Ejemplar> traerEjemplaresPorLibro(int idLibro) {
        return controller3.findEjemplaresByLibro(idLibro);
    }
    
    @Override
    public void modificarEjemplar(Libro libro, String ejemplares){
        try {
            controller3.modificarEjemplaresP(libro, ejemplares);
        } catch (ValidationException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean LibroTieneEjemplaresDisponibles(String codigoLibro) {
        return controller3.LibroTieneEjemplaresDisponibles(codigoLibro);
    }
    
    @Override
    public Ejemplar obtenerPrimerEjemplarDisponible(String codigoLibro) {
        return controller3.obtenerPrimerEjemplarDisponible(codigoLibro);
    }
    
    @Override
    public Long contarEjemplaresDisponibles(String codigoLibro) {
        return  controller3.contarEjemplaresDisponibles(codigoLibro);
    }
    
    
    //----------------------------------------------------------------    Prestamo    -------------------------------------------------

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        controller4.create(prestamo);
    }

    @Override
    public void eliminarPrestamo(int id) {
        try {
            controller4.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editarPrestamo(Prestamo prestamo) {
        try {
            controller4.edit(prestamo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Prestamo traerPrestamo(int id) {
        return controller4.findPrestamo(id);
    }

    @Override
    public List<Prestamo> traerListaPrestamos() {
        
        return controller4.findPrestamoEntities();
    }

    @Override
    public boolean verificarLibroPrestado(int idLibro){
        return controller4.libroTienePrestamos(idLibro);
    } 

    @Override
    public boolean UsuarioSuperaLimitePrestamos(int idUsuario) {
        return controller4.UsuarioSuperaLimitePrestamos(idUsuario);
    }

//    @Override
//    public void crearTransaccionDePrestamo(String dni, String codigoLibro, Integer traerIdPorDni) {
//        
//    }









}
