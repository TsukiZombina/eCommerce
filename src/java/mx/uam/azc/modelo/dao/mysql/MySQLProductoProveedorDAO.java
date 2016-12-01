package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.ProductoProveedor;
import mx.uam.azc.modelo.dao.ProductoProveedorDAO;

/**
 *
 * @author Marce
 * @version
 */
public class MySQLProductoProveedorDAO implements ProductoProveedorDAO {

    @Override
    public void insertar(ProductoProveedor t) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    @Override
    public void modificar(ProductoProveedor t) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductoProveedor> obtenerTodos() throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoProveedor obtener(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
