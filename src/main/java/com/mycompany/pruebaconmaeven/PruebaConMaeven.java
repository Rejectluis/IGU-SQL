
package com.mycompany.pruebaconmaeven;


import com.mycompany.pruebaconmaeven.igu.Principal;
import com.mycompany.pruebaconmaeven.logica.ControladoraLogica;
import com.mycompany.pruebaconmaeven.persistencia.ControladoraPersistencia;
import com.mycompany.pruebaconmaeven.persistencia.IControladoraPersistencia;
import inyeccion.InversionDependency;

public class PruebaConMaeven {

    public static void main(String[] args) {
        
        //Se crea la única instancia de la implementación concreta 
        IControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        // se inyecta la dependencia de la clase IControladora a la clase InversionDependency
        InversionDependency dependencias = new InversionDependency(controlPersis);
        
        // se crea la instancia de controladoraLogica para inyectarla a la interfaz  «Principal»
        ControladoraLogica controller = new ControladoraLogica();
        
        //se setean las dependencias
        controller.setControl(controlPersis);
        controller.setDependencias(dependencias);
        
        //Se inyecta la dependencia de la clase  «ControladoraLogica» a la clase  «Principal»
        Principal ventana = new Principal(controller);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
          
         
        
    }
}