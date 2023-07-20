/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author CRISTOFER
 */
public class Pasaje implements Serializable{
    public String pasajeID;
    public Venta venta;
    public String descripcion;

    public Pasaje() {
        pasajeID="";
        venta=new Venta();
        descripcion="Aun no esta creado";
    }

    public Pasaje(String pasajeID, Venta venta) {
        this.pasajeID = pasajeID;
        this.venta = venta;
        descripcion="CANCELADO";
    }
}
