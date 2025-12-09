
package inyeccion;

import com.mycompany.pruebaconmaeven.logica.validadores.LibroValidador;
import com.mycompany.pruebaconmaeven.logica.validadores.PrestamoValidador;
import com.mycompany.pruebaconmaeven.logica.validadores.UsuarioValidador;
import com.mycompany.pruebaconmaeven.persistencia.IControladoraPersistencia;


public class InversionDependency {

    private final IControladoraPersistencia controlPersis;
    
    public InversionDependency(IControladoraPersistencia controlPersis) {
        this.controlPersis = controlPersis;
    }
    
    
    public LibroValidador getLibroValidador() {return new LibroValidador(this.controlPersis);}
    public UsuarioValidador getUsuarioValidador() {return new UsuarioValidador(this.controlPersis);}
    public PrestamoValidador getPrestamoValidador() {return new PrestamoValidador(this.controlPersis);}
    
    
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
   //                                                                 Libro -> Métodos auxiliares para validación de datos                                                                                      //
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    
    
    public boolean validarDatosLibro(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo){                                  
        LibroValidador validadorConcreto = this.getLibroValidador();
        return validadorConcreto.validar(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);                                          
    }
    
    public boolean validarCodigoLibro(String codigoLibroOriginal, String codigoLibroNuevo) {
        LibroValidador validadorConcreto = this.getLibroValidador();
        return validadorConcreto.validarCodigoLibro(codigoLibroOriginal, codigoLibroNuevo);
    }
    
    public boolean validarCodigo(String codigoLibro) {
        LibroValidador validadorConcreto = this.getLibroValidador();
        return validadorConcreto.validarCodigoLibro(codigoLibro);
    }
    
    public boolean existeCodigoLibroEnBD(int codigoLibro) {
        LibroValidador validadorConcreto = this.getLibroValidador();
        return validadorConcreto.validarExistenciaDeLibroEnBD(codigoLibro);
    }
    
    public boolean LibroTieneEjemplaresDisponibles(String codigoLibro) {
        LibroValidador validadorConcrto = this.getLibroValidador();
        return validadorConcrto.validarDisponibilidadDeEjemplares(codigoLibro);
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //                                                                 USUARIO -> Métodos auxiliares para validación de datos                                                                                      //
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    
    public boolean validarDatosUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono){
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.validacionesParaCargarDatosUsuario(ape_materno, ape_paterno, dni, email, nombre, telefono);
    }

    public boolean validarDni(String dniOriginal, String dniNuevo) {
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.validarDatoUniqueDni(dniOriginal, dniNuevo);
    }
    
    public boolean validarDni(String dni) {
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.dniValidador(dni);
    }

    public boolean validarEmail(String emailOriginal, String emailNuevo) {
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.validarDatoUniqueEmail(emailOriginal, emailNuevo);
    }
    
    public boolean consultarEmailEnBD(String emailNuevo) {
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.validarEmailEnBD(emailNuevo);
    }
    
    public boolean existeUsuarioEnBD(String dni) {
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.validarExistenciaDeDniEnBD(dni); 
    }
    
    public boolean UsuarioSuperaLimitePrestamos(int idPorDni) {
        UsuarioValidador validadorConcreto = this.getUsuarioValidador();
        return validadorConcreto.UsuarioSuperaLimitesDePrestamo(idPorDni);
    }
    
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
   //                                                                 Préstamo -> Métodos auxiliares para validación de datos                                                                                      //
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//













    

    
    
    
    
    
    
    
    
    
    
    
    
}
