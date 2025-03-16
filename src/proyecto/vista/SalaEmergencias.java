/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.vista;

/**
 *
 * @author Jou
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalaEmergencias extends JFrame
{

    public SalaEmergencias()
    {
        initComponents();
        centrarJFrame();
    }

    private void initComponents()
    {
        setTitle("Sala de Emergencias - Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // Panel 1: Addd Patient
        JPanel panelAdddPatient = new JPanel();
        panelAdddPatient.setLayout(new GridLayout(4, 2));
        panelAdddPatient.setBorder(BorderFactory.createTitledBorder("Addd patient"));

        panelAdddPatient.add(new JLabel("Agregar paciente"));
        panelAdddPatient.add(new JPanel()); // Espacio en blanco

        panelAdddPatient.add(new JLabel("Name"));
        panelAdddPatient.add(new JTextField());

        panelAdddPatient.add(new JLabel("Priority"));
        panelAdddPatient.add(new JSpinner(new SpinnerNumberModel(0, 0, 10, 1)));

        add(panelAdddPatient);

        // Panel 2: Agregar paciente / Atender pasiente
        JPanel panelAgregarAtender = new JPanel();
        panelAgregarAtender.setLayout(new GridLayout(4, 2));
        panelAgregarAtender.setBorder(BorderFactory.createTitledBorder("Agregar paciente"));

        panelAgregarAtender.add(new JLabel("Agregar paciente"));
        panelAgregarAtender.add(new JButton("+"));

        panelAgregarAtender.add(new JLabel("Atender pasiente"));
        panelAgregarAtender.add(new JButton("+"));

        panelAgregarAtender.add(new JLabel("Priority 0-10"));
        panelAgregarAtender.add(new JSpinner(new SpinnerNumberModel(0, 0, 10, 1)));

        panelAgregarAtender.add(new JLabel("Zona"));
        panelAgregarAtender.add(new JTextField());

        add(panelAgregarAtender);

        // Panel 3: Add Patient (Ambulancia)
        JPanel panelAddPatientAmbulancia = new JPanel();
        panelAddPatientAmbulancia.setLayout(new BorderLayout());
        panelAddPatientAmbulancia.setBorder(BorderFactory.createTitledBorder("Add Patient"));

        JPanel panelAmbulancia = new JPanel();
        panelAmbulancia.add(new JLabel("Ambulancia (Imagen aquí)")); // Reemplaza con una imagen
        panelAddPatientAmbulancia.add(panelAmbulancia, BorderLayout.CENTER);

        JPanel panelAgregarCruz = new JPanel();
        panelAgregarCruz.add(new JButton("+"));
        panelAddPatientAmbulancia.add(panelAgregarCruz, BorderLayout.EAST);

        add(panelAddPatientAmbulancia);

        // Panel 4: Ordenar por ZON
        JPanel panelOrdenarZona = new JPanel();
        panelOrdenarZona.setLayout(new GridLayout(4, 2));
        panelOrdenarZona.setBorder(BorderFactory.createTitledBorder("Ordenar por ZONA"));

        panelOrdenarZona.add(new JLabel("No. paciente"));
        panelOrdenarZona.add(new JButton("+"));

        panelOrdenarZona.add(new JLabel("Nrдораси")); // Reemplaza con etiqueta correcta
        panelOrdenarZona.add(new JButton("+"));

        panelOrdenarZona.add(new JLabel("Zone pacientes"));
        panelOrdenarZona.add(new JButton("+"));

        add(panelOrdenarZona);

        pack(); // Ajusta el tamaño del JFrame al contenido

        JButton btnAgregarPaciente = new JButton("+"); // El botón de agregar paciente
        btnAgregarPaciente.addActionListener((ActionEvent e) ->
        {
            FormularioAgregarPaciente formulario = new FormularioAgregarPaciente(SalaEmergencias.this);
            formulario.setVisible(true);
        });
    }

    private void centrarJFrame()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(() ->
        {
            new SalaEmergencias().setVisible(true);
        });
    }
}
