
package com.mycompany.pruebaconmaeven.igu.Prestamo;

import com.mycompany.pruebaconmaeven.Interfaces.IMostrar;
import com.mycompany.pruebaconmaeven.Interfaces.IRetornar;
import com.mycompany.pruebaconmaeven.logica.IControladora;
import javax.swing.JFrame;

public class GestionDePrestamos extends javax.swing.JFrame implements IRetornar, IMostrar {
    
    private final IControladora controller;
    public GestionDePrestamos(IControladora controller){
        initComponents();
        this.controller = controller;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarPrestamo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnVerPrestamos = new javax.swing.JButton();
        btnRegistrarDevolucion = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 36)); // NOI18N
        jLabel1.setText("Gestión de préstamos");

        btnRegistrarPrestamo.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegistrarPrestamo.setText("Préstamo nuevo");
        btnRegistrarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPrestamoActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnVerPrestamos.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnVerPrestamos.setText("Ver préstamos");
        btnVerPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPrestamosActionPerformed(evt);
            }
        });

        btnRegistrarDevolucion.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegistrarDevolucion.setText("Devolución");
        btnRegistrarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDevolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnVerPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegistrarDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
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

    private void btnRegistrarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPrestamoActionPerformed
        NuevoPrestamo nuevoPrestamo = new NuevoPrestamo(this.controller);
        mostrarYCentrarPantalla(nuevoPrestamo);
    }//GEN-LAST:event_btnRegistrarPrestamoActionPerformed

    private void btnRegistrarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDevolucionActionPerformed
        Devolucion dev = new Devolucion(this.controller);
        mostrarYCentrarPantalla(dev);
    }//GEN-LAST:event_btnRegistrarDevolucionActionPerformed

    private void btnVerPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPrestamosActionPerformed
        VerPrestamosActivos resumenPres = new VerPrestamosActivos(this.controller);
        mostrarYCentrarPantalla(resumenPres);
    }//GEN-LAST:event_btnVerPrestamosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarDevolucion;
    private javax.swing.JButton btnRegistrarPrestamo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerPrestamos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    // End of variables declaration//GEN-END:variables

    
    //----------------------------------------------------------- Interfaces ----------------------------------------------------------------------------------------------------
    @Override
    public void regresar() {
        dispose();
    }

    @Override
    public void mostrarYCentrarPantalla(JFrame pantalla) {
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
}
