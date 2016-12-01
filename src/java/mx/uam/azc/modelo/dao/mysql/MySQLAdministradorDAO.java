package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Administrador;
import mx.uam.azc.modelo.dao.AdministradorDAO;

/**
 *
 * @author Marce
 */
public class MySQLAdministradorDAO implements AdministradorDAO{

    @Override
    public void insertar(Administrador t) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    @Override
    public void modificar(Administrador t) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Administrador> obtenerTodos() throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrador obtener(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
