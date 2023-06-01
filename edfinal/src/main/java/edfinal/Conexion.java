package edfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String NOMBRE_BD = "EDBD";
    private static final String UBICACION = "127.0.0.1";
    private static final String PUERTO = "3306";
    private static final String USUARIO = "newuser1";
    private static final String CLAVE = "1234ABC.";

    // Para versión mysql-conector-java-5.1.6.jar + mysql Server 5.7
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + NOMBRE_BD
            + "?useUnicode=true&characterEncoding=utf-8";

    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
        }
    }

    public Connection conectar() {
        Connection conexion = null;

        try {
            // Establecemos la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

            System.out.println("Conexión correctamente establecida con la base de datos " + NOMBRE_BD);

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
        }

        return conexion;
    }

    // SEGUNDA ACTUALIZACION

    public static void conectar1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String userName = "root";
            String password = "root";

            String url = "jdbc:mysql://localhost:3306/bd_ejemplo?useUnicode=true&characterEncoding=utf-8";

            DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión establecida con BD correctamente");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
        }
    }

    public static void main(String[] args) {
        conectar1();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String userName = "user1";
            String password = "1234ABC.";

            String url = "jdbc:mysql://localhost:3306/bd_ejemplo?useUnicode=true&characterEncoding=utf-8";

            DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión establecida con BD correctamente");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
        }
    }
}
