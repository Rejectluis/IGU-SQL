
package com.mycompany.pruebaconmaeven.igu;

import com.mycompany.pruebaconmaeven.logica.ControladoraLogica;
import com.mycompany.pruebaconmaeven.logica.Libro;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class A_ColeccionLibro extends javax.swing.JFrame implements IColeccion{
    
    ControladoraLogica controller=null;

    public A_ColeccionLibro() {
        controller = new ControladoraLogica();
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        BuscarLibro = new javax.swing.JTextField();

        jButton5.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jButton5.setText("Regresar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLibro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 36)); // NOI18N
        jLabel1.setText("Googloteca");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegresar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(93, 93, 93)
                .addComponent(btnEliminar)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        BuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarLibroActionPerformed(evt);
            }
        });
        BuscarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscarLibroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(BuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargartTabla(tablaLibro);
    }//GEN-LAST:event_formWindowOpened

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tablaLibro.getRowCount()>0){
            if(tablaLibro.getSelectedRow() != -1){
                int id_libro = Integer.parseInt(String.valueOf(tablaLibro.getValueAt(tablaLibro.getSelectedRow(), 0)));
                
                A_ModificarDatos pantallaModif = new A_ModificarDatos(id_libro);
                mostrarYCentrarPantalla(pantallaModif);
                
                this.dispose();  
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La tabla de libros está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaLibro.getRowCount() >0){ //cuenta cuántas filas hay -> para eliminar una fila debe haber al menos una fila, por eso el getRowCount()
            if(tablaLibro.getSelectedRow() !=-1){ // selecciona la fila que va a escoger. Se pone != -1 porque la primera fila es 0, las que siguen son 1, 2... n, de modo que -1 significa ninguna fila. Es decir, verifica que haya selecciona una fila 
                
                EliminarRegistroYRecargarPantalla();
                
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La tabla de libros está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void BuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarLibroActionPerformed

    private void BuscarLibroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarLibroKeyPressed
        if(evt.getExtendedKeyCode() == KeyEvent.VK_E){
        }
    }//GEN-LAST:event_BuscarLibroKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarLibro;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaLibro;
    // End of variables declaration//GEN-END:variables

    //----------------------------------------------------------------  Interfaz IPantalla  ----------------------------------------------------------------  
    @Override
    public void mostrarYCentrarPantalla(JFrame pantalla) {
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }

    @Override
    public void regresar() {
        dispose();
    }
    
    @Override
    public void cargartTabla(javax.swing.JTable tablaConRegistros) {
        // Se define el modelo de tabla donde se presentarán los registros
        DefaultTableModel modeloTabla = new DefaultTableModel(){ 
            // se establece que las filas y columnas no sean editables
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Establecer el nombre de las columnas
        String titulos [] = {"id","Título","Autor","Publicación","Ejemplares","Código"};
        modeloTabla.setColumnIdentifiers(titulos); // se setea el nombre de las columnas
        
        //Cargar la tabla
        List<Libro> libros = controller.traerListaLibros();
        
        //Recorrer la lista y mostrar cada atributo del registro de la bd
        if (libros!=null){
            
            for (Libro lib: libros){
                Object [] objeto = {lib.getId_libro(),lib.getTitulo(),lib.getAutor(),lib.getAnno_publicacion(),lib.getEjemplareslist().size(),lib.getCodigo_libro()};
                if(lib.getEstado() == 1){
                    modeloTabla.addRow(objeto);
                }     
            }
        }
        //Se setea la tabla del Jframe con la tabla 
        tablaConRegistros.setModel(modeloTabla);
    }
    
    @Override
    public void EliminarRegistroYRecargarPantalla() {
        int id_libro = Integer.parseInt(String.valueOf(tablaLibro.getValueAt(tablaLibro.getSelectedRow(), 0))); // -> ... tablaLibro.getValueAt(tablaLibro.getSelectedRow(), 0))) = traeme los valores de(la fila seleccionada, en la columna 0)               
                
        int confirmar = JOptionPane.showConfirmDialog(
            null,"¿Estás seguro de que deseas eliminar el libro con ID " + id_libro + 
            " y todos sus ejemplares? Esta acción es irreversible.", 
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                
        if (confirmar == JOptionPane.YES_OPTION){
            try {
                controller.eliminarLibro(id_libro);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, 
                ex.getMessage(), // Captura el mensaje lanzado ("ERROR: El libro... tiene préstamos asociados.")
                "Error al Eliminar Libro", JOptionPane.ERROR_MESSAGE);
                    
                Logger.getLogger(A_ColeccionLibro.class.getName()).log(Level.SEVERE, "Error en la eliminación del libro ID: " + id_libro, ex);
            } 
        }
        cargartTabla(tablaLibro); // se actualiza la tabla donde se muestran los resultados
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------  
}
