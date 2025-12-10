
package com.mycompany.pruebaconmaeven.igu.Prestamo;

import com.mycompany.pruebaconmaeven.Interfaces.IActualizacion;
import com.mycompany.pruebaconmaeven.Interfaces.IInicializar;
import com.mycompany.pruebaconmaeven.Interfaces.IRetornar;
import com.mycompany.pruebaconmaeven.logica.IGuiPrestamo;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class Devolucion extends javax.swing.JFrame implements IActualizacion, IInicializar, IRetornar {

    private final IGuiPrestamo controller;
    public Devolucion(IGuiPrestamo controller) {
        initComponents();
        this.controller = controller;
        
        inicializarComponentesAdicionales();
    }

    private void inicializarComponentesAdicionales(){
        txtDni.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkAndRefresh();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkAndRefresh();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
            public void checkAndRefresh(){
                if(txtDni.getText().trim().isEmpty()){
                    limpiarTabla(tablaPrestamosActivos);
                }else{
                    
                }
            }
        });
    }
    
    private void limpiarTabla(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamosActivos = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 36)); // NOI18N
        jLabel1.setText("Devoluciones");

        txtDni.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel6.setText("DNI (o carnet):");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tablaPrestamosActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPrestamosActivos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRegistrar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegistrar.setText("Devolución");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(297, 297, 297))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDni))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(btnRegistrar)
                        .addGap(40, 40, 40)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        EliminarRegistroYRecargarPantalla();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if(evt.getExtendedKeyCode() == KeyEvent.VK_ENTER){
            if(!txtDni.getText().trim().isEmpty()){
                cargartTabla(tablaPrestamosActivos);
            }
        }
    }//GEN-LAST:event_txtDniKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaPrestamosActivos;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables

    
    
    //--------------------------------------------------------------------------- Interfaces -----------------------------------------------------------------------------------------------------------------------
    
    @Override
    public void cargartTabla(JTable tablaConPrestamos) {
        // Se define el modelo de tabla donde se presentarán los registros
        DefaultTableModel modeloTabla = new DefaultTableModel(){ 
            // se establece que las filas y columnas no sean editables
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Establecer el nombre de las columnas
        String titulos [] = {"id","Usuario","Libro","Fecha del prestamo","Fecha esperada","Fecha real"};
        modeloTabla.setColumnIdentifiers(titulos); // se setea el nombre de las columnas
        
        //Cargar la tabla
        List<Object[]> prestamosActivos = controller.mostrarRegistrosDePrestamos(txtDni.getText());
        
        //Recorrer la lista y mostrar cada atributo del registro de la bd
        if (prestamosActivos!=null){
            
            for (Object[] pres: prestamosActivos){
                modeloTabla.addRow(pres);
            }
        }
        //Se setea la tabla del Jframe con la tabla 
        tablaConPrestamos.setModel(modeloTabla);
    }

    @Override
    public void EliminarRegistroYRecargarPantalla() {
        if(!validarFilas()){
            return;
        }
        int idPrestamo = Integer.parseInt(String.valueOf(tablaPrestamosActivos.getValueAt(tablaPrestamosActivos.getSelectedRow(),0)));
        
        int confirmar = JOptionPane.showConfirmDialog(
            null,"¿Estás seguro de que deseas devolver el prestamo de ID " + idPrestamo + 
            "", "Confirmar devolución", JOptionPane.YES_NO_OPTION);
        
                if (confirmar == JOptionPane.YES_OPTION){
            try {
                this.controller.RegresarPrestamo(idPrestamo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al Eliminar Libro", JOptionPane.ERROR_MESSAGE);
            } 
        }
        cargartTabla(tablaPrestamosActivos);
    }
    
    @Override
    public void regresar() {
        dispose();
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
        public boolean validarFilas(){
        if(tablaPrestamosActivos.getRowCount()<1){
            JOptionPane.showMessageDialog(null, "La tabla de libros está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if(tablaPrestamosActivos.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
