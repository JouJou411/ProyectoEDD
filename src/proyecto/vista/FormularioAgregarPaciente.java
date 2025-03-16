/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jou
 */

public class FormularioAgregarPaciente extends JDialog
{

    private JTextField txtNombre;
    private JSpinner spinnerPrioridad;
    private JTextField txtZona;
    private JButton btnAgregar;
    private JButton btnCancelar;

    public FormularioAgregarPaciente(JFrame parent)
    {
        super(parent, "Agregar Paciente", true); // Modal
        initComponents();
        centrarDialogo();
    }

    private void initComponents()
    {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Prioridad:"));
        spinnerPrioridad = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        add(spinnerPrioridad);

        add(new JLabel("Zona:"));
        txtZona = new JTextField();
        add(txtZona);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener((ActionEvent e) ->
        {
            agregarPaciente();
        });
        add(btnAgregar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener((ActionEvent e) ->
        {
            dispose(); // Cierra el diálogo
        });
        add(btnCancelar);

        pack();
    }

    private void agregarPaciente()
    {
        String nombre = txtNombre.getText();
        int prioridad = (int) spinnerPrioridad.getValue();
        String zona = txtZona.getText();

        // Aquí deberías agregar la lógica para agregar el paciente
        // Puedes pasar los datos a la clase principal o almacenarlos en una lista
        System.out.println("Paciente agregado: " + nombre + ", Prioridad: " + prioridad + ", Zona: " + zona);

        dispose(); // Cierra el diálogo después de agregar el paciente
    }

    private void centrarDialogo()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = getSize();
        int x = (screenSize.width - dialogSize.width) / 2;
        int y = (screenSize.height - dialogSize.height) / 2;
        setLocation(x, y);
    }
}
