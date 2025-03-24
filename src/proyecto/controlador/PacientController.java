/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import proyecto.modelo.*;

/**
 *
 * @author Jou
 */
public class PacientController
{

    public static boolean agregaPaciente(String nombrePaciente, ListaSL lsl, int prioridad, int zona)
    {
        Paciente p = new Paciente(nombrePaciente, prioridad, zona);
        String et = String.valueOf(prioridad);
        Nodo nPaciente = new Nodo(p, et);
        Nodo nLista = lsl.buscar(et);
        ColaDinamica cd = (nLista == null) ? new ColaDinamica() : (ColaDinamica) nLista.getObj();
        cd.inserta(nPaciente);
        if (nLista == null)
        {
            lsl.inserta(new Nodo(cd, et));
        }
        return true;
    }

    public static boolean atenderPaciente(ListaSL lsl)
    {
        if (lsl != null && lsl.getR() != null)
        {
            Nodo nLista = lsl.getR();
            ColaDinamica cd = (ColaDinamica) nLista.getObj();
            if (cd.getF() != null)
            {
                cd.elimina();
                if (cd.getF() == null)
                {
                    lsl.elimina(nLista.getEtiqueta());
                }
                return true;
            } else
            {
                lsl.elimina(nLista.getEtiqueta());
                return true;
            }
        } else
        {
            return false;
        }
    }

    public static boolean movePatientPriority(ListaSL lsl, String et)
    {
        Nodo nLista = lsl.elimina(et);
        if (nLista == null)
        {
            return false;
        }
        ColaDinamica cd = (ColaDinamica) nLista.getObj();
        while (cd.getF() != null)
        {
            cd.elimina();
        }
        return true;
    }

    public static boolean exceptionPacient(ListaSL lsl, String et)
    {
        Nodo nLista = lsl.elimina(et);
        if (nLista == null)
        {
            return false;
        }
        ColaDinamica cd = (ColaDinamica) nLista.getObj();
        Nodo nAuxLsl = lsl.elimina(et);
        ColaDinamica destinoCD;
        if (nAuxLsl == null)
        {
            destinoCD = new ColaDinamica();
        } else
        {
            destinoCD = (ColaDinamica) nAuxLsl.getObj();
        }
        int nuevaPrioridad = 0;
        while (cd.getF() != null)
        {
            Nodo nPaciente = cd.elimina();
            Paciente p = (Paciente) nPaciente.getObj();
            p.setPrioridad(nuevaPrioridad);
            nPaciente.setEtiqueta("0");
            destinoCD.inserta(nPaciente);
        }
        lsl.inserta(new Nodo(destinoCD, "0"));
        return true;
    }

    public static boolean orderPacientZonePriority(ListaSL lsl, String et)
    {
        Nodo nLista = lsl.elimina(et);
        if (nLista == null)
        {
            return false;
        } else
        {
            ColaDinamica cd = (ColaDinamica) nLista.getObj();
            ArregloDinamico ad = new ArregloDinamico();
            while (cd.getF() != null)
            {
                Nodo nPacient = cd.elimina();
                ad.inserta(nPacient.getObj());
            }
            cd = order(ad);
            lsl.inserta(new Nodo(cd, et));
            return true;
        }
    }

    private static ColaDinamica order(ArregloDinamico ad)
    {
        ColaDinamica cd = new ColaDinamica();
        Pilas<Paciente> pila1 = new Pilas<>(new Paciente[ad.length()]);
        Pilas<Paciente> pila2 = new Pilas<>(new Paciente[ad.length()]);
        Colas<Paciente> cola = new Colas<>(new Paciente[ad.length()]);

        for (Object obj : ad.getArr())
        {
            if (obj instanceof Paciente paciente)
            {
                cola.inserta(paciente);
            }
        }
        while (!cola.vacia())
        {
            Paciente temp = cola.elimina();
            while (!pila1.vacia() && pila1.cima().getZona() < temp.getZona())
            {
                pila2.inserta(pila1.elimina());
            }
            pila1.inserta(temp);

            while (!pila2.vacia())
            {
                pila1.inserta(pila2.elimina());
            }
        }
        while (!pila1.vacia())
        {
            Paciente p = pila1.elimina();
            String et = String.valueOf(p.getPrioridad());
            cd.inserta(new Nodo(p, et));
        }
        return cd;
    }
}
