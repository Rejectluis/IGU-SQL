
package com.mycompany.pruebaconmaeven;


import com.mycompany.pruebaconmaeven.igu.Principal;
import com.mycompany.pruebaconmaeven.logica.ControladoraLogica;



public class PruebaConMaeven {

    public static void main(String[] args) {
        ControladoraLogica controller = new ControladoraLogica();
        Principal ventana = new Principal(controller);
        
        
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        

        
    }
}