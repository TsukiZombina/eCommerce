/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.modelo.dao;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface DAOManager {
    AdministradorDAO getAdministradorDAO();
    ProductoDAO getProductpDAO();
    ProductoProveedorDAO getProductoProveedor();
    ProveedorDAO getProveedorDAO();
    UsuarioDAO getUsuarioDAO();
}
