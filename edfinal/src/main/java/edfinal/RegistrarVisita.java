package edfinal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class RegistrarVisita {

    public static void registrarVisita(String profesional,String dniVisitas,String fecha,String hora,double peso,String unidadPeso,double altura
    ,String unidadAltura) {
        try {
            try (FileWriter fw = new FileWriter("Visitas.txt", true); PrintWriter pw = new PrintWriter(fw)) {
                pw.println("Profesional: " + profesional);
                pw.println("DNI: " + dniVisitas);
                pw.println("Fecha: " + fecha);
                pw.println("Hora: " + hora);
                pw.println("Peso: " + peso + " " + unidadPeso);
                pw.println("Altura: " + altura + " " + unidadAltura);
                pw.println("-----------------------");
            }

            JOptionPane.showMessageDialog(null, "Visita registrada con éxito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la visita");
        }
    }
}
