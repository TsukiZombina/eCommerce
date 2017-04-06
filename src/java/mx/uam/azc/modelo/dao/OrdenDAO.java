package mx.uam.azc.modelo.dao;

import java.util.List;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Orden;
import mx.uam.azc.modelo.dao.mysql.MySQLOrdenDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class OrdenDAO implements DAO<Orden, Long>{
    MySQLOrdenDAO orden;

    @Override
    public void insertar(Orden t) throws EcommerceException {
        orden.insertarMySQLOrdenDAO(t);
    }

    @Override
    public void modificar(Orden t) throws EcommerceException {
        orden.insertarMySQLOrdenDAO(t);
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        orden.eliminarMySQLOrdenDAO(id);
    }

    @Override
    public List<Orden> obtenerTodos() throws EcommerceException {
        return orden.obtenerTodosMySQLOrdenDAO();
    }

    @Override
    public Orden obtener(Long id) throws EcommerceException {
        return orden.obtenerMySQLOrdenDAO(id);
    }
}
