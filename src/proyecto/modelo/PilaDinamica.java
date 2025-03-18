/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Joabp
 */
public class PilaDinamica
{

    private Nodo t;

    public PilaDinamica(Nodo t)
    {
        this.t = t;
    }

    public PilaDinamica()
    {
    }

    public Nodo getT()
    {
        return t;
    }

    public void setT(Nodo t)
    {
        this.t = t;
    }

    public void inserta(Nodo n)
    {
        if (n == null)
        {
            System.out.println("no se puede insertar");
        } else
        {
            if (t != null)
            {
                n.setSiguiente(t);
            }
            t = n;
        }
    }

    public Nodo elimina()
    {
        Nodo n = null;
        if (t != null)
        {
            n = t;
            t = t.getSiguiente();
            n.setSiguiente(null);
        } else
        {
            System.out.println("Pila vacias");
        }
        return n;
    }
}
