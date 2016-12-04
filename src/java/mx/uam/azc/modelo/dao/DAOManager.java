package mx.uam.azc.modelo.dao;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface DAOManager {
    AdministradorDAO getAdministradorDAO();
    
    CarritoDAO getCarritoDAO();
    
    DetalleOrdenDAO getDetalleOrdenDAO();
    
    OrdenDAO getOrdenDAO();
    
    ProductoDAO getProductoDAO();
    
    ProductoProveedorDAO getProductoProveedorDAO();
    
    ProveedorDAO getProveedorDAO();
    
    UsuarioDAO getUsuarioDAO();
    
}
