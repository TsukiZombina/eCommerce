package mx.uam.azc.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.DetalleOrden;
import mx.uam.azc.modelo.beans.Orden;
import mx.uam.azc.modelo.dao.CarritoDAO;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class MySQLCarritoDAO implements CarritoDAO {

    private final String ORDEN = "INSERT INTO tb_orden(id_usuario, fecha, hora, total) VALUES(?, ?, ?, ?)";
    private final String ORDEN_DETALLE = "INSERT INTO tb_detalleOrden(id_orden, id_productoProveedor, cantidad, totalProducto) VALUES(?, ?, ?, ?)";
    private final String ACTUALIZAR_EXISTENCIA = "UPDATE tb_productoProveedor SET existencia=existencia- ?  where id_productoProveedor = ?";
    
    @Override
    public void ordenar(Orden unaOrden, ArrayList<DetalleOrden> detalles, Long idUsuario, Long idProductoProveedor) throws EcommerceException {
        Connection con = DataBaseManager.getConexion();
        PreparedStatement psOrden = null, psDetalleOrden = null, psExistencia = null;
        ResultSet rsOrden = null, rsDetalleOrden;

        if (con == null) {
            throw new EcommerceException("No hay conexión a la BD");
        }

        try {
            psOrden = con.prepareStatement(ORDEN, Statement.RETURN_GENERATED_KEYS);
            psOrden.setLong(1, idUsuario);
            psOrden.setDate(2, (Date) unaOrden.getFecha());
            psOrden.setDate(3, (Date) unaOrden.getHora());
            psOrden.setDouble(4, unaOrden.getTotal());

            if (psOrden.executeUpdate() == 0) {
                throw new EcommerceException("Puede ser que no se haya guardado");
            }

            rsOrden = psOrden.getGeneratedKeys();

            if (rsOrden.next()) {
                unaOrden.setIdOrden(rsOrden.getLong(1));
            } else {
                throw new EcommerceException("Puede ser que no se haya asignada un ID");
            }

            for (DetalleOrden d : detalles) {
                psDetalleOrden = con.prepareStatement(ORDEN_DETALLE, Statement.RETURN_GENERATED_KEYS);
                psDetalleOrden.setLong(1, unaOrden.getIdOrden());
                psDetalleOrden.setLong(2, idProductoProveedor);
                psDetalleOrden.setInt(3, d.getCantidad());
                psDetalleOrden.setDouble(4, d.getTotalProducto());

                if (psDetalleOrden.executeUpdate() == 0) {
                    throw new EcommerceException("Puede ser que no se haya guardado");
                }

                rsDetalleOrden = psDetalleOrden.getGeneratedKeys();                

                if (rsDetalleOrden.next()) {
                    d.setIdDetalleOrden(rsDetalleOrden.getLong(1));
                } else {
                    throw new EcommerceException("Puede ser que no se haya asignada un ID");
                }
                
                psExistencia = con.prepareStatement(ACTUALIZAR_EXISTENCIA);
                psExistencia.setInt(1, d.getCantidad());
                psExistencia.setLong(2, idProductoProveedor);                
                
                if (psExistencia.executeUpdate() == 0)
                    throw new EcommerceException("Puede ser que no se haya modificado");
                
            }
        } catch (SQLException ex) {
            throw new EcommerceException("Error de SQL: " + ex.getMessage());
        } finally {
            MySQLUtils.cerrar(psOrden, rsOrden, con);
        }
    }

}
