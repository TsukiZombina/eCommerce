/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Marce
 */
public class Carrito implements Serializable{
    private ArrayList<Producto> productosCarrito;

    public Carrito() {
        this.productosCarrito = new ArrayList<>();
    }
    
    public void insertarProducto(Producto producto){
        productosCarrito.add(producto);
    }
    
    public ArrayList<Producto> obtenerProductos(){
        return productosCarrito;
    }
    
    public void elminarProducto(Producto producto){
        productosCarrito.remove(producto);
    }
    
    
}
