package edfinal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class RegistrarPaciente {

    public static void registrarPaciente(String dni, String nombre, int edad, String calle, String localidad, int codPostal) {
        try {
            try (FileWriter fw = new FileWriter("Pacientes.txt", true); PrintWriter pw = new PrintWriter(fw)) {
                pw.println("DNI: " + dni);
                pw.println("Nombre: " + nombre);
                pw.println("Edad: " + edad);
                pw.println("Calle: " + calle);
                pw.println("Localidad: " + localidad);
                pw.println("Código Postal: " + codPostal);
                pw.println("-----------------------");
            }

            JOptionPane.showMessageDialog(null, "Paciente registrado con éxito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el paciente");
        }
    }
}
