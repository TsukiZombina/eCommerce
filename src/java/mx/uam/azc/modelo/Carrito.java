package mx.uam.azc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import mx.uam.azc.modelo.beans.DetalleOrden;
import mx.uam.azc.modelo.beans.Orden;
import mx.uam.azc.modelo.beans.Producto;
import mx.uam.azc.modelo.beans.ProductoProveedor;
import mx.uam.azc.modelo.beans.Usuario;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public class Carrito implements Serializable{
    private ArrayList<DetalleOrden> productosCarrito = new ArrayList<>();
    
    public void insertarProducto(DetalleOrden producto){
        productosCarrito.add(producto);
    }
    
    public ArrayList<DetalleOrden> obtenerProductos(){
        return productosCarrito;
    }
    
    public void elminarProducto(DetalleOrden producto){
        productosCarrito.remove(producto);
    }
    
    /**
     * Método que obtiene el saldo del usuario logueado
     * @param unUsuario un objeto de tipo Usuario
     * @return el saldo disponible del usuario logueado
     */
    public double obtenerSaldo(Usuario unUsuario){
        return unUsuario.getSaldo();
    }
    
    /**
     * Método que verifica si un usuario está o no logueado al sistema
     * @param unUsuario un objeto Usuario
     * @return verdadero si el usuario está logueado, falso si no está logueado
     */
    public boolean usuarioLogueado(Usuario unUsuario){
        if  (unUsuario.getIdUsuario()!=null)
            return true;
        else
            return false;
    }
    
    /**
     * Método que verifica que el usuario logueado tenga saldo suficiente
     * para comprar los productos que estén en el carrito de compras
     * @param unUsuario 
     * @param unaOrden
     * @return 
     */
    public boolean verificarSaldoSuficiente(Usuario unUsuario, Orden unaOrden){
        if (obtenerSaldo(unUsuario)<unaOrden.getTotal())
            return true;
        else return false;
    }
    
}
