/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.estacionamiento.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dew.estacionamiento.domain.Usuario;

/**
 *
 * @author jcastro
 */
public class LoginPasswordServlet extends HttpServlet {

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Usuario usuario = new Usuario();
         usuario.setCodigo(req.getParameter("txtIdUsuario"));

         usuario.setApellido("DE LA CRUZ");
         usuario.setNombre("RONALD");


         HttpSession session = req.getSession();
         session.setAttribute("usuario" , usuario);
         Usuario usuario2 = (Usuario)session.getAttribute("usuario") ;

         req.setAttribute("usuario", usuario);
         /*todas las variables globales va en el scope de aplicacion*/
        //getServletContext().setAttribute(null, resp);


         req.getRequestDispatcher("/menu.jsp").forward(req, resp);
     }
 }
