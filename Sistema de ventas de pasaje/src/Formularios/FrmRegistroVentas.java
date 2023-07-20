package Formularios;

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
public class FrmRegistroVentas extends javax.swing.JInternalFrame {

    RegistroVenta regVen=new RegistroVenta();
    File archivo=new File("Ventas.txt");
    
    Color pnlBcolor;
    DefaultTableModel Tabla;
    String[] cabecera={"Venta ID","Cliente", "DNI","Bus","Nro. Asiento","Servicio","Origen","Destino","Fecha","Hora","Precio"};
    String[][] datos={};
    
    SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hm=new SimpleDateFormat("hh:mm");
    
    void establecerTamanio(){
        this.setMinimumSize(new Dimension(950, 650));
        this.setSize(new Dimension(950, 650));
        
    }
    void cambiarTamanioColumnas(){
        TableColumn columna=null;
        columna=tblRegVen.getColumnModel().getColumn(0);
        columna.setPreferredWidth(120);
        columna=tblRegVen.getColumnModel().getColumn(2);
        columna.setPreferredWidth(80);
        columna=tblRegVen.getColumnModel().getColumn(4);
        columna.setPreferredWidth(80);
        columna=tblRegVen.getColumnModel().getColumn(7);
        columna.setPreferredWidth(80);
        columna=tblRegVen.getColumnModel().getColumn(8);
        columna.setPreferredWidth(80);
        columna=tblRegVen.getColumnModel().getColumn(9);
        columna.setPreferredWidth(80);
    }
    
    RegistroVenta leerArchivo(){
        try{
            ObjectInputStream leer=new ObjectInputStream(new FileInputStream("Ventas.txt"));
            RegistroVenta listaAux=(RegistroVenta) leer.readObject();
            leer.close();
            return listaAux;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    TextAutoCompleter acID;
    void txtAutocompletarID(){
        for (int i = 0; i < regVen.lista.size(); i++) {
            String ID = regVen.lista.get(i).viaje.viajeID;
            acID.addItem(ID);
        }
    }
    
    void imprimir(){
        if(regVen.lista.isEmpty()) return;
        Tabla.setRowCount(0);
        for (int i = 0; i < regVen.lista.size(); i++) {
            Object[] fila = {regVen.lista.get(i).viaje.viajeID, regVen.lista.get(i).viaje.pasajero.nombres + " "
                + regVen.lista.get(i).viaje.pasajero.apellidos,
                regVen.lista.get(i).viaje.pasajero.DNI, regVen.lista.get(i).viaje.movilidad.nroBus,
                regVen.lista.get(i).viaje.nroAsiento, regVen.lista.get(i).viaje.movilidad.servicio,
                regVen.lista.get(i).viaje.origen.departamento, regVen.lista.get(i).viaje.destino.departamento,
                dma.format(regVen.lista.get(i).viaje.fechaOrigen), hm.format(regVen.lista.get(i).viaje.horaOrigen),
                regVen.lista.get(i).costo() + " $"};
            Tabla.addRow(fila);
        }
    }
    void imprimir(int mes, int anio){
        if(regVen.lista.isEmpty()) return;
        Tabla.setRowCount(0);
        double total=0;
        for (int i = 0; i < regVen.lista.size(); i++) {
            if(regVen.lista.get(i).viaje.fechaOrigen.getMonth()==mes && regVen.lista.get(i).viaje.fechaOrigen.getYear()==anio){
                Object[] fila = {regVen.lista.get(i).viaje.viajeID, regVen.lista.get(i).viaje.pasajero.nombres + " "
                    + regVen.lista.get(i).viaje.pasajero.apellidos,
                    regVen.lista.get(i).viaje.pasajero.DNI, regVen.lista.get(i).viaje.movilidad.nroBus,
                    regVen.lista.get(i).viaje.nroAsiento, regVen.lista.get(i).viaje.movilidad.servicio,
                    regVen.lista.get(i).viaje.origen.departamento, regVen.lista.get(i).viaje.destino.departamento,
                    dma.format(regVen.lista.get(i).viaje.fechaOrigen), hm.format(regVen.lista.get(i).viaje.horaOrigen),
                    regVen.lista.get(i).costo() + " $"};
                total+=regVen.lista.get(i).costo();
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
        txtVentaID.setText("");
    }
    public FrmRegistroVentas(int w) {
        initComponents();
        this.setLocation(w, 0);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        establecerTamanio();
        insertarAnio();
        getColorBtn();
        Tabla=new DefaultTableModel(datos,cabecera);
        tblRegVen.setModel(Tabla);
        if(archivo.exists()){
            regVen=leerArchivo();
        }
        acID=new TextAutoCompleter(txtVentaID);
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
    String getVentaID(){
        return txtVentaID.getText();
    }
    
    Venta existeVenta(String ID){
        for (int i = 0; i < regVen.lista.size(); i++) {
            if(regVen.lista.get(i).viaje.viajeID.equals(ID)){
                return regVen.lista.get(i);
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegVen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        cboMes = new javax.swing.JComboBox<>();
        cboAnio = new javax.swing.JComboBox<>();
        rbNoFiltrar = new javax.swing.JRadioButton();
        txtVentaID = new javax.swing.JTextField();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Ventas");

        jPanel1.setLayout(null);

        tblRegVen.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tblRegVen.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRegVen.setToolTipText("");
        jScrollPane1.setViewportView(tblRegVen);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 880, 430);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("TOTAL:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(730, 550, 60, 17);

        lblTotal.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        lblTotal.setText("0");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(810, 550, 80, 17);

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
        cboAnio.setBounds(220, 20, 160, 70);

        rbNoFiltrar.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        rbNoFiltrar.setText("No filtrar");
        rbNoFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(rbNoFiltrar);
        rbNoFiltrar.setBounds(400, 40, 120, 21);

        txtVentaID.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtVentaID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venta ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        txtVentaID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVentaIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVentaIDKeyTyped(evt);
            }
        });
        jPanel1.add(txtVentaID);
        txtVentaID.setBounds(600, 20, 140, 70);

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
        pnlBtnBuscar.setBounds(780, 40, 100, 30);

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 30, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono ventas.png"))); // NOI18N
        jLabel2.setText("   Registro de Ventas");
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean validarCBO(){
        if(String.valueOf(cboAnio.getSelectedItem()).equals("") || String.valueOf(cboMes.getSelectedItem()).equals("")){
            return false;
        }
        return true;
    }
    String validarDatos(){
        if(txtVentaID.getText().equals(""))
            return "Ingrese un ID valido en el campo buscar.";
        else
            return "";
    }
    
    private void cboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesItemStateChanged
        if(!validarCBO()) return;
        imprimir(getMes(), getAnio());
    }//GEN-LAST:event_cboMesItemStateChanged

    private void cboAnioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAnioItemStateChanged
        if(!validarCBO()) return;
        imprimir(getMes(), getAnio());
    }//GEN-LAST:event_cboAnioItemStateChanged

    private void rbNoFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoFiltrarActionPerformed
        if(rbNoFiltrar.isSelected()){
            cboAnio.setEnabled(false);
            cboMes.setEnabled(false);
            imprimir();
            lblTotal.setText(String.valueOf(regVen.calcularTotal())+" $");
        }else{
            cboAnio.setEnabled(true);
            cboMes.setEnabled(true);
        }
    }//GEN-LAST:event_rbNoFiltrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        Venta buscado=existeVenta(getVentaID());
        if(buscado==null){
            JOptionPane.showMessageDialog(null, "La venta no existe, ingrese otro ID.", "Error", 0);
            return;
        }
        JOptionPane.showMessageDialog(null, "Cliente: "+buscado.viaje.pasajero.nombres+" "+buscado.viaje.pasajero.apellidos+
            "\nDNI: "+buscado.viaje.pasajero.DNI+"\nNumero de Bus: "+buscado.viaje.movilidad.nroBus+
            "\nNumero de asiento: "+buscado.viaje.nroAsiento+"\nServicio: "+buscado.viaje.movilidad.servicio+
            "\nDestino: "+buscado.viaje.destino.departamento+" - "+buscado.viaje.destino.provincia+
            "\nFecha destino: "+dma.format(buscado.viaje.fechaDestino)+"\nHora de destino: "+hm.format(buscado.viaje.horaDestino)+
            "\nPrecio: "+buscado.costo()+" $\nMoneda: "+buscado.moneda, "Encontrado", 1);
        limpiar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped
        if(txtVentaID.getText().length()>=8) evt.consume();
    }//GEN-LAST:event_btnBuscarKeyTyped

    private void txtVentaIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaIDKeyTyped
        if(txtVentaID.getText().length()>8)
            btnBuscar.setEnabled(false);
        else btnBuscar.setEnabled(true);
    }//GEN-LAST:event_txtVentaIDKeyTyped

    private void txtVentaIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaIDKeyReleased
        
    }//GEN-LAST:event_txtVentaIDKeyReleased

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(125, 24, 1));
    }//GEN-LAST:event_lblCerrarMouseExited

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
    private javax.swing.JTable tblRegVen;
    private javax.swing.JTextField txtVentaID;
    // End of variables declaration//GEN-END:variables
}
