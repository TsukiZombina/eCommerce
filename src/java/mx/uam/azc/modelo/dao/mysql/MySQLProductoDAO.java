package mx.uam.azc.modelo.dao.mysql;

import mx.uam.azc.modelo.beans.Producto;
import mx.uam.azc.modelo.dao.ProductoDAO;
import java.util.List;

/**
 *
 * @author Marce
 * @version
 */
public class MySQLProductoDAO implements ProductoDAO{

    @Override
    public void insertar(Producto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Producto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
