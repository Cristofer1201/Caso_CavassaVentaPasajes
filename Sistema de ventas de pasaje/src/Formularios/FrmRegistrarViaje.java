/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Formularios;

import Clases.*;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FrmRegistrarViaje extends javax.swing.JInternalFrame {

    // Creacion de listas
    List<Viaje> listaViajes=new LinkedList();
    List<Cliente> listaClientes=new LinkedList();
    List<Bus> listaBuses=new LinkedList();
    RegistroVenta regVen=new RegistroVenta();
    
    // Creacion de documentos
    File fileClientes=new File("Clientes.txt");
    File fileBuses=new File("Buses.txt");
    File fileViajes=new File("Viajes.txt");
    File fileVentas=new File("Ventas.txt");
    
    // colores
    Color pnlGcolor,pnlBcolor,pnlEcolor,pnlMcolor,pnlIDcolor;
    
    // Creacion de tabla
    SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hm=new SimpleDateFormat("hh:mm");
    DefaultTableModel Tabla;
    String[] cabecera = {"Viaje ID", "DNI", "Bus", "Nro. Asiento", "Fecha", "Hora", "Origen", "Destino"};
    String[][] datos={};
    
    void establecerTamanio(){
        this.setMinimumSize(new Dimension(824, 685));
        this.setSize(new Dimension(824, 685));
    }
    void cambiarTamanioColumnas(){
        tblRegViaje.getTableHeader().setFont(new Font ("Century Cothic",Font.BOLD,13));
        TableColumn columna = null;
        columna=tblRegViaje.getColumnModel().getColumn(4);
        columna.setPreferredWidth(150);
    }
    
    List<Cliente> leerArchivoC() {
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
    List<Bus> leerArchivoB() {
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
    void escribirArchivoB() {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Buses.txt"));
            escribir.writeObject(listaBuses);
            escribir.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    List<Viaje> leerArchivoV() {
        try {
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Viajes.txt"));
            List<Viaje> listaAux = (List<Viaje>) leer.readObject();
            leer.close();
            return listaAux;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    RegistroVenta leerArchivoVe(){
        try {
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Ventas.txt"));
            RegistroVenta listaAux = (RegistroVenta) leer.readObject();
            leer.close();
            return listaAux;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;        
    }
    void escribirArchivo() {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Viajes.txt"));
            escribir.writeObject(listaViajes);
            escribir.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    // Autocompletador de jtextfield
    TextAutoCompleter acDNI;
    void txtAutocompletarDNI(){
        for (int i = 0; i < listaClientes.size(); i++) {
            String dni = String.valueOf(listaClientes.get(i).DNI);
            acDNI.addItem(dni);
        }
    }
    
    void insertarBus(JComboBox cbo){
        for (int i = 0; i < listaBuses.size(); i++){
            cbo.addItem(listaBuses.get(i).nroBus);
        }
    }
    void actualizarAsientos(Bus bus){
        cboNroAsiento.removeAllItems();
        for (int i = 0; i < bus.cantidadAsientos; i++) {
            if(bus.asientos[i].disponibilidad) cboNroAsiento.addItem(bus.asientos[i].nroAsiento);
        }
    }
    void insertarDepartamento(JComboBox cbo){
        cbo.addItem("Amazonas");
        cbo.addItem("Apurimac");
        cbo.addItem("Ayacucho");
        cbo.addItem("Cajamarca");
        cbo.addItem("Cuzco");
        cbo.addItem("Huancavelica");
        cbo.addItem("Huanuco");
        cbo.addItem("Ica");
        cbo.addItem("Junin");
        cbo.addItem("Loreto");
        cbo.addItem("Moquegua");
        cbo.addItem("Ucayali");
    }
    void insertarProvincia(JComboBox cboD, JComboBox cboP){
        cboP.removeAllItems();
        switch(cboD.getSelectedItem().toString()){
            case "Amazonas":
                cboP.addItem("Chachapoyas");
                cboP.addItem("La jaica");
                cboP.addItem("Huancas"); break;
            case "Apurimac":
                cboP.addItem("Andahuaylas");
                cboP.addItem("Abancay"); break;
            case "Ayacucho":
                cboP.addItem("Cangallo");
                cboP.addItem("Huanta"); break;
            case "Cajamarca":
                cboP.addItem("Cajamarca");
                cboP.addItem("Cutervo");
                cboP.addItem("San Ignacio"); break;
            case "Cuzco":
                cboP.addItem("Cuzco"); break;
            case "Huancavelica":
                cboP.addItem("Huancavelica");
                cboP.addItem("Acobamba");
                cboP.addItem("San Ignacio"); break;
            case "Huanuco":
                cboP.addItem("Huanuco");
                cboP.addItem("Ambo");
                cboP.addItem("Puerto Imca"); break;
            case "Ica":
                cboP.addItem("Ica");
                cboP.addItem("Chincha");
                cboP.addItem("Nazca"); break;
            case "Junin":
                cboP.addItem("Junin");
                cboP.addItem("Huancayo"); break;
            case "Loreto":
                cboP.addItem("Loreto"); break;
            case "Moquegua":
                cboP.addItem("Ilo"); break;
            case "Ucayali":
                cboP.addItem("Atayala");
                cboP.addItem("Purus"); break;
        }
    }
    
    void eliminarViaje(String id){
        for (int i = 0; i < listaViajes.size(); i++) {
            if(listaViajes.get(i).viajeID.equals(id)){
                Date ahora=new Date();
                if(listaViajes.get(i).fechaDestino.before(ahora) || (listaViajes.get(i).fechaDestino.equals(ahora)
                        && listaViajes.get(i).horaDestino.before(ahora))){
                    listaViajes.remove(i);
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente.", "Confirmacion",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int respuesta=JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el viaje? Se habilitara el asiento.",
                        "Confirmacion", 0, 1);
                if(respuesta==0){
                    AsientoBus asiento=existeAsientoBus(existeBus(listaViajes.get(i).movilidad.nroBus), listaViajes.get(i).nroAsiento);
                    listaViajes.remove(i);
                    asiento.disponibilidad = true;
                    escribirArchivoB();
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente.", "Confirmacion",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }
    }
    void imprimir(){
        Tabla.setRowCount(0);
        SimpleDateFormat dma=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hm=new SimpleDateFormat("hh:mm");
        for (int i = 0; i < listaViajes.size(); i++) {
            Object[] fila={listaViajes.get(i).viajeID,listaViajes.get(i).pasajero.DNI,listaViajes.get(i).movilidad.nroBus,
            listaViajes.get(i).nroAsiento,dma.format(listaViajes.get(i).fechaOrigen),hm.format(listaViajes.get(i).horaOrigen),
            listaViajes.get(i).origen.departamento+" - "+listaViajes.get(i).origen.provincia,
            listaViajes.get(i).destino.departamento+" - "+listaViajes.get(i).destino.provincia};
            Tabla.addRow(fila);
        }
    }
    void limpiar(){
        txtDNI.setText("");
        dcFechaOrigen.setDate(null);
        dcFechaDestino.setDate(null);
    }
    void limpiarPK(){
        txtViajeID.setText("");
    }
    
    public FrmRegistrarViaje(int w) {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        establecerTamanio();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setLocation(w, 0);
        
        getColorBtn();
        Tabla =new DefaultTableModel(datos,cabecera);
        tblRegViaje.setModel(Tabla);
        
        if (fileClientes.exists()) {
            listaClientes = leerArchivoC();
        }
        if (fileBuses.exists()) {
            listaBuses = leerArchivoB();
        }
        if (fileViajes.exists()) {
            listaViajes = leerArchivoV();
        }
        if(fileVentas.exists()){
            regVen=leerArchivoVe();
        }
        // Inicializacion del apartado estetico del formulario
        if(!listaClientes.isEmpty()){
            txtDNI.setText(String.valueOf(listaClientes.get(listaClientes.size()-1).DNI));
        }
        imprimir();
        cambiarTamanioColumnas();
        acDNI=new TextAutoCompleter(txtDNI);
        txtAutocompletarDNI();
        insertarBus(cboBus);
        insertarDepartamento(cboOrigenDepartamento);
        insertarDepartamento(cboDestinoDepartamento);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegViaje = new javax.swing.JTable();
        cboBus = new javax.swing.JComboBox<>();
        txtDNI = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        dcFechaOrigen = new com.toedter.calendar.JDateChooser();
        cboOrigenDepartamento = new javax.swing.JComboBox<>();
        cboOrigenProvincia = new javax.swing.JComboBox<>();
        cboHoraOrigen = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        dcFechaDestino = new com.toedter.calendar.JDateChooser();
        cboDestinoDepartamento = new javax.swing.JComboBox<>();
        cboDestinoProvincia = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        lblHoraDestino = new javax.swing.JLabel();
        txtViajeID = new javax.swing.JTextField();
        cboNroAsiento = new javax.swing.JComboBox<>();
        pnlBtnGuardar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        pnlBtnModificar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        pnlBtnEliminar = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        pnlBtnBuscar = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        pnlBtnInfoDestino = new javax.swing.JPanel();
        btnInfoDestino = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        pnlCerrar = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Viaje");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        tblRegViaje.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tblRegViaje.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRegViaje.setToolTipText("");
        jScrollPane2.setViewportView(tblRegViaje);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 320, 760, 280);

        cboBus.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboBus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboBus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBusItemStateChanged(evt);
            }
        });
        cboBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cboBusKeyTyped(evt);
            }
        });
        jPanel2.add(cboBus);
        cboBus.setBounds(220, 20, 180, 60);

        txtDNI.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDNI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel2.add(txtDNI);
        txtDNI.setBounds(20, 20, 190, 60);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Origen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel1.setLayout(null);

        dcFechaOrigen.setBackground(new java.awt.Color(255, 255, 255));
        dcFechaOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        dcFechaOrigen.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jPanel1.add(dcFechaOrigen);
        dcFechaOrigen.setBounds(10, 20, 160, 70);

        cboOrigenDepartamento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboOrigenDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboOrigenDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOrigenDepartamentoItemStateChanged(evt);
            }
        });
        jPanel1.add(cboOrigenDepartamento);
        cboOrigenDepartamento.setBounds(180, 20, 170, 70);

        cboOrigenProvincia.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboOrigenProvincia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Provincia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel1.add(cboOrigenProvincia);
        cboOrigenProvincia.setBounds(180, 90, 170, 70);

        cboHoraOrigen.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboHoraOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6:00", "14:00", "22:00" }));
        cboHoraOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboHoraOrigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHoraOrigenItemStateChanged(evt);
            }
        });
        jPanel1.add(cboHoraOrigen);
        cboHoraOrigen.setBounds(10, 90, 160, 70);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(20, 90, 380, 170);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel4.setLayout(null);

        dcFechaDestino.setBackground(new java.awt.Color(255, 255, 255));
        dcFechaDestino.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        dcFechaDestino.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jPanel4.add(dcFechaDestino);
        dcFechaDestino.setBounds(10, 20, 160, 70);

        cboDestinoDepartamento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboDestinoDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        cboDestinoDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDestinoDepartamentoItemStateChanged(evt);
            }
        });
        jPanel4.add(cboDestinoDepartamento);
        cboDestinoDepartamento.setBounds(180, 20, 170, 70);

        cboDestinoProvincia.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboDestinoProvincia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Provincia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel4.add(cboDestinoProvincia);
        cboDestinoProvincia.setBounds(180, 90, 170, 70);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        lblHoraDestino.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblHoraDestino))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblHoraDestino))
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(10, 90, 160, 70);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(410, 90, 380, 170);

        txtViajeID.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtViajeID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar, eliminar, buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        txtViajeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtViajeIDKeyTyped(evt);
            }
        });
        jPanel2.add(txtViajeID);
        txtViajeID.setBounds(540, 20, 220, 60);

        cboNroAsiento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cboNroAsiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 13))); // NOI18N
        jPanel2.add(cboNroAsiento);
        cboNroAsiento.setBounds(410, 20, 120, 60);

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

        jPanel2.add(pnlBtnGuardar);
        pnlBtnGuardar.setBounds(20, 280, 100, 30);

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

        jPanel2.add(pnlBtnModificar);
        pnlBtnModificar.setBounds(130, 280, 100, 30);

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

        jPanel2.add(pnlBtnEliminar);
        pnlBtnEliminar.setBounds(240, 280, 100, 30);

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

        jPanel2.add(pnlBtnBuscar);
        pnlBtnBuscar.setBounds(350, 280, 100, 30);

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/help_question_16768.png"))); // NOI18N
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAyuda);
        btnAyuda.setBounds(660, 280, 30, 30);

        pnlBtnInfoDestino.setBackground(new java.awt.Color(158, 158, 6));
        pnlBtnInfoDestino.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInfoDestino.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnInfoDestino.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoDestino.setText("Información de destino");
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
        pnlBtnInfoDestino.add(btnInfoDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 30));

        jPanel2.add(pnlBtnInfoDestino);
        pnlBtnInfoDestino.setBounds(460, 280, 190, 30);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

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

        header.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 30, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrarViaje.png"))); // NOI18N
        jLabel1.setText("   Registrar Viaje");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String validarDatos(){
        if(txtDNI.getText().equals("") || dcFechaOrigen.getDate()==null ||
                dcFechaDestino.getDate()==null || lblHoraDestino.getText().equals("")){
            return "Uno o más datos están incompletos.";
        }else if(dcFechaOrigen.getDate().after(dcFechaDestino.getDate())){
            return "La fecha de origen debe ser antes que la feeha de destino.";
        }else if(!esNumero(txtDNI.getText())){
            return "Ingrese números en el campo DNI.";
        }else if(txtDNI.getText().length()!=8){
            return "La cantidad de digitos de un DNI es 8.";
        }else if(String.valueOf(cboOrigenDepartamento.getSelectedItem()).equals(String.valueOf(cboDestinoDepartamento.getSelectedItem()))
                && String.valueOf(cboOrigenProvincia.getSelectedItem()).equals(String.valueOf(cboDestinoProvincia.getSelectedItem()))){
            return "El origen y destino es el mismo, seleccione otros.";
        }
        return "";
    }
    String validarPK(){
        if(txtViajeID.getText().equals("")){
            return "Ingrese un ID de viaje válido.";
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
    int getDNI(){
        return Integer.parseInt(txtDNI.getText());
    }
    String getBusN(){
        return cboBus.getSelectedItem().toString();
    }
    String getAsientoN(){
        return String.valueOf(cboNroAsiento.getSelectedItem());
    }
    String getViajeID(){
        return txtViajeID.getText();
    }
    Date getFechaO(){
        return dcFechaOrigen.getDate();
    }
    Date getHoraO(){
        String horaS="";
        for (int i = 0; i < cboHoraOrigen.getSelectedItem().toString().length(); i++) {
            if(!Character.isDigit(cboHoraOrigen.getSelectedItem().toString().charAt(i))) break;
            horaS+=cboHoraOrigen.getSelectedItem().toString().charAt(i);
        }
        int horasI=Integer.parseInt(horaS);
        Calendar hora=Calendar.getInstance();
        hora.set(Calendar.HOUR_OF_DAY, horasI);
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);
        return hora.getTime();
    }
    Date getFechaD(){
        Calendar aux=Calendar.getInstance();
        aux.setTime(getHoraD());
        int horaD = aux.get(Calendar.HOUR_OF_DAY);
        horaD-=17;
        if(horaD<0){
            Date fechad=getFechaO();
            fechad.setDate(getFechaO().getDate()+1);
            return fechad;
        }
        return getFechaO();
    }
    Date getHoraD(){
        Calendar aux=Calendar.getInstance();
        aux.setTime(getHoraO());
        int horaD = aux.get(Calendar.HOUR_OF_DAY);
        horaD+=17;
        if(horaD>=24){
            horaD-=24;
        }
        Calendar hora=Calendar.getInstance();
        hora.set(Calendar.HOUR_OF_DAY, horaD);
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);
        return hora.getTime();
    }
    Lugar getOrigen(){
        Lugar o = new Lugar(String.valueOf(cboOrigenDepartamento.getSelectedItem()), 
                String.valueOf(cboOrigenProvincia.getSelectedItem()), "", "");
        return o;
    }
    Lugar getDestino(){
        Lugar d = new Lugar(String.valueOf(cboDestinoDepartamento.getSelectedItem()), 
                String.valueOf(cboDestinoProvincia.getSelectedItem()), "", "");
        return d;
    }
    
    void viajesIDs(){
        int i=0;
        /*if(regVen.lista.isEmpty()) i=0;
        else i=regVen.lista.size();
        //i=1
        //LV=2
        //RV=1
        for (; i < listaViajes.size()+regVen.lista.size(); i++) {
            String id="";
            for (int j = 0; j < 8-String.valueOf(i).length(); j++) id+="0";
            id+=((i+1)+"");
            listaViajes.get(i-regVen.lista.size()).viajeID=id;
        }*/
        //i=listaViajes.size()+regVen.lista.size();
        int m=0;
        listaViajes.get(listaViajes.size()-1).viajeID="00000000";
        for (int j = 0; j < regVen.lista.size(); j++) {
            int idINT=Integer.parseInt(regVen.lista.get(j).viaje.viajeID);
            if(m<idINT) m=idINT;
        }
        for (int j = 0; j < listaViajes.size(); j++) {
            int idINT=Integer.parseInt(listaViajes.get(j).viajeID);
            if(m<idINT) m=idINT;
        }
        i=m+1;
        String id="";
        for (int j = 0; j < 8-String.valueOf(i).length(); j++) id+="0";
        id+=((i)+"");
        listaViajes.get(listaViajes.size()-1).viajeID=id;
    }
    Viaje existeViaje(String id){
        for (int i = 0; i < listaViajes.size(); i++) {
            if(listaViajes.get(i).viajeID.equals(id)){
                return listaViajes.get(i);
            }
        }
        return null;
    }
    Cliente existeCliente(int dni){
        for (int i = 0; i < listaClientes.size(); i++) {
            if(dni==listaClientes.get(i).DNI){
                return listaClientes.get(i);
            }
        }
        return null;
    }
    Bus existeBus(String nro){
        for (int i = 0; i < listaBuses.size(); i++) {
            if(listaBuses.get(i).nroBus.equals(nro)){
                return listaBuses.get(i);
            }
        }
        return null;
    }
    AsientoBus existeAsientoBus(Bus bus, String nro){
        for (int i = 0; i < bus.asientos.length; i++) {
            if(bus.asientos[i].nroAsiento.equals(nro)){
                return bus.asientos[i];
            }
        }
        return null;
    }
    
    void asientoOcupado(Bus bus, String nro){
        for (int i = 0; i < bus.asientos.length; i++) {
            if(bus.asientos[i].nroAsiento.equals(nro)){
                bus.asientos[i].disponibilidad=false;
                break;
            }
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        Cliente getCliente=existeCliente(getDNI());
        if(getCliente==null){
            JOptionPane.showMessageDialog(null, "El cliente no existe, ingrese otro DNI","Error",0);
            return;
        }
        Bus getBus=existeBus(getBusN());
        if(getBus==null){
            JOptionPane.showMessageDialog(null, "El bus no existe, ingrese otro numero de bus","Error",0);
            return;
        }
        AsientoBus getAsiento=existeAsientoBus(getBus, getAsientoN());
        if(getAsiento==null){
            JOptionPane.showMessageDialog(null, "El asiento no existe.","Error",0);
            return;
        }
        if(!existeAsientoBus(getBus, getAsientoN()).disponibilidad){
            JOptionPane.showMessageDialog(null, "El asiento no esta disponible, ingrese otro numero ","Error",0);
            return;
        }
        Viaje nuevo=new Viaje(getFechaO(), getHoraO(), getFechaD(), getHoraD(),
                getCliente, getAsientoN(), getBus, getOrigen(), getDestino());
        listaViajes.add(nuevo);
        
        asientoOcupado(getBus, getAsientoN());
        actualizarAsientos(getBus);
        viajesIDs();
        escribirArchivoB();
        escribirArchivo();
        imprimir();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Guardar: Guarda los datos del viaje en una lista, para guardar llene todos los campos.\n"+
            "Modificar: Actualiza los datos del viaje mediante el ID de viaje, ingrese el viaje ID para modificar los datos.\n"+
            "Eliminar: Remueve los datos del viaje de la lista, para eliminar ingrese el viaje ID.\n"+
            "Buscar: Encuentra los datos del viaje en la lista, para buscar ingrese el viaje ID.\n"+
            "Informacion de destino: Ventana emergente donde se actualizara los asientos de los buses.\n",
                "Ayuda", 1);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Viaje buscado=existeViaje(getViajeID());
        if(buscado != null){
            JOptionPane.showMessageDialog(null,"Nombres: "+buscado.pasajero.nombres+
                    "\nApellidos: "+buscado.pasajero.apellidos+"\nBus: "+buscado.movilidad.nroBus+
                    "\nNumero de asiento: "+buscado.nroAsiento+"\nOrigen departamento: "+buscado.origen.departamento+
                    "\nOrigen provincia: "+buscado.origen.provincia+"\nDestino departamento: "+buscado.destino.departamento+
                    "\nDestino provincia: "+buscado.destino.provincia+"\nFecha de origen: "+dma.format(buscado.fechaOrigen)+
                    "\nHora de origen: "+hm.format(buscado.horaOrigen)+"\nFecha de destino: "+dma.format(buscado.fechaDestino)+
                    "\nHora de destino: "+hm.format(buscado.horaDestino),"Viaje encontrado",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "El vaije no existe, ingrese otro ID.","Error",0);
        }
        limpiarPK();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        if(existeViaje(getViajeID())==null){
            JOptionPane.showMessageDialog(null, "El viaje no existe, ingrese otro ID.","Error",0);
            return;
        }    
        String nroB=existeViaje(getViajeID()).movilidad.nroBus;
        eliminarViaje(getViajeID());
        actualizarAsientos(existeBus(nroB));
        //viajesIDs();
        imprimir();
        limpiarPK();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(!validarPK().equals("")){
            JOptionPane.showMessageDialog(null, validarPK(), "Error", 0);
            return;
        }
        Viaje modificado=existeViaje(getViajeID());
        if(modificado==null){
            JOptionPane.showMessageDialog(null, "El viaje no existe, ingrese otro ID.", "Error", 0);
            return;
        }
        if(!validarDatos().equals("")){
            JOptionPane.showMessageDialog(null, validarDatos(), "Error", 0);
            return;
        }
        Cliente getCliente=existeCliente(getDNI());
        if(getCliente==null){
            JOptionPane.showMessageDialog(null, "El cliente no existe, ingrese otro DNI.","Error",0);
            return;
        }
        Bus getBus=existeBus(getBusN());
        if(getBus==null){
            JOptionPane.showMessageDialog(null, "El bus no existe, ingrese otro numero de bus.","Error",0);
            return;
        }
        AsientoBus getAsiento=existeAsientoBus(getBus, getAsientoN());
        if(getAsiento==null){
            JOptionPane.showMessageDialog(null, "El asiento no existe.","Error",0);
            return;
        }
        if(!existeAsientoBus(getBus, getAsientoN()).disponibilidad){
            JOptionPane.showMessageDialog(null, "El asiento no esta disponible, ingrese otro numero.","Error",0);
            return;
        }
        modificado.pasajero=getCliente;
        modificado.movilidad=getBus;
        modificado.nroAsiento=getAsientoN();
        modificado.fechaOrigen=getFechaO();
        modificado.horaOrigen=getHoraO();
        modificado.origen=getOrigen();
        modificado.fechaDestino=getFechaD();
        modificado.horaDestino=getHoraD();
        modificado.destino=getDestino();
        JOptionPane.showMessageDialog(null, "Se modifico correctamente.","Confirmacion",1);
        imprimir();
        limpiar();
        limpiarPK();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cboOrigenDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOrigenDepartamentoItemStateChanged
        insertarProvincia(cboOrigenDepartamento, cboOrigenProvincia);
    }//GEN-LAST:event_cboOrigenDepartamentoItemStateChanged

    
    private void cboDestinoDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDestinoDepartamentoItemStateChanged
        insertarProvincia(cboDestinoDepartamento, cboDestinoProvincia);
    }//GEN-LAST:event_cboDestinoDepartamentoItemStateChanged

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        if(txtDNI.getText().length()>=8) evt.consume();
    }//GEN-LAST:event_txtDNIKeyTyped

    private void cboBusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBusItemStateChanged
        actualizarAsientos(existeBus(String.valueOf(cboBus.getSelectedItem())));
    }//GEN-LAST:event_cboBusItemStateChanged

    FrmInfoDestino nuevoInf=new FrmInfoDestino(0);
    private void btnInfoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoDestinoActionPerformed
        if(listaBuses.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay buses registrados.", "Error", 0);
            return;
        }
        if(!nuevoInf.isShowing()){
            nuevoInf=new FrmInfoDestino(this.getLocation().x);
            this.getDesktopPane().add(nuevoInf);
            nuevoInf.show();
        }
    }//GEN-LAST:event_btnInfoDestinoActionPerformed

    private void cboHoraOrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHoraOrigenItemStateChanged
        lblHoraDestino.setText(hm.format(getHoraD()));
        if(getFechaO()!=null) dcFechaDestino.setDate(getFechaD());
    }//GEN-LAST:event_cboHoraOrigenItemStateChanged

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de saiir?", "Confirmacion", 0, 3);
        if(respuesta==JOptionPane.YES_OPTION){
            escribirArchivo();
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION) this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void cboBusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboBusKeyTyped
    }//GEN-LAST:event_cboBusKeyTyped

    private void txtViajeIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtViajeIDKeyTyped
        if(txtViajeID.getText().length()>=8){
            evt.consume();
        }
    }//GEN-LAST:event_txtViajeIDKeyTyped

    void getColorBtn(){
        pnlGcolor=pnlBtnGuardar.getBackground();
        pnlBcolor =pnlBtnBuscar.getBackground();
        pnlMcolor=pnlBtnModificar.getBackground();
        pnlEcolor=pnlBtnEliminar.getBackground();
        pnlIDcolor=pnlBtnInfoDestino.getBackground();
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

    
    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios en el registro antes de salir?", "Confirmacion",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            escribirArchivo();
            
            this.dispose();
        }else if(respuesta==JOptionPane.NO_OPTION){
            nuevoInf.dispose();
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

    private void btnInfoDestinoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMouseEntered
        pnlBtnInfoDestino.setBackground(setColorBtn(pnlIDcolor, 12));
    }//GEN-LAST:event_btnInfoDestinoMouseEntered

    private void btnInfoDestinoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMouseExited
        pnlBtnInfoDestino.setBackground(pnlIDcolor);
    }//GEN-LAST:event_btnInfoDestinoMouseExited

    private void btnInfoDestinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMousePressed
        pnlBtnInfoDestino.setBackground(setColorBtn(pnlIDcolor, 20));
    }//GEN-LAST:event_btnInfoDestinoMousePressed

    private void btnInfoDestinoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoDestinoMouseReleased
        pnlBtnInfoDestino.setBackground(setColorBtn(pnlIDcolor, 12));
    }//GEN-LAST:event_btnInfoDestinoMouseReleased

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
    private javax.swing.JComboBox<String> cboBus;
    private javax.swing.JComboBox<String> cboDestinoDepartamento;
    private javax.swing.JComboBox<String> cboDestinoProvincia;
    private javax.swing.JComboBox<String> cboHoraOrigen;
    private javax.swing.JComboBox<String> cboNroAsiento;
    private javax.swing.JComboBox<String> cboOrigenDepartamento;
    private javax.swing.JComboBox<String> cboOrigenProvincia;
    private com.toedter.calendar.JDateChooser dcFechaDestino;
    private com.toedter.calendar.JDateChooser dcFechaOrigen;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblHoraDestino;
    private javax.swing.JPanel pnlBtnBuscar;
    private javax.swing.JPanel pnlBtnEliminar;
    private javax.swing.JPanel pnlBtnGuardar;
    private javax.swing.JPanel pnlBtnInfoDestino;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JTable tblRegViaje;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtViajeID;
    // End of variables declaration//GEN-END:variables
}
