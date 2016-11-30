package mx.uam.azc.modelo.beans;

import java.io.Serializable;

/**
 *
 * @author Marce
 * @version 
 */
public class Producto implements Serializable{
    private Long idProducto = null;
    private String clave;
    private String nombre;
    private String descripcion;

    public Producto() {}

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
