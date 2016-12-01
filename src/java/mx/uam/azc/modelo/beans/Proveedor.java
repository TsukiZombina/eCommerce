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
    private String contactoTel;
    private String contactoCorreo;
    private String contactoDireccion;
    private String encargado;

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

    public String getContactoTel() {
        return contactoTel;
    }

    public void setContactoTel(String contactoTel) {
        this.contactoTel = contactoTel;
    }

    public String getContactoCorreo() {
        return contactoCorreo;
    }

    public void setContactoCorreo(String contactoCorreo) {
        this.contactoCorreo = contactoCorreo;
    }

    public String getContactoDireccion() {
        return contactoDireccion;
    }

    public void setContactoDireccion(String contactoDireccion) {
        this.contactoDireccion = contactoDireccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
}
