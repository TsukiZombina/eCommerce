package mx.uam.azc.modelo.beans;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class ProductoProveedor {
    private Long idProductoProveedor = null;
    private int existencia;
    private double precioUnitario;
    private Long idProducto;
    private Long idProveedor;

    public ProductoProveedor() {
    }

    public Long getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(Long idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    } 
}
