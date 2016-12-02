package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public void insertar(Proveedor t) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    @Override
    public void modificar(Proveedor t) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proveedor> obtenerTodos() throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor obtener(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
