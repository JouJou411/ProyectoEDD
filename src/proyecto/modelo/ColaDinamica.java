/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Joabp
 */
public class ColaDinamica
{

    private Nodo f;
    private Nodo a;

    public ColaDinamica(Nodo f, Nodo a)
    {
        this.f = f;
        this.a = a;
    }

    public ColaDinamica()
    {
    }

    public Nodo getF()
    {
        return f;
    }

    public void setF(Nodo f)
    {
        this.f = f;
    }

    public Nodo getA()
    {
        return a;
    }

    public void setA(Nodo a)
    {
        this.a = a;
    }

    public void inserta(Nodo n)
    {
        if (n == null)
        {
            System.out.println("No se puede insertar");
        } else
        {
            if (a != null)
            {
                a.setSiguiente(n);
            } else
            {
                f = n;
            }
            a = n;
        }
    }

    public Nodo elimina()
    {
        if (f == null)
        {
            System.out.println("Cola vacias");
            return null;
        }
        Nodo n = f;
        f = f.getSiguiente();
        n.setSiguiente(null);
        if (f == null)
        {
            a = f;
        }
        return n;
    }
}
