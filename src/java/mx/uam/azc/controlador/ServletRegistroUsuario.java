package mx.uam.azc.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletRegistroUsuario", urlPatterns = {"/ServletRegistroUsuario"})
public class ServletRegistroUsuario extends HttpServlet {

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
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contactoTel = request.getParameter("contactoTel");
        String contactoCorreo = request.getParameter("contactoCorreo");
        
        Usuario unUsuario = new Usuario();
        
        unUsuario.setNombre(nombre);
        unUsuario.setApellidoP(apellidoP);
        unUsuario.setApellidoM(apellidoM);
        unUsuario.setUsername(username);
        unUsuario.setPassword(password);
        unUsuario.setSal("qwerty");
        unUsuario.setContactoTel(contactoTel);
        unUsuario.setContactoCorreo(contactoCorreo);

        DAOManager manager = new MySQLDAOManager();
        try {
            manager.getUsuarioDAO().insertar(unUsuario);
        } catch (EcommerceException ex) {
            System.out.println(ex.getMessage());
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
