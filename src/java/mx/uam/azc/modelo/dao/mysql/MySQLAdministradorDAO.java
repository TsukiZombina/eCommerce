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
    private final String UPDATE = "UPDATE tb_administrador SET nombre = ?, apellidoP = ?, apellidoM = ?, username=? WHERE id_administrador = ?";
    private final String GETONE = "SELECT * FROM tb_administrador WHERE id_administrador = ?";
    private final String CHECK_PASSWORD = "SELECT verificarContrasenia(?, ?);";
    
    @Override
    public void modificar(Administrador unAdministrador) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, unAdministrador.getNombre());
            ps.setString(2, unAdministrador.getApellidoP());
            ps.setString(3, unAdministrador.getApellidoM());
            ps.setString(4, unAdministrador.getUsername());
            ps.setLong(5, unAdministrador.getIdAdministrador());
            
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo modificar el administrador " + unAdministrador.getIdAdministrador());
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
    
    @Override
    public boolean validarAdministrador(Long id, String password) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Administrador unAdministrador = null;
        boolean verifica = false;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            unAdministrador = obtener(id);
            
            if (unAdministrador == null)
                throw new EcommerceException("No se pudo ibtener la persona con id: " + id);
            
            ps = con.prepareStatement(CHECK_PASSWORD);
            ps.setLong(1, unAdministrador.getIdAdministrador());
            ps.setString(2, unAdministrador.getSal() + password);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                verifica = rs.getBoolean(1);
            } else
                throw new EcommerceException("No se pudo validar la contraseña");
            
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally{
            MySQLUtils.cerrar(ps, rs, con);
        }  
        return verifica;
    }
}
