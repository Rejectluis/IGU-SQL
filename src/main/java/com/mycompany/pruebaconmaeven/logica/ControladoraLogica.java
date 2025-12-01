
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
    
    public void eliminarUsuario(int id){     
        controlPersis.eliminarUsuario(id);  
    }                                       
    
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
        boolean comproExitosa = this.dependencias.validarDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);
        
        if(!comproExitosa){
            return;
        }
        
        crearLibroYEjemplares(new Libro(Integer.parseInt(codigoLibro), titulo, autor, Integer.parseInt(publicacion), Integer.parseInt(paginas)),Integer.parseInt(ejemplares));
        showInformativeMessage("¡Se guardó correctamente con inyeccion!", "Info", "¡Guardado exitoso!");
    }
    
    public void guardarModificacion(Libro libro, String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {
        boolean comproExitosa = this.dependencias.validarDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);
        
        if(!comproExitosa){
            return;
        }
        
        //validación faltante: que el codigo del libro no esté usado ya: implementar
        
        controlPersis.editarLibro(setearDatos(libro, autor, codigoLibro, ejemplares, paginas, publicacion, titulo));
        showInformativeMessage("!Se actualizó el libro correctamente!", "Info", "¡Actualización de datos exitosa!");
        controlPersis.modificarEjemplar(libro, ejemplares);
    }

    //----------------------------------------------------------- igu.Usuario ------------------------------------------------------------------------------------------------------------------------------------//

    public void guardarUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono) {
      boolean comproExitosa = this.dependencias.validarDatosUsuario(ape_materno, ape_paterno, dni, email, nombre, telefono);

      if(!comproExitosa){
        return; 
      }

      Usuario user = new Usuario(dni, nombre, ape_paterno, ape_materno, email, telefono);
      crearUsuario(user);
      showInformativeMessage("¡Se guardó el usuario correctamente!", "Info", "¡Guardado exitoso!");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //----------------------------------------------------------------------- Métodos de mensajes (información, aleta, etc)-----------------------------------------------
    
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
    
    
    
}
