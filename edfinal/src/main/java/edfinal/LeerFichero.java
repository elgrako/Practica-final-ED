package edfinal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    public static String muestraContenido(String archivo) 
    throws FileNotFoundException, IOException {
        String cadena, content="";
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while ((cadena = b.readLine()) != null) {
                //System.out.println(cadena);
                content+=cadena+"\n";
            }
        }
        //System.out.println(content);
        return content;
    }

    public static void main(String[] args) throws IOException {
        String ruta = "Pacientes.txt";
        muestraContenido(ruta);
    }
}
