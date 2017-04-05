package mx.uam.azc.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@WebServlet(name = "ServletDetalleProducto", urlPatterns = {"/ServletDetalleProducto"})
public class ServletDetalleProducto extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idProducto"));
        
        DAOManager manager = new MySQLDAOManager();
        
        Producto p=null;
        ProductoProveedor pp=null;
        
        try {
            p = manager.getProductoDAO().obtener(id);
            pp = manager.getProductoProveedorDAO().obtenerPorIdProducto(id);
        } catch (EcommerceException e) {
            System.out.println(e.getMessage());
        }
        
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("producto", p);
        sesion.setAttribute("productoProveedor", pp);
        request.getRequestDispatcher("single.jsp").forward(request, response);
        
    }

}
