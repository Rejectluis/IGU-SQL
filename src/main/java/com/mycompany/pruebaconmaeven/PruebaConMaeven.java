
package com.mycompany.pruebaconmaeven;

import com.mycompany.pruebaconmaeven.logica.ControladoraLogica;
import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import com.mycompany.pruebaconmaeven.logica.Libro;
import java.util.LinkedList;

public class PruebaConMaeven {

    public static void main(String[] args) {
        ControladoraLogica control = new ControladoraLogica();
        
        //Crear la lista vacía
        //LinkedList<Ejemplar> listaEjemplares = new LinkedList<Ejemplar>();
        
        //Crear la instancia libro con la lista de ejemplares vacía
        //Libro libro = new Libro(102, "Cien años de soledad", "Gabriel GM", 1977, 376, listaEjemplares);
        
        //Guarda el libro en BD, crea la cantidad de ejemplares del libro y los guarda en la BD
        //control.crearLibroYEjemplares(libro, 6);
        
        //Traer un libro de la bd
        Libro liber = control.traerLibro(1);
        System.out.println("Libro de id 3: \n"+liber.toString());
        
        
        
        
        
        
        
        
        
        
        
    }
}