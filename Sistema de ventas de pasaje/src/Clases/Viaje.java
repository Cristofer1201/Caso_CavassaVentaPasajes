/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author CRISTOFER
 */
public class Viaje implements Serializable{
    public String viajeID;
    public Date fechaOrigen;
    public Date horaOrigen;
    public Date fechaDestino;
    public Date horaDestino;
    public Cliente pasajero;
    public String nroAsiento;
    public Bus movilidad;
    public Lugar origen;
    public Lugar destino;

    public Viaje() {
        viajeID = "";
        fechaOrigen = horaOrigen = fechaDestino = horaDestino = new Date();
        pasajero = new Cliente();
        nroAsiento = "";
        movilidad = new Bus();
        origen = new Lugar();
        destino = new Lugar();
    }

    public Viaje(Date fechaOrigen, Date horaOrigen, Date fechaDestino, Date horaDestino, Cliente pasajero, String nroAsiento, Bus movilidad, Lugar origen, Lugar destino) {
        this.fechaOrigen = fechaOrigen;
        this.horaOrigen = horaOrigen;
        this.fechaDestino = fechaDestino;
        this.horaDestino = horaDestino;
        this.pasajero = pasajero;
        this.nroAsiento = nroAsiento;
        this.movilidad = movilidad;
        this.origen = origen;
        this.destino = destino;
    }

    
}
