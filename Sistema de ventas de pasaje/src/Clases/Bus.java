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
public class Bus implements Serializable{
    public String nroBus;
    public String marca;
    public String modelo;
    public String placa;
    public String servicio;
    public int cantidadAsientos;
    public AsientoBus asientos[];
    
    public Bus() {
        nroBus = marca = modelo = placa = servicio = "";
        cantidadAsientos = 0;
    }

    public Bus(String marca, String modelo, String placa, String servicio, int cantidadAsientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.servicio=servicio;
        this.cantidadAsientos = cantidadAsientos;
        this.asientos=new AsientoBus[cantidadAsientos];
        for (int i = 0; i < this.cantidadAsientos; i++) {
            asientos[i] = new AsientoBus("" + (i + 1), true);
        }
    }
    
}
