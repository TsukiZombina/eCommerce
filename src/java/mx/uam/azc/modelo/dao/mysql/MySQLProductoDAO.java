package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mx.uam.azc.modelo.beans.Producto;
import mx.uam.azc.modelo.dao.ProductoDAO;
import java.util.List;
import mx.uam.azc.modelo.EcommerceException;

/**
 *
 * @author Marce
 * @version
 */
public class MySQLProductoDAO implements ProductoDAO {

    private final String INSERT = "INSERT INTO tb_productos(clave, nombre, descripcion) VALUES (?, ?, ?)";

    @Override
    public void insertar(Producto unProducto) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, unProducto.getClave());
            ps.setString(2, unProducto.getNombre());
            ps.setString(3, unProducto.getDescripcion());

            if (ps.executeUpdate() == 0) {
                throw new EcommerceException("Puede ser que no se haya guardado");
            }

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                unProducto.setIdProducto(rs.getLong(1));
            } else {
                throw new EcommerceException("Puede ser que no se haya asignada un ID");
            }
            System.out.println("Inserción de producto exitosa");

        } catch (SQLException ex) {
            throw new EcommerceException("Error en SQL: " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(ps, rs, con);
        }
    }

    @Override
    public void modificar(Producto t) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> obtenerTodos() throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto obtener(Long id) throws EcommerceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
