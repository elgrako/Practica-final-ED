package edfinal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListarPacientesPorFecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha (formato dd/mm/yyyy): ");
        String fecha = scanner.nextLine();

        try {
            ListarPacientesPorFecha listarPacientesPorFecha = new ListarPacientesPorFecha();
            listarPacientesPorFecha.listarPacientes(fecha);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de visitas.");
        }
    }

    public void listarPacientes(String fecha) throws IOException {
        String archivo = "Visitas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean pacientesEncontrados = false;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Fecha:")) {
                    String fechaVisita = linea.substring(7).trim();

                    // Leer las líneas siguientes para obtener los datos
                    String profesional = "";
                    String paciente = "";

                    String siguienteLinea;
                    while ((siguienteLinea = br.readLine()) != null) {
                        if (siguienteLinea.startsWith("Profesional:")) {
                            profesional = siguienteLinea.substring(13).trim();
                        } else if (siguienteLinea.startsWith("Nombre:")) {
                            paciente = siguienteLinea.substring(8).trim();
                            break;
                        }
                    }

                    if (fecha.equals(fechaVisita)) {
                        System.out.println("Fecha: " + fechaVisita);
                        System.out.println("Profesional: " + profesional);
                        System.out.println("Paciente: " + paciente);
                        System.out.println("-----------------------");
                        pacientesEncontrados = true;
                    }
                }
            }

            if (!pacientesEncontrados) {
                System.out.println("No se encontraron pacientes para la fecha " + fecha);
            }
        }
    }
}
