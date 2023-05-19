package edfinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
    private final JTextField profesionalNombreField;
    private final JTextField apellidosField;
    private final JTextField profesionalLocalidadField;
    private final JTextField telefonoField;
    private final JTextField especialidadField;

    private final JButton btnRegistrar;
    private final JButton btnSaltar;

    public InterfazEdfinal() {
        super("Registro de Datos");

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
        profesionalNombreField = new JTextField();
        apellidosField = new JTextField();
        profesionalLocalidadField = new JTextField();
        telefonoField = new JTextField();
        especialidadField = new JTextField();

        // Crear botones
        btnRegistrar = new JButton("Registrar");
        btnSaltar = new JButton("Saltar");

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

        add(btnSaltar);
        add(btnRegistrar);

        // Configurar acción del botón Saltar
        btnSaltar.addActionListener((ActionEvent e) -> {
            // Ir a la sección de visitas
            removeFields();
            addVisitFields();
            validate();
            repaint();
        });

        // Configurar acción del botón Registrar
        btnRegistrar.addActionListener((ActionEvent e) -> {
            // Registrar los datos en el archivo correspondiente
            String dni = dniField.getText();
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            String calle = calleField.getText();
            String localidad = localidadField.getText();
            int codPostal = Integer.parseInt(codPostalField.getText());
            
            registrarPaciente(dni, nombre, edad, calle, localidad, codPostal);
            
            // Ir a la sección de visitas
            removeFields();
            addVisitFields();
            validate();
            repaint();
        });

     
        setVisible(true);
    }

    private void removeFields() {
        remove(new JLabel("Pacientes"));
        remove(new JLabel(""));
        remove(new JLabel("DNI:"));
        remove(dniField);
        remove(new JLabel("Nombre:"));
        remove(nombreField);
        remove(new JLabel("Edad:"));
        remove(edadField);
        remove(new JLabel("Calle:"));
        remove(calleField);
        remove(new JLabel("Localidad:"));
        remove(localidadField);
        remove(new JLabel("Código Postal:"));
        remove(codPostalField);
        remove(btnSaltar);
        remove(btnRegistrar);
    }

    private void addVisitFields() {
        // Agregar etiquetas y campos de entrada para las visitas
        add(new JLabel("Visitas"));
        add(new JLabel(""));
        
        add(new JLabel("Profesional:"));
        add(profesionalField);

        add(new JLabel("DNI:"));
        add(visitasdniField);

        add(new JLabel("Fecha:"));
        add(fechaField);

        add(new JLabel("Hora:"));
        add(horaField);

        add(new JLabel("Peso:"));
        add(pesoField);

        add(new JLabel("Unidad de Peso:"));
        add(unidadPesoField);

        add(new JLabel("Altura:"));
        add(alturaField);

        add(new JLabel("Unidad de Altura:"));
        add(unidadAlturaField);

        add(btnSaltar);
        add(btnRegistrar);

   
        btnSaltar.addActionListener((ActionEvent e) -> {
  
            removeFields();
            addProfessionalFields();
            validate();
            repaint();
        });

       
        btnRegistrar.addActionListener((ActionEvent e) -> {
          
            String profesional = profesionalField.getText();
            String dni = visitasdniField.getText();
            String fecha = fechaField.getText();
            String hora = horaField.getText();
            double peso = Double.parseDouble(pesoField.getText());
            String unidadPeso = unidadPesoField.getText();
            double altura = Double.parseDouble(alturaField.getText());
            String unidadAltura = unidadAlturaField.getText();
            
            registrarVisita(profesional,dni, fecha, hora, peso, unidadPeso, altura, unidadAltura);
            
            // Ir a la sección de profesionales
            removeFields();
            addProfessionalFields();
            validate();
            repaint();
        });
    }

    private void addProfessionalFields() {
        add(new JLabel("Profesionales"));
        add(new JLabel(""));

        add(new JLabel("Código:"));
        add(codigoField);

        add(new JLabel("DNI:"));
        add(dniField);

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

        add(btnSaltar);
        add(btnRegistrar);


        btnSaltar.addActionListener((ActionEvent e) -> {
            removeFields();
            dispose();
        });

    
        btnRegistrar.addActionListener((ActionEvent e) -> {
 
            String codigo = codigoField.getText();
            String dni = dniField.getText();
            String nombre = profesionalNombreField.getText();
            String apellidos = apellidosField.getText();
            String localidad = profesionalLocalidadField.getText();
            String telefono = telefonoField.getText();
            String especialidad = especialidadField.getText();
            
            registrarProfesional(codigo, dni, nombre, apellidos, localidad, telefono, especialidad);
            
            removeFields();
            dispose();
        });
    }

    private void registrarPaciente(String dni, String nombre, int edad, String calle, String localidad, int codPostal) {
        // Registro de la visita en el archivo pacientes.txt
        try {
            FileWriter fw = new FileWriter("pacientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("DNI: " + dni);
            pw.println("Nombre: " + nombre);
            pw.println("Edad: " + edad);
            pw.println("Calle: " + calle);
            pw.println("Localidad: " + localidad);
            pw.println("Código Postal: " + codPostal);
            pw.println();

            pw.close();
            fw.close();
        } catch (IOException e) {
        }
    }

    private void registrarVisita(String profesional,String dni, String fecha, String hora, double peso, String unidadPeso, double altura, String unidadAltura) {
        // Registro de la visita en el archivo visitas.txt
        try {
            FileWriter fw = new FileWriter("visitas.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("Profesional: " + profesional);
            pw.println("DNI: " + dni);
            pw.println("Fecha: " + fecha);
            pw.println("Hora: " + hora);
            pw.println("Peso: " + peso);
            pw.println("Unidad de Peso: " + unidadPeso);
            pw.println("Altura: " + altura);
            pw.println("Unidad de Altura: " + unidadAltura);
            pw.println();

            pw.close();
            fw.close();
        } catch (IOException e) {
        }
    }

    private void registrarProfesional(String codigo, String dni, String nombre, String apellidos, String localidad, String telefono, String especialidad) {
        // Registro del profesional en el archivo profesionales.txt
        try {
            FileWriter fw = new FileWriter("profesionales.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Código: " + codigo);
            pw.println("DNI: " + dni);
            pw.println("Nombre: " + nombre);
            pw.println("Apellidos: " + apellidos);
            pw.println("Localidad: " + localidad);
            pw.println("Teléfono: " + telefono);
            pw.println("Especialidad: " + especialidad);
            pw.println();

            pw.close();
            fw.close();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        new InterfazEdfinal();
    }
}