
package com.mycompany.pruebaconmaeven.logica;

import java.util.List;

public interface IGuiLibro {

    public void guardarLibro(String text, String text0, String text1, String text2, String text3, String text4);

    public void eliminarLibro(int id_libro);

    public Object[] pasarDatosDelLibro(int idLibro);

    public void guardarModificacionLibro(int idLibro, String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo);

    public List<Object[]> mostrarRegistrosDeLibros();
    
}
