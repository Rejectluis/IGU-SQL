
package inyeccion;

import com.mycompany.pruebaconmaeven.Interfaces.validaciones.IValidador;
import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.logica.Usuario;
import com.mycompany.pruebaconmaeven.logica.validadores.LibroValidador;
import com.mycompany.pruebaconmaeven.logica.validadores.UsuarioValidador;


public class InversionDependency {
    private final IValidador<Libro> libroValidador;
    private final IValidador<Usuario> usuarioValidador;
    
    public InversionDependency() {
        this.libroValidador = new LibroValidador();
        this.usuarioValidador = new UsuarioValidador();
    }

    public InversionDependency(IValidador<Libro> libroValidador,IValidador<Usuario> usuarioValidador) {
        this.libroValidador = new LibroValidador();
        this.usuarioValidador = new UsuarioValidador();
    }

    public IValidador<Libro> getLibroValidador() {return libroValidador;}
    public IValidador<Usuario> getUsuarioValidador() {return usuarioValidador;}
    
    //---------------------------------------------------------------- Métodos auxiliares para validación de datos ----------------------------------------------------------------------------------------//
    
    
    public boolean validarDatosLibro(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo){                                   //-- Explicación del métdo--//
        IValidador<Libro> validadorGenerico = this.getLibroValidador();                                                                         // -> se obtiene la instancia del validador de Libros. Se recibe como la interfaz genérica IValidador<Libro>: this.getLibroValidador(); --> este método devuelve la instancia de la clase concreta LibroValidador (new LibroValidador()): Es decir, la misma que fue creada en el constructor
        
        if(!(validadorGenerico instanceof LibroValidador)){                                                                                     // -> se verifica que la instancia obtenida sea efectivamente de la clase concreta que necesitamos.                                        
            //showInformativeMessage("ERROR: No se pudo cargar el validador de Libro.", "Error", "Error de inyección");
            return false;
        }
    
        LibroValidador validadorStrings = (LibroValidador) validadorGenerico;                                                                   // -> Se convierte el tipo genérico (IValidador<Libro>) al tipo concreto (LibroValidador). Esto es necesario para poder llamar al método validar(String...) que no está en la interfaz         
        return validadorStrings.validar(autor, codigoLibro, ejemplares, paginas, publicacion, titulo);                                          // -> El método validarDatosLibro delega la tarea real de validación al objeto LibroValidador. Este método ejecuta toda la lógica de validación de formato/rango y devuelve el resultado
    }
    
    public boolean validarDatosUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono){       // -> Aplica la misma idea del método validarDatosLibro
        IValidador<Usuario> validadorGenerico = this.getUsuarioValidador();
    
        if(!(validadorGenerico instanceof UsuarioValidador)){
            //showInformativeMessage("ERROR: No se pudo cargar el validador de Usuario.", "Error", "Error de inyección");
            return false;
        }

        UsuarioValidador validadorStrings = (UsuarioValidador) validadorGenerico;
        return validadorStrings.validacionesParaCargarDatosUsuario(ape_materno, ape_paterno, dni, email, nombre, telefono);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
