
package inyeccion;

import com.mycompany.pruebaconmaeven.Interfaces.validaciones.IValidador;
import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.logica.validadores.LibroValidador;



public class InversionDependency {
    private final IValidador<Libro> libroValidador;

    public InversionDependency() {
        this.libroValidador = new LibroValidador();
    }

    public InversionDependency(IValidador<Libro> libroValidador) {
        this.libroValidador = new LibroValidador();
    }

    public IValidador<Libro> getLibroValidador() {return libroValidador;}
    
    
}
