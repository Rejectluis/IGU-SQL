
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
    
    
    /*
    *   El método «validacionesParaCargarDatosUsuario» se encarga de hacer las validaciones de los inputs que se mandan desde la IGU
    *   NuevoUsuario. Valida casos como que los nombres, apellidos, email o dni no estén vacios, que el dni tenga solo dígitos entre
    *   8 y 12 dígitos. Todas las validaciones básicas se hacen acá.
    *
    */
    public boolean validacionesParaCargarDatosUsuario(String ape_materno, String ape_paterno, String dni, String email, String nombre, String telefono){
        
        // ------------------------------------------------------ 1. Validación de campos obligatorios 
        if (nombre.trim().isEmpty() || ape_paterno.trim().isEmpty() || dni.trim().isEmpty() || email.trim().isEmpty()) {
            showInformativeMessage("ERROR: Los campos Nombre, Apellidos, DNI y Email son obligatorios.", "Error", "Error de validación");
            return false;
        }
        
        // ------------------------------------------------------ 2. Validación de formato de DNI 
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
    }        //-> Antes de cargar los datos a la bd, el método verifica que no sean datos no incoherentes, como nombres vacíos, o strings en lugar de números.                                

    /*
    *   El método «validarDatoUniqueDni» se encarga de validar si el usuario desea editar el dni o no. 
    *   Se compara el dni registrado en la bd y el dni nuevo ingresado. De esta manera, se busca evitar
    *   reenviar el dni que ya existen en la base de datos una segunda vez: ¿Por qué? porque el dni es 
    *   es un atributo UNIQUE, si se envía de nuevo el dni que ya existe, podrá generar errores.
    */
    public boolean validarDatoUniqueDni(String dniOriginal, String dniNuevo) {
        if(dniOriginal.equals(dniNuevo)){
            return false;                           // -> false: significa que no se pretende editar dni 
        }
        return true;                               // -> true: significa que sí se desea editar el dni en la bd
    }
    
    /*
    *   El método «dniValidador» se encarga de validar si el dni del usuario que desea registrar para un prestamo nuevo
    *   no esté vacío ni sean valores enteros mayores a 12. Dado que el String dni puede llevar tanto el carnet de identidad
    *   como el carnet de extranjería u otro documento que identifique a la persona. Este métdo es llamado desde el override de
    *   crear un prestamo, en controladoraLogica, en la seccion de igu.Prestamos.
    */
    public boolean dniValidador(String dni) {
        if(dni.trim().isEmpty() || !dni.matches("\\d{8,12}")){
            showInformativeMessage("ERROR: El DNI debe contener solo números (entre 8 y 12 dígitos).", "Error", "Carnet de identidad no válido");
            return false;                                               // false -> si el dni está vacío o no es un entero de entre 8 o 12 dígitos 
        }
        return true;                                                    // true -> si el dni es válido
    }
    
    /*
    *   Este método «validarDatoUniqueEmail» funciona igual que el método «validarDatoUniqueDni». Este se encarga de validar si
    *   el usuario desea editar de verdad el email o no. Compara el email ya cargado en la base de datos con el nuevo email que el 
    *   usuario envió desde la clase «ModificarDatosUsuario», en el paquete igu.Usuario. La finalidad de este método es no enviar de 
    *   nuevo el mismo email que ya fue cargado en la base de datos: ¿Por qué? porque el email, así como el dni, es un atributo UNIQUE
    *   es decir, no puede existir más de un registro con el mismo email. Si se carga un email ya cargado a la base de datos podrá 
    *   arrojar errores, y la idea es que eso no suceda.
    */
    public boolean validarDatoUniqueEmail(String emailOriginal, String emailNuevo) {
        if(emailOriginal.equals(emailNuevo)){
            return false;                               // -> false: sigfnifica que no se pretende editar el email
        }
        return true;                                    // -> true: singifica que sí se pretende editar el email
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
