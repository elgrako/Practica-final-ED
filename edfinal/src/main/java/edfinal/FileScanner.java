package edfinal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileScanner {
    public static void main(String[] args) {
        String ruta = "Pacientes.txt";
        File f = new File(ruta);
        System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
        Scanner s;
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                Scanner sl = new Scanner(linea);
                sl.useDelimiter(",");
                System.out.println(sl.next());
                System.out.println(sl.next());
                System.out.println(sl.next());
                System.out.println(sl.next());
                System.out.println(sl.next());
                System.out.println(sl.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean search(String path, String dni){
        File f = new File(path);
        Scanner s;
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                Scanner sl = new Scanner(linea);
                sl.useDelimiter(",");
                String dni_file = sl.next();
                //System.out.println(dni_file);
                if (dni_file.equals(dni)) {
                    return true;
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
