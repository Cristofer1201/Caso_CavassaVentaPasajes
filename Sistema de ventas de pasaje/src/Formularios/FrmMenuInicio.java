/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author CRISTOFER
 */
public class FrmMenuInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuInicio
     */
    Color pnlBMcolor;
    public FrmMenuInicio() {
        this.setMinimumSize(new Dimension(1000,700));
        //this.setSize(new Dimension(1000,800));
        //this.setMaximumSize(new Dimension(1000,800));
        
        initComponents();
        getColorBtn();
        pnlBMcolor=pnlBarraMenu.getBackground();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/imagen1.png"));
        Image image = icon.getImage();
        dpEscritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        pnlBarraMenu = new javax.swing.JPanel();
        pnlBtnCliente = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        pnlBtnComprarPasaje = new javax.swing.JPanel();
        btnComprarPasaje = new javax.swing.JButton();
        pnlBtnRegistroPasajes = new javax.swing.JPanel();
        btnRegistroPasajes = new javax.swing.JButton();
        pnlBtnRegistroVentas = new javax.swing.JPanel();
        btnRegistroVentas = new javax.swing.JButton();
        pnlBtnEmpleado = new javax.swing.JPanel();
        btnEmpleado = new javax.swing.JButton();
        pnlBtnRegistrarViaje = new javax.swing.JPanel();
        btnRegistrarViaje = new javax.swing.JButton();
        pnlBtnBus = new javax.swing.JPanel();
        btnBus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");

        pnlBarraMenu.setBackground(new java.awt.Color(3, 54, 27));
        pnlBarraMenu.setLayout(null);

        pnlBtnCliente.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnCliente.setLayout(null);

        btnCliente.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Registrar Cliente");
        btnCliente.setContentAreaFilled(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClienteMousePressed(evt);
            }
        });
        pnlBtnCliente.add(btnCliente);
        btnCliente.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnCliente);
        pnlBtnCliente.setBounds(0, 110, 190, 50);

        pnlBtnComprarPasaje.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnComprarPasaje.setLayout(null);

        btnComprarPasaje.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnComprarPasaje.setForeground(new java.awt.Color(255, 255, 255));
        btnComprarPasaje.setText("Comprar Pasaje");
        btnComprarPasaje.setContentAreaFilled(false);
        btnComprarPasaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComprarPasaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnComprarPasajeMousePressed(evt);
            }
        });
        pnlBtnComprarPasaje.add(btnComprarPasaje);
        btnComprarPasaje.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnComprarPasaje);
        pnlBtnComprarPasaje.setBounds(0, 210, 190, 50);

        pnlBtnRegistroPasajes.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnRegistroPasajes.setLayout(null);

        btnRegistroPasajes.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnRegistroPasajes.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroPasajes.setText("Registro de Pasajes");
        btnRegistroPasajes.setContentAreaFilled(false);
        btnRegistroPasajes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroPasajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistroPasajesMousePressed(evt);
            }
        });
        pnlBtnRegistroPasajes.add(btnRegistroPasajes);
        btnRegistroPasajes.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnRegistroPasajes);
        pnlBtnRegistroPasajes.setBounds(0, 410, 190, 50);

        pnlBtnRegistroVentas.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnRegistroVentas.setLayout(null);

        btnRegistroVentas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnRegistroVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroVentas.setText("Registro de Ventas");
        btnRegistroVentas.setContentAreaFilled(false);
        btnRegistroVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistroVentasMousePressed(evt);
            }
        });
        pnlBtnRegistroVentas.add(btnRegistroVentas);
        btnRegistroVentas.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnRegistroVentas);
        pnlBtnRegistroVentas.setBounds(0, 360, 190, 50);

        pnlBtnEmpleado.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnEmpleado.setLayout(null);

        btnEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleado.setText("Empleado");
        btnEmpleado.setContentAreaFilled(false);
        btnEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEmpleadoMousePressed(evt);
            }
        });
        pnlBtnEmpleado.add(btnEmpleado);
        btnEmpleado.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnEmpleado);
        pnlBtnEmpleado.setBounds(0, 310, 190, 50);

        pnlBtnRegistrarViaje.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnRegistrarViaje.setLayout(null);

        btnRegistrarViaje.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnRegistrarViaje.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarViaje.setText("Registrar Viaje");
        btnRegistrarViaje.setContentAreaFilled(false);
        btnRegistrarViaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarViaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarViajeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistrarViajeMousePressed(evt);
            }
        });
        pnlBtnRegistrarViaje.add(btnRegistrarViaje);
        btnRegistrarViaje.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnRegistrarViaje);
        pnlBtnRegistrarViaje.setBounds(0, 160, 190, 50);

        pnlBtnBus.setBackground(new java.awt.Color(3, 54, 27));
        pnlBtnBus.setLayout(null);

        btnBus.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnBus.setForeground(new java.awt.Color(255, 255, 255));
        btnBus.setText("Bus");
        btnBus.setContentAreaFilled(false);
        btnBus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBusMousePressed(evt);
            }
        });
        btnBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBusKeyPressed(evt);
            }
        });
        pnlBtnBus.add(btnBus);
        btnBus.setBounds(0, 0, 190, 50);

        pnlBarraMenu.add(pnlBtnBus);
        pnlBtnBus.setBounds(0, 260, 190, 50);

        dpEscritorio.setLayer(pnlBarraMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpEscritorioLayout = new javax.swing.GroupLayout(dpEscritorio);
        dpEscritorio.setLayout(dpEscritorioLayout);
        dpEscritorioLayout.setHorizontalGroup(
            dpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpEscritorioLayout.createSequentialGroup()
                .addComponent(pnlBarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 687, Short.MAX_VALUE))
        );
        dpEscritorioLayout.setVerticalGroup(
            dpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );

        getContentPane().add(dpEscritorio, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    FrmClientes nuevoC = new FrmClientes(0);
    FrmBus nuevoB=new FrmBus(0);
    FrmRegistrarViaje nuevoRV=new FrmRegistrarViaje(0);
    FrmComprarPasaje nuevoCP=new FrmComprarPasaje(0);
    FrmRegistroVentas nuevoRVe=new FrmRegistroVentas(0);
    //FrmRegistroCompras nuevoRC=new FrmRegistroCompras();
    FrmRegistroPasajes nuevoRP=new FrmRegistroPasajes(0);
    FrmEmpleado nuevoE=new FrmEmpleado(0);
    void cerrarForms(){
        if(nuevoC.isShowing() || nuevoB.isShowing() || nuevoRV.isShowing() || nuevoCP.isShowing() ||
                nuevoRVe.isShowing() || nuevoE.isShowing()){
            nuevoC.dispose();
            nuevoB.dispose();
            nuevoRV.dispose();
            nuevoCP.dispose();
            nuevoRVe.dispose();
            nuevoE.dispose();
        }
    }
    
    void getColorBtn(){
        pnlBtnCliente.setBackground(pnlBMcolor);
        pnlBtnBus.setBackground(pnlBMcolor);
        pnlBtnRegistrarViaje.setBackground(pnlBMcolor);
        pnlBtnComprarPasaje.setBackground(pnlBMcolor);
        pnlBtnRegistroVentas.setBackground(pnlBMcolor);
        pnlBtnRegistroPasajes.setBackground(pnlBMcolor);
        pnlBtnEmpleado.setBackground(pnlBMcolor);
    }
    Color setColorBtn(Color original, float porcentaje){
        int r=original.getRed();
        int g=original.getGreen();
        int b=original.getBlue();
        porcentaje/=100;
        r+=(r*porcentaje);
        g+=(g*porcentaje);
        b+=(b*porcentaje);
        return new Color(r, g, b);
    }
    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMousePressed
        getColorBtn();
        pnlBtnCliente.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoC=new FrmClientes(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoC);
        nuevoC.show();
    }//GEN-LAST:event_btnClienteMousePressed

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnRegistrarViajeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarViajeMouseExited
    }//GEN-LAST:event_btnRegistrarViajeMouseExited

    private void btnRegistrarViajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarViajeMousePressed
        getColorBtn();
        pnlBtnRegistrarViaje.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoRV=new FrmRegistrarViaje(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoRV);
        nuevoRV.show();
    }//GEN-LAST:event_btnRegistrarViajeMousePressed

    private void btnComprarPasajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarPasajeMousePressed
        getColorBtn();
        pnlBtnComprarPasaje.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoCP=new FrmComprarPasaje(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoCP);
        nuevoCP.show();
    }//GEN-LAST:event_btnComprarPasajeMousePressed

    private void btnBusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBusKeyPressed
    }//GEN-LAST:event_btnBusKeyPressed

    private void btnBusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusMousePressed
        getColorBtn();
        pnlBtnBus.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoB=new FrmBus(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoB);
        nuevoB.show();
    }//GEN-LAST:event_btnBusMousePressed

    private void btnEmpleadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMousePressed
        getColorBtn();
        pnlBtnEmpleado.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoE=new FrmEmpleado(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoE);
        nuevoE.show();
    }//GEN-LAST:event_btnEmpleadoMousePressed

    private void btnRegistroVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroVentasMousePressed
        getColorBtn();
        pnlBtnRegistroVentas.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoRVe=new FrmRegistroVentas(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoRVe);
        nuevoRVe.show();
    }//GEN-LAST:event_btnRegistroVentasMousePressed

    private void btnRegistroPasajesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroPasajesMousePressed
        getColorBtn();
        pnlBtnRegistroPasajes.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoRP=new FrmRegistroPasajes(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoRP);
        nuevoRP.show();
        /*getColorBtn();
        pnlBtnRegistroCompras.setBackground(setColorBtn(pnlBMcolor, 25));
        cerrarForms();
        nuevoRC=new FrmRegistroCompras(pnlBarraMenu.getWidth());
        dpEscritorio.add(nuevoRC);
        nuevoRC.show();*/
    }//GEN-LAST:event_btnRegistroPasajesMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnComprarPasaje;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnRegistrarViaje;
    private javax.swing.JButton btnRegistroPasajes;
    private javax.swing.JButton btnRegistroVentas;
    private javax.swing.JDesktopPane dpEscritorio;
    private javax.swing.JPanel pnlBarraMenu;
    private javax.swing.JPanel pnlBtnBus;
    private javax.swing.JPanel pnlBtnCliente;
    private javax.swing.JPanel pnlBtnComprarPasaje;
    private javax.swing.JPanel pnlBtnEmpleado;
    private javax.swing.JPanel pnlBtnRegistrarViaje;
    private javax.swing.JPanel pnlBtnRegistroPasajes;
    private javax.swing.JPanel pnlBtnRegistroVentas;
    // End of variables declaration//GEN-END:variables
}
