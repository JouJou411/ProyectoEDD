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
        System.out.println("agregaPaciente() llamado");
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

    public static boolean movePatientPriority(ListaSL lsl, String et, String nvoEt)
    {
        Nodo nLista = lsl.elimina(et);
        if (nLista == null)
        {
            return false;
        }
        ColaDinamica cd = (ColaDinamica) nLista.getObj();
        Nodo nAuxLsl = lsl.elimina(nvoEt);
        ColaDinamica destinoCD;
        if (nAuxLsl == null)
        {
            destinoCD = new ColaDinamica();
        } else
        {
            destinoCD = (ColaDinamica) nAuxLsl.getObj();
        }
        int nuevaPrioridad = Integer.parseInt(nvoEt);
        while (cd.getF() != null)
        {
            Nodo nPaciente = cd.elimina();
            Paciente p = (Paciente) nPaciente.getObj();
            p.setPrioridad(nuevaPrioridad);
            nPaciente.setEtiqueta(nvoEt);
            destinoCD.inserta(nPaciente);
        }
        lsl.inserta(new Nodo(destinoCD, nvoEt));
        return true;
    }
}
