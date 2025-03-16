/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Jou
 */
public class Paciente
{

    private int noPaciente;
    private String nomPaciente;
    private int prioridad;//0 a 10
    private int zona;// 1 a 10

    public Paciente(int noPaciente, String nomPaciente, int prioridad, int zona)
    {
        this.noPaciente = noPaciente;
        this.nomPaciente = nomPaciente;
        this.prioridad = prioridad;
        this.zona = zona;
    }

    public Paciente()
    {
    }

    public int getNoPaciente()
    {
        return noPaciente;
    }

    public void setNoPaciente(int noPaciente)
    {
        this.noPaciente = noPaciente;
    }

    public String getNomPaciente()
    {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente)
    {
        this.nomPaciente = nomPaciente;
    }

    public int getPrioridad()
    {
        return prioridad;
    }

    public void setPrioridad(int prioridad)
    {
        this.prioridad = prioridad;
    }

    public int getZona()
    {
        return zona;
    }

    public void setZona(int zona)
    {
        this.zona = zona;
    }

}
