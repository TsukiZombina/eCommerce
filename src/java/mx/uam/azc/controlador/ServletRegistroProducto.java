package mx.uam.azc.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Producto;
import mx.uam.azc.modelo.beans.ProductoProveedor;
import mx.uam.azc.modelo.dao.DAOManager;
import mx.uam.azc.modelo.dao.mysql.MySQLDAOManager;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
@WebServlet(name = "ServletRegistroProducto", urlPatterns = {"/ServletRegistroProducto"})
public class ServletRegistroProducto extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int existencia = Integer.parseInt(request.getParameter("existencia"));
        double precioUnitario = Double.parseDouble(request.getParameter("precioUnitario"));
        
        Producto unProducto = new Producto();
        ProductoProveedor unProductoProveedor = new ProductoProveedor();
        
        unProducto.setClave(clave);
        unProducto.setNombre(nombre);
        unProducto.setDescripcion(descripcion);
        unProductoProveedor.setExistencia(existencia);
        unProductoProveedor.setPrecioUnitario(precioUnitario);

        DAOManager manager = new MySQLDAOManager();
        try {
            manager.getProductoDAO().insertar(unProducto);
        } catch (EcommerceException ex) {
            System.out.println(ex.getMessage());
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
