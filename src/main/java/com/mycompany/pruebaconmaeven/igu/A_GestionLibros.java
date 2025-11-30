
package com.mycompany.pruebaconmaeven.igu;

import com.mycompany.pruebaconmaeven.Interfaces.IPantalla;

public class A_GestionLibros extends javax.swing.JFrame implements IPantalla{


    public A_GestionLibros() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevoLibro = new javax.swing.JButton();
        btnColeccionLibros = new javax.swing.JButton();
        btnRegresarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Californian FB", 0, 36)); // NOI18N
        jLabel1.setText("Gestión de libros");

        btnNuevoLibro.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnNuevoLibro.setText("Nuevo libro");
        btnNuevoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLibroActionPerformed(evt);
            }
        });

        btnColeccionLibros.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnColeccionLibros.setText("Coleccion");
        btnColeccionLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColeccionLibrosActionPerformed(evt);
            }
        });

        btnRegresarMenu.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btnRegresarMenu.setText("Regresar");
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColeccionLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnNuevoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnColeccionLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void btnNuevoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLibroActionPerformed
        A_NuevoLibro lb = new A_NuevoLibro();
        mostrarYCentrarPantalla(lb);
        
    }//GEN-LAST:event_btnNuevoLibroActionPerformed

    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed
        regresar();
    }//GEN-LAST:event_btnRegresarMenuActionPerformed

    private void btnColeccionLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColeccionLibrosActionPerformed
        A_ColeccionLibro colec = new A_ColeccionLibro();
        mostrarYCentrarPantalla(colec);
        
    }//GEN-LAST:event_btnColeccionLibrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColeccionLibros;
    private javax.swing.JButton btnNuevoLibro;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarYCentrarPantalla(javax.swing.JFrame pantalla) {
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        
    }

    @Override
    public void vaciarTexto() {
        
    }

    @Override
    public void regresar() {
        dispose();
    }

    @Override
    public void cargartTabla(javax.swing.JTable tablaConRegistros) {
    }

    @Override
    public void EliminarRegistroYRecargarPantalla() {
    }
}
