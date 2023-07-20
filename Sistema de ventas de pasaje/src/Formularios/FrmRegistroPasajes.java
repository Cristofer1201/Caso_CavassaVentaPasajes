/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Clases.Pasaje;
import Clases.RegistroPasajes;
import Clases.RegistroVenta;
import Clases.Venta;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author CRISTOFER
 */
public class FrmRegistroPasajes extends javax.swing.JInternalFrame {

    RegistroPasajes regPas=new RegistroPasajes();
    
    File archivo=new File("Pasajes.txt");
    
    Color pnlBcolor;
    DefaultTableModel Tabla;
    String[] cabecera={"Pasaje ID","Estado","Cliente", "DNI","Bus","Nro. Asiento","Servicio","Origen","Destino","Fecha","Hora","Precio"};
    String[][] datos={};
    
    SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hm=new SimpleDateFormat("hh:mm");
    
    void establecerTamanio(){
        this.setMinimumSize(new Dimension(1000, 640));
        this.setSize(new Dimension(1000, 640));
        
    }
    void cambiarTamanioColumnas(){
        TableColumn columna=null;
        columna=tblRegPas.getColumnModel().getColumn(0);
        columna.setPreferredWidth(120);
        columna=tblRegPas.getColumnModel().getColumn(2);
        columna.setPreferredWidth(80);
        columna=tblRegPas.getColumnModel().getColumn(4);
        columna.setPreferredWidth(80);
        columna=tblRegPas.getColumnModel().getColumn(7);
        columna.setPreferredWidth(80);
        columna=tblRegPas.getColumnModel().getColumn(8);
        columna.setPreferredWidth(80);
        columna=tblRegPas.getColumnModel().getColumn(9);
        columna.setPreferredWidth(80);
    }
    RegistroPasajes leerArchivo(){
        try{
            ObjectInputStream leer=new ObjectInputStream(new FileInputStream("Pasajes.txt"));
            RegistroPasajes listaAux=(RegistroPasajes) leer.readObject();
            leer.close();
            return listaAux;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    TextAutoCompleter acID;
    void txtAutocompletarID(){
        for (int i = 0; i < regPas.lista.size(); i++) {
            String ID = regPas.lista.get(i).pasajeID;
            acID.addItem(ID);
        }
    }
    
    void imprimir(){
        if(regPas.lista.isEmpty()) return;
        Tabla.setRowCount(0);
        for (int i = 0; i < regPas.lista.size(); i++) {
            Object[] fila = {regPas.lista.get(i).pasajeID, regPas.lista.get(i).descripcion,
                regPas.lista.get(i).venta.viaje.pasajero.nombres + " "+ regPas.lista.get(i).venta.viaje.pasajero.apellidos,
                regPas.lista.get(i).venta.viaje.pasajero.DNI, regPas.lista.get(i).venta.viaje.movilidad.nroBus,
                regPas.lista.get(i).venta.viaje.nroAsiento, regPas.lista.get(i).venta.viaje.movilidad.servicio,
                regPas.lista.get(i).venta.viaje.origen.departamento, regPas.lista.get(i).venta.viaje.destino.departamento,
                dma.format(regPas.lista.get(i).venta.viaje.fechaOrigen), hm.format(regPas.lista.get(i).venta.viaje.horaOrigen),
                regPas.lista.get(i).venta.costo() + " $"};
            Tabla.addRow(fila);
        }
    }
    void imprimir(int mes, int anio){
        if(regPas.lista.isEmpty()) return;
        Tabla.setRowCount(0);
        double total=0;
        for (int i = 0; i < regPas.lista.size(); i++) {
            if (regPas.lista.get(i).venta.viaje.fechaOrigen.getMonth() == mes && regPas.lista.get(i).venta.viaje.fechaOrigen.getYear() == anio) {
                Object[] fila = {regPas.lista.get(i).pasajeID, regPas.lista.get(i).descripcion,
                    regPas.lista.get(i).venta.viaje.pasajero.nombres + " " + regPas.lista.get(i).venta.viaje.pasajero.apellidos,
                    regPas.lista.get(i).venta.viaje.pasajero.DNI, regPas.lista.get(i).venta.viaje.movilidad.nroBus,
                    regPas.lista.get(i).venta.viaje.nroAsiento, regPas.lista.get(i).venta.viaje.movilidad.servicio,
                    regPas.lista.get(i).venta.viaje.origen.departamento, regPas.lista.get(i).venta.viaje.destino.departamento,
                    dma.format(regPas.lista.get(i).venta.viaje.fechaOrigen), hm.format(regPas.lista.get(i).venta.viaje.horaOrigen),
                    regPas.lista.get(i).venta.costo() + " $"};
                Tabla.addRow(fila);
            }
        }
        lblTotal.setText(String.valueOf(total)+" $");
    }
    void imprimir(int mes, int anio, String estado){
        if(regPas.lista.isEmpty()) return;
        Tabla.setRowCount(0);
        double total=0;
        for (int i = 0; i < regPas.lista.size(); i++) {
            if (regPas.lista.get(i).venta.viaje.fechaOrigen.getMonth() == mes && regPas.lista.get(i).venta.viaje.fechaOrigen.getYear() == anio
                    && regPas.lista.get(i).descripcion.equals(estado)) {
                Object[] fila = {regPas.lista.get(i).pasajeID, regPas.lista.get(i).descripcion,
                    regPas.lista.get(i).venta.viaje.pasajero.nombres + " " + regPas.lista.get(i).venta.viaje.pasajero.apellidos,
                    regPas.lista.get(i).venta.viaje.pasajero.DNI, regPas.lista.get(i).venta.viaje.movilidad.nroBus,
                    regPas.lista.get(i).venta.viaje.nroAsiento, regPas.lista.get(i).venta.viaje.movilidad.servicio,
                    regPas.lista.get(i).venta.viaje.origen.departamento, regPas.lista.get(i).venta.viaje.destino.departamento,
                    dma.format(regPas.lista.get(i).venta.viaje.fechaOrigen), hm.format(regPas.lista.get(i).venta.viaje.horaOrigen),
                    regPas.lista.get(i).venta.costo() + " $"};
                Tabla.addRow(fila);
            }
        }
        lblTotal.setText(String.valueOf(total)+" $");
    }
    void insertarAnio(){
        cboAnio.removeAllItems();
        Date h=new Date();
        for (int i = 2015; i <= h.getYear()+1900 ; i++) {
            cboAnio.addItem(String.valueOf(i));
        }
    }
    void limpiar(){
        txtPasajeID.setText("");
    }
    public FrmRegistroPasajes(int w) {
        initComponents();
        this.setLocation(w, 0);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        establecerTamanio();
        insertarAnio();
        getColorBtn();
        Tabla=new DefaultTableModel(datos,cabecera);
        tblRegPas.setModel(Tabla);
        if(archivo.exists()){
            regPas=leerArchivo();
        }
        acID=new TextAutoCompleter(txtPasajeID);
        txtAutocompletarID();
        cambiarTamanioColumnas();
    }

    int getMes(){
        switch(String.valueOf(cboMes.getSelectedItem())){
            case "Enero": return 0;
            case "Febrero": return 1;
            case "Marzo": return 2;
            case "Abril": return 3;
            case "Mayo": return 4;
            case "Junio": return 5;
            case "Julio": return 6;
            case "Agosto": return 7;
            case "Septiembre": return 8;
            case "Octubre": return 9;
            case "Noviembre": return 10;
            case "Diciembre": return 11;
        }
        return 0;
    }
    int getAnio(){
        return Integer.parseInt(String.valueOf(cboAnio.getSelectedItem()))-1900;
    }
    String getEstado(){
        return String.valueOf(cboEstado.getSelectedItem());
    }
    String getPasajeID(){
        return txtPasajeID.getText();
    }
    Pasaje existePasaje(String ID){
        for (int i = 0; i < regPas.lista.size(); i++) {
            if(regPas.lista.get(i).pasajeID.equals(ID)){
                return regPas.lista.get(i);
            }
        }
        return null;
    }
    
    boolean validarCBO(){
        if(String.valueOf(cboAnio.getSelectedItem()).equals("") || String.valueOf(cboMes.getSelectedItem()).equals("") ||
                String.valueOf(cboEstado.getSelectedItem()).equals("")){
            return false;
        }
        return true;
    }
    String validarDatos(){
        if(txtPasajeID.getText().equals(""))
            return "Ingrese un ID valido en el campo buscar.";
        else
            return "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboMes = new javax.swing.JComboBox<>();
        cboAnio = new javax.swing.JComboBox<>();
        cboEstado = new javax.swing.JComboBox<>();
        rbNoFiltrar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegPas = new javax.swing.JTable();
        txtPasajeID = new javax.swing.JTextField();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setLayout(null);

        cboMes.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cboMes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMesItemStateChanged(evt);
            }
        });
        jPanel1.add(cboMes);
        cboMes.setBounds(30, 20, 170, 70);

        cboAnio.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboAnio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Año", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        cboAnio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAnioItemStateChanged(evt);
            }
        });
        jPanel1.add(cboAnio);
        cboAnio.setBounds(210, 20, 160, 70);

        cboEstado.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CANCELADO", "ANULADO", "TODOS" }));
        cboEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N
        cboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEstadoItemStateChanged(evt);
            }
        });
        jPanel1.add(cboEstado);
        cboEstado.setBounds(380, 20, 160, 70);

        rbNoFiltrar.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        rbNoFiltrar.setText("No filtrar");
        rbNoFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(rbNoFiltrar);
        rbNoFiltrar.setBounds(560, 40, 120, 21);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("TOTAL:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(780, 550, 60, 17);

        lblTotal.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        lblTotal.setText("0");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(860, 550, 80, 17);

        tblRegPas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tblRegPas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRegPas.setToolTipText("");
        jScrollPane1.setViewportView(tblRegPas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 930, 430);

        txtPasajeID.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtPasajeID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pasaje ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        txtPasajeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasajeIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasajeIDKeyTyped(evt);
            }
        });
        jPanel1.add(txtPasajeID);
        txtPasajeID.setBounds(680, 20, 140, 70);

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
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarKeyTyped(evt);
            }
        });
        pnlBtnBuscar.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(pnlBtnBuscar);
        pnlBtnBuscar.setBounds(850, 40, 100, 30);

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono empleado.png"))); // NOI18N
        jLabel2.setText("   Reporte de Pasajes");
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesItemStateChanged
        if(!validarCBO()) return;
        if(getEstado().equals("TODOS")){
            imprimir(getMes(), getAnio());
            return;
        }
        imprimir(getMes(), getAnio(), getEstado());
    }//GEN-LAST:event_cboMesItemStateChanged

    private void cboAnioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAnioItemStateChanged
        if(!validarCBO()) return;
        if(getEstado().equals("TODOS")){
            imprimir(getMes(), getAnio());
            return;
        }
        imprimir(getMes(), getAnio(), getEstado());
    }//GEN-LAST:event_cboAnioItemStateChanged

    private void cboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEstadoItemStateChanged
        if(!validarCBO()) return;
        if(getEstado().equals("TODOS")){
            imprimir(getMes(), getAnio());
            return;
        }
        imprimir(getMes(), getAnio(), getEstado());
    }//GEN-LAST:event_cboEstadoItemStateChanged

    private void rbNoFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoFiltrarActionPerformed
        if(rbNoFiltrar.isSelected()){
            cboAnio.setEnabled(false);
            cboMes.setEnabled(false);
            cboEstado.setEnabled(false);
            imprimir();
            lblTotal.setText(String.valueOf(regPas.calcularTotal())+" $");
        }else{
            cboAnio.setEnabled(true);
            cboMes.setEnabled(true);
            cboEstado.setEnabled(true);
        }
    }//GEN-LAST:event_rbNoFiltrarActionPerformed

    private void txtPasajeIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasajeIDKeyReleased

    }//GEN-LAST:event_txtPasajeIDKeyReleased

    private void txtPasajeIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasajeIDKeyTyped
        if(txtPasajeID.getText().length()>8)
        btnBuscar.setEnabled(false);
        else btnBuscar.setEnabled(true);
    }//GEN-LAST:event_txtPasajeIDKeyTyped

    void getColorBtn(){
        pnlBcolor =pnlBtnBuscar.getBackground();
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

    FrmPasaje nuevoPasaje;
    void generarPasaje(Pasaje pasaje){
        nuevoPasaje=new FrmPasaje(pasaje,this.getLocation().x);
        this.getDesktopPane().add(nuevoPasaje);
        nuevoPasaje.show();
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        Pasaje buscado=existePasaje(getPasajeID());
        if(buscado==null){
            JOptionPane.showMessageDialog(null, "El pasaje no existe, ingrese otro ID.", "Error", 0);
            return;
        }
        generarPasaje(buscado);
        limpiar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped
        if(txtPasajeID.getText().length()>=8) evt.consume();
    }//GEN-LAST:event_btnBuscarKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(125, 24, 1));
    }//GEN-LAST:event_lblCerrarMouseExited

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboAnio;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JRadioButton rbNoFiltrar;
    private javax.swing.JTable tblRegPas;
    private javax.swing.JTextField txtPasajeID;
    // End of variables declaration//GEN-END:variables
}
