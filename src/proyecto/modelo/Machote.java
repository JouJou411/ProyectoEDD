/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto.modelo;

/**
 *
 * @author Jou
 */
public interface Machote<T>
{

    public void inserta(T obj);

    public T elimina();

    public boolean llena();

    public boolean vacia();
}
