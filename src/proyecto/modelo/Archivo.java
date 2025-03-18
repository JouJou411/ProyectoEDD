/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jou
 */
public class Archivo
{

    private static String filePath;

    public Archivo(String url)
    {
        this.filePath = url;
    }

    public Archivo()
    {
    }

    public String getUrl()
    {
        return filePath;
    }

    public void setUrl(String url)
    {
        this.filePath = url;
    }

    public static void guardar(Object obj, String url)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(url);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception err)
        {
            System.out.println("Error..." + err.toString());
        }
    }

    public static Object cargar(String url)
    {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(url); ObjectInputStream arch = new ObjectInputStream(fis))
        {
            obj = arch.readObject();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontró el archivo: " + url);
        } catch (ClassNotFoundException ex)
        {
            System.out.println("Clase no encontrada durante la deserialización: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex)
        {
            System.out.println("Error de E/S durante la deserialización: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex)
        {
            System.out.println("Error inesperado durante la deserialización: " + ex.getMessage());
            ex.printStackTrace();
        }
        return obj;
    }

    public static void guardar(Object obj)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception err)
        {
            System.out.println("Error..." + err.toString());
        }
    }

    public static Object cargar()
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream arch = new ObjectInputStream(fis);
            obj = arch.readObject();
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception err)
        {
            System.out.println("Error..." + err.toString());
        }
        return obj;
    }
}
