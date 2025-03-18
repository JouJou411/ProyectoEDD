/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Jou
 */
public class Validar
{

    public static boolean isValidText(String text)
    {
        return text.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidNumber(int number, int min, int max)
    {
        return number >= min && number <= max;
    }

}
