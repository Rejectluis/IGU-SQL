
package com.mycompany.pruebaconmaeven;

import com.mycompany.pruebaconmaeven.logica.ControladoraLogica;
import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import com.mycompany.pruebaconmaeven.logica.Libro;
import java.util.LinkedList;

public class PruebaConMaeven {

    public static void main(String[] args) {
        ControladoraLogica control = new ControladoraLogica();
        
        //Crear la lista vacía
        LinkedList<Ejemplar> listaEjemplares = new LinkedList<Ejemplar>();
        
        //Crear la instancia libro con la lista de ejemplares vacía
        Libro libro = new Libro(100, "It", "Stephan", 1999, 400, listaEjemplares);
        
        //Guardar el libro en la BD
        control.crearLibro(libro);

        
        //Crear la instancia de ejemplar
        Ejemplar ejemplar = new Ejemplar(libro);
        
        //Crear el registro de ejemplar en la base de datos
        control.crearEjemplar(ejemplar, 5);
        
        //Agregar a la lista los registros 
        LinkedList<Ejemplar> ejemLis = control.traerListaEjemplares();  
        for (Ejemplar e : ejemLis){
            if(e.getLibro().getId_libro() == libro.getId_libro()){
                listaEjemplares.add(e);
            }
        }
        
        //Editar libro:
        libro.setEjemplareslist(listaEjemplares);
        //Guardar los cambios en BD
        control.editarLibro(libro);
        
       
        
        
    }
}
