package com.uam.azc.modelo.dao;

import mx.uam.azc.modelo.dao.mysql.DataBaseManager;
import java.sql.Connection;
import org.junit.Test;

/**
 *
 * @author Marce
 */
public class DataBaseManagerTest {

    @Test
    public void testSomeMethod() {
        Connection con = DataBaseManager.INSTANCE.getConexion();
    }
    
}
