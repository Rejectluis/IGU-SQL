
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
    
    public void eliminarLibro(int idLibro)throws Exception {
        
        if(controlPersis.verificarLibroPrestado(idLibro)){
            throw new Exception("ERROR: El libro con ID " + idLibro + " no puede eliminarse porque tiene registros de préstamos asociados.");
        }
        
        try {
            controlPersis.eliminarEjemplaresPorLibro(idLibro);
            controlPersis.eliminarLibro(idLibro);
            JOptionPane.showMessageDialog(null,"Libro ID " + idLibro + " y todos sus ejemplares eliminados exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Fallo durante el proceso de eliminación en la base de datos." );
            throw new Exception("Error al ejecutar la eliminación del libro.", e);
        }
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
    

    public void guardarModificacion(Libro libro, String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {
        boolean cargaValida = validacionesParaCargarDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);
        if (!cargaValida){
            return;
        }
        
        int codi = Integer.parseInt(codigoLibro);
        int fecha = Integer.parseInt(publicacion);
        int pag = Integer.parseInt(paginas);
        int ejem = Integer.parseInt(ejemplares);
        
        libro.setAutor(autor);
        libro.setTitulo(titulo);
        libro.setNro_paginas(pag);
        libro.setAnno_publicacion(fecha);
        libro.setCodigo_libro(codi);
        
        controlPersis.editarLibro(libro);
        showInformativeMessage("!Se actualizó el libro correctamente!", "Info", "¡Actualización de datos exitosa!");
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
    
    public List<Ejemplar> traerEjemplaresPorLibro(int idLibro) {
        return controlPersis.traerEjemplaresPorLibro(idLibro);
    }
    
    public void modificarEjemplares(Libro libro, String nuevaCantidadEjemplar) {
        int ejemplaresCargados = libro.getEjemplareslist().size();
        int ejemplaresDeseados = Integer.parseInt(nuevaCantidadEjemplar);
        
        int diferencia = ejemplaresDeseados-ejemplaresCargados; // -> diferencia = 5 - 10 -> diferencia = -5 -> significa que a los ejemplares en la bd hay que restarles 5. Es decir, eliminar 5 ejemplares
                                                                // -> diferencia = 9 - 3 -> diferencia = 6 -> significa que a los ejemplares de la bd hay que sumarle 6.
                                                                // -> diferencia = 2 - 2 -> diferencia = 0 -> no pueden haber 0 ejemplares de un libro
        if (diferencia>0){
            Ejemplar ej = new Ejemplar(libro);
            for (int i=1; i<= diferencia;i++){
                crearEjemplar(ej);    
            }
            showInformativeMessage("!Edición completada", "Info", "Validación de datos");
            
        }else if (diferencia<0){
            int eAElminar = Math.abs(diferencia);
            List <Ejemplar> ejemplares = traerEjemplaresPorLibro(libro.getId_libro());
            
            int eliminados =0;
            for(Ejemplar ej: ejemplares){
                if(ej.getEstado()==1 && eliminados<eAElminar){
                    eliminarEjemplar(ej.getId_ejemplar());
                    
                    eliminados++;
                }
            }
            
            if(eliminados<eAElminar){
                showInformativeMessage("Solo se pudieron eliminar "+eliminados+" de "+eAElminar+"(Algunos están prstados)", "Info", "Datos parcialmente actualizados");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No es posible editar un libro con 0 ejemplares.","Dato no actualizado",JOptionPane.WARNING_MESSAGE);
        } 
        //Setear la nueva lista de ejemplares al objeto libro
        libro.setEjemplareslist(traerEjemplaresPorLibro(libro.getId_libro()));
        
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
    
    
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //                                                       Interfaces Gráficas                                                                                                                                //
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
        
    //----------------------------------------------------------- igu.Libro ------------------------------------------------------------------------------------------------------------------------------------//
    
    public void guardar(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {
        boolean cargaValida = validacionesParaCargarDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo); // se llama al método encargado de realizar las validaciones pertienentes antes de cargar los datos a la BD
        if (!cargaValida){
            return;
        }
        
        int codi = Integer.parseInt(codigoLibro);
        int fecha = Integer.parseInt(publicacion);
        int pag = Integer.parseInt(paginas);
        int ejem = Integer.parseInt(ejemplares);
        
        //--------------------- creación del libro y su carga a la BD -------------------------//
        
        Libro libro = new Libro(codi, titulo, autor, fecha, pag);
        crearLibroYEjemplares(libro,ejem);
        showInformativeMessage("¡Se guardó correctamente!", "Info", "¡Guardado exitoso!");
        //--------------------- creación del libro y su carga a la BD -------------------------//
    }
    
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

    public boolean validacionesParaCargarDatosLibro(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo){
         // ------------------------------------------------------ Validación 1 -> que el código del libro no esté vacío ni tenga más de 3 dígitos
        if(codigoLibro.trim().isEmpty() || !codigoLibro.matches("\\d{3}")){                                                                                                                                                                                           
            showInformativeMessage("ERROR: Formato inválido. El código debe ser de 3 dígitos", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------ Validación 2 -> que la fecha de publicación no esté vacía ni sea diferente de 4 dígitos
        if(publicacion.trim().isEmpty() || !publicacion.matches("\\d{4}")){
            showInformativeMessage("ERROR: Fecha de publicación no válida.", "Error", "Error de validación");
            return false;
        }
        
        //------------------------------------------------------- Validación 3 -> que la fecha de publicación no sea mayor al año actual
        int annoActual = java.time.LocalDate.now().getYear();
        if(Integer.parseInt(publicacion) > annoActual){
            showInformativeMessage("ERROR: La fecha no puede ser posterior al año actual", "Error", "Error de validación");
            return false;
        }

        //------------------------------------------------------- //Validación 4 -> que la variable páginas no esté vacía    
        if(paginas.trim().isEmpty()){                                                                                                                                                                           
            showInformativeMessage("ERROR: El número de páginas no puede estar vacío", "Error", "Error de validación");
            return false;
        }
        
        //------------------------------------------------------- //Validación 5 -> que el número de páginas sólo sea enteros
        if(!paginas.matches("\\d+")){                                                                                                                                                           
            showInformativeMessage("ERROR: Número de páginas no válido.", "Error", "Error de validación");
            return false;
        }
        
        //------------------------------------------------------- //Validación 6 -> que las páginas del libro no tengan valores absurdos. Como mínimo 10 y máximo 3000
        if(Integer.parseInt(paginas) < 10 || Integer.parseInt(paginas) >3000){
            showInformativeMessage("ERROR: Número de páginas no válido", "Error", "Erro de validación");
            return false;
        }
        
        //------------------------------------------------------- //Validación 7 -> que el numero de ejemplares no esté vacío
        if(ejemplares.trim().isEmpty() || !ejemplares.matches("\\d+")){
            showInformativeMessage("ERROR: Número de ejemplares no válido", "Error","Error de validación");
            return false;
        }
     
        // ------------------------------------------------------- //Validación 8 -> que los ejemplares no sean cero ni mayor que 20. Mínimo 1 ejemplar, como máximo 20
        if(Integer.parseInt(ejemplares) < 1 || Integer.parseInt(ejemplares) > 20){
            showInformativeMessage("ERROR: Límite permitido: 20 unidades", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------- //Validación 9 -> que los titulos y autores no sean vacíos
        if(autor.trim().isEmpty() || titulo.trim().isEmpty()){
            showInformativeMessage("ERROR: Título o autor no válidos", "Error", "Error de validación");
            return false;
        }
        return true;
    }









    
    
    
    
    
}
