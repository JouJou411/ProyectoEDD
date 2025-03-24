/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;


/**
 *
 * @author Jou
 */
public class GestorNoPacientes
{

    private static final String FILE_PATH = "src/proyecto/archivo/noPaciente.dat";
    private static int ultimoNumero = cargarUltimoNumero();

    private static int cargarUltimoNumero()
    {
        Integer numero = (Integer) Archivo.cargar(FILE_PATH);
        return (numero != null) ? numero : 0;
    }

    public static int obtenerNuevoNumero()
    {
        return ++ultimoNumero;
    }

    public static void guardarNumeroFinal()
    {
        Archivo.guardar(ultimoNumero, FILE_PATH);
    }
}
