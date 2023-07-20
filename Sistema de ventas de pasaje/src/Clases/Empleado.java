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
public class Empleado extends Persona implements Serializable{
    public String cargo;
    public String seguro;
    public Date fechaContrato;

    public Empleado() {
        super();
        cargo=seguro="";
        fechaContrato=new Date();
    }

    public Empleado(String cargo, String seguro, Date fechaContrato, int DNI, String nombres, String apellidos, Date fechaNac, String correo, String direccion, int telefono) {
        super(DNI, nombres, apellidos, fechaNac, correo, direccion, telefono);
        this.cargo = cargo;
        this.seguro = seguro;
        this.fechaContrato = fechaContrato;
    }
    
    
    
}
