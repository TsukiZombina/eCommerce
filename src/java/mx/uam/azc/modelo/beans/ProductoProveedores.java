/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.modelo.beans;

/**
 *
 * @author Marce
 */
public class ProductoProveedores {
    private Long idProductoProovedor = null;
    private int existencias;
    private int PrecioUnitario;
    private Long idProducto;
    private Long idProveedores;

    public ProductoProveedores() {
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

    public int getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int PrecioUnitario) {
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
