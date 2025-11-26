
package com.mycompany.pruebaconmaeven;

import com.mycompany.pruebaconmaeven.logica.ControladoraLogica;
import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import com.mycompany.pruebaconmaeven.logica.Libro;
import com.mycompany.pruebaconmaeven.logica.Prestamo;
import com.mycompany.pruebaconmaeven.logica.Usuario;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PruebaConMaeven {

    public static void main(String[] args) {
        ControladoraLogica control = new ControladoraLogica();
        
        
        //Crear la lista vacía
        LinkedList<Ejemplar> listaEjemplares = new LinkedList<Ejemplar>();
        
        //Crear la instancia libro con la lista de ejemplares vacía
        Libro libro = new Libro(102, "Cien años de soledad", "Gabriel GM", 1977, 376, listaEjemplares);
        
        //Guarda el libro en BD, crea la cantidad de ejemplares del libro y los guarda en la BD
        control.crearLibroYEjemplares(libro, 6);
        
        //Traer un libro de la bd
        //Libro liber = control.traerLibro(1);
        //System.out.println("Libro de id 3: \n"+liber.toString());
        
        //Crear un usuario
        List<Prestamo> prestamosList = new LinkedList<Prestamo>();
        Usuario usuario = new Usuario("81685005","Luis Fernando","Lopez Torres","Reyes", "luisfernandolopeztorresr@gmil.com", "953073099", prestamosList);
        
        //Cargar usuario a la BD
        control.crearUsuario(usuario);
        
        //Crear el prestamo 
        Prestamo prestamo = new Prestamo(control.traerUsuario(1), control.traerEjemplar(1));
        
        //Cargar el prestamo a la BD
        control.crearPrestamo(prestamo);
        
        //Traigo el prestamo de id 2
        Prestamo press = control.traerPrestamo(2);
        //Seteo la fecha de devolución real para indicar que ya se devolvió el libro
        press.setFecha_devolucion_real(LocalDate.now());
        press.setEstado(0); // 0 -> se devolvió el libro
        
        //Se edita el prestamo con la fecha de devolución y el estado inactivo 
        control.editarPrestamo(press);
        
    }
}