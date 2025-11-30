
package com.mycompany.pruebaconmaeven.logica;

import com.mycompany.pruebaconmaeven.Interfaces.validaciones.IValidador;
import com.mycompany.pruebaconmaeven.logica.validadores.LibroValidador;
import com.mycompany.pruebaconmaeven.logica.validadores.UsuarioValidador;
import com.mycompany.pruebaconmaeven.persistencia.ControladoraPersistencia;
import inyeccion.InversionDependency;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis = null; 
    private InversionDependency dependencias; 

    public ControladoraLogica() {
        this.dependencias = new InversionDependency();
        this.controlPersis = new ControladoraPersistencia();
    }

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
        boolean comproExitosa = comprobacionDeDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);
        
        if(!comproExitosa){
            return;
        }
        
        //validación faltante: que el codigo del libro no esté usado ya: implementar
        
        controlPersis.editarLibro(setearDatos(libro, autor, codigoLibro, ejemplares, paginas, publicacion, titulo));
        showInformativeMessage("!Se actualizó el libro correctamente!", "Info", "¡Actualización de datos exitosa!");
        controlPersis.modificarEjemplar(libro, ejemplares);
       
    }
    
    public Libro setearDatos(Libro libro, String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo){
        int codi = Integer.parseInt(codigoLibro);
        int fecha = Integer.parseInt(publicacion);
        int pag = Integer.parseInt(paginas);
        
        libro.setAutor(autor);
        libro.setTitulo(titulo);
        libro.setNro_paginas(pag);
        libro.setAnno_publicacion(fecha);
        libro.setCodigo_libro(codi);
        return libro;
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
   
    public void guardarLibro(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {
        boolean comproExitosa = comprobacionDeDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);
        
        if(!comproExitosa){
            return;
        }
        
        crearLibroYEjemplares(new Libro(Integer.parseInt(codigoLibro), titulo, autor, Integer.parseInt(publicacion), Integer.parseInt(paginas)),Integer.parseInt(ejemplares));
        showInformativeMessage("¡Se guardó correctamente con inyeccion!", "Info", "¡Guardado exitoso!");
    }
    
    public boolean comprobacionDeDatosLibro(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo){
        IValidador<Libro> validadorGenerico = this.dependencias.getLibroValidador();
        if(!(validadorGenerico instanceof LibroValidador)){
            return false;
        }
    
        LibroValidador validadorStrings = (LibroValidador) validadorGenerico;
        boolean validacionStringsExitosa = validadorStrings.validar(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);
        
        if (!validacionStringsExitosa) {
            // 2. Si la validación falló (devuelve false), se sale del método void (el validador ya mostró el mensaje)
            return false;
        }
        return true;
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

    //----------------------------------------------------------- igu.Usuario ------------------------------------------------------------------------------------------------------------------------------------//

    public void guardarUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono) {
        
      boolean comproExitosa = comprobacionDeDatosUsuario(ape_materno, ape_paterno, dni, email, nombre, telefono);

      if(!comproExitosa){
        return; 
      }

      Usuario user = new Usuario(dni, nombre, ape_paterno, ape_materno, email, telefono);
      crearUsuario(user);
      showInformativeMessage("¡Se guardó el usuario correctamente!", "Info", "¡Guardado exitoso!");
    }
    
    public boolean comprobacionDeDatosUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono){
        IValidador<Usuario> validadorGenerico = this.dependencias.getUsuarioValidador();
    
        if(!(validadorGenerico instanceof UsuarioValidador)){

            showInformativeMessage("ERROR: No se pudo cargar el validador de Usuario.", "Error", "Error de inyección");
            return false;
        }

        UsuarioValidador validadorStrings = (UsuarioValidador) validadorGenerico;
    
        boolean validacionStringsExitosa = validadorStrings.validacionesParaCargarDatosUsuario(ape_materno, ape_paterno, dni, email, nombre, telefono);
    
        if (!validacionStringsExitosa) {
            // Si la validación falló (devuelve false), se sale del método. El validador ya mostró el mensaje.
            return false;
        }
        return true;
    }
    
        
}
