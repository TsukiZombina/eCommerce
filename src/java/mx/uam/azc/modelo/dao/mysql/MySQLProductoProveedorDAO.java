package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    private final String GETALL = "SELECT * FROM tb_productoProveedor";
    private final String GET_PRODUCTOPROVEEDOR_BYIDPRODUCTO = "SELECT * FROM tb_productoProveedor WHERE id_producto=?";
    
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
    
    public ProductoProveedor convertir(ResultSet rs) throws SQLException{
        Long id_productoProveedor = rs.getLong("id_productoProveedor");
        Long id_producto = rs.getLong("id_producto");
        Long id_proveedor = rs.getLong("id_proveedor");
        int existencia = rs.getInt("existencia");
        double precioUnitario = rs.getDouble("precioUnitario");
        
        ProductoProveedor unProductoProveedor = new ProductoProveedor();
        unProductoProveedor.setIdProductoProveedor(id_productoProveedor);
        unProductoProveedor.setIdProducto(id_producto);
        unProductoProveedor.setIdProveedor(id_proveedor);
        unProductoProveedor.setExistencia(existencia);
        unProductoProveedor.setPrecioUnitario(precioUnitario);
        
        return unProductoProveedor;
    }

    @Override
    public List<ProductoProveedor> obtenerTodos() throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProductoProveedor> productoProveedores = new ArrayList<>();
        
        if (con==null)
            throw new EcommerceException("No hay conexión a la BD");
        
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            
            while (rs.next()){
                productoProveedores.add(convertir(rs));
            }
            
        }catch(SQLException ex){
            throw new EcommerceException("Error SQL: "+ex.getMessage());
        }finally{
            MySQLUtils.cerrar(ps, rs, con);
        }
        
        return productoProveedores;
    }

    @Override
    public ProductoProveedor obtenerPorIdProducto(Long id) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductoProveedor productoProveedor = null;
        
        if (con == null) {
            throw new EcommerceException("No  hay conexión a la BD");
        }
        
        try {
            ps = con.prepareStatement(GET_PRODUCTOPROVEEDOR_BYIDPRODUCTO);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                productoProveedor = convertir(rs);
            } else {
                throw new EcommerceException("No se encontró el producto con id " + id);
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error SQL : " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
        return productoProveedor;
    }
    
}
