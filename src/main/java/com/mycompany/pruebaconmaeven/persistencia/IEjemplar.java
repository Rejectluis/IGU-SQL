
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Ejemplar;
import java.util.ArrayList;
import java.util.List;

public interface IEjemplar {
    
    public void crearEjemplar(Ejemplar ejemplar);

    public void eliminarEjemplar(int id);

    public void editarEjemplar(Ejemplar ejemplar);

    public Ejemplar traerEjemplar(int id);

    public ArrayList<Ejemplar> traerListaEjemplares();

    public List<Ejemplar> traerEjemplaresPorLibro(int idLibro);
    
    public Ejemplar obtenerPrimerEjemplarDisponible(String codigoLibro);
    
    public Long contarEjemplaresDisponibles(String codigoLibro);
}
