/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author CRISTOFER
 */
public class RegistroVenta implements Serializable{
    public List<Venta> lista;

    public RegistroVenta() {
        lista=new LinkedList();
    }
    
    public double calcularTotal() {
        double suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i).costo();
        }
        return suma;
    }
}
