package com.uam.azc.modelo.dao;

import java.sql.Connection;
import mx.uam.azc.modelo.dao.mysql.DataBaseManager;
import org.junit.Test;

/**
 *
 * @author Marce
 */
public class DataBaseManagerTest {

    @Test
    public void testSomeMethod() {
        Connection con = DataBaseManager.getConexion();
    }
    
}
