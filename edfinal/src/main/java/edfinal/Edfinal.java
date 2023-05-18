package edfinal;

import java.io.IOException;
import java.util.Scanner;

public class Edfinal {

    public static void main(String[] args) throws IOException {

        String path = "Pacientes.txt", dni, nombre, P_Nombre, apellidos, especialidad, calle, localidad, P_Localidad, opt;
        String fecha, hora, unidad_peso, unidad_altura;
        int edad, cod_postal, peso, telefono, codigo, altura;

        Scanner entradaEscaner = new Scanner(System.in);

        System.out.println("Seccion de registro");

        System.out.printf("¿Desea introducir sus datos?[y|n]: ");
        opt = entradaEscaner.nextLine();

        if (opt.equalsIgnoreCase("N")) {
            System.out.println("Omitiendo registro.");
        } else {
            System.out.println("Introduzca los datos");

            System.out.printf("DNI[*]: ");
            dni = entradaEscaner.nextLine();

            System.out.printf("Nombre[*]: ");
            nombre = entradaEscaner.nextLine();

            System.out.printf("Edad[*]: ");
            edad = entradaEscaner.nextInt();
            entradaEscaner.nextLine(); // Consumir el salto de línea pendiente

            System.out.printf("Calle[*]: ");
            calle = entradaEscaner.nextLine();

            System.out.printf("Localidad[*]: ");
            localidad = entradaEscaner.nextLine();

            System.out.printf("Cod postal[*]: ");
            cod_postal = entradaEscaner.nextInt();
            entradaEscaner.nextLine(); // Consumir el salto de línea pendiente

            FileScanner filescanner = new FileScanner();
            EscribeFichero EscribeFichero = new EscribeFichero();

            if (!filescanner.search(path, dni)) {

                EscribeFichero.write(path,
                        dni + "," + nombre + "," + edad + "," + calle + "," + localidad + "," + cod_postal);

            }
        }

        /*
            Visitas
         */
        path = "Visitas.txt";
        System.out.println("----------------------");

        System.out.println("Seccion de visitas");

        System.out.printf("Desea pedir una cita[y|n]: ");
        opt = entradaEscaner.nextLine();

        if (opt.equalsIgnoreCase("N")) {
            System.out.println("Omitiendo cita previa");
        } else {

            System.out.println("Acontinuacion intrduzca los datos para la cita");

            System.out.printf("DNI[*]: ");
            dni = entradaEscaner.nextLine();

            System.out.printf("Fecha[*]: ");
            fecha = entradaEscaner.nextLine();

            System.out.printf("Hora[*]: ");
            hora = entradaEscaner.nextLine();

            System.out.printf("Peso[*]: ");
            peso = entradaEscaner.nextInt();
            entradaEscaner.nextLine();

            System.out.printf("Unidad peso[*]: ");
            unidad_peso = entradaEscaner.nextLine();

            System.out.printf("Altura[*]: ");
            altura = entradaEscaner.nextInt();
            entradaEscaner.nextLine();

            System.out.printf("Unidad altura[*]: ");
            unidad_altura = entradaEscaner.nextLine();

            System.out.println("Su IMC es: [" + peso % (altura * altura) + "]");

             EscribeFichero EscribeFichero = new EscribeFichero();
            EscribeFichero.write(path,
                    dni + "," + fecha + "," + hora + "," + peso + "," + unidad_peso + "," + altura + "," + unidad_altura
            );
        }

        //Medicos
        path = "Profesionales.txt";
        System.out.println("----------------------");

        System.out.println("Seccion de Profesionales");

        System.out.printf("Desea registrar un profesional[y|n]: ");
        opt = entradaEscaner.nextLine();

        if (opt.equalsIgnoreCase("N")) {
            System.out.println("Gracias por su visita");
        } else {

            System.out.println("Acontinuacion intrduzca sus datos");

            System.out.printf("Codigo[*]: ");
            codigo = entradaEscaner.nextInt();

            System.out.printf("DNI[*]: ");
            dni = entradaEscaner.nextLine();
            entradaEscaner.nextLine();

            System.out.printf("Nombre[*]: ");
            P_Nombre = entradaEscaner.nextLine();

            System.out.printf("Apellidos[*]: ");
            apellidos = entradaEscaner.nextLine();

            System.out.printf("Localidad[*]: ");
            P_Localidad = entradaEscaner.nextLine();

            System.out.printf("Telefono[*]: ");
            telefono = entradaEscaner.nextInt();

            System.out.printf("Especialidad[*]: ");
            especialidad = entradaEscaner.nextLine();
            entradaEscaner.nextLine();

            EscribeFichero EscribeFichero = new EscribeFichero();
            EscribeFichero.write(path,
                    codigo + "," + P_Nombre + "," + apellidos + "," + dni + "," + P_Localidad + "," + telefono + "," + especialidad);
            System.out.printf("Gracias por su visita");
        }
    }
}
