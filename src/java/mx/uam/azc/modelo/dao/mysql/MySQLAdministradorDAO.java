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
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLAdministradorDAO implements AdministradorDAO{
    
    @Override
    public void modificar(Administrador t) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrador obtener(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
