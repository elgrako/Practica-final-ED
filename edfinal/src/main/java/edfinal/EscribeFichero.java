package edfinal;
import java.io.*;

public class EscribeFichero {
    public static void write(
            String path, String content) {
        String ruta = path;
        FileWriter fichero = null;
        PrintWriter pw = null;

        try (FileWriter FileWriter = new FileWriter(ruta, true)) {
            pw = new PrintWriter(FileWriter);
            /*for (int i = 0; i < 10; i++) {
                pw.println("Coche " + i);
            }*/

            pw.println(content);
            System.out.println("Nuevo registro añadido con exito [path: "+path+"]");
            System.out.println("> ["+content+"]");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();

            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}