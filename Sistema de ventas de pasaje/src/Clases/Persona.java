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
public class Persona implements Serializable{
    public int DNI;
    public String nombres;
    public String apellidos;
    public Date fechaNac;
    public String correo;
    public String direccion;
    public int telefono;

    public Persona() {
        DNI=0;
        nombres=apellidos="";
        fechaNac=new Date();
        correo=direccion="";
        telefono=0;
    }

    public Persona(int DNI, String nombres, String apellidos, Date fechaNac, String correo, String direccion, int telefono) {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono=telefono;
    }
    
    public int edad(){
        Date fechaHoy=new Date();
        int dh, mh, ah, d, m, a;
        dh = fechaHoy.getDate();
        mh = fechaHoy.getMonth() + 1;
        ah = fechaHoy.getYear() + 1900;
        d = fechaNac.getDate();
        m = fechaNac.getMonth() + 1;
        a = fechaNac.getYear() + 1900;
        if (d <= dh) {
            if (m <= mh) {
                return ah - a;
            } else {
                return ah - a - 1;
            }
        } else {
            if (m < mh) {
                return ah - a;
            } else {
                return ah - a - 1;
            }
        }
    }
}
