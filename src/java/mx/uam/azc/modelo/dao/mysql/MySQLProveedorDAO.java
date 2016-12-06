package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.uam.azc.modelo.beans.Proveedor;
import java.util.List;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.dao.ProveedorDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLProveedorDAO implements ProveedorDAO{
    private final String INSERT = "INSERT INTO tb_proveedor(clave, nombre, apellidoP, apellidoM, contactoTel, contactoCorreo, contactoDireccion, encargado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE = "DELETE FROM tb_proveedor WHERE id_proveedor = ?";
    private final String UPDATE = "UPDATE tb_proveedor SET clave = ?, nombre = ?, apellidoP = ?, apellidoM = ?, contactoTel = ?, contactoCorreo = ?, contactoDireccion = ?, encargado = ? WHERE id_proveedor = ?";
    private final String GETONE = "SELECT * FROM tb_proveedor WHERE id_proveedor = ?";
    private final String GETALL = "SELECT * FROM tb_proveedor";

    @Override
    public void insertar(Proveedor unProveedor) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }

        try {
            ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, unProveedor.getClave());
            ps.setString(2, unProveedor.getNombre());
            ps.setString(3, unProveedor.getApellidoP());
            ps.setString(4, unProveedor.getApellidoM());
            ps.setString(5, unProveedor.getContactoTel());
            ps.setString(6, unProveedor.getContactoCorreo());
            ps.setString(7, unProveedor.getContactoDireccion());
            ps.setString(8, unProveedor.getEncargado());

            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("Puede ser que no se haya guardado");
            }

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                unProveedor.setIdProveedor(rs.getLong(1));
            } else {
                throw new EcommerceException("Puede ser que no se haya asignada un ID");
            }
            System.out.println("Inserción de proveedor exitosa");

        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL: " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
    }

    @Override
    public void modificar(Proveedor proveedor) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setLong(1, proveedor.getIdProveedor());
            ps.setString(2, proveedor.getClave());
            ps.setString(3, proveedor.getNombre());
            ps.setString(4, proveedor.getApellidoP());
            ps.setString(5, proveedor.getApellidoM());
            ps.setString(6, proveedor.getContactoTel());
            ps.setString(7, proveedor.getContactoCorreo());
            ps.setString(8, proveedor.getContactoDireccion());
            ps.setString(9, proveedor.getEncargado());
            
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo modificar el proveedor " + proveedor.getIdProveedor());
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
                throw new EcommerceException("No se pudo eliminiar el proveedor" + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, con);
        }
    }

    public Proveedor convertir(ResultSet rs) throws SQLException {
        Long id_proveedor = rs.getLong("id_proveedor");
        String clave = rs.getString("clave");
        String nombre = rs.getString("nombre");
        String apellidoP = rs.getString("apellidoP");
        String apellidoM = rs.getString("apellidoM");
        String contactoTel = rs.getString("contactoTel");
        String contactoCorreo = rs.getString("contactoCorreo");
        String contactoDireccion = rs.getString("contactoDireccion");
        String encargado = rs.getString("encargado");

        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(id_proveedor);
        proveedor.setClave(clave);
        proveedor.setNombre(nombre);
        proveedor.setApellidoP(apellidoP);
        proveedor.setApellidoM(apellidoM);
        proveedor.setContactoTel(contactoTel);
        proveedor.setContactoCorreo(contactoCorreo);
        proveedor.setContactoDireccion(contactoDireccion);
        proveedor.setEncargado(encargado);

        return proveedor;
    }

    @Override
    public List<Proveedor> obtenerTodos() throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Proveedor> proveedors = new ArrayList<>();
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedors.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return proveedors;
    }

    @Override
    public Proveedor obtener(Long id) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Proveedor proveedor = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(GETONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                proveedor = convertir(rs);
            } else {
                throw new EcommerceException("No se encontró el proveedor con id " + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return proveedor;
    }  
}
