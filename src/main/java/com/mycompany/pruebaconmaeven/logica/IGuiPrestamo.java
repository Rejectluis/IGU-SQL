
package com.mycompany.pruebaconmaeven.logica;

import javax.swing.JTextField;

public interface IGuiPrestamo {

    public boolean crearPrestamo(String dniUsuario, String codigoLibro);

    public String LibroPrestado(JTextField txtCodigoLibro);

    public String UsuarioDeudor(int dni);

}
