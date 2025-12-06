
package com.mycompany.pruebaconmaeven.logica.validadores;

import com.mycompany.pruebaconmaeven.Interfaces.validaciones.IValidador;
import com.mycompany.pruebaconmaeven.logica.Libro;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LibroValidador implements IValidador<Libro>{

    public void showInformativeMessage(String message, String type, String title){
        JOptionPane opti = new JOptionPane(message);
        
        if(type.equals("Error")){
            opti.setMessageType(JOptionPane.ERROR_MESSAGE);
        }else if (type.equals("Info")){
            opti.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        
        JDialog dialog = opti.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
    //---------------------------------------------------------------------- Métodos de IValidador --------------------------------------------------------------------------------------------------------//
    @Override
    public boolean validar(Libro entidad) {
        return false;
    }
    //---------------------------------------------------------------------- Métodos de IValidador --------------------------------------------------------------------------------------------------------//
    
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //                                                                      Métodos independientes                                                                                                         //
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    
    public boolean validar(String autor, String codigoLibro, String ejemplares, String paginas, String publicacion, String titulo) {
         // ------------------------------------------------------ Validación 1 -> que el código del libro no esté vacío ni tenga más de 3 dígitos
        if(codigoLibro.trim().isEmpty() || !codigoLibro.matches("\\d{3}")){                                                                                                                                                                                           
            showInformativeMessage("ERROR: Formato inválido. El código debe ser de 3 dígitos", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------ Validación 2 -> que la fecha de publicación no esté vacía ni sea diferente de 4 dígitos
        if(publicacion.trim().isEmpty() || !publicacion.matches("\\d{4}")){
            showInformativeMessage("ERROR: Fecha de publicación no válida.", "Error", "Error de validación");
            return false;
        }
        
        //------------------------------------------------------- Validación 3 -> que la fecha de publicación no sea mayor al año actual
        int annoActual = java.time.LocalDate.now().getYear();
        if(Integer.parseInt(publicacion) > annoActual){
            showInformativeMessage("ERROR: La fecha no puede ser posterior al año actual", "Error", "Error de validación");
            return false;
        }

        //------------------------------------------------------- //Validación 4 -> que la variable páginas no esté vacía    
        if(paginas.trim().isEmpty()){                                                                                                                                                                           
            showInformativeMessage("ERROR: El número de páginas no puede estar vacío", "Error", "Error de validación");
            return false;
        }
        
        //------------------------------------------------------- //Validación 5 -> que el número de páginas sólo sea enteros
        if(!paginas.matches("\\d+")){                                                                                                                                                           
            showInformativeMessage("ERROR: Número de páginas no válido.", "Error", "Error de validación");
            return false;
        }
        
        //------------------------------------------------------- //Validación 6 -> que las páginas del libro no tengan valores absurdos. Como mínimo 10 y máximo 3000
        if(Integer.parseInt(paginas) < 10 || Integer.parseInt(paginas) >3000){
            showInformativeMessage("ERROR: Número de páginas no válido", "Error", "Erro de validación");
            return false;
        }
        
        //------------------------------------------------------- //Validación 7 -> que el numero de ejemplares no esté vacío
        if(ejemplares.trim().isEmpty() || !ejemplares.matches("\\d+")){
            showInformativeMessage("ERROR: Número de ejemplares no válido", "Error","Error de validación");
            return false;
        }
     
        // ------------------------------------------------------- //Validación 8 -> que los ejemplares no sean cero ni mayor que 20. Mínimo 1 ejemplar, como máximo 20
        if(Integer.parseInt(ejemplares) < 1 || Integer.parseInt(ejemplares) > 20){
            showInformativeMessage("ERROR: Límite permitido: 20 unidades", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------- //Validación 9 -> que los titulos y autores no sean vacíos
        if(autor.trim().isEmpty() || titulo.trim().isEmpty()){
            showInformativeMessage("ERROR: Título o autor no válidos", "Error", "Error de validación");
            return false;
        }
        return true;
    }

    public boolean validarCodigoLibro(String codigoLibroOriginal, String codigoLibroNuevo) {
        
        if(codigoLibroOriginal.equals(codigoLibroNuevo)){
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
}
