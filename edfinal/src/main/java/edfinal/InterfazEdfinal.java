package edfinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazEdfinal extends JFrame {

    private JTextField dniField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField calleField;
    private JTextField localidadField;
    private JTextField codPostalField;
    private final JTextField profesionalField;
    private final JTextField visitasdniField;
    private final JTextField fechaField;
    private final JTextField horaField;
    private final JTextField pesoField;
    private final JTextField unidadPesoField;
    private final JTextField alturaField;
    private final JTextField unidadAlturaField;
    private final JTextField codigoField;
    private final JTextField profesionaldniField;
    private final JTextField profesionalNombreField;
    private final JTextField apellidosField;
    private final JTextField profesionalLocalidadField;
    private final JTextField telefonoField;
    private final JTextField especialidadField;

    private final JButton btnRegistrarPaciente;
    private final JButton btnSaltarPaciente;
    private final JButton btnRegistrarVisita;
    private final JButton btnSaltarVisitas;
    private final JButton btnRegistrarProfesional;
    private final JButton btnSaltarFinalizacion;


    public InterfazEdfinal() {

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2));

        // Crear los campos de entrada
        dniField = new JTextField();
        nombreField = new JTextField();
        edadField = new JTextField();
        calleField = new JTextField();
        localidadField = new JTextField();
        codPostalField = new JTextField();
        profesionalField = new JTextField();
        visitasdniField = new JTextField();
        fechaField = new JTextField();
        horaField = new JTextField();
        pesoField = new JTextField();
        unidadPesoField = new JTextField();
        alturaField = new JTextField();
        unidadAlturaField = new JTextField();
        codigoField = new JTextField();
        profesionaldniField = new JTextField();
        profesionalNombreField = new JTextField();
        apellidosField = new JTextField();
        profesionalLocalidadField = new JTextField();
        telefonoField = new JTextField();
        especialidadField = new JTextField();

        // Crear botones para cada sección
        btnRegistrarPaciente = new JButton("Registrar Paciente");
        btnSaltarPaciente = new JButton("Saltar Paciente");
        btnRegistrarVisita = new JButton("Registrar Visita");
        btnSaltarVisitas = new JButton("Saltar Visitas");
        btnRegistrarProfesional = new JButton("Registrar Profesional");
        btnSaltarFinalizacion = new JButton("Finalizar");

        // Agregar etiquetas y campos de entrada a la ventana
        add(new JLabel("Pacientes"));
        add(new JLabel(""));

        add(new JLabel("DNI:"));
        add(dniField);

        add(new JLabel("Nombre:"));
        add(nombreField);

        add(new JLabel("Edad:"));
        add(edadField);

        add(new JLabel("Calle:"));
        add(calleField);

        add(new JLabel("Localidad:"));
        add(localidadField);

        add(new JLabel("Código Postal:"));
        add(codPostalField);
        
        add(btnRegistrarPaciente);
         add(btnSaltarFinalizacion);

        // Configurar acción del botón Saltar Paciente
        btnSaltarPaciente.addActionListener((ActionEvent e) -> {
            removeFields();
            addVisitFields();
            validate();
            repaint();
        });
          btnSaltarFinalizacion.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        // Configurar acción del botón Registrar Paciente
        btnRegistrarPaciente.addActionListener((ActionEvent e) -> {
            String dni = dniField.getText();
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            String calle = calleField.getText();
            String localidad = localidadField.getText();
            int codPostal = Integer.parseInt(codPostalField.getText());

            RegistrarPaciente.registrarPaciente(dni, nombre, edad, calle, localidad, codPostal);

            removeFields();
            addVisitFields();
            validate();
            repaint();
        });

        // Configurar acción del botón Saltar Visitas
        btnSaltarVisitas.addActionListener((ActionEvent e) -> {
            removeFields();
            addProfessionalFields();
            validate();
            repaint();
        });

        // Configurar acción del botón Registrar Visita
        btnRegistrarVisita.addActionListener((ActionEvent e) -> {
            String profesional = profesionalField.getText();
            String dniVisitas = visitasdniField.getText();
            String fecha = fechaField.getText();
            String hora = horaField.getText();
            double peso = Double.parseDouble(pesoField.getText());
            String unidadPeso = unidadPesoField.getText();
            double altura = Double.parseDouble(alturaField.getText());
            String unidadAltura = unidadAlturaField.getText();

            RegistrarVisita.registrarVisita(profesional, dniVisitas, fecha, hora, peso, unidadPeso, altura, unidadAltura);

            removeFields();
            addProfessionalFields();
            validate();
            repaint();
        });

        // Agregar los botones restantes a la ventana
        add(btnSaltarPaciente);
        add(btnSaltarFinalizacion);
    }

    private void removeFields() {
        getContentPane().removeAll();
        revalidate();
        repaint();
    }

    private void addVisitFields() {
        getContentPane().setLayout(new GridLayout(8, 2));

        // Agregar etiquetas y campos de entrada para visitas
        add(new JLabel("Visitas"));
        add(new JLabel(""));

        add(new JLabel("Profesional:"));
        add(profesionalField);

        add(new JLabel("DNI Paciente:"));
        add(visitasdniField);

        add(new JLabel("Fecha:"));
        add(fechaField);

        add(new JLabel("Hora:"));
        add(horaField);

        add(new JLabel("Peso:"));
        add(pesoField);

        add(new JLabel("Unidad Peso:"));
        add(unidadPesoField);

        add(new JLabel("Altura:"));
        add(alturaField);

        add(new JLabel("Unidad Altura:"));
        add(unidadAlturaField);

        add(btnSaltarVisitas);
        add(btnRegistrarVisita);
        add(btnSaltarFinalizacion);      
    }

    private void addProfessionalFields() {
        getContentPane().setLayout(new GridLayout(8, 2));

        // Agregar etiquetas y campos de entrada para profesionales
        add(new JLabel("Profesionales"));
        add(new JLabel(""));

        add(new JLabel("Código:"));
        add(codigoField);
        
        add(new JLabel("DNI:"));
        add(profesionaldniField);

        add(new JLabel("Nombre:"));
        add(profesionalNombreField);

        add(new JLabel("Apellidos:"));
        add(apellidosField);

        add(new JLabel("Localidad:"));
        add(profesionalLocalidadField);

        add(new JLabel("Teléfono:"));
        add(telefonoField);

        add(new JLabel("Especialidad:"));
        add(especialidadField);

        
        btnRegistrarProfesional.addActionListener((ActionEvent e) -> {
            int codigo = Integer.parseInt(codigoField.getText());
            String dni = profesionaldniField.getText();
            String nombre= profesionalNombreField.getText();
            String apellidos = horaField.getText();
            String localidad = profesionalLocalidadField.getText();
            int telefono = Integer.parseInt(telefonoField.getText());
            String especialidad = unidadPesoField.getText();
            

            RegistrarProfesional.registrarProfesional(codigo, dni, nombre, apellidos, localidad, telefono, especialidad);

            removeFields();
            addProfessionalFields();
            validate();
            repaint();
        });
        
        add(btnSaltarFinalizacion);
        add(btnRegistrarProfesional);
        
    }
    
    public static void main(String[] args) {
        InterfazEdfinal interfaz = new InterfazEdfinal();
        interfaz.setVisible(true);
    }
}
