
package com.mycompany.pruebaconmaeven.logica.validadores;

import com.mycompany.pruebaconmaeven.Interfaces.validaciones.IValidador;
import com.mycompany.pruebaconmaeven.logica.Usuario;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class UsuarioValidador implements IValidador<Usuario>{
    
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
    public boolean validar(Usuario entidad) {
        return false;
    }
    //---------------------------------------------------------------------- Métodos de IValidador --------------------------------------------------------------------------------------------------------//

    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //                                                                      Métodos independientes                                                                                                         //
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    
    public boolean validacionesParaCargarDatosUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono){
        
        // ------------------------------------------------------ 1. Validación de campos obligatorios 
        if (nombre.trim().isEmpty() || ape_paterno.trim().isEmpty() || dni.trim().isEmpty() || email.trim().isEmpty()) {
            showInformativeMessage("ERROR: Los campos Nombre, Apellido Paterno, DNI y Email son obligatorios.", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------ 2. Validación de formato de DNI (Suponemos 8 dígitos numéricos)
        if (!dni.matches("\\d{8,12}")) {
            showInformativeMessage("ERROR: El DNI debe contener solo números (entre 8 y 12 dígitos).", "Error", "Error de validación");
            return false;
        }

        // ------------------------------------------------------ 3. Validación de formato de Email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!email.matches(emailRegex)) {
            showInformativeMessage("ERROR: El formato del correo electrónico es inválido.", "Error", "Error de validación");
            return false;
        }

        // ------------------------------------------------------ 4. Validación de formato de Teléfono (Opcional si no es obligatorio)
        if (!telefono.trim().isEmpty() && !telefono.matches("\\d+")) {
             showInformativeMessage("ERROR: El campo Teléfono solo debe contener números.", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------ 5. Validación de Longitud (Basado en la BD)
        if (nombre.length() > 200 || ape_paterno.length() > 200 || ape_materno.length() > 200) {
            showInformativeMessage("ADVERTENCIA: Nombre o apellidos exceden la longitud máxima permitida (200 caracteres).", "Error", "Error de validación");
            return false;
        }
        return true; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
