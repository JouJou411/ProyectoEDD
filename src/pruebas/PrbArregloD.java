/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import proyecto.modelo.ArregloDinamico;

/**
 *
 * @author Jou
 */
public class PrbArregloD
{
    public static void main(String[] args)
    {
        ArregloDinamico arrD = new ArregloDinamico();
        arrD.inserta(5);
        arrD.inserta(6);
        arrD.inserta(4);
        arrD.inserta(8);
        
        System.out.println(arrD.elimina());
    }
}
