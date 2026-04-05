/**
 * Fecha: 4 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
package sistemabancario;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.sun.jdi.connect.spi.Connection;

public class Conexion {
  

  
    public static Connection getConexion() {
     
          // Datos de tu base de datos
   Connection con = null;
    String BASE = "sistema_bancario"; 
     String URL = "jdbc:mysql://localhost:3306/"+BASE;
   String USER = "root";
     String PASSWORD = ""; 
        try {
            // Cargar el driver (opcional en versiones nuevas, pero seguro)
           // Class.forName("com.mysql.cj.jdbc.Driver");//Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion con exito a "+URL);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }
}