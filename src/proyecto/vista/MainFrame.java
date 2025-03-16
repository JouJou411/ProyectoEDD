/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jou
 */
public class MainFrame extends JFrame
{

    public MainFrame()
    {
        setTitle("Sala de Emergencias");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 1));

        JButton btnAgregar = new JButton("Agregar Paciente");
        JButton btnAtender = new JButton("Atender Paciente");
        JButton btnMover = new JButton("Mover Pacientes");
        JButton btnOrdenar = new JButton("Ordenar por Zona");
        JButton btnExcepcion = new JButton("Excepción de Pacientes");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnAtender);
        panelBotones.add(btnMover);
        panelBotones.add(btnOrdenar);
        panelBotones.add(btnExcepcion);

        add(panelBotones, BorderLayout.WEST);

        // Tabla de pacientes
        String[] columnas =
        {
            "No. Paciente", "Nombre", "Prioridad", "Zona"
        };
        Object[][] datos =
        {
        };
        JTable tablaPacientes = new JTable(datos, columnas);
        add(new JScrollPane(tablaPacientes), BorderLayout.CENTER);

        // Eventos de los botones
        btnAgregar.addActionListener(e -> abrirVentanaAgregar());
        btnAtender.addActionListener(e -> atenderPaciente());
        btnMover.addActionListener(e -> moverPacientes());
        btnOrdenar.addActionListener(e -> ordenarPacientes());
        btnExcepcion.addActionListener(e -> excepcionPacientes());

        centrarJFrame();
    }

    private void abrirVentanaAgregar()
    {
        
    }

    private void atenderPaciente()
    {
        JOptionPane.showMessageDialog(this, "Atender paciente de menor prioridad.");
    }

    private void moverPacientes()
    {
        JOptionPane.showMessageDialog(this, "Mover pacientes de una prioridad específica.");
    }

    private void ordenarPacientes()
    {
        JOptionPane.showMessageDialog(this, "Ordenar pacientes por zona en una prioridad específica.");
    }

    private void excepcionPacientes()
    {
        JOptionPane.showMessageDialog(this, "Mover pacientes de una prioridad a la prioridad 0.");
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }

    private void centrarJFrame()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }
}
