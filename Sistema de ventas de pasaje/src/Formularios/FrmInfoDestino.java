/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Clases.Bus;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTOFER
 */
public class FrmInfoDestino extends javax.swing.JInternalFrame {

    List<Bus> listaBuses=new LinkedList();
    File archivo = new File("Buses.txt");
    
    Color pnlDcolor, pnlCcolor;
    DefaultListModel modelo= new DefaultListModel();
    void establecerTamanio(){
        this.setSize(new Dimension(532, 418));
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
    
    void insertarCboBus(){
        for (int i = 0; i < listaBuses.size(); i++) {
            cboBus.addItem(listaBuses.get(i).nroBus);
        }
    }
    void imprimir(Bus bus){
        modelo.removeAllElements();
        modelo.addElement("Numero       Disponibilidad");
        for (int i = 0; i < bus.cantidadAsientos; i++) {
            String asiento= "N°"+bus.asientos[i].nroAsiento+"               ";
            if(bus.asientos[i].disponibilidad) asiento+="Disponible";
            else asiento+="Ocupado";
            modelo.addElement(asiento);
        }
    }
    
    public FrmInfoDestino(int w) {
        initComponents();
        establecerTamanio();
        this.setLocation(w, 0);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        getColorBtn();
        lstAsientos.setModel(modelo);
        
        if (archivo.exists()) {
            listaBuses = leerArchivo();
        }
        rbUnAsiento.setSelected(true);
        insertarCboBus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        cboBus = new javax.swing.JComboBox<>();
        cboAsiento = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        rbUnAsiento = new javax.swing.JRadioButton();
        rbTodosAsientos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAsientos = new javax.swing.JList<>();
        pnlBtnDesocupar = new javax.swing.JPanel();
        btnDesocupar = new javax.swing.JButton();
        pnlBtnCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Informacion de llegada del bus");
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

        jPanel2.setLayout(null);

        cboBus.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboBus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboBus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBusItemStateChanged(evt);
            }
        });
        jPanel2.add(cboBus);
        cboBus.setBounds(20, 20, 130, 70);

        cboAsiento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboAsiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nro. Asiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboAsiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAsientoItemStateChanged(evt);
            }
        });
        jPanel2.add(cboAsiento);
        cboAsiento.setBounds(20, 100, 120, 70);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        buttonGroup1.add(rbUnAsiento);
        rbUnAsiento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rbUnAsiento.setText("Seleccionar un asiento");
        rbUnAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUnAsientoActionPerformed(evt);
            }
        });
        jPanel1.add(rbUnAsiento);
        rbUnAsiento.setBounds(10, 10, 220, 21);

        buttonGroup1.add(rbTodosAsientos);
        rbTodosAsientos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rbTodosAsientos.setText("Seleccionar todos los asientos");
        rbTodosAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosAsientosActionPerformed(evt);
            }
        });
        jPanel1.add(rbTodosAsientos);
        rbTodosAsientos.setBounds(10, 40, 220, 21);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(20, 180, 240, 70);

        lstAsientos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jScrollPane1.setViewportView(lstAsientos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(280, 20, 220, 320);

        pnlBtnDesocupar.setBackground(new java.awt.Color(80, 143, 61));
        pnlBtnDesocupar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDesocupar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnDesocupar.setForeground(new java.awt.Color(255, 255, 255));
        btnDesocupar.setText("Desocupar asiento(s)");
        btnDesocupar.setContentAreaFilled(false);
        btnDesocupar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDesocuparMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDesocuparMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDesocuparMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDesocuparMouseReleased(evt);
            }
        });
        btnDesocupar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesocuparActionPerformed(evt);
            }
        });
        pnlBtnDesocupar.add(btnDesocupar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 30));

        jPanel2.add(pnlBtnDesocupar);
        pnlBtnDesocupar.setBounds(20, 260, 190, 30);

        pnlBtnCancelar.setBackground(new java.awt.Color(176, 40, 30));
        pnlBtnCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBtnCancelar.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 30));

        jPanel2.add(pnlBtnCancelar);
        pnlBtnCancelar.setBounds(20, 300, 190, 30);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/destino.png"))); // NOI18N
        jLabel1.setText("   Información de destino de bus");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String getBusN(){
        return String.valueOf(cboBus.getSelectedItem());
    }
    String getNroAsiento(){
        return String.valueOf(cboAsiento.getSelectedItem());
    }
    Bus existeBus(String nro){
        for (int i = 0; i < listaBuses.size(); i++) {
            if(nro.equals(listaBuses.get(i).nroBus)){
                return listaBuses.get(i);
            }
        }
        return null;
    }
    
    private void btnDesocuparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesocuparActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea actualizar la disponibilidad?",
                "Confirmacion",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            Bus bus=existeBus(getBusN());
            if(bus == null){
                JOptionPane.showMessageDialog(null, "El bus no existe, seleccione otro.","Error",0);
                return;
            }
            if(rbUnAsiento.isSelected()){
                for (int i = 0; i < bus.cantidadAsientos; i++) {
                    if(bus.asientos[i].nroAsiento.equals(getNroAsiento())){
                        bus.asientos[i].disponibilidad=true;
                        JOptionPane.showMessageDialog(null, "El asiento ya se encuentra disponible.", "Confirmacion", 1);
                        escribirArchivo();
                        break;
                    }
                }
                
            }else if(rbTodosAsientos.isSelected()){
                for (int i = 0; i < listaBuses.size(); i++) {
                    if(listaBuses.get(i).nroBus.equals(getBusN())){
                        for (int j = 0; j < listaBuses.get(i).cantidadAsientos; j++) {
                            listaBuses.get(i).asientos[j].disponibilidad=true;
                        }
                        JOptionPane.showMessageDialog(null, "Los asientos ya se encuentran disponibles.", "Confirmacion", 1);
                        break;
                    }
                    
                }
            }
            escribirArchivo();
            imprimir(bus);
        }
    }//GEN-LAST:event_btnDesocuparActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cboBusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBusItemStateChanged
        Bus bus=existeBus(getBusN());
        if(bus != null){
            imprimir(bus);
            cboAsiento.removeAllItems();
            for (int i = 0; i < bus.cantidadAsientos; i++) {
                cboAsiento.addItem(bus.asientos[i].nroAsiento);
            }
        }
    }//GEN-LAST:event_cboBusItemStateChanged

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        escribirArchivo();
    }//GEN-LAST:event_formInternalFrameClosing

    private void cboAsientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAsientoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAsientoItemStateChanged

    private void rbUnAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUnAsientoActionPerformed
        cboAsiento.setEnabled(true);
    }//GEN-LAST:event_rbUnAsientoActionPerformed

    private void rbTodosAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosAsientosActionPerformed
        cboAsiento.setEnabled(false);
    }//GEN-LAST:event_rbTodosAsientosActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        pnlCerrar.setBackground(new Color(200, 25, 16));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        pnlCerrar.setBackground(new Color(125, 24, 1));
    }//GEN-LAST:event_lblCerrarMouseExited

    private void btnDesocuparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesocuparMouseEntered
        pnlBtnDesocupar.setBackground(setColorBtn(pnlDcolor, 12));
    }//GEN-LAST:event_btnDesocuparMouseEntered

    private void btnDesocuparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesocuparMouseExited
        pnlBtnDesocupar.setBackground(pnlDcolor);
    }//GEN-LAST:event_btnDesocuparMouseExited

    private void btnDesocuparMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesocuparMousePressed
        pnlBtnDesocupar.setBackground(setColorBtn(pnlDcolor, 20));
    }//GEN-LAST:event_btnDesocuparMousePressed

    private void btnDesocuparMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesocuparMouseReleased
        pnlBtnDesocupar.setBackground(setColorBtn(pnlDcolor, 12));
    }//GEN-LAST:event_btnDesocuparMouseReleased

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        pnlBtnCancelar.setBackground(setColorBtn(pnlCcolor, 12));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        pnlBtnCancelar.setBackground(pnlCcolor);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        pnlBtnCancelar.setBackground(setColorBtn(pnlCcolor, 20));
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        pnlBtnCancelar.setBackground(setColorBtn(pnlCcolor, 12));
    }//GEN-LAST:event_btnCancelarMouseReleased

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

    void getColorBtn(){
        pnlDcolor=pnlBtnDesocupar.getBackground();
        pnlCcolor=pnlBtnCancelar.getBackground();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesocupar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboAsiento;
    private javax.swing.JComboBox<String> cboBus;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JList<String> lstAsientos;
    private javax.swing.JPanel pnlBtnCancelar;
    private javax.swing.JPanel pnlBtnDesocupar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JRadioButton rbTodosAsientos;
    private javax.swing.JRadioButton rbUnAsiento;
    // End of variables declaration//GEN-END:variables
}
