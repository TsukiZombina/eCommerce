package mx.uam.azc.modelo.dao.mysql;

import mx.uam.azc.modelo.dao.AdministradorDAO;
import mx.uam.azc.modelo.dao.CarritoDAO;
import mx.uam.azc.modelo.dao.DAOManager;
import mx.uam.azc.modelo.dao.ProductoDAO;
import mx.uam.azc.modelo.dao.ProductoProveedorDAO;
import mx.uam.azc.modelo.dao.ProveedorDAO;
import mx.uam.azc.modelo.dao.UsuarioDAO;
import mx.uam.azc.modelo.dao.OrdenDAO;
import mx.uam.azc.modelo.dao.DetalleOrdenDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLDAOManager implements DAOManager {

    private AdministradorDAO administrador = null;
    private CarritoDAO carrito = null;
    private DetalleOrdenDAO detalleOrden = null;
    private MySQLOrdenDAO orden = null;
    private ProductoDAO producto = null;
    private ProductoProveedorDAO productoProveedor = null;
    private ProveedorDAO proveedor = null;
    private UsuarioDAO usuario = null;

    @Override
    public AdministradorDAO getAdministradorDAO() {
        if (administrador == null) {
            administrador = new MySQLAdministradorDAO();
        }
        return administrador;
    }

    @Override
    public CarritoDAO getCarritoDAO() {
        if (carrito == null) {
            carrito = new MySQLCarritoDAO();
        }

        return carrito;
    }

    @Override
    public DetalleOrdenDAO getDetalleOrdenDAO() {
        if (detalleOrden == null) {
            detalleOrden = new MySQLDetalleOrdenDAO();
        }

        return detalleOrden;
    }

    @Override
    public MySQLOrdenDAO getOrdenDAO() {
        if (orden == null) {
            orden = new MySQLOrdenDAO();
        }

        return orden;
    }

    @Override
    public ProductoDAO getProductoDAO() {
        if (producto == null) {
            producto = new MySQLProductoDAO();
        }
        return producto;
    }

    @Override
    public ProductoProveedorDAO getProductoProveedorDAO() {
        if (productoProveedor == null) {
            productoProveedor = new MySQLProductoProveedorDAO();
        }
        return productoProveedor;
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        if (proveedor == null) {
            proveedor = new MySQLProveedorDAO();
        }
        return proveedor;
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
         if(usuario == null){
            usuario = new MySQLUsuarioDAO();
        }
        return usuario;
    }
}
