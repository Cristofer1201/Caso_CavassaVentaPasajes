/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Clases.Bus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author CRISTOFER
 */
public class FrmBus extends javax.swing.JInternalFrame {

    List<Bus> listaBuses=new LinkedList();
    File archivo = new File("Buses.txt");
    
    Color btnG,btnB,btnM,btnE,btnID;
    DefaultTableModel Tabla;
    String[] cabecera={"Numero bus", "Marca", "Modelo", "Placa", "Servicio", "Numero de asientos"};
    String[][] datos={};
    
    public FrmBus(int w) {
        initComponents();
        this.setLocation(w, 0);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        getColorBtn();
        establecerTamanio();
        
        SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
        Tabla = new DefaultTableModel(datos, cabecera); 
        tblBuses.setModel(Tabla);
        cambiarTamanioColumnas();
        if (archivo.exists()) {
            listaBuses = leerArchivo();
            btnInfoDestino.setEnabled(true);
        }
        imprimir();
        limpiar();
    }
    void establecerTamanio(){
        this.setMinimumSize(new Dimension(742, 578));
        this.setSize(new Dimension(742, 578));
    }
    void cambiarTamanioColumnas(){
        tblBuses.getTableHeader().setFont(new Font ("Century Cothic",Font.BOLD,13));
        tblBuses.getTableHeader().setBackground(new Color(0, 133, 66));
        
        TableColumn columna=null;
        columna=tblBuses.getColumnModel().getColumn(1);
        columna.setPreferredWidth(120);
        columna=tblBuses.getColumnModel().getColumn(2);
        columna.setPreferredWidth(120);
    }
    List<Bus> leerArchivo() {
        try {
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Buses.txt"));
            List<Bus> listaAux = (List<Bus>) leer.readObject();
            leer.close();
            return listaAux;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    void escribirArchivo() {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Buses.txt"));
            escribir.writeObject(listaBuses);
            escribir.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuses = new javax.swing.JTable();
        txtCantidadAsientos = new javax.swing.JTextField();
        txtNroBus = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbVIP = new javax.swing.JRadioButton();
        rbEconomico = new javax.swing.JRadioButton();
        btnAyuda = new javax.swing.JButton();
        pnlBtnInfoDes = new javax.swing.JPanel();
        btnInfoDestino = new javax.swing.JButton();
        pnlBtnModificar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        pnlBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        pnlBtnGuardar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModelo.setBackground(new java.awt.Color(102, 102, 102));
        txtModelo.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 260, 70));

        txtMarca.setBackground(new java.awt.Color(102, 102, 102));
        txtMarca.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(255, 255, 255));
        txtMarca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 250, 70));

        txtPlaca.setBackground(new java.awt.Color(102, 102, 102));
        txtPlaca.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(255, 255, 255));
        txtPlaca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Placa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 70));

        tblBuses.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tblBuses.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuses.setGridColor(new java.awt.Color(153, 255, 153));
        tblBuses.setSelectionBackground(new java.awt.Color(0, 133, 66));
        tblBuses.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBuses);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 670, 250));

        txtCantidadAsientos.setBackground(new java.awt.Color(102, 102, 102));
        txtCantidadAsientos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCantidadAsientos.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidadAsientos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad de asientos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtCantidadAsientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadAsientosKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidadAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 180, 70));

        txtNroBus.setBackground(new java.awt.Color(102, 102, 102));
        txtNroBus.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNroBus.setForeground(new java.awt.Color(255, 255, 255));
        txtNroBus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar, eliminar, buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNroBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroBusKeyTyped(evt);
            }
        });
        jPanel1.add(txtNroBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 210, 70));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(null);

        buttonGroup1.add(rbVIP);
        rbVIP.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rbVIP.setForeground(new java.awt.Color(255, 255, 255));
        rbVIP.setText("VIP");
        rbVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVIPActionPerformed(evt);
            }
        });
        jPanel2.add(rbVIP);
        rbVIP.setBounds(10, 40, 70, 21);

        buttonGroup1.add(rbEconomico);
        rbEconomico.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rbEconomico.setForeground(new java.awt.Color(255, 255, 255));
        rbEconomico.setText("Economico");
        jPanel2.add(rbEconomico);
        rbEconomico.setBounds(10, 20, 98, 21);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 120, 70));

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help_question_16768.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 40, 30));

        pnlBtnInfoDes.setBackground(new java.awt.Color(84, 57, 184));
        pnlBtnInfoDes.setLayout(new java.awt.BorderLayout());

        btnInfoDestino.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnInfoDestino.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoDestino.setText("Informacion de destino");
        btnInfoDestino.setContentAreaFilled(false);
        btnInfoDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInfoDestinoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInfoDestinoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInfoDestinoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInfoDestinoMouseReleased(evt);
            }
        });
        btnInfoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoDestinoActionPerformed(evt);
            }
        });
        pnlBtnInfoDes.add(btnInfoDestino, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlBtnInfoDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 180, 30));

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

        jPanel1.add(pnlBtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 100, 30));

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

        jPanel1.add(pnlBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 100, 30));

        pnlBtnGuardar.setBackground(new java.awt.Color(80, 143, 61));
        pnlBtnGuardar.setLayout(new java.awt.BorderLayout());

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
        pnlBtnGuardar.add(btnGuardar, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 30));

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

        jPanel1.add(pnlBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 100, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono bus.png"))); // NOI18N
        jLabel1.setText("   Bus");
        jLabel1.setToolTipText("");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        setBounds(20, 20, 744, 583);
    }// </editor-fold>//GEN-END:initComponents

    String validarDatos(){
        if(txtMarca.getText().equals("") || txtModelo.getText().equals("") || 
                txtPlaca.getText().equals("") || (getServicio().equals("")) ||
                txtCantidadAsientos.getText().equals("")){
            return "Uno o mas datos estan incompletos.";
        }else if(!esNumero(txtCantidadAsientos.getText())){
            return "La cantidad de asientos es numerica";
        }else if(getCantidadAsientos()<=10 || getCantidadAsientos()>90){
            return "Ingrese una cantidad de asientos entre 11 y 90";
        }
        return "";
    }
    String validarPK(){
        if(txtNroBus.getText().equals("")){
            return "Ingrese un número de bus válido (B-X).";
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

    String getMarca(){
        return txtMarca.getText();
    }
    String getModelo(){
        return txtModelo.getText();
    }
    String getPlaca(){
        return txtPlaca.getText();
    }
    String getServicio(){
        if(rbEconomico.isSelected()) return "Economico";
        else if(rbVIP.isSelected()) return "VIP";
        else return "";
    }
    int getCantidadAsientos(){
        return Integer.parseInt(txtCantidadAsientos.getText());
    }
    String getNroBus(){
        return txtNroBus.getText();
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        Bus nuevoB=new Bus(getMarca(), getModelo(), getPlaca(), getServicio(), getCantidadAsientos());
        listaBuses.add(nuevoB);
        numeroBus();
        imprimir();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed
 
    void numeroBus(){
        for (int i = 0; i < listaBuses.size(); i++) {
            listaBuses.get(i).nroBus = "B-" + (i + 1);
        }
    }
    Bus existeBus(String nro){
        for (int i = 0; i < listaBuses.size(); i++) {
            if(listaBuses.get(i).nroBus.equals(nro)){
                return listaBuses.get(i);
            }
        }
        return null;
    }
    void imprimir(){
        Tabla.setRowCount(0);
        for (int i = 0; i < listaBuses.size(); i++) {
            Object[] fila={listaBuses.get(i).nroBus,listaBuses.get(i).marca,
                listaBuses.get(i).modelo,listaBuses.get(i).placa, listaBuses.get(i).servicio,
                listaBuses.get(i).cantidadAsientos};
            Tabla.addRow(fila);
        }
    }
    void limpiar(){
        txtCantidadAsientos.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtPlaca.setText("");
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        Bus modificado=existeBus(getNroBus());
        if(modificado==null){
            JOptionPane.showMessageDialog(null, "El bus NO existe, ingrese otro numero de bus.");
            return;
        }
        modificado.marca=getMarca();
        modificado.modelo=getModelo();
        modificado.placa=getPlaca();
        modificado.servicio=getServicio();
        modificado.cantidadAsientos=getCantidadAsientos();
        imprimir();
        limpiar();
        JOptionPane.showMessageDialog(null, "Modificado correctamente.");
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        eliminarBus(txtNroBus.getText());
    }//GEN-LAST:event_btnEliminarActionPerformed

    void eliminarBus(String nro){
        if(existeBus(nro) == null){
            JOptionPane.showMessageDialog(null, "El bus no existe, ingrese otro numero de bus.");
            return;
        }
        for (int i = 0; i < listaBuses.size(); i++) {
            if(listaBuses.get(i).nroBus.equals(nro)){
                listaBuses.remove(i);
            }
            numeroBus();
            imprimir();
        }
        JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Bus buscado=existeBus(getNroBus());
        if(buscado==null){
            JOptionPane.showMessageDialog(null, "El bus no existe, ingrese otro numero de bus.","Error",0);
            return;
        }
        JOptionPane.showMessageDialog(null, "Numero de bus: "+buscado.nroBus+"\n"
                + "Marca: " +buscado.marca+"\n"+"Modelo: "+buscado.modelo+"\n"
                +"Placa: "+buscado.placa+"\n"+"Numero de asientos: "+buscado.cantidadAsientos,
                "Bus encontrado",1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Guardar: Guarda los datos del bus en la lista, para guardar llene todos los campos.\n"+
            "Modificar: Actualiza los datos del bus mediante el numero de bus, ingrese el numero para modificar los datos.\n"+
            "Eliminar: Remueve los datos del bus de la lista mediante el numero.\n"+
            "Buscar: Encuentra los datos del bus en la lista mediante el numero.\n",
            "Ayuda", 1);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if(listaBuses.isEmpty()){
            this.dispose();
            escribirArchivo();
        }
        int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?", "Confirmación", 0,3);
        if(respuesta==JOptionPane.YES_OPTION){
            escribirArchivo();
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void rbVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbVIPActionPerformed

    FrmInfoDestino nuevoInf=new FrmInfoDestino(0);
    private void btnInfoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoDestinoActionPerformed
        if(listaBuses.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay buses regitrados.", "Error", 0);
            return;
        }
        if(!nuevoInf.isShowing()){
            nuevoInf=new FrmInfoDestino(this.getLocation().x);
            this.getDesktopPane().add(nuevoInf);
            nuevoInf.show();
        }
    }//GEN-LAST:event_btnInfoDestinoActionPerformed

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        if(txtMarca.getText().length()>=30){
            evt.consume();
        }
    }//GEN-LAST:event_txtMarcaKeyTyped

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        if(txtModelo.getText().length()>=40){
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloKeyTyped

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        if(txtPlaca.getText().length()>=7){
            evt.consume();
        }
    }//GEN-LAST:event_txtPlacaKeyTyped

    private void txtCantidadAsientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadAsientosKeyTyped
        if(txtCantidadAsientos.getText().length()>=2){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadAsientosKeyTyped

    private void txtNroBusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroBusKeyTyped
        if(txtNroBus.getText().length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_txtNroBusKeyTyped

    void getColorBtn(){
        btnG=pnlBtnGuardar.getBackground();
        btnB=pnlBtnBuscar.getBackground();
        btnM=pnlBtnModificar.getBackground();
        btnE=pnlBtnEliminar.getBackground();
        btnID=pnlBtnInfoDes.getBackground();
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
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        pnlBtnGuardar.setBackground(setColorBtn(btnG, 12));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        pnlBtnGuardar.setBackground(btnG);
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        pnlBtnGuardar.setBackground(setColorBtn(btnG, 20));
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        pnlBtnGuardar.setBackground(setColorBtn(btnG, 12));
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        pnlBtnModificar.setBackground(setColorBtn(btnM, 12));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        pnlBtnModificar.setBackground(btnM);
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMousePressed
        pnlBtnModificar.setBackground(setColorBtn(btnM, 20));
    }//GEN-LAST:event_btnModificarMousePressed

    private void btnModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseReleased
        pnlBtnModificar.setBackground(setColorBtn(btnM, 12));
    }//GEN-LAST:event_btnModificarMouseReleased

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        pnlBtnEliminar.setBackground(setColorBtn(btnE, 12));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        pnlBtnEliminar.setBackground(btnE);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        pnlBtnEliminar.setBackground(setColorBtn(btnE, 20));
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseReleased
        pnlBtnEliminar.setBackground(setColorBtn(btnE, 12));
    }//GEN-LAST:event_btnEliminarMouseReleased

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        pnlBtnBuscar.setBackground(setColorBtn(btnB, 12));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        pnlBtnBuscar.setBackground(btnB);
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
        pnlBtnBuscar.setBackground(setColorBtn(btnB, 20));
    }//GEN-LAST:event_btnBuscarMousePressed

    private void btnBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseReleased
        pnlBtnBuscar.setBackground(setColorBtn(btnB, 12));
    }//GEN-LAST:event_btnBuscarMouseReleased

    private void btnInfoDestinoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMouseEntered
        pnlBtnInfoDes.setBackground(setColorBtn(btnID, 12));
    }//GEN-LAST:event_btnInfoDestinoMouseEntered

    private void btnInfoDestinoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMouseExited
        pnlBtnInfoDes.setBackground(btnID);
    }//GEN-LAST:event_btnInfoDestinoMouseExited

    private void btnInfoDestinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMousePressed
        pnlBtnInfoDes.setBackground(setColorBtn(btnID, 20));
    }//GEN-LAST:event_btnInfoDestinoMousePressed

    private void btnInfoDestinoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMouseReleased
        pnlBtnInfoDes.setBackground(setColorBtn(btnID, 12));
    }//GEN-LAST:event_btnInfoDestinoMouseReleased

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?", "Confirmación", 0,3);
        if(respuesta==JOptionPane.YES_OPTION){
            escribirArchivo();
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(0, 133, 66));
    }//GEN-LAST:event_lblCerrarMouseExited

    private void pnlCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseEntered

    }//GEN-LAST:event_pnlCerrarMouseEntered

    private void pnlCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseExited

    }//GEN-LAST:event_pnlCerrarMouseExited

    private void pnlCerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseReleased

    }//GEN-LAST:event_pnlCerrarMouseReleased

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
    private javax.swing.JButton btnInfoDestino;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlBtnEliminar;
    private javax.swing.JPanel pnlBtnGuardar;
    private javax.swing.JPanel pnlBtnInfoDes;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JRadioButton rbEconomico;
    private javax.swing.JRadioButton rbVIP;
    private javax.swing.JTable tblBuses;
    private javax.swing.JTextField txtCantidadAsientos;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNroBus;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
