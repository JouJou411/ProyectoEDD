/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Joabp
 */
public class Colas<T> implements Machote<T>
{

    private int atras = -1;
    private T arr[];

    public Colas(T arr[])
    {
        this.arr = arr;
    }

    public int getAtras()
    {
        return atras;
    }

    public void setAtras(int atras)
    {
        this.atras = atras;
    }

    public T[] getArr()
    {
        return arr;
    }

    public void setArr(T[] arr)
    {
        this.arr = arr;
    }

    @Override
    public void inserta(T obj)
    {
        if (!llena())
        {
            arr[++atras] = obj;
        } else
        {
            System.out.println("Cola llena");
        }
    }

    @Override
    public T elimina()
    {
        T obj = null;
        if (!vacia())
        {
            obj = arr[0];
            for (int i = 0; i < atras; i++)
            {
                arr[i] = arr[i + 1];
            }
            atras--;
        } else
        {
            System.out.println("cola vacia");
        }
        return obj;
    }

    @Override
    public boolean llena()
    {
        return arr.length - 1 == atras;
    }

    @Override
    public boolean vacia()
    {
        return atras == -1;
    }

}
