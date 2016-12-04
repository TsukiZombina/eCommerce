package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Administrador;
import mx.uam.azc.modelo.dao.AdministradorDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLAdministradorDAO implements AdministradorDAO{
    private final String UPDATE = "UPDATE tb_producto SET clave = ?, nombre = ?, descripcion = ? WHERE id_producto = ?";
    private final String GETONE = "SELECT * FROM tb_producto WHERE id_producto = ?";
    
    @Override
    public void modificar(Administrador unAdministrador) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setLong(1, unAdministrador.getIdAdministrador());
            ps.setString(2, unAdministrador.getNombre());
            ps.setString(3, unAdministrador.getApellidoP());
            ps.setString(4, unAdministrador.getApellidoM());
            ps.setString(5, unAdministrador.getUsername());
            
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo modificar el unAdministrador " + unAdministrador.getIdAdministrador());
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, con);
        }
    }

    @Override
    public Administrador obtener(Long id) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Administrador administrador = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(GETONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                administrador = convertir(rs);
            } else {
                throw new EcommerceException("No se encontró el administrador con id " + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return administrador;
    }

    private Administrador convertir(ResultSet rs) throws SQLException {
        Long id_administrador = rs.getLong("id_administrador");
        String nombre = rs.getString("nombre");
        String apellidoP = rs.getString("apellidoP");
        String apellidoM = rs.getString("apellidoM");
        String username = rs.getString("username");
        String sal = rs.getString("sal");

        Administrador administrador = new Administrador();
        administrador.setIdAdministrador(id_administrador);
        administrador.setNombre(nombre);
        administrador.setApellidoP(apellidoP);
        administrador.setApellidoM(apellidoM);
        administrador.setUsername(username);
        administrador.setSal(sal);

        return administrador;
    }
}
