
package com.mycompany.pruebaconmaeven.logica;

import com.mycompany.pruebaconmaeven.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
    
        //////////////////////////////////////////////////////////      Interfaz Libro    ////////////////////////////////////////////////////////////////////////////

    public void guardar(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {
        // ------------------------------------------------------ Validación 1 -> que el código del libro no esté vacío ni tenga más de 3 dígitos
        if(codigoLibro.trim().isEmpty() || !codigoLibro.matches("\\d{3}")){                                                                                                                                                                                           
            JOptionPane.showMessageDialog(null, "ERROR: Formato inválido. El código debe ser de 3 dígitos","Error de validación",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codi = Integer.parseInt(codigoLibro);
        
        // ------------------------------------------------------ Validación 2 -> que la fecha de publicación no esté vacía ni sea diferente de 4 dígitos
        if(publicacion.trim().isEmpty() || !publicacion.matches("\\d{4}")){
            JOptionPane.showMessageDialog(null, "ERROR: Fecha de publicación no válida.","Error de validación",JOptionPane.ERROR_MESSAGE);                        
            return;
        }
        int fecha = Integer.parseInt(publicacion);
        
        //------------------------------------------------------- Validación 3 -> que la fecha de publicación no sea mayor al año actual
        int annoActual = java.time.LocalDate.now().getYear();
        if(fecha > annoActual){
            JOptionPane.showMessageDialog(null, "ERROR: La fecha no puede ser posterior al año actual", "Error de validación",JOptionPane.ERROR_MESSAGE);  
            return;
        }

        //------------------------------------------------------- //Validación 4 -> que la variable páginas no esté vacía    
        if(paginas.trim().isEmpty()){                                                                                                                                                                           
            JOptionPane.showMessageDialog(null, "ERROR: El número de páginas no puede estar vacío","Error de validación",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //------------------------------------------------------- //Validación 5 -> que el número de páginas sólo sea enteros
        if(!paginas.matches("\\d+")){                                                                                                                                                           
            JOptionPane.showMessageDialog(null, "ERROR: Número de páginas no válido.","Error de validación",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int pag = Integer.parseInt(paginas);
        
        //------------------------------------------------------- //Validación 6 -> que las páginas del libro no tengan valores absurdos. Como mínimo 10 y máximo 3000
        if(pag < 10 || pag >3000){
            JOptionPane.showMessageDialog(null, "ERROR: Número de páginas no válido","Erro de validación",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //------------------------------------------------------- //Validación 7 -> que el numero de ejemplares no esté vacío
        if(ejemplares.trim().isEmpty() || !ejemplares.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "ERROR: Número de ejemplares no válido","Error de validación",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int ejem = Integer.parseInt(ejemplares);
        
        // ------------------------------------------------------- //Validación 8 -> que los ejemplares no sean cero ni mayor que 20. Mínimo 1 ejemplar, como máximo 20
        if(ejem < 1 || ejem > 20){
            JOptionPane.showMessageDialog(null, "ERROR: Límite permitido: 20 unidades","Error de validación",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //--------------------- creación del libro y su carga a la BD -------------------------//
        
        Libro libro = new Libro(codi, titulo, autor, fecha, pag);
        crearLibroYEjemplares(libro,ejem);
        
        //--------------------- creación del libro y su carga a la BD -------------------------//
        
        JOptionPane exitoso = new JOptionPane("Se guardó correctamente");
        exitoso.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = exitoso.createDialog("¡Guardado exitoso!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        
    }

}
