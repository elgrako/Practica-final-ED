package edfinal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class RegistrarProfesional {

    public static void registrarProfesional(int codigo, String dni, String nombre, String apellidos, 
            String localidad, int telefono, String especialidad) {
        try {
            try (FileWriter fw = new FileWriter("Profesionales.txt", true); PrintWriter pw = new PrintWriter(fw)) {
                pw.println("Código: " + codigo);
                pw.println("DNI: " + dni);
                pw.println("Nombre: " + nombre);
                pw.println("Apellidos: " + apellidos);
                pw.println("Localidad: " + localidad);
                pw.println("Teléfono: " + telefono);
                pw.println("Especialidad: " + especialidad);
                pw.println("-----------------------");
            }

            JOptionPane.showMessageDialog(null, "Profesional registrado con éxito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el profesional");
        }
    }
}
