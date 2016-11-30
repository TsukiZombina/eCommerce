package mx.uam.azc.modelo.beans;

import java.io.Serializable;

/**
 *
 * @author Marce
 */
public class Proveedor implements Serializable{
    private Long idProveedores = null;
    private String claveProveedor;
    private String nombreProveedor;

    public Proveedor() {
    }

    public Long getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(Long idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getClaveProveedor() {
        return claveProveedor;
    }

    public void setClaveProveedor(String claveProveedor) {
        this.claveProveedor = claveProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}
