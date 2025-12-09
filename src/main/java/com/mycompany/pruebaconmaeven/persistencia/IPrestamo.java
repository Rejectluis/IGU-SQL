
package com.mycompany.pruebaconmaeven.persistencia;

import com.mycompany.pruebaconmaeven.logica.Prestamo;
import java.util.List;

public interface IPrestamo {
    
    public void crearPrestamo(Prestamo prestamo);
    
    public void eliminarPrestamo(int id);
    
    public void editarPrestamo(Prestamo prestamo);
    
    public Prestamo traerPrestamo(int id);
    
    public List<Prestamo> traerListaPrestamos();
    
    public boolean UsuarioSuperaLimitePrestamos(int id);
    
    public boolean LibroTieneEjemplaresDisponibles(String codigoLibro);
    
//    public void crearTransaccionDePrestamo(String dni, String codigoLibro, Integer traerIdPorDni);


    
}
