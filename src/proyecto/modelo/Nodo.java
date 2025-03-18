/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.io.Serializable;

/**
 *
 * @author Joabp
 * @param <T>
 */
public class Nodo<T> implements Serializable
{

    private static final long serialVersionUID = 1L;
    private T obj;
    private String etiqueta;
    private Nodo<T> siguiente;

    public Nodo(T obj, String etiqueta)
    {
        this.obj = obj;
        this.etiqueta = etiqueta;
        System.out.println("Tipo de obj: " + obj.getClass().getName()); // Imprime el tipo de obj
    }

    public String getEtiqueta()
    {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public T getObj()
    {
        return obj;
    }

    public void setObj(T obj)
    {
        this.obj = obj;
    }

    public Nodo getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }

}
