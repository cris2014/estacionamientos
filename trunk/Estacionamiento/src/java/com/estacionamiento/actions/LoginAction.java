/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.actions;

import com.estacionamiento.forms.LoginForm;
import com.estacionamiento.bean.UsuarioBean;
import com.estacionamiento.dao.UsuarioDAO;
import com.estacionamiento.util.GlobalMappingsEstacionamiento;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author pcruces
 */
public class LoginAction extends Action{


   public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {

        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward();
        LoginForm loginForm = (LoginForm)form;

        HttpSession session=request.getSession();
        String next;
        
        try{
  
        String operacion=loginForm.getOperacion();

        
     System.out.println("dquinonez::"+operacion); 

        if(operacion!=null && operacion.equals(GlobalMappingsEstacionamiento.INICIO1)){

            forward = mapping.findForward(GlobalMappingsEstacionamiento.INGRESO);

        }else if (operacion!=null && operacion.equals(GlobalMappingsEstacionamiento.INICIO2)){
            session.removeAttribute("usuario");
            UsuarioBean usuariobean = new UsuarioBean();
            UsuarioBean usuario = new UsuarioBean();
            forward = mapping.findForward(GlobalMappingsEstacionamiento.MENU);

            if(loginForm.getUser().trim().equals("")||loginForm.getPwd().trim().equals("") ){
                errors.add("error.validacion.usuariopwd", new ActionMessage("error.validacion.usuariopwd"));
            }else {
                usuariobean.setLogin(loginForm.getUser());
                usuariobean.setPwd(loginForm.getPwd());

                UsuarioDAO usuarioDAO=new UsuarioDAO();
                usuario=usuarioDAO.validarLogin(usuariobean,errors);

                session.setAttribute("usuario",usuario);
            }
            if(!errors.isEmpty()){
               saveErrors(request, errors);
               forward = mapping.findForward(GlobalMappingsEstacionamiento.SELF);
            }

            //Datos jalados x BD
            /*
            usuario.setApellido("LUNA LUNA VIGO");
            usuario.setNombre("IVAN"); 
            usuario.setTipousuario("Alumno");
            usuario.setCodigo("U913833");
            */
          
            
            
        }
        
        }catch(Exception e){
           e.printStackTrace();
        }

        return (forward);

    }
}
