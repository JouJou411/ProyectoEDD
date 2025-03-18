/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.io.Serializable;

/**
 *
 * @author Joabp
 */
public class ListaSL implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Nodo r;

    public ListaSL(Nodo r)
    {
        this.r = r;
    }

    public ListaSL()
    {
    }

    public Nodo getR()
    {
        return r;
    }

    public void setR(Nodo r)
    {
        this.r = r;
    }

    public boolean inserta(Nodo n) {
        if (n == null) {
            System.out.println("No se puede insertar un nodo nulo.");
            return false;
        } else {
            if (r == null) {
                r = n;
            } else {
                if (esNumerico(n.getEtiqueta()) && esNumerico(r.getEtiqueta())) {
                    if (Integer.parseInt(r.getEtiqueta()) > Integer.parseInt(n.getEtiqueta())) {
                        n.setSiguiente(r);
                        r = n;
                    } else {
                        Nodo aux = r;
                        while (aux.getSiguiente() != null) {
                            if (esNumerico(aux.getSiguiente().getEtiqueta()) &&
                                    Integer.parseInt(aux.getSiguiente().getEtiqueta()) > Integer.parseInt(n.getEtiqueta())) {
                                n.setSiguiente(aux.getSiguiente());
                                aux.setSiguiente(n);
                                return true;
                            }
                            aux = aux.getSiguiente();
                        }
                        aux.setSiguiente(n);
                    }
                } else {
                    if (r.getEtiqueta().compareTo(n.getEtiqueta()) > 0) {
                        n.setSiguiente(r);
                        r = n;
                    } else {
                        Nodo aux = r;
                        while (aux.getSiguiente() != null) {
                            if (aux.getSiguiente().getEtiqueta().compareTo(n.getEtiqueta()) > 0) {
                                n.setSiguiente(aux.getSiguiente());
                                aux.setSiguiente(n);
                                return true;
                            }
                            aux = aux.getSiguiente();
                        }
                        aux.setSiguiente(n);
                    }
                }
            }
            return true;
        }
    }

    public String desp()
    {
        String s = "";
        Nodo aux = r;
        while (aux != null)
        {
            s += aux.getEtiqueta() + "\t";
            aux = aux.getSiguiente();
        }
        return s;
    }

    public String despRecursivo(Nodo aux, String s)
    {
        if (aux != null)
        {
            s += aux.getEtiqueta() + "\t" + despRecursivo(aux.getSiguiente(), s);
        }
        return s;
    }

    public Nodo elimina(String et)
    {
        if (r == null)
        {
            System.out.println("Lista vacia");
            return null;
        }

        Nodo eliminado = null;
        if (esNumerico(et) && esNumerico(r.getEtiqueta()))
        {
            if (Integer.parseInt(r.getEtiqueta()) > Integer.parseInt(et))
            {
                System.out.println("Nodo no encontrado");
                return null;
            }
            if (Integer.parseInt(r.getEtiqueta()) == Integer.parseInt(et))
            {
                eliminado = r;
                r = r.getSiguiente();
                eliminado.setSiguiente(null);
                return eliminado;
            }
            Nodo aux = r;
            while (aux.getSiguiente() != null)
            {
                if (esNumerico(aux.getSiguiente().getEtiqueta())
                        && Integer.parseInt(aux.getSiguiente().getEtiqueta()) == Integer.parseInt(et))
                {
                    eliminado = aux.getSiguiente();
                    aux.setSiguiente(eliminado.getSiguiente());
                    eliminado.setSiguiente(null);
                    return eliminado;
                }
                aux = aux.getSiguiente();
            }
        } else
        {
            if (r.getEtiqueta().compareTo(et) > 0)
            {
                System.out.println("Nodo no encontrado");
                return null;
            }
            if (r.getEtiqueta().compareTo(et) == 0)
            {
                eliminado = r;
                r = r.getSiguiente();
                eliminado.setSiguiente(null);
                return eliminado;
            }
            Nodo aux = r;
            while (aux.getSiguiente() != null)
            {
                if (aux.getSiguiente().getEtiqueta().compareTo(et) == 0)
                {
                    eliminado = aux.getSiguiente();
                    aux.setSiguiente(eliminado.getSiguiente());
                    eliminado.setSiguiente(null);
                    return eliminado;
                }
                aux = aux.getSiguiente();
            }
        }
        return eliminado;
    }

    private boolean esNumerico(String cadena)
    {
        try
        {
            Integer.valueOf(cadena);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    public Nodo buscar(String et)
    {
        Nodo aux = r;
        while (aux != null)
        {
            if (aux.getEtiqueta().equals(et))
            {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public boolean esVacio()
    {
        return r == null;
    }
}
