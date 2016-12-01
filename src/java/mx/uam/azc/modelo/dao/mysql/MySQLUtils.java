package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.uam.azc.modelo.EcommerceException;

/**
 *
 * @author cubo
 */
public class MySQLUtils {

    public static void cerrar(PreparedStatement ps, ResultSet rs, Connection con) throws EcommerceException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new EcommerceException("Error al cerrar el recurso: " + ex.getMessage());
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new EcommerceException("Error al cerrar el recurso: " + ex.getMessage());
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new EcommerceException("Error al cerrar el recurso: " + ex.getMessage());

            }
        }
    }
    
    public static void cerrar(PreparedStatement ps, Connection con) throws EcommerceException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new EcommerceException("Error al cerrar el recurso: " + ex.getMessage());
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new EcommerceException("Error al cerrar el recurso: " + ex.getMessage());

            }
        }
    }
}
