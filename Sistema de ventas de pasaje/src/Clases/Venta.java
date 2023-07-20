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
public class Venta implements Serializable{
    public String formaPago;
    public String moneda;
    public Viaje viaje;

    public Venta() {
        formaPago=moneda="";
    }

    public Venta(String formaPago, String moneda, Viaje viaje) {
        this.formaPago = formaPago;
        this.moneda = moneda;
        this.viaje = viaje;
    }
    public float costo(){
        switch(moneda){
            case "PEN":
                if(viaje.movilidad.servicio.equals("Economico")) return 80;
                else if(viaje.movilidad.servicio.equals("VIP")) return 150;
            case "USD":
                if(viaje.movilidad.servicio.equals("Economico")) return 22;
                else if(viaje.movilidad.servicio.equals("VIP")) return 40;
        }
        return 0;
    }
}
