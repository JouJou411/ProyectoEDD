/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Jou
 */
public class ArregloDinamico
{

    private Object arr[] = null;

    public Object[] getArr()
    {
        return arr;
    }

    public void setArr(Object[] arr)
    {
        this.arr = arr;
    }

    public void inserta(Object obj)
    {
        if (arr == null)
        {
            arr = new Object[1];
            arr[0] = obj;
        } else
        {
            Object nvo[] = new Object[arr.length + 1];
            System.arraycopy(arr, 0, nvo, 0, arr.length);
            nvo[arr.length] = obj;
            arr = nvo;
        }
    }

    public Object elimina(Object obj)
    {
        if (arr == null)
        {
            return null;
        } else
        {
            int pos = buscar(obj);
            if (pos != -1)
            {
                if (pos == 0 && arr.length == 1)
                {
                    arr = null;
                } else
                {
                    Object nvo[] = new Object[arr.length - 1];
                    for (int i = 0, j = 0; i < arr.length; i++)
                    {
                        if (pos != i)
                        {
                            nvo[j++] = arr[i];
                        }
                    }
                    arr = nvo;
                }
                return obj;
            }
            return null;
        }
    }

    public Object elimina()
    {
        if (arr == null)
        {
            return null;
        } else
        {
            Object eliminado = arr[arr.length - 1];
            if (arr.length == 1)
            {
                arr = null;
            } else
            {
                Object nvo[] = new Object[arr.length - 1];
                System.arraycopy(arr, 0, nvo, 0, arr.length - 1);
                arr = nvo;
            }
            return eliminado;
        }
    }

    private int buscar(Object obj)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == obj)
            {
                return i;
            }
        }
        return -1;
    }

    public int length()
    {
        return arr.length;
    }
}
