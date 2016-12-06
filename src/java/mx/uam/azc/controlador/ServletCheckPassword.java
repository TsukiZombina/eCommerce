package mx.uam.azc.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.uam.azc.modelo.EcommerceException;
import mx.uam.azc.modelo.beans.Usuario;
import mx.uam.azc.modelo.dao.DAOManager;
import mx.uam.azc.modelo.dao.mysql.MySQLDAOManager;

/**
 *
 * @author Zelzin Marcela Márquez Navarrete
 * @author Ernesto García Maldonado
 * @version 1.0
 */
@WebServlet(name = "ServletCheckPassword", urlPatterns = {"/ServletCheckPassword"})
public class ServletCheckPassword extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Servlet verifica contraseña");
        if (!username.isEmpty() && !password.isEmpty()) {
            DAOManager manager = new MySQLDAOManager();
            Long id = null;
            boolean valida = false;
            Usuario unUsuario = null;
            
            try {
                id = manager.getUsuarioDAO().buscarUsername(username);
                valida = manager.getUsuarioDAO().validarUsuario(id, password);
            } catch (EcommerceException ex) {
                request.setAttribute("error", "Usuario y/o contraseña incorrectos");
                request.getRequestDispatcher("404.jsp").forward(request, response);
                System.out.println(ex.getMessage());
            }
            
            if (valida) {
                try {
                    unUsuario = manager.getUsuarioDAO().obtener(id);
                } catch (EcommerceException ex) {
                    request.setAttribute("error", "No se pudo iniciar sesión");
                    request.getRequestDispatcher("404.jsp").forward(request, response);
                    System.out.println(ex.getMessage());
                }
                
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", unUsuario);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "Usuario y/o contraseña incorrectos");
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }
            
        } else{
            response.sendRedirect("login.jsp");
        }
    }
}
