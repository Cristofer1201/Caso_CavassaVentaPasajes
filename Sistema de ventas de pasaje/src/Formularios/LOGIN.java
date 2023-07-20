/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;
import java.awt.Color;

/**
 *
 * @author User
 */
public class LOGIN extends javax.swing.JFrame {
    
    String usuario="Chris_Blas";
    String contraseña="CBCavassa2022";
    
    Color btnC;
    public LOGIN() {
        initComponents();
        setLocationRelativeTo(null);
        btnC=pnlBtnIngresar.getBackground();
    }
    int xMouse,yMouse;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        JPContraseña = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlBtnIngresar = new javax.swing.JPanel();
        BtnIngresar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 114, 68));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo cavasssa 2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 260, 275, 104);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/WhatsApp Image 2022-06-18 at 10.43.07 PM.jpeg"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 70, 270, 180);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 380, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESIÓN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(90, 30, 252, 40);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("CONTRASEÑA ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 190, 120, 31);

        txtUsuario.setBackground(new java.awt.Color(220, 220, 220));
        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Ingresar usuario");
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario);
        txtUsuario.setBounds(120, 120, 220, 47);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario (1).png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(50, 120, 51, 47);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bloquear.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(50, 230, 49, 47);

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(120, 170, 220, 10);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(120, 280, 220, 10);

        JPContraseña.setBackground(new java.awt.Color(204, 204, 204));
        JPContraseña.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        JPContraseña.setForeground(new java.awt.Color(153, 153, 153));
        JPContraseña.setText("12345678");
        JPContraseña.setToolTipText("");
        JPContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPContraseñaMousePressed(evt);
            }
        });
        JPContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPContraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(JPContraseña);
        JPContraseña.setBounds(120, 230, 220, 44);

        lblError.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblError);
        lblError.setBounds(100, 300, 270, 20);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("USUARIO");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 80, 104, 36);

        pnlBtnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        pnlBtnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBtnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBtnIngresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBtnIngresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlBtnIngresarMouseReleased(evt);
            }
        });
        pnlBtnIngresar.setLayout(new java.awt.BorderLayout());

        BtnIngresar.setBackground(new java.awt.Color(153, 255, 255));
        BtnIngresar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        BtnIngresar.setText("INGRESAR");
        BtnIngresar.setBorder(null);
        BtnIngresar.setBorderPainted(false);
        BtnIngresar.setContentAreaFilled(false);
        BtnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnIngresar.setFocusPainted(false);
        BtnIngresar.setFocusable(false);
        BtnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnIngresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnIngresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BtnIngresarMouseReleased(evt);
            }
        });
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        pnlBtnIngresar.add(BtnIngresar, java.awt.BorderLayout.CENTER);

        jPanel2.add(pnlBtnIngresar);
        pnlBtnIngresar.setBounds(160, 320, 150, 40);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 410, 400));

        header.setBackground(new java.awt.Color(0, 133, 66));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCerrar.setBackground(new java.awt.Color(0, 133, 66));
        pnlCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCerrarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlCerrarMouseReleased(evt);
            }
        });
        pnlCerrar.setLayout(new java.awt.BorderLayout());

        lblCerrar.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setText("X");
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarMouseExited(evt);
            }
        });
        pnlCerrar.add(lblCerrar, java.awt.BorderLayout.CENTER);

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 0, 42, 42));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String getUsuario(){
        return txtUsuario.getText();
    }
    String getContrasenia(){
        return String.valueOf(JPContraseña.getPassword());
    }
    String validarDatos(){
        if(txtUsuario.getText().equals("") || String.valueOf(JPContraseña.getPassword()).equals("") ||
                txtUsuario.getText().equals("Ingresar usuario") || String.valueOf(JPContraseña.getPassword()).equals("12345678")){
            return "*Uno o mas datos estan incompletos.*";
        }
        return "";
    }
    boolean existeUsuario(String u, String c){
        return (usuario.equals(u)) && (contraseña.equals(c));
    }
    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        
        if(!validarDatos().equals("")){
            lblError.setText(validarDatos());
            return;
        }
        if(!existeUsuario(getUsuario(), getContrasenia())){
            lblError.setText("*Usuario y/o contraseña incorrectos.*");
            return;
        }
        lblError.setText("");
        FrmMenuInicio nuevo = new FrmMenuInicio();
        nuevo.setVisible(true);
        this.dispose();
        Limpiar();
    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        //
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void JPContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPContraseñaActionPerformed
        //
    }//GEN-LAST:event_JPContraseñaActionPerformed

//Seleccionado 
    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        //En caso que el string seleccionado sea igual a la frase preterminada
        //Se borrara y se implementara el color negro
        if(txtUsuario.getText().equals("Ingresar usuario")){
        txtUsuario.setText("");
        txtUsuario.setForeground(Color.black);
        }
        //Si el string esta vacio se intentara rellenar como estuvo preterminadamente
        //y se implementara la cantidad de * y su color preterminado
        if(String.valueOf(JPContraseña.getPassword()).isEmpty()){
        JPContraseña.setText("12345678");
        JPContraseña.setForeground(Color.gray);
        }
        
    }//GEN-LAST:event_txtUsuarioMousePressed
//Seleccionado
    private void JPContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPContraseñaMousePressed
        //En caso que el string seleccionado sea igual a la frase preterminada
        //Se borrara y se implementara el color negro
        if(String.valueOf(JPContraseña.getPassword()).equals("12345678")){
        JPContraseña.setText("");
        JPContraseña.setForeground(Color.black);
        }
        //Si el string esta vacio se intentara rellenar como estuvo preterminadamente
        //Y se implementara su color preterminado
        if(txtUsuario.getText().isEmpty()){
        txtUsuario.setText("Ingresar usuario");
        txtUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_JPContraseñaMousePressed

    Color setColorBtn(Color original, float porcentaje){
        int r=original.getRed();
        int g=original.getGreen();
        int b=original.getBlue();
        porcentaje/=100;
        r-=(r*porcentaje);
        g-=(g*porcentaje);
        b-=(b*porcentaje);
        return new Color(r, g, b);
    }
    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void BtnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMouseEntered
        pnlBtnIngresar.setBackground(setColorBtn(btnC, 10));
    }//GEN-LAST:event_BtnIngresarMouseEntered

    private void BtnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMouseExited
        pnlBtnIngresar.setBackground(btnC);
    }//GEN-LAST:event_BtnIngresarMouseExited

    private void BtnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMousePressed
        pnlBtnIngresar.setBackground(setColorBtn(btnC, 15));
    }//GEN-LAST:event_BtnIngresarMousePressed

    private void BtnIngresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMouseReleased
        pnlBtnIngresar.setBackground(setColorBtn(btnC, 10));
    }//GEN-LAST:event_BtnIngresarMouseReleased

    private void pnlCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseEntered
    }//GEN-LAST:event_pnlCerrarMouseEntered

    private void pnlCerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseReleased
    }//GEN-LAST:event_pnlCerrarMouseReleased

    private void pnlCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseExited
    }//GEN-LAST:event_pnlCerrarMouseExited

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(0, 133, 66));
    }//GEN-LAST:event_lblCerrarMouseExited

    private void pnlBtnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnIngresarMouseEntered
    }//GEN-LAST:event_pnlBtnIngresarMouseEntered

    private void pnlBtnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnIngresarMouseExited

    }//GEN-LAST:event_pnlBtnIngresarMouseExited

    private void pnlBtnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnIngresarMousePressed
    }//GEN-LAST:event_pnlBtnIngresarMousePressed

    private void pnlBtnIngresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBtnIngresarMouseReleased
    }//GEN-LAST:event_pnlBtnIngresarMouseReleased

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_headerMouseDragged

    
    void Limpiar(){
    txtUsuario.setText("Ingresar usuario");
    txtUsuario.setForeground(Color.gray);
    JPContraseña.setText("********");
    JPContraseña.setForeground(Color.gray);
    }

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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JPasswordField JPContraseña;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblError;
    private javax.swing.JPanel pnlBtnIngresar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
