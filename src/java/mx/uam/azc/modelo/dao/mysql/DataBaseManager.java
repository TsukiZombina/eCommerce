package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class DataBaseManager {
    private final static DataBaseManager INSTANCE = new DataBaseManager();
    
    private final String host = "localhost";
    private final String basededatos = "ecommercedb";
    private final String usuario ="root";
    private final String password ="behappy";
    private final String url="jdbc:mysql://"+host+":3306/"+basededatos;    
    
    private DataBaseManager() {
    }
    
    private Connection crearConexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a la base de datos" + url + "...ok");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver: "+ex.getMessage());
        }
        
        return con;
    }
    
    public static Connection getConexion(){
        return INSTANCE.crearConexion();
    }
}
