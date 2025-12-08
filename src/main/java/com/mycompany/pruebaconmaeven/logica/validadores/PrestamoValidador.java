
package com.mycompany.pruebaconmaeven.logica.validadores;

import com.mycompany.pruebaconmaeven.Interfaces.validaciones.IValidador;
import com.mycompany.pruebaconmaeven.logica.Usuario;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PrestamoValidador implements IValidador<Usuario>{
    
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
    
    
    
    
    
    
    
}
