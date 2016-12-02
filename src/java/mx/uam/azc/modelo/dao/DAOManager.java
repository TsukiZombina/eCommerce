package mx.uam.azc.modelo.dao;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface DAOManager {
    AdministradorDAO getAdministradorDAO();
    
    DetalleOrden getDetalleOrden();
    
    Orden getOrden();
    
    ProductoDAO getProductoDAO();
    
    ProductoProveedorDAO getProductoProveedor();
    
    ProveedorDAO getProveedorDAO();
    
    UsuarioDAO getUsuarioDAO();
    
}
