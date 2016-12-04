package mx.uam.azc.modelo.dao;

import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Administrador;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
public interface AdministradorDAO{
    void modificar(Administrador administrador) throws EcommerceException; 
    Administrador obtener(Long id) throws EcommerceException;
}
