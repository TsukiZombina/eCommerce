package mx.uam.azc.modelo.beans;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class ProductoProveedor {
    private Long idProductoProovedor = null;
    private int existencias;
    private double PrecioUnitario;
    private Long idProducto;
    private Long idProveedores;

    public ProductoProveedor() {
    }

    public Long getIdProductoProovedor() {
        return idProductoProovedor;
    }

    public void setIdProductoProovedor(Long idProductoProovedor) {
        this.idProductoProovedor = idProductoProovedor;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(Long idProveedores) {
        this.idProveedores = idProveedores;
    } 
}
