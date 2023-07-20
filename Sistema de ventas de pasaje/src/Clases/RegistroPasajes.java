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
public class RegistroPasajes implements Serializable{
    public List<Pasaje> lista;

    public RegistroPasajes() {
        lista=new LinkedList();
    }
    public double calcularTotal() {
        double suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).descripcion.equals("CANCELADO"))
                suma += lista.get(i).venta.costo();
        }
        return suma;
    }
}
