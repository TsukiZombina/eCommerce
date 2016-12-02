package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.uam.azc.modelo.beans.Producto;
import mx.uam.azc.modelo.dao.ProductoDAO;
import java.util.List;
import mx.uam.azc.modelo.EcommerceException;

/**
 *
 * @author Marce
 * @version
 */
public class MySQLProductoDAO implements ProductoDAO {

    private final String INSERT = "INSERT INTO tb_producto(clave, nombre, descripcion) VALUES (?, ?, ?)";
    private final String DELETE = "DELETE FROM tb_producto WHERE id_producto = ?";
    private final String UPDATE = "UPDATE tb_producto SET clave = ?, nombre = ?, descripcion = ? WHERE id_producto = ?";
    private final String GETONE = "SELECT * FROM tb_producto WHERE id_producto = ?";
    private final String GETALL = "SELECT * FROM tb_producto";

    @Override
    public void insertar(Producto unProducto) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }

        try {
            ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, unProducto.getClave());
            ps.setString(2, unProducto.getNombre());
            ps.setString(3, unProducto.getDescripcion());

            if (ps.executeUpdate() == 1) {
                throw new EcommerceException("Puede ser que no se haya guardado");
            }

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                unProducto.setIdProducto(rs.getLong(1));
            } else {
                throw new EcommerceException("Puede ser que no se haya asignada un ID");
            }
            System.out.println("Inserción de producto exitosa");

        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL: " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
    }

    @Override
    public void modificar(Producto producto) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, "clave");
            ps.setString(2, "nombre");
            ps.setString(3, "descripcion");
            ps.setLong(4, producto.getIdProducto());
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo modificar el producto " + producto.getIdProducto());
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

        try {
            ps = con.prepareStatement(DELETE);
            ps.setLong(1, id);
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo eliminiar el producto" + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, con);
        }
    }

    public Producto convertir(ResultSet rs) throws SQLException {
        Long id_producto = rs.getLong("id_producto");
        String clave = rs.getString("clave");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");

        Producto producto = new Producto();
        producto.setIdProducto(id_producto);
        producto.setClave(clave);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);

        return producto;
    }

    @Override
    public List<Producto> obtenerTodos() throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();

        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return productos;
    }

    @Override
    public Producto obtener(Long id) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto producto = null;

        try {
            ps = con.prepareStatement(GETONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = convertir(rs);
            } else {
                throw new EcommerceException("No se encontró el producto con id " + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return producto;
    }
}
