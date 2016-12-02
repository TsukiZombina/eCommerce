package mx.uam.azc.modelo.beans;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class DetalleOrden {
    private Long idDetalleOrden = null;
    private int cantidad;
    private double totalProducto;
    private Long idOrden;
    private Long idProductoProveedor;

    public DetalleOrden() {
    }

    public Long getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(Long idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(double totalProducto) {
        this.totalProducto = totalProducto;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Long getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(Long idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }   
}
