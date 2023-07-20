 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Clases.Cliente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author CRISTOFER
 */
public class FrmResgistroClientes extends javax.swing.JInternalFrame {

    List<Cliente> listaClientes=new LinkedList();
    File archivo = new File("Clientes.txt");
    
    Color pnlBcolor,pnlEcolor,pnlMcolor;
    DefaultTableModel Tabla;
    String[] cabecera={"DNI", "Nombres", "Apellidos", "Direccion","Correo", 
        "Telefono", "Fecha Nacimiento"};
    String[][] datos={};
    void establecerTamanio(){
        this.setSize(new Dimension(852, 658));
    }
    void cambiarTamanioColumnas(){
        tblClientes.getTableHeader().setFont(new Font ("Century Cothic",Font.BOLD,13));        
        
        TableColumn columna=null;
        
        columna=tblClientes.getColumnModel().getColumn(0);
        columna.setPreferredWidth(140);
        columna=tblClientes.getColumnModel().getColumn(1);
        columna.setPreferredWidth(120);
        columna=tblClientes.getColumnModel().getColumn(2);
        columna.setPreferredWidth(120);
        columna=tblClientes.getColumnModel().getColumn(3);
        columna.setPreferredWidth(160);
        columna=tblClientes.getColumnModel().getColumn(4);
        columna.setPreferredWidth(160);
    }

    List<Cliente> leerArchivo() {
        try {
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Clientes.txt"));
            List<Cliente> listaAux = (List<Cliente>) leer.readObject();
            leer.close();
            return listaAux;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    void escribirArchivo() {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Clientes.txt"));
            escribir.writeObject(listaClientes);
            escribir.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    Cliente existeCliente(int dni){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(dni==listaClientes.get(i).DNI){
                return listaClientes.get(i);
            }
        }
        return null;
    }
    
    void imprimir(){
        Tabla.setRowCount(0);
        SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaClientes.size(); i++) {
            Object[] fila={listaClientes.get(i).DNI,listaClientes.get(i).nombres,listaClientes.get(i).apellidos,
                listaClientes.get(i).direccion, listaClientes.get(i).correo,listaClientes.get(i).telefono,
                dma.format(listaClientes.get(i).fechaNac)};
            Tabla.addRow(fila);
        }
    }
    void limpiar(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCorreo.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
    void limpiarPK(){
        txtDNI.setText("");
    }
    public FrmResgistroClientes(int w) {
        initComponents();
        this.setLocation(w, 0);
        establecerTamanio();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getColorBtn();
        
        SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
        Tabla = new DefaultTableModel(datos, cabecera);       
        tblClientes.setModel(Tabla);
        if (archivo.exists()) {
            listaClientes = leerArchivo();
        }
        imprimir();
        cambiarTamanioColumnas();
    }
    String validarDatos(){
        if(txtNombres.getText().equals("") || txtApellidos.getText().equals("") ||
                txtDNI.getText().equals("") || txtCorreo.getText().equals("") ||
                txtDireccion.getText().equals("") || txtTelefono.getText().equals("") ||
                dcFechaNacimiento.getDate()==null){
            return "Uno o mas datos estan incompletos.";
        }else if(!esNumero(txtDNI.getText())){
            return "Ingrese numeros en el campo DNI.";
        }else if(!esNumero(txtTelefono.getText())){
            return "Ingrese numeros en el campo telefono.";
        }else if(txtDNI.getText().length()!=8){
            return "La longitud de un DNI es de 8 dígitos.";
        }else if(txtTelefono.getText().length()!=9){
            return "La longitud de un númerod de teléfono es de 9 dígitos";
        }else if(dcFechaNacimiento.getDate().after(new Date())){
            return "Fecha de nacimiento no valida.";
        }
        return "";
    }
    String validarPK(){
        if(txtDNI.getText().equals("")){
            return "Ingrese un DNI válido.";
        }else if(!esNumero(txtDNI.getText())){
            return "Ingrese numeros en el campo DNI.";
        }else if(txtDNI.getText().length()!=8){
            return "La longitud de un DNI es de 8 dígitos.";
        }
        return "";
    }
    boolean esNumero(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
            if(!Character.isDigit(palabra.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnAyuda = new javax.swing.JButton();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        pnlBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        pnlBtnModificar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setBackground(new java.awt.Color(59, 24, 25));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        tblClientes.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.setSelectionBackground(new java.awt.Color(125, 24, 1));
        jScrollPane1.setViewportView(tblClientes);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 790, 360);

        txtNombres.setBackground(new java.awt.Color(69, 28, 30));
        txtNombres.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(255, 255, 255));
        txtNombres.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel3.add(txtNombres);
        txtNombres.setBounds(30, 20, 220, 60);

        txtApellidos.setBackground(new java.awt.Color(69, 28, 30));
        txtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        jPanel3.add(txtApellidos);
        txtApellidos.setBounds(260, 20, 220, 60);

        txtDireccion.setBackground(new java.awt.Color(69, 28, 30));
        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel3.add(txtDireccion);
        txtDireccion.setBounds(30, 90, 270, 60);

        txtDNI.setBackground(new java.awt.Color(69, 28, 30));
        txtDNI.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(255, 255, 255));
        txtDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel3.add(txtDNI);
        txtDNI.setBounds(490, 20, 150, 60);

        txtTelefono.setBackground(new java.awt.Color(69, 28, 30));
        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txtTelefono);
        txtTelefono.setBounds(570, 90, 150, 60);

        txtCorreo.setBackground(new java.awt.Color(69, 28, 30));
        txtCorreo.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel3.add(txtCorreo);
        txtCorreo.setBounds(310, 90, 250, 60);

        dcFechaNacimiento.setBackground(new java.awt.Color(69, 28, 30));
        dcFechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        dcFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(dcFechaNacimiento);
        dcFechaNacimiento.setBounds(650, 10, 170, 70);

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help_question_16768.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel3.add(btnAyuda);
        btnAyuda.setBounds(420, 160, 30, 30);

        pnlBtnBuscar.setBackground(new java.awt.Color(35, 128, 184));
        pnlBtnBuscar.setLayout(new java.awt.BorderLayout());

        btnBuscar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBuscarMouseReleased(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlBtnBuscar.add(btnBuscar, java.awt.BorderLayout.CENTER);

        jPanel3.add(pnlBtnBuscar);
        pnlBtnBuscar.setBounds(290, 160, 120, 30);

        pnlBtnEliminar.setBackground(new java.awt.Color(176, 40, 30));
        pnlBtnEliminar.setLayout(new java.awt.BorderLayout());

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEliminarMouseReleased(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlBtnEliminar.add(btnEliminar, java.awt.BorderLayout.CENTER);

        jPanel3.add(pnlBtnEliminar);
        pnlBtnEliminar.setBounds(160, 160, 120, 30);

        pnlBtnModificar.setBackground(new java.awt.Color(189, 109, 25));
        pnlBtnModificar.setLayout(new java.awt.BorderLayout());

        btnModificar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setContentAreaFilled(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnModificarMouseReleased(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlBtnModificar.add(btnModificar, java.awt.BorderLayout.CENTER);

        jPanel3.add(pnlBtnModificar);
        pnlBtnModificar.setBounds(30, 160, 120, 30);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(125, 24, 1));
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

        pnlCerrar.setBackground(new java.awt.Color(125, 24, 1));
        pnlCerrar.setLayout(new java.awt.BorderLayout());

        lblCerrar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro clientes.png"))); // NOI18N
        jLabel1.setText("   Registro total de Clientes");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(),"Error",0);
            return;
        }
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(),"Error",0);
            return;
        }
        int dniNuevo=Integer.parseInt(txtDNI.getText());
        if(existeCliente(dniNuevo)==null){
            JOptionPane.showMessageDialog(null, "El cliente NO existe, ingrese otro DNI.");
        }else{
            for (int i = 0; i < listaClientes.size(); i++) {
                if(listaClientes.get(i).DNI==Integer.parseInt(txtDNI.getText())){
                    listaClientes.get(i).nombres=txtNombres.getText();
                    listaClientes.get(i).apellidos=txtApellidos.getText();
                    listaClientes.get(i).direccion=txtDireccion.getText();
                    listaClientes.get(i).correo=txtCorreo.getText();
                    listaClientes.get(i).telefono=Integer.parseInt(txtTelefono.getText());
                    listaClientes.get(i).fechaNac=dcFechaNacimiento.getDate();
                    break;
                }
            }
            imprimir();
            JOptionPane.showMessageDialog(null, "Modificado correctamente.");
            limpiar();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        eliminarCliente(Integer.parseInt(txtDNI.getText()));
    }//GEN-LAST:event_btnEliminarActionPerformed

    void eliminarCliente(int eliminado){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).DNI == eliminado){
                listaClientes.remove(i);
                JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
                imprimir();
                limpiarPK();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El cliente no existe, ingrese otro DNI.");
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(),"Error",0);
            return;
        }
        Cliente buscado=existeCliente(Integer.parseInt(txtDNI.getText()));
        if(buscado != null){
            JOptionPane.showMessageDialog(null, "Nombres: "+buscado.nombres+"\n"
                + "Apellidos: " +buscado.apellidos+"\n"+"DNI: "+buscado.DNI+"\n"
                +"Direccion: "+buscado.direccion+"\n"+"Correo: "+buscado.correo+"\n"+
                "Telefono: "+buscado.telefono);
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no existe, ingrese otro DNI");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null,
            "Modificar: Actualiza los datos del cliente mediante el DNI, ingrese el DNI para modificar los datos.\n"+
            "Eliminar: Remueve los datos del cliente de la lista mediante el DNI, ingrese el DNI para eliminar.\n"+
            "Buscar: Encuentra los datos del cliente en la lista mediante el DNI, ingrese el DNI para buscar.\n",
            "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        if(txtNombres.getText().length()>=30) evt.consume();
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        if(txtApellidos.getText().length()>=30) evt.consume();
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if(txtDireccion.getText().length()>=40) evt.consume();
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        if(txtCorreo.getText().length()>=40) evt.consume();
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        if(txtDNI.getText().length()>=8) evt.consume();
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if(txtTelefono.getText().length()>=9) evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        escribirArchivo();
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked
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

    void getColorBtn(){
        pnlBcolor=pnlBtnBuscar.getBackground();
        pnlMcolor=pnlBtnModificar.getBackground();
        pnlEcolor=pnlBtnEliminar.getBackground();
    }
    

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(125, 24, 1));
    }//GEN-LAST:event_lblCerrarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        pnlBtnModificar.setBackground(setColorBtn(pnlMcolor, 12));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        pnlBtnModificar.setBackground(pnlMcolor);
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMousePressed
        pnlBtnModificar.setBackground(setColorBtn(pnlMcolor, 20));
    }//GEN-LAST:event_btnModificarMousePressed

    private void btnModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseReleased
        pnlBtnModificar.setBackground(setColorBtn(pnlMcolor, 12));
    }//GEN-LAST:event_btnModificarMouseReleased

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        pnlBtnEliminar.setBackground(setColorBtn(pnlEcolor, 12));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        pnlBtnEliminar.setBackground(pnlEcolor);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        pnlBtnEliminar.setBackground(setColorBtn(pnlEcolor, 20));
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseReleased
        pnlBtnEliminar.setBackground(setColorBtn(pnlEcolor, 12));
    }//GEN-LAST:event_btnEliminarMouseReleased

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        pnlBtnBuscar.setBackground(setColorBtn(pnlBcolor, 12));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        pnlBtnBuscar.setBackground(pnlBcolor);
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
        pnlBtnBuscar.setBackground(setColorBtn(pnlBcolor, 20));
    }//GEN-LAST:event_btnBuscarMousePressed

    private void btnBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseReleased
        pnlBtnBuscar.setBackground(setColorBtn(pnlBcolor, 12));
    }//GEN-LAST:event_btnBuscarMouseReleased

    int xMouse,yMouse;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY()+30;
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlBtnEliminar;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
