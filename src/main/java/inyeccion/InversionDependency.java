
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
    
    
}
