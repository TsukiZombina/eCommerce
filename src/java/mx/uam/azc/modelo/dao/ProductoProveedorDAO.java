
package mx.uam.azc.modelo.dao;

import java.util.List;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.ProductoProveedor;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface ProductoProveedorDAO {
    public void insertar(ProductoProveedor unProductoProveedor) throws EcommerceException;
    public void modificar(ProductoProveedor unProductoProveedor) throws EcommerceException;
    public List<ProductoProveedor> obtenerTodos() throws EcommerceException;
}
