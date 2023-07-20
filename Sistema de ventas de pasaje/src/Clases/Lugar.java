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
public class Lugar implements Serializable{
    public String departamento;
    public String provincia;
    public String distrito;
    public String direccion;

    public Lugar() {
        departamento = provincia = distrito = direccion = "";
    }

    public Lugar(String departamento, String provincia, String distrito, String direccion) {
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.direccion = direccion;
    }
}
