
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Usuario;
import java.util.ArrayList;

public interface IUsuario {
    
    public void crearUsuario(Usuario user);

    public void eliminarUsuario(int id);

    public void editarUsuario(Usuario user);

    public Usuario traerUsuario(int id);

    public ArrayList<Usuario> traerListaUsuarios();
    
    public boolean existeUsuarioEnBD(String dni);

    public boolean consultarEmailEnBD(String email);
    
    public Integer traerIdPorDni(String dni);
    


}
