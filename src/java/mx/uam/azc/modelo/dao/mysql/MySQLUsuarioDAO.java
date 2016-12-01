package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Usuario;
import mx.uam.azc.modelo.dao.UsuarioDAO;

/**
 *
 * @author Marce
 */
public class MySQLUsuarioDAO implements UsuarioDAO{

    @Override
    public void insertar(Usuario t) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    @Override
    public void modificar(Usuario t) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> obtenerTodos() throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtener(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
