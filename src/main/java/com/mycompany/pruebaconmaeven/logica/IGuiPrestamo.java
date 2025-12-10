
package com.mycompany.pruebaconmaeven.logica;

import java.util.List;

public interface IGuiPrestamo {

    public boolean crearPrestamo(String dniUsuario, String codigoLibro);

    public String LibroPrestado(String CodigoLibro);

    public String UsuarioDeudor(int dni);
    
    public List<Object[]> mostrarRegistrosDePrestamos(String dni);

    public void RegresarPrestamo(int idPrestamo);
}
