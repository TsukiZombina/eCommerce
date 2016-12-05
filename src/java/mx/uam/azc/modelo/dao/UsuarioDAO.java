
package mx.uam.azc.modelo.dao;

import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Usuario;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface UsuarioDAO {
    public void insertar(Usuario usuario) throws EcommerceException;
    public void modificar(Usuario usuario) throws EcommerceException;
    public void eliminar(Long id) throws EcommerceException;
    public Usuario obtener(Long id) throws EcommerceException;
    boolean validarUsuario(Long id, String contrasenia) throws EcommerceException;
    double generarSaldo();
}
