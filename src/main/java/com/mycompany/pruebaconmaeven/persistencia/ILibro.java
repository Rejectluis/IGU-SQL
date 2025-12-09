
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Libro;
import java.util.ArrayList;

public interface ILibro {
    
    public void crearLibro(Libro libro);
    
    public void editarLibro(Libro libro);

    public Libro traerLibro(int id);

    public ArrayList<Libro> traerListaLibros();
    
    public boolean existeCodigoLibroEnBD(int codigoLibro);
    
    public void modificarEjemplar(Libro libroOriginal, String ejemplaresNuevo);
    
    public boolean verificarLibroPrestado(int idLibro);
    
    public void eliminarEjemplaresPorLibro(int idLibro);

    public void eliminarLibro(int idLibro);
    
    public int traerIdPorCodigoLibro(String valueOf);

}
