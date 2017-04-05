package mx.uam.azc.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ServletProductosOfrecidos", urlPatterns = {"/ServletProductosOfrecidos"})
public class ServletProductosOfrecidos extends HttpServlet {
    
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
        DAOManager manager = new MySQLDAOManager();
        
        ArrayList<Producto> productos = null;
        ArrayList<ProductoProveedor> productosProveedores = null;
        
        try {
            productos = (ArrayList<Producto>) manager.getProductoDAO().obtenerTodos();
            productosProveedores = (ArrayList<ProductoProveedor>) manager.getProductoProveedorDAO().obtenerTodos();
        } catch (EcommerceException e) {
            System.out.println(e.getMessage());
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("productos", productos);
        session.setAttribute("productosProveedores", productosProveedores);
//        request.getRequestDispatcher("index.jsp").forward(request, response);
//        response.sendRedirect("index.jsp");
    }

   
}
