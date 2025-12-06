
package com.mycompany.pruebaconmaeven.logica;

import java.util.List;

public interface IGuiUsuario {

    public void cargarUsuario(String apellidoPaterno, String apellidoMaterno, String dni, String email, String nombre, String telefono);

    public List<Object[]> mostrarRegistrosDeUsuario();

    public void guardarModificacion(int idUsuario,String apellidoPaterno, String apellidoMaterno, String dni, String email, String nombre, String telefono);

    public Object[] pasarDatosDelUsuario(int idUsuario);

    public void eliminarUsuario(int idUsuario);
    
}
