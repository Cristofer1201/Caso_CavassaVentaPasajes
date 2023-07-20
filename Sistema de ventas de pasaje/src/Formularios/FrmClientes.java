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
public class FrmClientes extends javax.swing.JInternalFrame {

    List<Cliente> listaClientes=new LinkedList();
    List<Cliente> listaauxClientes=new LinkedList();
    File archivo = new File("Clientes.txt");
    
    Color pnlGcolor,pnlMcolor,pnlEcolor,pnlBcolor,pnlVRcolor,pnlGRcolor;
    DefaultTableModel Tabla;
    String[] cabecera={"DNI", "Nombres", "Apellidos", "Direccion","Correo", 
        "Telefono", "Fecha Nacimiento"};
    String[][] datos={};
    
    public FrmClientes(int w) {
        initComponents();
        this.setLocation(w, 0);
        // para borrar el header del form
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getColorBtn();
        establecerTamanio();
        
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
    
    void establecerTamanio(){
        this.setSize(new Dimension(773, 639));
    }
    void cambiarTamanioColumnas(){
        
        tblClientes.getTableHeader().setFont(new Font ("Century Cothic",Font.BOLD,13));
        tblClientes.getTableHeader().setBackground(new Color(125,24,1));

        
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
    void pasarLista(){
        for (int i = 0; i < listaauxClientes.size(); i++) {
            listaClientes.add(listaauxClientes.get(i));
        }
        listaauxClientes.clear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        pnlBtnGuardar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        pnlBtnModificar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        pnlBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        pnlBtnVerRegistro = new javax.swing.JPanel();
        btnVerRegistro = new javax.swing.JButton();
        pnlBtnGuardarRegistro = new javax.swing.JPanel();
        btnGuardarRegistro = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
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

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));
        jPanel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.setLayout(null);

        txtCorreo.setBackground(new java.awt.Color(125, 24, 1));
        txtCorreo.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(280, 90, 300, 60);

        txtApellidos.setBackground(new java.awt.Color(125, 24, 1));
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
        txtApellidos.setBounds(310, 20, 270, 60);

        txtNombres.setBackground(new java.awt.Color(125, 24, 1));
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
        txtNombres.setBounds(30, 20, 270, 60);

        txtDNI.setBackground(new java.awt.Color(125, 24, 1));
        txtDNI.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(255, 255, 255));
        txtDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(txtDNI);
        txtDNI.setBounds(590, 20, 150, 60);

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
        tblClientes.setToolTipText("");
        tblClientes.setGridColor(new java.awt.Color(255, 255, 0));
        tblClientes.setSelectionBackground(new java.awt.Color(125, 24, 1));
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 300, 710, 250);

        dcFechaNacimiento.setBackground(new java.awt.Color(125, 24, 1));
        dcFechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        dcFechaNacimiento.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jPanel1.add(dcFechaNacimiento);
        dcFechaNacimiento.setBounds(30, 160, 210, 70);

        txtDireccion.setBackground(new java.awt.Color(125, 24, 1));
        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(30, 90, 240, 60);

        txtTelefono.setBackground(new java.awt.Color(125, 24, 1));
        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(590, 90, 150, 60);

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
        pnlBtnBuscar.setBounds(360, 250, 100, 30);

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
        pnlBtnGuardar.setBounds(30, 250, 100, 30);

        pnlBtnModificar.setBackground(new java.awt.Color(189, 109, 25));
        pnlBtnModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        pnlBtnModificar.setBounds(140, 250, 100, 30);

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
        pnlBtnEliminar.setBounds(250, 250, 100, 30);

        pnlBtnVerRegistro.setBackground(new java.awt.Color(28, 176, 114));
        pnlBtnVerRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVerRegistro.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnVerRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnVerRegistro.setText("Ver registro");
        btnVerRegistro.setContentAreaFilled(false);
        btnVerRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerRegistroMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerRegistroMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVerRegistroMouseReleased(evt);
            }
        });
        btnVerRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRegistroActionPerformed(evt);
            }
        });
        pnlBtnVerRegistro.add(btnVerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        jPanel1.add(pnlBtnVerRegistro);
        pnlBtnVerRegistro.setBounds(470, 250, 110, 30);

        pnlBtnGuardarRegistro.setBackground(new java.awt.Color(158, 158, 6));
        pnlBtnGuardarRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardarRegistro.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnGuardarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarRegistro.setText("Guardar registro");
        btnGuardarRegistro.setContentAreaFilled(false);
        btnGuardarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarRegistroMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarRegistroMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarRegistroMouseReleased(evt);
            }
        });
        btnGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegistroActionPerformed(evt);
            }
        });
        pnlBtnGuardarRegistro.add(btnGuardarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        jPanel1.add(pnlBtnGuardarRegistro);
        pnlBtnGuardarRegistro.setBounds(590, 250, 140, 30);

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help_question_16768.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda);
        btnAyuda.setBounds(690, 190, 40, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleName("Registrar Cliente");

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono cliente.png"))); // NOI18N
        jLabel1.setText("   Clientes");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(),"Error",0);
            return;
        }
        if(existeCliente(Integer.parseInt(txtDNI.getText()))!=null){
            JOptionPane.showMessageDialog(null, "El cliente ya existe, ingrese otro DNI.","Error",0);
            return;
        }
        
        Cliente nuevoc=new Cliente();
        nuevoc.nombres=txtNombres.getText();
        nuevoc.apellidos=txtApellidos.getText();
        nuevoc.direccion=txtDireccion.getText();
        nuevoc.correo=txtCorreo.getText();
        nuevoc.DNI=Integer.parseInt(txtDNI.getText());
        nuevoc.telefono=Integer.parseInt(txtTelefono.getText());
        nuevoc.fechaNac=dcFechaNacimiento.getDate();
        if(nuevoc.edad() < 18){
            int respuesta=JOptionPane.showConfirmDialog(null, "El cliente es menor de edad, ¿Desea continuar?.",
                    "Confirmacion",JOptionPane.YES_NO_OPTION, 3);
            if(respuesta==JOptionPane.NO_OPTION || respuesta==JOptionPane.CLOSED_OPTION) return;
        }
        listaauxClientes.add(nuevoc);
        imprimir();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    Cliente existeCliente(int dni){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(dni==listaClientes.get(i).DNI){
                return listaClientes.get(i);
            }
        }
        for (int i = 0; i < listaauxClientes.size(); i++) {
            if(dni==listaauxClientes.get(i).DNI){
                return listaauxClientes.get(i);
            }
        }
        return null;
    }
    
    void imprimir(){
        Tabla.setRowCount(0);
        SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaauxClientes.size(); i++) {
            Object[] fila={listaauxClientes.get(i).DNI,listaauxClientes.get(i).nombres,listaauxClientes.get(i).apellidos,
                listaauxClientes.get(i).direccion, listaauxClientes.get(i).correo,listaauxClientes.get(i).telefono,
                dma.format(listaauxClientes.get(i).fechaNac)};
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
        dcFechaNacimiento.setDate(null);
    }
    void limpiarPK(){
        txtDNI.setText("");
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(),"Error",0);
            return;
        }
        // SI EXISTE DEVULEVE CLIENTE SI NO EXISTE DEVUELVE NULL
        Cliente buscado=existeCliente(Integer.parseInt(txtDNI.getText()));
        if(buscado == null){
            JOptionPane.showMessageDialog(null, "El cliente no existe, ingrese otro DNI");
            return;
        }
        JOptionPane.showMessageDialog(null, "Nombres: "+buscado.nombres+"\n"
                    + "Apellidos: " +buscado.apellidos+"\n"+"DNI: "+buscado.DNI+"\n"
                    +"Direccion: "+buscado.direccion+"\n"+"Correo: "+buscado.correo+"\n"+
                    "Telefono: "+buscado.telefono);
        limpiarPK();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(listaauxClientes.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista de clientes a registrar se encuentra vacía.", "Error", 0);
            return;
        }
        eliminarCliente();
        imprimir();
    }//GEN-LAST:event_btnEliminarActionPerformed

    void eliminarCliente(){
        try{
            int fila=tblClientes.getSelectedRow();
            int dni=Integer.parseInt(tblClientes.getValueAt(fila, 0).toString());
            for (int i = 0; i < 10; i++) {
                if(listaauxClientes.get(i).DNI==dni){
                    listaauxClientes.remove(i);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Se elimino correctamente.","Confirmación",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla para eliminar.","Error",0);
        }
    }
    
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
            for (int i = 0; i < listaauxClientes.size(); i++) {
                if(listaauxClientes.get(i).DNI==Integer.parseInt(txtDNI.getText())){
                    listaauxClientes.get(i).nombres=txtNombres.getText();
                    listaauxClientes.get(i).apellidos=txtApellidos.getText();
                    listaauxClientes.get(i).direccion=txtDireccion.getText();
                    listaauxClientes.get(i).correo=txtCorreo.getText();
                    listaauxClientes.get(i).telefono=Integer.parseInt(txtTelefono.getText());
                    listaauxClientes.get(i).fechaNac=dcFechaNacimiento.getDate();
                    break;
                }
            }
            imprimir();
            limpiar();
            JOptionPane.showMessageDialog(null, "Modificado correctamente.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    void getColorBtn(){
        pnlGcolor=pnlBtnGuardar.getBackground();
        pnlMcolor=pnlBtnModificar.getBackground();
        pnlEcolor=pnlBtnEliminar.getBackground();
        pnlBcolor=pnlBtnBuscar.getBackground();
        pnlVRcolor=pnlBtnVerRegistro.getBackground();
        pnlGRcolor=pnlBtnGuardarRegistro.getBackground();
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
    
    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
    }//GEN-LAST:event_formInternalFrameClosing
    
    FrmResgistroClientes nuevoRegC=new FrmResgistroClientes(0);
    private void btnVerRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRegistroActionPerformed
        if(!nuevoRegC.isShowing()){
            nuevoRegC=new FrmResgistroClientes(this.getLocation().x);
            this.getDesktopPane().add(nuevoRegC);
            nuevoRegC.show();
        }
        
    }//GEN-LAST:event_btnVerRegistroActionPerformed

    private void btnGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        if(listaauxClientes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay clientes en la lista.");
            return;
        }
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro?", "Confirmacion", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            pasarLista();
            escribirArchivo();
            imprimir();
            JOptionPane.showMessageDialog(null, "Se registraron los datos correctamente al registro,"
                    + " para visualizarlo haga click en Ver registro.","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Guardar: Guarda los datos del cliente en una lista pequeña, para guardar llene todos los campos.\n"+
                "Modificar: Actualiza los datos del cliente mediante el DNI, ingrese el DNI para modificar los datos.\n"+
                "Eliminar: Remueve los datos del cliente de la lista seleccionandolo desde la tabla.\n"+
                "Buscar: Encuentra los datos del cliente en la lista mediante el DNI, ingrese el DNI para buscar.\n"+
                "Guardar registro: Guarda los datos del cliente en la lista general de clientes.\n"+
                "Ver registro: El sistema abre un formulario donde se podra visualizar todos los clientes registrados.",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

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
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios en el registro antes de salir?", "Confirmacion", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            pasarLista();
            escribirArchivo();
            nuevoRegC.escribirArchivo();
            nuevoRegC.dispose();
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION){
            nuevoRegC.escribirArchivo();
            nuevoRegC.dispose();
            this.dispose();
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

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

    private void btnVerRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerRegistroMouseEntered
        pnlBtnVerRegistro.setBackground(setColorBtn(pnlVRcolor, 12));
    }//GEN-LAST:event_btnVerRegistroMouseEntered

    private void btnVerRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerRegistroMouseExited
        pnlBtnVerRegistro.setBackground(pnlVRcolor);
    }//GEN-LAST:event_btnVerRegistroMouseExited

    private void btnVerRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerRegistroMousePressed
        pnlBtnVerRegistro.setBackground(setColorBtn(pnlVRcolor, 20));
    }//GEN-LAST:event_btnVerRegistroMousePressed

    private void btnVerRegistroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerRegistroMouseReleased
        pnlBtnVerRegistro.setBackground(setColorBtn(pnlVRcolor, 12));
    }//GEN-LAST:event_btnVerRegistroMouseReleased

    private void btnGuardarRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarRegistroMouseEntered
        pnlBtnGuardarRegistro.setBackground(setColorBtn(pnlGRcolor, 12));
    }//GEN-LAST:event_btnGuardarRegistroMouseEntered

    private void btnGuardarRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarRegistroMouseExited
        pnlBtnGuardarRegistro.setBackground(pnlGRcolor);
    }//GEN-LAST:event_btnGuardarRegistroMouseExited

    private void btnGuardarRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarRegistroMousePressed
        pnlBtnGuardarRegistro.setBackground(setColorBtn(pnlGRcolor, 20));
    }//GEN-LAST:event_btnGuardarRegistroMousePressed

    private void btnGuardarRegistroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarRegistroMouseReleased
        pnlBtnGuardarRegistro.setBackground(setColorBtn(pnlGRcolor, 12));
    }//GEN-LAST:event_btnGuardarRegistroMouseReleased

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
    private javax.swing.JButton btnGuardarRegistro;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVerRegistro;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlBtnEliminar;
    private javax.swing.JPanel pnlBtnGuardar;
    private javax.swing.JPanel pnlBtnGuardarRegistro;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlBtnVerRegistro;
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
