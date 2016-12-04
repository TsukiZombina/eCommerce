package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.ProductoProveedor;
import mx.uam.azc.modelo.dao.ProductoProveedorDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLProductoProveedorDAO implements ProductoProveedorDAO {
    private final String INSERT = "INSERT INTO tb_productoproveedor(id_producto, id_proveedor, existencia, precioUnitario) VALUES (?, ?, ?, ?)";
    private final String UPDATE = "UPDATE tb_productoproveedor SET id_producto = ?, id_proveedor = ?, existencia = ?, precioUnitario = ? WHERE id_productoproveedor = ?";
    
    @Override
    public void insertar(ProductoProveedor unProductoProveedor) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }

        try {
            ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, unProductoProveedor.getIdProducto());
            ps.setLong(2, unProductoProveedor.getIdProveedor());
            ps.setInt(3, unProductoProveedor.getExistencia());
            ps.setDouble(4, unProductoProveedor.getPrecioUnitario());

            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("Puede ser que no se haya guardado");
            }

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                unProductoProveedor.setIdProducto(rs.getLong(1));
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
    public void modificar(ProductoProveedor unProductoProveedor) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setLong(1, unProductoProveedor.getIdProducto());
            ps.setLong(2, unProductoProveedor.getIdProveedor());
            ps.setInt(3, unProductoProveedor.getExistencia());
            ps.setDouble(4, unProductoProveedor.getPrecioUnitario());

            
            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("No se pudo modificar el proveedor " + unProductoProveedor.getIdProveedor());
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, con);
        }
    }
}
