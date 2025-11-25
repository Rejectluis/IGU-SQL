
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.logica.Usuario;
import com.mycompany.pruebaconmaeven.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UsuarioJpaController controller1 = new UsuarioJpaController();
    LibroJpaController controller2 = new LibroJpaController();
    EjemplarJpaController controller3 = new EjemplarJpaController();
    
    //----------------------------------------------------------------   Usuarios    ------------------------------------------------------
    public void crearUsuario(Usuario user) {
        controller1.create(user);
    }

    public void eliminarUsuario(int id) {
        try {
            controller1.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(Usuario user) {
        try {
            controller1.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return controller1.findUsuario(id);
    }

    public ArrayList<Usuario> traerListaUsuarios() {
        
        List <Usuario> listaUsers = controller1.findUsuarioEntities();
        ArrayList <Usuario> arraylistUsers = new ArrayList<Usuario> (listaUsers);
        
        return arraylistUsers;
    }
    
    //----------------------------------------------------------------     Libro   --------------------------------------------------------
    public void crearLibro(Libro libro) {
        controller2.create(libro);
    }

    public void eliminarLibro(int id) {
        try {
            controller2.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLibro(Libro libro) {
        try {
            controller2.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro traerLibro(int id) {
        return controller2.findLibro(id);
    }

    public ArrayList<Libro> traerListaLibros() {
        
        List<Libro> libroLista = controller2.findLibroEntities();
        ArrayList<Libro> listaLibros = new ArrayList<Libro> (libroLista);
        
        return listaLibros;
    }
    
    //----------------------------------------------------------------    Ejemplar    -------------------------------------------------

    public void crearEjemplar(Ejemplar ejemplar) {
        controller3.create(ejemplar);
    }
        
    public void eliminarEjemplar(int id) {
        try {
            controller3.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarEjemplar(Ejemplar ejemplar) {
        try {
            controller3.edit(ejemplar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ejemplar traerEjemplar(int id) {
        return controller3.findEjemplar(id);
    }

    public LinkedList<Ejemplar> traerListaEjemplares() {
        
        List<Ejemplar> listaEjemplar = controller3.findEjemplarEntities();
        LinkedList<Ejemplar> ejemList = new LinkedList<Ejemplar>(listaEjemplar);
        
        return ejemList;
    }


    


    
}
