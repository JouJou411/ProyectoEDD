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

    private static int contadorPacientes = 1;
    private ListaSL lsl = new ListaSL();

    public boolean agregaPaciente(String nombrePaciente, int prioridad, int zona)
    {
        Paciente p = new Paciente(contadorPacientes++, nombrePaciente, prioridad, zona);
        Nodo n = new Nodo(p, String.valueOf(prioridad));
        return lsl.inserta(n);
    }

}
