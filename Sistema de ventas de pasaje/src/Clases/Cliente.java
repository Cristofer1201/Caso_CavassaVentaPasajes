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
public class Cliente extends Persona implements Serializable{
    public Cliente() {
        super();
    }

    public Cliente(int DNI, String nombres, String apellidos, Date fechaNac, String correo, String direccion, int telefono) {
        super(DNI, nombres, apellidos, fechaNac, correo, direccion, telefono);
    }
}
