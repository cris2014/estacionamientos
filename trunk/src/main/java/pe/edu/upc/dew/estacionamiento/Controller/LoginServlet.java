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
 public class LoginServlet extends HttpServlet {

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Usuario usuario = new Usuario();
         usuario.setCodigo(req.getParameter("txtIdUsuario"));

         usuario.setApellido("LUNA LUNA");
         usuario.setNombre("IVAN");
          String ingreso = "1";

         HttpSession session = req.getSession();
         session.setAttribute("usuario" , usuario);
         Usuario usuario2 = (Usuario)session.getAttribute("usuario") ;

         //String ingreso = session.getAttribute("ingreso").toString();

         req.setAttribute("usuario", usuario);

         if (session.getAttribute("ingreso") ==null)
         {

             session.setAttribute("ingreso", ingreso);
             req.getRequestDispatcher("/ingreso.jsp").forward(req, resp);
         }
         else
         {

            req.getRequestDispatcher("/salida.jsp").forward(req, resp);
         }

         
         /*todas las variables globales va en el scope de aplicacion*/
        //getServletContext().setAttribute(null, resp);


         
     }
 }