/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.modelo.dao.mysql;

import mx.uam.azc.modelo.dao.AdministradorDAO;
import mx.uam.azc.modelo.dao.DAOManager;
import mx.uam.azc.modelo.dao.ProductoDAO;
import mx.uam.azc.modelo.dao.ProductoProveedorDAO;
import mx.uam.azc.modelo.dao.ProveedorDAO;
import mx.uam.azc.modelo.dao.UsuarioDAO;

/**
 *
 * @author Marce
 */
public class MySQLDAOManager implements DAOManager{
    private AdministradorDAO administrador = null;
    private ProductoDAO producto = null;
    
    @Override
    public AdministradorDAO getAdministradorDAO() {
        if(administrador == null){
            administrador = new MySQLAdministradorDAO();
        }
        return administrador;
    }

    @Override
    public ProductoDAO getProductpDAO() {
        if(producto == null){
            producto = new MySQLProductoDAO();
        }
        return producto;
    }

    @Override
    public ProductoProveedorDAO getProductoProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
