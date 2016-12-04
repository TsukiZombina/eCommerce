package mx.uam.azc.modelo.dao;

import java.util.ArrayList;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.DetalleOrden;
import mx.uam.azc.modelo.beans.Orden;

/**
 *
 * @author Ernesto García Maldonado
 */
public interface CarritoDAO {
   void ordenar(Orden orden, ArrayList<DetalleOrden> detalles, Long idUsuario, Long idProductoProveedor) throws EcommerceException;
}
