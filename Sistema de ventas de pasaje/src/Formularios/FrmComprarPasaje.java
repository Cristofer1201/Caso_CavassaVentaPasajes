/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;
import Clases.RegistroPasajes;
import Clases.RegistroVenta;
import Clases.Venta;
import Clases.Viaje;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Dimension;
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
/**
 *
 * @author CRISTOFER
 */
public class FrmComprarPasaje extends javax.swing.JInternalFrame {

    RegistroVenta regVen=new RegistroVenta();
    RegistroPasajes regPas=new RegistroPasajes();
    List<Viaje> listaViajes=new LinkedList();
    File archivo=new File("Ventas.txt");
    File archivoViajes= new File("Viajes.txt");
    File archivoPasajes=new File("Pasajes.txt");
    
    Color pnlCcolor,pnlBcolor,pnlMcolor,pnlEcolor;
    DefaultTableModel Tabla;
    String[] cabecera={"Viaje iD","Destino","Fecha","Forma de pago","Moneda","Precio"};
    String[][] datos={};
    SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hm=new SimpleDateFormat("hh:mm");
    
    void establecerTamanio(){
        this.setSize(new Dimension(583, 220));
    }
    
    RegistroPasajes leerArchivoP(){
        try{
            ObjectInputStream leer=new ObjectInputStream(new FileInputStream("Pasajes.txt"));
            RegistroPasajes listaAux=(RegistroPasajes) leer.readObject();
            leer.close();
            return listaAux;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    RegistroVenta leerArchivo(){
        try{
            ObjectInputStream leer=new ObjectInputStream(new FileInputStream("Ventas.txt"));
            RegistroVenta listaAux=(RegistroVenta) leer.readObject();
            leer.close();
            return listaAux;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    List<Viaje> leerArchivoV(){
        try{
            ObjectInputStream leer=new ObjectInputStream(new FileInputStream("Viajes.txt"));
            List<Viaje> listaAux=(List<Viaje>) leer.readObject();
            leer.close();
            return listaAux;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    void escribirArchivo(){
        try{
            ObjectOutputStream escribir=new ObjectOutputStream(new FileOutputStream("Ventas.txt"));
            escribir.writeObject(regVen);
            escribir.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    void escribirArchivoV(){
        try{
            ObjectOutputStream escribir=new ObjectOutputStream(new FileOutputStream("Viajes.txt"));
            escribir.writeObject(listaViajes);
            escribir.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    void escribirArchivoP(){
        try{
            ObjectOutputStream escribir=new ObjectOutputStream(new FileOutputStream("Pasajes.txt"));
            escribir.writeObject(regPas);
            escribir.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    TextAutoCompleter acID;
    void txtAutocompletarID(){
        for (int i = 0; i < listaViajes.size(); i++) {
            String ID = listaViajes.get(i).viajeID;
            acID.addItem(ID);
        }
    }
    
    void cancelarPasaje(String ID){
        for (int i = 0; i < regPas.lista.size(); i++) {
            if(regPas.lista.get(i).venta.viaje.viajeID.equals(ID)){
                regPas.lista.get(i).descripcion="ANULADO";
                regPas.lista.get(i).venta.moneda="--";
                regPas.lista.get(i).venta.formaPago="--";
                escribirArchivoP();
                return;
            }
        }
    }
    void eliminarVenta(String ID){
        for (int i = 0; i < regVen.lista.size(); i++) {
            if(regVen.lista.get(i).viaje.viajeID.equals(ID)){
                regVen.lista.remove(i);
                JOptionPane.showMessageDialog(null, "Se elimino correctamente, en el Registro de ventas se"
                        + " visualizaran los datos.", "Confirmacion", 1);
                cancelarPasaje(ID);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "La venta no existe, ingrese otro ID.", "Error", 0);
    }
    void eliminarViaje(String ID){
        for (int i = 0; i < listaViajes.size(); i++) {
            if(listaViajes.get(i).viajeID.equals(ID)){
                listaViajes.remove(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El viaje no existe.", "Error", 0);
    }
    
    void limpiar(){
        txtViajeID.setText("");
    }
    
    public FrmComprarPasaje(int w) {
        initComponents();
        this.setLocation(w, 0);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        establecerTamanio();
        getColorBtn();
        
        if(archivoViajes.exists()){
            listaViajes=leerArchivoV();
            if(!listaViajes.isEmpty()){
                txtViajeID.setText(String.valueOf(listaViajes.get(listaViajes.size()-1).viajeID));
            }
        }
        if(archivo.exists()){
            regVen=leerArchivo();
        }
        if(archivoPasajes.exists()){
            regPas=leerArchivoP();
        }
        acID=new TextAutoCompleter(txtViajeID);
        txtAutocompletarID();
        //imprimir();
        //cambiarTamanioColumnas();
    }

    String validarPK(){
        if(txtViajeID.getText().equals("")){
            return "El viaje ID no es válido.";
        }else return "";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtViajeID = new javax.swing.JTextField();
        cboFormaPago = new javax.swing.JComboBox<>();
        cboMoneda = new javax.swing.JComboBox<>();
        btnAyuda = new javax.swing.JButton();
        pnlBtnComprar = new javax.swing.JPanel();
        btnComprar = new javax.swing.JButton();
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
        setMaximizable(true);
        setResizable(true);
        setTitle("Vender pasaje");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        txtViajeID.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtViajeID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Viaje ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        txtViajeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtViajeIDKeyTyped(evt);
            }
        });
        jPanel1.add(txtViajeID);
        txtViajeID.setBounds(20, 20, 210, 70);

        cboFormaPago.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta de credito", "Tarjeta de debito", "Efectivo" }));
        cboFormaPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel1.add(cboFormaPago);
        cboFormaPago.setBounds(240, 20, 180, 70);

        cboMoneda.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PEN", "USD" }));
        cboMoneda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Moneda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel1.add(cboMoneda);
        cboMoneda.setBounds(430, 20, 130, 70);

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help_question_16768.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyuda);
        btnAyuda.setBounds(460, 100, 40, 30);

        pnlBtnComprar.setBackground(new java.awt.Color(80, 143, 61));
        pnlBtnComprar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnComprar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar");
        btnComprar.setContentAreaFilled(false);
        btnComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComprarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComprarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnComprarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnComprarMouseReleased(evt);
            }
        });
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        pnlBtnComprar.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.add(pnlBtnComprar);
        pnlBtnComprar.setBounds(20, 100, 100, 30);

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
        pnlBtnModificar.setBounds(130, 100, 100, 30);

        pnlBtnEliminar.setBackground(new java.awt.Color(176, 40, 30));
        pnlBtnEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Anular");
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
        pnlBtnEliminar.setBounds(240, 100, 100, 30);

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
        pnlBtnBuscar.setBounds(350, 100, 100, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(58, 89, 33));
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

        pnlCerrar.setBackground(new java.awt.Color(58, 89, 33));
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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono pasaje.png"))); // NOI18N
        jLabel1.setText("   Vender pasaje");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String getViajeID(){
        return txtViajeID.getText();
    }
    String getFormaPago(){
        return String.valueOf(cboFormaPago.getSelectedItem());
    }
    String getMoneda(){
        return String.valueOf(cboMoneda.getSelectedItem());
    }
    
    Viaje existeViaje(String ID){
        for (int i = 0; i < listaViajes.size(); i++) {
            if(listaViajes.get(i).viajeID.equals(ID)){
                return listaViajes.get(i);
            }
        }
        return null;
    }
    Venta existeVenta(String ID){
        for (int i = 0; i < regVen.lista.size(); i++) {
            if(regVen.lista.get(i).viaje.viajeID.equals(ID)){
                return regVen.lista.get(i);
            }
        }
        return null;
    }
    
    FrmPasaje nuevoPasaje;
    void generarPasaje(Venta venta){
        nuevoPasaje=new FrmPasaje(venta,this.getLocation().x);
        this.getDesktopPane().add(nuevoPasaje);
        nuevoPasaje.show();
    }
    
    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Viaje viaje = existeViaje(getViajeID());
        if(viaje==null){
            JOptionPane.showMessageDialog(null, "El viaje no existe, ingrese otro ID.", "Error", 0);
            return;
        }
        if(existeVenta(getViajeID())!=null){
            JOptionPane.showMessageDialog(null, "La venta ya se cancelo, ingrese otro ID.", "Error", 0);
            return;
        }
        
        Venta nuevo=new Venta(getFormaPago(), getMoneda(), viaje);
        regVen.lista.add(nuevo);
        
        // LLAMAR A LA LISRA DE REGISTRO DE VIAJES Y ELIMINAR EL DATO MEDIANTE EL VIAJE ID
        eliminarViaje(getViajeID());
        escribirArchivoV();
        
        //GENERACION DE PASAJE
        generarPasaje(nuevo);
        limpiar();
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Venta buscado=existeVenta(getViajeID());
        if(buscado==null){
            JOptionPane.showMessageDialog(null, "La venta no existe, ingrese otro ID.", "Error", 0);
            return;
        }
        JOptionPane.showMessageDialog(null, "Venta encontrada."
                + "\nCliente: "+buscado.viaje.pasajero.nombres+" "+buscado.viaje.pasajero.apellidos+
                "\nDNI: "+buscado.viaje.pasajero.DNI+"\nNumero de Bus: "+buscado.viaje.movilidad.nroBus+
                "\nNumero de asiento: "+buscado.viaje.nroAsiento+"\nServicio: "+buscado.viaje.movilidad.servicio+
                "\nDestino: "+buscado.viaje.destino.departamento+" - "+buscado.viaje.destino.provincia+
                "\nFecha destino: "+dma.format(buscado.viaje.fechaDestino)+"\nHora de destino: "+hm.format(buscado.viaje.horaDestino)+
                "\nPrecio: "+buscado.costo()+" $\nMoneda: "+buscado.moneda, "Confirmacion", 1);
        limpiar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarVenta(getViajeID());
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Venta modificado=existeVenta(getViajeID());
        if(modificado==null){
            JOptionPane.showMessageDialog(null, "La venta no existe, ingrese otro ID.", "Error", 0);
            return;
        }
        modificado.formaPago=getFormaPago();
        modificado.moneda=getMoneda();
        JOptionPane.showMessageDialog(null, "Modificado correctamente, en el Registro de ventas se visualizaran los datos."
                + "\nCliente: "+modificado.viaje.pasajero.nombres+" "+modificado.viaje.pasajero.apellidos+
                "\nDNI: "+modificado.viaje.pasajero.DNI+"\nNumero de Bus: "+modificado.viaje.movilidad.nroBus+
                "\nNumero de asiento: "+modificado.viaje.nroAsiento+"\nServicio: "+modificado.viaje.movilidad.servicio+
                "\nDestino: "+modificado.viaje.destino.departamento+" - "+modificado.viaje.destino.provincia+
                "\nFecha destino: "+dma.format(modificado.viaje.fechaDestino)+"\nHora de destino: "+hm.format(modificado.viaje.horaDestino)+
                "\nPrecio: "+modificado.costo()+" $\nMoneda: "+modificado.moneda, "Confirmacion", 1);
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Comprar: Guarda los datos de la venta en una lista, para guardar llene todos los campos.\n"+
            "Modificar: Actualiza los datos del venta mediante el ID de viaje, ingrese el viaje ID para modificar los datos.\n"+
            "Eliminar: Remueve los datos del venta de la lista, para eliminar ingrese el viaje ID.\n"+
            "Buscar: Encuentra los datos del venta en la lista, para buscar ingrese el viaje ID.\n",
            "Ayuda", 1);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        escribirArchivo();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtViajeIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtViajeIDKeyTyped
        if(txtViajeID.getText().length()>=8) evt.consume();
    }//GEN-LAST:event_txtViajeIDKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios en el registro antes de salir?", "Confirmacion",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
        pnlCerrar.setBackground(new Color(125, 24, 1));
    }//GEN-LAST:event_lblCerrarMouseExited

    void getColorBtn(){
        pnlCcolor=pnlBtnComprar.getBackground();
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

    
    private void btnComprarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseEntered
        pnlBtnComprar.setBackground(setColorBtn(pnlCcolor, 12));
    }//GEN-LAST:event_btnComprarMouseEntered

    private void btnComprarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseExited
        pnlBtnComprar.setBackground(pnlCcolor);
    }//GEN-LAST:event_btnComprarMouseExited

    private void btnComprarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMousePressed
        pnlBtnComprar.setBackground(setColorBtn(pnlCcolor, 20));
    }//GEN-LAST:event_btnComprarMousePressed

    private void btnComprarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseReleased
        pnlBtnComprar.setBackground(setColorBtn(pnlCcolor, 12));
    }//GEN-LAST:event_btnComprarMouseReleased

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
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cboFormaPago;
    private javax.swing.JComboBox<String> cboMoneda;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlBtnComprar;
    private javax.swing.JPanel pnlBtnEliminar;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JTextField txtViajeID;
    // End of variables declaration//GEN-END:variables
}
