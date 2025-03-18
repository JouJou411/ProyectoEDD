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

}
