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
public class AsientoBus implements Serializable{
    public String nroAsiento;
    public boolean disponibilidad;

    public AsientoBus() {
        nroAsiento = "";
        disponibilidad = true;
    }

    public AsientoBus(String nroAsiento, boolean disponibilidad) {
        this.nroAsiento = nroAsiento;
        this.disponibilidad = disponibilidad;
    }
    
}
