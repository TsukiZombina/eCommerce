/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.modelo.dao.mysql;

import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Producto;
import mx.uam.azc.modelo.dao.DAOManager;
import org.junit.Test;

/**
 *
 * @author Marce
 */
public class MySQLProductoDAOTest {
    
    @Test
    public void testSomeMethod() {
        DAOManager manager = new MySQLDAOManager();
        Producto unProducto = new Producto();
        unProducto.setClave("ABCDE");
        unProducto.setNombre("unProducto");
        unProducto.setDescripcion("unaDescripción");
        
        try {
            manager.getProductpDAO().insertar(unProducto);
        } catch (EcommerceException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(unProducto.getIdProducto());
        
    }
    
}
