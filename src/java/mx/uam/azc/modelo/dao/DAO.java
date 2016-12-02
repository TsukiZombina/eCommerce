package mx.uam.azc.modelo.dao;

import java.util.List;
import mx.uam.azc.modelo.EcommerceException;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface DAO<T, L> {
    public void insertar(T t) throws EcommerceException;
    public void modificar(T t) throws EcommerceException;
    public void eliminar(L id) throws EcommerceException;
    public List<T> obtenerTodos() throws EcommerceException;
    public T obtener(L id) throws EcommerceException;
}
