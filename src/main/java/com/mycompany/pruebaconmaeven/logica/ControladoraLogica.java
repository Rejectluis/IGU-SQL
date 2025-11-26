
package com.mycompany.pruebaconmaeven.logica;

import com.mycompany.pruebaconmaeven.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    ////////////////////////////////////////////////////////    Usuarios   //////////////////////////////////////////////////////////////////////////
    public void crearUsuario(Usuario user){
        controlPersis.crearUsuario(user);
    }
    
    public void eliminarUsuario(int id){    // NO USAR -> Para desactivar usuarios, libros, registros o préstamos se cambia el estado. 
        controlPersis.eliminarUsuario(id);  // Esto con la finalidad de que no haya errores de relaciones. Si elimino un registro padre
    }                                       // el registro hijo ya no tendrá la referencia a la PK del registro padre, lo que lleva a un error.
    
    public void editarUsuario(Usuario user){
        controlPersis.editarUsuario(user);
    }
    
    public Usuario traerUsuario(int id){
        
        return controlPersis.traerUsuario(id);
    }
    
    public ArrayList<Usuario> traerListaUsuarios(){
        return controlPersis.traerListaUsuarios();
    }
    
    /////////////////////////////////////////////////////////   Libro   ////////////////////////////////////////////////////////////////////////////

    public void crearLibroYEjemplares(Libro libro, int cantidad){
        controlPersis.crearLibro(libro);
        
        for(int i=1; i<= cantidad;i++){
            Ejemplar ejemplar = new Ejemplar(libro);
            controlPersis.crearEjemplar(ejemplar);
        }
        
    }
    
    public void eliminarLibro(int id){
        controlPersis.eliminarLibro(id);
    }
    
    public void editarLibro(Libro libro){
        controlPersis.editarLibro(libro);
    }
    
    public Libro traerLibro(int id){
        
        return controlPersis.traerLibro(id);
    }
    
    public ArrayList<Libro> traerListaLibros(){
        return controlPersis.traerListaLibros();
    }
    
    //////////////////////////////////////////////////////////      Ejemplar    ////////////////////////////////////////////////////////////////////////////
    
    public void crearEjemplar(Ejemplar ejemplar){
        controlPersis.crearEjemplar(ejemplar);
                                                        
    }
    
    public void eliminarEjemplar(int id){
        controlPersis.eliminarEjemplar(id);
    }
    
    public void editarEjemplar(Ejemplar ejemplar){
        controlPersis.editarEjemplar(ejemplar);
    }
    
    public Ejemplar traerEjemplar(int id){
        
        return controlPersis.traerEjemplar(id);
    }
    
    public ArrayList<Ejemplar> traerListaEjemplares(){
        return controlPersis.traerListaEjemplares();
    }
    
    //////////////////////////////////////////////////////////      Prestamo    ////////////////////////////////////////////////////////////////////////////
    
    public void crearPrestamo(Prestamo prestamo){
        controlPersis.crearPrestamo(prestamo);
    }
    
    public void eliminarPrestamo(int id){     
        controlPersis.eliminarPrestamo(id); 
    }                                      
    
    public void editarPrestamo(Prestamo prestamo){
        controlPersis.editarPrestamo(prestamo);
    }
    
    public Prestamo traerPrestamo(int id){
        
        return controlPersis.traerPrestamo(id);
    }
    
    public List<Prestamo> traerListaPrestamos(){
        return controlPersis.traerListaPrestamos();
    }

}
