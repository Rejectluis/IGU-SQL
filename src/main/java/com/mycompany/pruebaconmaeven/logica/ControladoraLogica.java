
package com.mycompany.pruebaconmaeven.logica;

import com.mycompany.pruebaconmaeven.persistencia.ControladoraPersistencia;
import inyeccion.InversionDependency;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ControladoraLogica implements IControladora{
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
    
    @Override
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
    
    
    @Override
    public void eliminarLibro(int idLibro){
        if(controlPersis.verificarLibroPrestado(idLibro)){
            JOptionPane.showMessageDialog(null, "ERROR: El libro con ID "+idLibro+" no puede eliminarse porque tiene registros de préstamos asociados.",
                "Error al eliminar un libro", JOptionPane.WARNING_MESSAGE);
        }
        try {
            controlPersis.eliminarEjemplaresPorLibro(idLibro);
            controlPersis.eliminarLibro(idLibro);
            JOptionPane.showMessageDialog(null,"Libro ID " + idLibro + " y todos sus ejemplares eliminados exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Fallo durante el proceso de eliminación en la base de datos." );
        }
    }
    
    public void editarLibro(Libro libro){
        controlPersis.editarLibro(libro);
    }
    
    public Libro traerLibro(int id){
        
        return controlPersis.traerLibro(id);
    }
    
    
    public ArrayList<Libro> listarLibros(){
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
   
    /*
    *   El método se encarga de guardar los datos del libro en la base de datos. Al empezar, el primer if se encarga de verificar
    *   que los strings enviados desde la interfaz gráfica de «A_NuevoLibro» sean datos válidos. Si no son válidos se termina
    *   el ciclo de vida del método. Lo mismo sucede con el método override GuardarModificaciónLibro.
    */
    @Override
    public void guardarLibro(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {        
        if(!(this.dependencias.validarDatosLibro(autor, codigoLibro, ejemplares, paginas, publicacion, titulo))){
            return;
        }
        
        if(this.controlPersis.codigoLibroExisteBD(Integer.parseInt(codigoLibro))){
            showInformativeMessage("El código del libro ingresado ya está registrado", "Error", "Error en el ingreso de datos");
            return;
        }
        
        crearLibroYEjemplares(new Libro(Integer.parseInt(codigoLibro), titulo, autor, Integer.parseInt(publicacion), Integer.parseInt(paginas)),Integer.parseInt(ejemplares));
        showInformativeMessage("¡Libro guardado correctamente!", "Info", "¡Guardado exitoso!");
    }
    
    @Override
    public void guardarModificacionLibro(int idLibro, String autorNuevo, String codigoLibroNuevo, String ejemplaresNuevo, String paginasNuevas, String publicacionNueva, String tituloNuevo) {
        if(!(this.dependencias.validarDatosLibro(autorNuevo, codigoLibroNuevo, ejemplaresNuevo, paginasNuevas, publicacionNueva, tituloNuevo))){
            return;
        }
        
        Libro libroOriginal = controlPersis.traerLibro(idLibro);
        String codigoLibroOriginal = String.valueOf(libroOriginal.getCodigo_libro());
        
        if(this.dependencias.validarCodigoLibro(codigoLibroOriginal, codigoLibroNuevo)){
            if(this.controlPersis.codigoLibroExisteBD(Integer.parseInt(codigoLibroNuevo))){
                showInformativeMessage("El código del libro ingresado ya está registrado", "Error", "Error en el ingreso de datos");
                return;
            }
            libroOriginal.setCodigo_libro(Integer.parseInt(codigoLibroNuevo));
        }
        
        libroOriginal.setAutor(autorNuevo);
        libroOriginal.setNro_paginas(Integer.parseInt(paginasNuevas));
        libroOriginal.setAnno_publicacion(Integer.parseInt(publicacionNueva));
        libroOriginal.setTitulo(tituloNuevo);
        
        controlPersis.editarLibro(libroOriginal);
        controlPersis.modificarEjemplar(libroOriginal, ejemplaresNuevo);
        showInformativeMessage("!Se actualizó el libro correctamente!", "Info", "¡Actualización de datos exitosa!");

    }
    
    /*
    *   El método se encarga de traer los datos del libro desde la base de datos y transformarlo en una lista de objetos.
    *   Se hace de esta manera para que la igu de «A_oleccionLibro» no esté relacionada la clase Libro directamente.
    *   En su método «cargarTabla», la línea List<Object[]> libros = controller.mostrarRegistrosDeLibros(); " trae los datos
    *   de cada registro de libros, pero no está retornando datos de tipo Libro, sino datos de tipo List<Objet[]>
    */

    @Override
    public List<Object[]> mostrarRegistrosDeLibros() {
        
        List<Libro> liber = this.controlPersis.traerListaLibros();    
        List<Object[]> datosTabla= new ArrayList<>();               
        
        if(liber !=null){                                             
            for(Libro e: liber){
                if(e.getEstado()==1){                               
                    Object[] registros = {
                        e.getId_libro(), 
                        e.getTitulo(),
                        e.getAutor(),
                        e.getAnno_publicacion(),
                        e.getEjemplareslist().size(),
                        e.getCodigo_libro()
                    };
                    datosTabla.add(registros);                          
                }
            }
        }
        return datosTabla;
    }
    
    /*
    *   El método se encarga de traer los datos del libro seleccionado en la interfaz «A_Coleccion» a la interfaz de
    *   «A_ModificarDatos» Se retorna un object[] para que la clase «A_ModificarDatos» no esté relacionada la clase 
    *    Libro directamente.
    */
    
    @Override
    public Object[] pasarDatosDelLibro(int idLibro) {
        
        Libro lib = controlPersis.traerLibro(idLibro);
        
        if(lib!=null){
            Object[] datos = {
                lib.getAutor(),
                lib.getCodigo_libro(),
                lib.getEjemplareslist().size(),
                lib.getNro_paginas(),
                lib.getAnno_publicacion(),
                lib.getTitulo()
            };
            return datos;
        }
        return null;
    }
    
    //----------------------------------------------------------- igu.Usuario ------------------------------------------------------------------------------------------------------------------------------------//
    
    /*
    *   El método es análogo al override de cargarLibro. Este encarga de guardar los datos del usuario en la base de datos.
    *   Al empezar, el primer if se encarga de verificar que los strings enviados (desde la interfaz gráfica de «NuevoUsuario»)
    *   sean datos válidos. Si no son válidos se termina el ciclo de vida del método. Lo mismo sucede con el método 
    *   "GuardarModificación".
    */

    @Override
    public void cargarUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono) {
        if(!(this.dependencias.validarDatosUsuario(ape_materno, ape_paterno, dni, email, nombre, telefono))){
            return; 
        }
        
        if(controlPersis.consultarDniEnBD(dni)){
            showInformativeMessage("El DNI ingresado ya está registrado", "Error", "Error en el ingreso de datos");
            return;
        }
        if(controlPersis.consultarEmailEnBD(email)){
            showInformativeMessage("El email ingresado ya está registrado", "Error", "Error en el ingreso de datos");
            return;
        }

      Usuario user = new Usuario(dni, nombre, ape_paterno, ape_materno, email, telefono);
      crearUsuario(user);
      showInformativeMessage("¡Se guardó el usuario correctamente!", "Info", "¡Guardado exitoso!");
        
    }
    
    @Override
    public void guardarModificacion(int idUsuario,String apellidoPaternoNuevo, String apellidoMaternoNuevo, String dniNuevo, String emailNuevo, String nombreNuevo, String telefonoNuevo) {
        if(!(this.dependencias.validarDatosUsuario(apellidoMaternoNuevo, apellidoPaternoNuevo, dniNuevo, emailNuevo, nombreNuevo, telefonoNuevo))){
            return; 
        }
        
        Usuario usuarioOriginal = this.controlPersis.traerUsuario(idUsuario);
        
        String dniOriginal = usuarioOriginal.getDni();
        String emailOriginal = usuarioOriginal.getEmail();
        
        if(this.dependencias.validarDni(dniOriginal, dniNuevo)){                                                              // -> true: significa que sí se desea editar el dni
            if(controlPersis.consultarDniEnBD(dniNuevo)){
                showInformativeMessage("El DNI ingresado ya está registrado", "Error", "Error en el ingreso de datos");
                return;
            }
            usuarioOriginal.setDni(dniNuevo);
        }
        
        if(this.dependencias.validarEmail(emailOriginal, emailNuevo)){                                                        // -> true: significa que sí se desea editar el email         
            if(controlPersis.consultarEmailEnBD(emailNuevo)){
                showInformativeMessage("El email ingresado ya está registrado", "Error", "Error en el ingreso de datos");
                return;
            }
            usuarioOriginal.setEmail(emailNuevo);
        }
        
        usuarioOriginal.setApe_paterno(apellidoPaternoNuevo);
        usuarioOriginal.setApe_materno(apellidoMaternoNuevo);
        usuarioOriginal.setNombre(nombreNuevo);
        usuarioOriginal.setTelefono(telefonoNuevo);
        
        this.controlPersis.editarUsuario(usuarioOriginal);
        showInformativeMessage("¡Usuario editado con éxito!", "Info","!Actualización de datos ralizada!");
    }
    
    /*
    *   Análogamente al método override de mostrarRegistrosDeLibros, este encarga de traer los registros de usuario 
    *   para mostrarlos en la seccion de Coleccion de usuarios. Se retorna una lista de tipo Object[] para que la clase
    *   de la interfaz gráfica («VerDatosUusario») no esté relacionada con la clase Usuario.
    */
    @Override
    public List<Object[]> mostrarRegistrosDeUsuario() {
        List<Usuario> user = this.controlPersis.traerListaUsuarios();       
        List<Object[]> datosTabla= new ArrayList<>();               
        
        if(user !=null){                                             
            for(Usuario e: user){
                if(e.getEstado()==1){                               
                    Object[] registros = {
                        e.getId_usuario(), 
                        e.getNombre(),
                        e.getApe_paterno(),
                        e.getApe_materno(),
                        e.getDni(),
                        e.getEmail(),
                        e.getTelefono()
                    };
                    datosTabla.add(registros);                          
                }
            }
        }
        return datosTabla;
    }
        
    /*
    *   El método funciona de igual manera que el método de pasarDatosDelLibro. Este se encarga de buscar los datos del usuario  
    *   seleccionado en la interfaz de coleccion («VerDatosUsuario»)y pasarlos a la interfaz de edición («ModificarDatosUsuario»). 
    *   También se retorna un Object [] para que ninguna clase de la interfaz esté directamente relacionada con las clases
    *    entidades (Libro, Usuario, Prestamo, etc).
    */
    
    @Override
    public Object[] pasarDatosDelUsuario(int idUsuario) {
        Usuario user = controlPersis.traerUsuario(idUsuario);
        
        if(user!=null){
            Object[] datos = {
                user.getNombre(),
                user.getApe_paterno(),
                user.getApe_materno(),
                user.getDni(),
                user.getEmail(),
                user.getTelefono()
            };
            return datos;
        }
        return null;
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
