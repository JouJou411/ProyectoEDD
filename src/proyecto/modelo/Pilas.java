/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Joabp
 * @param <T>
 */
public class Pilas<T> implements Machote<T>
{

    private T arr[];
    private int t = -1;

    public Pilas(T[] arr)
    {
        this.arr = arr;
    }

    public T[] getArr()
    {
        return arr;
    }

    public void setArr(T[] arr)
    {
        this.arr = arr;
    }

    public int getT()
    {
        return t;
    }

    public void setT(int t)
    {
        this.t = t;
    }

    @Override
    public void inserta(T obj)
    {
        if (!llena())
        {
            arr[++t] = obj;
        } else
        {
            System.out.println("Pila llena :C");
        }
    }

    @Override
    public T elimina()
    {
        T obj = null;
        if (!vacia())
        {
            obj = arr[t--];
        } else
        {
            System.out.println("Pila vacia :C");
        }
        return obj;
    }

    @Override
    public boolean llena()
    {
        return t == arr.length - 1;
    }

    @Override
    public boolean vacia()
    {
        return t == -1;
    }

    public T cima()
    {
        if (!vacia())
        {
            return arr[t];
        }
        return null;
    }

}
