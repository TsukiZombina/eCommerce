package mx.uam.azc.modelo.dao;

import java.util.List;

/**
 *
 * @author Marce
 * @version 
 */

public interface DAO<T, L> {
    public void insertar(T t);
    public void modificar(T t);
    public void eliminar(L id);
    public List<T> obtenerTodos();
    public T obtener(L id);
}
