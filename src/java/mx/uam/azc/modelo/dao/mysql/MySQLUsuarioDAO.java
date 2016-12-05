package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Usuario;
import mx.uam.azc.modelo.dao.UsuarioDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLUsuarioDAO implements UsuarioDAO{
    private final String INSERT = "INSERT INTO tb_usuario(nombre, apellidoP, apellidoM, username, password, sal, contactoTel, contactoCorreo, saldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )";
    private final String DELETE = "DELETE FROM tb_usuario WHERE id_usuario = ?";
    private final String UPDATE = "UPDATE tb_usuario SET clave = ?, nombre = ?, descripcion = ? WHERE id_usuario = ?";
    private final String GETONE = "SELECT * FROM tb_usuario WHERE id_usuario = ?";
    private final String CHECK_PASSWORD = "SELECT verificarContrasenia(?, ?);";

    @Override
    public void insertar(Usuario unUsuario) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }

        try {
            ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, unUsuario.getNombre());
            ps.setString(2, unUsuario.getApellidoP());
            ps.setString(3, unUsuario.getApellidoM());
            ps.setString(4, unUsuario.getUsername());
            ps.setString(5, unUsuario.getPassword());
            ps.setString(8, unUsuario.getSal());
            ps.setString(6, unUsuario.getContactoTel());
            ps.setString(7, unUsuario.getContactoCorreo());
            ps.setDouble(9, unUsuario.getSaldo());

            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("Puede ser que no se haya guardado");
            }

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                unUsuario.setIdUsuario(rs.getLong(1));
            } else {
                throw new EcommerceException("Puede ser que no se haya asignada un ID");
            }
            System.out.println("Inserción de usuario exitosa");

        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL: " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
    }

    @Override
    public void modificar(Usuario unUsuario) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, unUsuario.getNombre());
            ps.setString(2, unUsuario.getApellidoP());
            ps.setString(3, unUsuario.getApellidoM());
            ps.setString(4, unUsuario.getUsername());
            ps.setString(5, unUsuario.getPassword());
            ps.setString(6, unUsuario.getContactoTel());
            ps.setString(7, unUsuario.getContactoCorreo());
            
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo modificar el usuario " + unUsuario.getIdUsuario());
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, con);
        }
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(DELETE);
            ps.setLong(1, id);
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo eliminiar el usuario" + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, con);
        }
    }

    public Usuario convertir(ResultSet rs) throws SQLException {
        Long id_usuario = rs.getLong("id_usuario");
        String nombre = rs.getString("nombre");
        String apellidoP = rs.getString("apellidoP");
        String apellidoM = rs.getString("apellidoM");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String sal = rs.getString("sal");
        String contactoTel = rs.getString("contactoTel");
        String contactoCorreo = rs.getString("contactoCorreo");
        double saldo = rs.getDouble("saldo");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id_usuario);
        usuario.setNombre(nombre);
        usuario.setApellidoP(apellidoP);
        usuario.setApellidoM(apellidoM);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setSal(sal);
        usuario.setContactoTel(contactoTel);
        usuario.setContactoCorreo(contactoCorreo);
        usuario.setSaldo(saldo);

        return usuario;
    }

    @Override
    public Usuario obtener(Long id) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(GETONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = convertir(rs);
            } else {
                throw new EcommerceException("No se encontró el usuario con id " + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return usuario;
    }
    
    public double generarSaldo(){
        double saldo = 0;
        ThreadLocalRandom.current().nextInt(0, 1000 + 1);
        return saldo;
    }
    
    public boolean validarUsuario(Long id, String password) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario unUsuario = null;
        boolean verifica = false;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            unUsuario = obtener(id);
            
            if (unUsuario == null)
                throw new EcommerceException("No se pudo ibtener la persona con id: " + id);
            
            ps = con.prepareStatement(CHECK_PASSWORD);
            ps.setLong(1, unUsuario.getIdUsuario());
            ps.setString(2, unUsuario.getSal() + password);
            
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
