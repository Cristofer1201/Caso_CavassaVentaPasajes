/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Clases.Empleado;
import java.awt.Color;
import java.awt.Dimension;
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

public class FrmEmpleado extends javax.swing.JInternalFrame {

    List<Empleado> listaEmpleados=new LinkedList();
    File archivo=new File("Empleados.txt");
    
    Color pnlGcolor, pnlBcolor, pnlMcolor, pnlEcolor;
    DefaultTableModel Tabla;
    String [] cabecera={"DNI", "Empleado","Correo","Telefono","Cargo","Seguro","Fecha contrato"};
    String [][]datos={};
    SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
    
    void establecerTamanio(){
        this.setSize(new Dimension(802,650));
    }
    void cambiarTamanioColumnas(){
        TableColumn columna=null;
        columna=tblEmpleados.getColumnModel().getColumn(1);
        columna.setPreferredWidth(150);
        columna=tblEmpleados.getColumnModel().getColumn(2);
        columna.setPreferredWidth(120);
        columna=tblEmpleados.getColumnModel().getColumn(3);
        columna.setPreferredWidth(110);
    }
    
    List<Empleado> leerArchivo(){
        try{
            ObjectInputStream leer=new ObjectInputStream(new FileInputStream("Empleados.txt"));
            List<Empleado> listaAux=(List<Empleado>) leer.readObject();
            leer.close();
            return listaAux;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    void escribirArchivo(){
        try{
            ObjectOutputStream escribir =new ObjectOutputStream(new FileOutputStream("Empleados.txt"));
            escribir.writeObject(listaEmpleados);
            escribir.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    Empleado existeEmpleado(int dni){
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).DNI==dni){
                return listaEmpleados.get(i);
            }
        }
        return null;
    }
    void eliminarEmpleado(int eliminado){
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).DNI==eliminado){
                listaEmpleados.remove(i);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamehte.", "Confirmación", 1);
                limpiarPK();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El empleado no existe, ingrese otro DNI.", "Error", 0);
    }
    
    void imprimir(){
        Tabla.setRowCount(0);
        SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Object[] fila = {listaEmpleados.get(i).DNI, listaEmpleados.get(i).nombres + " " + listaEmpleados.get(i).apellidos,
                listaEmpleados.get(i).correo, listaEmpleados.get(i).telefono, listaEmpleados.get(i).cargo, listaEmpleados.get(i).seguro,
                dma.format(listaEmpleados.get(i).fechaContrato)};
            Tabla.addRow(fila);
        }
    }
    void limpiar(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        dcFechaContrato.setDate(null);
        dcFechaNacimiento.setDate(null);
    }
    void limpiarPK(){
        txtDNI.setText("");
    }
    
    public FrmEmpleado(int w) {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        establecerTamanio();
        this.setLocation(w,0);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        getColorBtn();
        Tabla=new DefaultTableModel(datos,cabecera);
        tblEmpleados.setModel(Tabla);
        if(archivo.exists()){
            listaEmpleados=leerArchivo();
        }
        imprimir();
        cambiarTamanioColumnas();
    }
    
    String validarDatos(){
        if(txtNombres.getText().equals("") || txtApellidos.getText().equals("") || 
                txtCorreo.getText().equals("") || txtDNI.getText().equals("") ||
                txtDireccion.getText().equals("") || txtTelefono.getText().equals("")||
                        dcFechaNacimiento.getDate()==null || dcFechaContrato.getDate()==null){
            return "Uno o más datos están incompletos.";
        }else if(!esNumero(txtDNI.getText())){
            return "Ingrese numeros en el campo DNI.";
        }else if(!esNumero(txtTelefono.getText())){
            return "Ingrese numeros en el campo telefono.";
        }else if(txtDNI.getText().length()!=8){
            return "La longitud de un DNI es de 8 dígitos.";
        }else if(txtTelefono.getText().length()!=9){
            return "La longitud de un númerod de teléfono es de 9 dígitos.";
        }else if(dcFechaNacimiento.getDate().after(dcFechaContrato.getDate())){
            return "Ingrese fechas válidas, la fecha de nacimiento no puede ser mayor a la de contrato.";
        }else if(dcFechaNacimiento.getDate().after(new Date())){
            return "Fecha de nacimiento no valida.";
        }else if(dcFechaContrato.getDate().after(new Date())){
            return "Fecha de contrato no valida.";
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
    
    String getNombre(){
        return txtNombres.getText();
    }
    String getApellido(){
        return txtApellidos.getText();
    }
    Date getFechaNac(){
        return dcFechaNacimiento.getDate();
    }
    int getDNI(){
        return Integer.parseInt(txtDNI.getText());
    }
    String getDireccion(){
        return txtDireccion.getText();
    }
    String getCorreo(){
        return txtCorreo.getText();
    }
    int getTelefono(){
        return Integer.parseInt(txtTelefono.getText());
    }
    String getCargo(){
        return String.valueOf(cboCargo.getSelectedItem());
    }
    String getSeguro(){
        return String.valueOf(cboSeguro.getSelectedItem());
    }
    Date getFechaCon(){
        return dcFechaContrato.getDate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        cboCargo = new javax.swing.JComboBox<>();
        cboSeguro = new javax.swing.JComboBox<>();
        dcFechaContrato = new com.toedter.calendar.JDateChooser();
        btnAyuda = new javax.swing.JButton();
        pnlBtnGuardar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        pnlBtnModificar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        pnlBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
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

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));
        jPanel1.setLayout(null);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmpleados);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 300, 750, 270);

        txtNombres.setBackground(new java.awt.Color(102, 102, 102));
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
        jPanel1.add(txtNombres);
        txtNombres.setBounds(20, 10, 240, 70);

        txtApellidos.setBackground(new java.awt.Color(102, 102, 102));
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
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(270, 10, 240, 70);

        txtDireccion.setBackground(new java.awt.Color(102, 102, 102));
        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(150, 90, 220, 70);

        txtCorreo.setBackground(new java.awt.Color(102, 102, 102));
        txtCorreo.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(380, 90, 210, 70);

        txtDNI.setBackground(new java.awt.Color(102, 102, 102));
        txtDNI.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(255, 255, 255));
        txtDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(txtDNI);
        txtDNI.setBounds(20, 90, 120, 70);

        txtTelefono.setBackground(new java.awt.Color(102, 102, 102));
        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(600, 90, 170, 70);

        dcFechaNacimiento.setBackground(new java.awt.Color(102, 102, 102));
        dcFechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        dcFechaNacimiento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jPanel1.add(dcFechaNacimiento);
        dcFechaNacimiento.setBounds(520, 10, 200, 70);

        cboCargo.setBackground(new java.awt.Color(102, 102, 102));
        cboCargo.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboCargo.setForeground(new java.awt.Color(255, 255, 255));
        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente Administrativo", "Coordinador de Transportes", "Jefe de Compras", "Jefe de Transporte" }));
        cboCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(cboCargo);
        cboCargo.setBounds(20, 180, 220, 60);

        cboSeguro.setBackground(new java.awt.Color(102, 102, 102));
        cboSeguro.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboSeguro.setForeground(new java.awt.Color(255, 255, 255));
        cboSeguro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Essalud", "Rimac", "Pacifico", "MAPFRE" }));
        cboSeguro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seguro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(cboSeguro);
        cboSeguro.setBounds(250, 180, 160, 60);

        dcFechaContrato.setBackground(new java.awt.Color(102, 102, 102));
        dcFechaContrato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Contrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        dcFechaContrato.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jPanel1.add(dcFechaContrato);
        dcFechaContrato.setBounds(420, 170, 200, 70);

        btnAyuda.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help_question_16768.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda);
        btnAyuda.setBounds(460, 250, 30, 30);

        pnlBtnGuardar.setBackground(new java.awt.Color(80, 143, 61));
        pnlBtnGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlBtnGuardar.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(pnlBtnGuardar);
        pnlBtnGuardar.setBounds(20, 250, 100, 30);

        pnlBtnModificar.setBackground(new java.awt.Color(189, 109, 25));
        pnlBtnModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setBackground(new java.awt.Color(255, 0, 0));
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
        pnlBtnModificar.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(pnlBtnModificar);
        pnlBtnModificar.setBounds(130, 250, 100, 30);

        pnlBtnEliminar.setBackground(new java.awt.Color(176, 40, 30));
        pnlBtnEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        pnlBtnEliminar.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(pnlBtnEliminar);
        pnlBtnEliminar.setBounds(240, 250, 100, 30);

        pnlBtnBuscar.setBackground(new java.awt.Color(35, 128, 184));
        pnlBtnBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        pnlBtnBuscar.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(pnlBtnBuscar);
        pnlBtnBuscar.setBounds(350, 250, 100, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono empleado.png"))); // NOI18N
        jLabel1.setText("   Empleados");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        if(existeEmpleado(getDNI())!=null){
            JOptionPane.showMessageDialog(null, "El empleado ya existe, ingrese otro DNI.", "Error", 0);
            return;
        }
        Empleado nuevo=new Empleado(getCargo(), getSeguro(), getFechaCon(), getDNI(),
                getNombre(), getApellido(), getFechaNac(), getCorreo(), getDireccion(), getTelefono());
        if(nuevo.edad()<18){
            JOptionPane.showMessageDialog(null, "El empleado debe ser mayor de edad.", "Error", 0);
            return;
        }
        listaEmpleados.add(nuevo);
        imprimir();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Empleado modificado=existeEmpleado(getDNI());
        if(modificado==null){
            JOptionPane.showMessageDialog(null, "El empleado no existe, ingrese otro DNI.", "Error", 0);
            return;
        }
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        modificado.nombres=getNombre();
        modificado.apellidos=getApellido();
        modificado.correo=getCorreo();
        modificado.direccion=getDireccion();
        modificado.telefono=getTelefono();
        modificado.fechaNac=getFechaNac();
        modificado.fechaContrato=getFechaCon();
        modificado.cargo=getCargo();
        modificado.seguro=getSeguro();
        JOptionPane.showMessageDialog(null, "Modificado correctamente");
        imprimir();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarEmpleado(getDNI());
        imprimir();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Empleado buscado=existeEmpleado(getDNI());
        if(buscado==null){
            JOptionPane.showMessageDialog(null, "El empleado no existe, ingrese otro DNI.", "Error", 0);
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Empleado: "+buscado.nombres +buscado.apellidos+"\nDNI: "+buscado.DNI+"\nDirección: "+
                buscado.direccion+"\nCorreo: "+buscado.correo+"\nTeléfono: "+buscado.telefono+"\nCargo: "+buscado.cargo+"\nSeguro: "+
                buscado.seguro+"\nFecha de contrato: "+dma.format(buscado.fechaContrato),"Empleado buscado",1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Guardar: Guarda los datos del empleado en una lista, para guardar llene todos los campos.\n"+
                "Modificar: Actualiza los datos del empleado mediante el DNI, ingrese el DNI para modificar los datos.\n"+
                "Eliminar: Remueve los datos del cliente de la lista mediante el DNI.\n"+
                "Buscar: Encuentra los datos del cliente en la lista mediante el DNI, ingrese el DNI para buscar.\n",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if(listaEmpleados.isEmpty()){
            this.dispose();
            return;
        }
        int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?", "Confirmación",
                JOptionPane.YES_NO_OPTION, 3);
        if(respuesta==JOptionPane.YES_OPTION){
            escribirArchivo();
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        if(txtNombres.getText().length()>=30) evt.consume();
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        if(txtApellidos.getText().length()>=30) evt.consume();
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        if(txtDNI.getText().length()>=8) evt.consume();
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if(txtDireccion.getText().length()>=40) evt.consume();
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        if(txtCorreo.getText().length()>=40) evt.consume();
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if(txtTelefono.getText().length()>=9) evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios en el registro antes de salir?", "Confirmacion",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            escribirArchivo();
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION){;
            this.dispose();
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

    void getColorBtn(){
        pnlGcolor=pnlBtnGuardar.getBackground();
        pnlBcolor =pnlBtnBuscar.getBackground();
        pnlMcolor=pnlBtnModificar.getBackground();
        pnlEcolor=pnlBtnEliminar.getBackground();
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

    
    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(125, 24, 1));
    }//GEN-LAST:event_lblCerrarMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        pnlBtnGuardar.setBackground(setColorBtn(pnlGcolor, 12));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        pnlBtnGuardar.setBackground(pnlGcolor);
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        pnlBtnGuardar.setBackground(setColorBtn(pnlGcolor, 20));
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        pnlBtnGuardar.setBackground(setColorBtn(pnlGcolor, 12));
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        pnlBtnModificar.setBackground(setColorBtn(pnlMcolor, 12));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        pnlBtnModificar.setBackground(pnlMcolor);
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMousePressed
        pnlBtnModificar.setBackground(pnlMcolor);
    }//GEN-LAST:event_btnModificarMousePressed

    private void btnModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseReleased
        pnlBtnModificar.setBackground(setColorBtn(pnlMcolor, 20));
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboSeguro;
    private com.toedter.calendar.JDateChooser dcFechaContrato;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlBtnEliminar;
    private javax.swing.JPanel pnlBtnGuardar;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
