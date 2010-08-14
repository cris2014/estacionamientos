/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.actions;

import com.estacionamiento.forms.LoginForm;
import com.estacionamiento.bean.Usuario;
import com.estacionamiento.util.GlobalMappingsEstacionamiento;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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

        String next;
        String operacion=loginForm.getOperacion();
        String usuario = loginForm.getUser();
        String clave = loginForm.getPwd();
        
        if (usuario.trim().equals("")){
            loginForm.setMensajeError("Ingrese un usuario valido!");
        }

        if(operacion!=null && operacion.equals(GlobalMappingsEstacionamiento.INICIO1)){
/*
            Usuario usuario = new Usuario();
            usuario.setCodigo(loginForm.getUser());

            usuario.setApellido("LUNA LUNA VIGO");
            usuario.setNombre("IVAN");
            String ingreso = "1";

 */


            forward = mapping.findForward(GlobalMappingsEstacionamiento.INGRESO);

        }else{
             if (operacion!=null && operacion.equals(GlobalMappingsEstacionamiento.INICIO2)){
                forward = mapping.findForward(GlobalMappingsEstacionamiento.MENU);
             }
        }


        if (loginForm.getMensajeError()!=null)
        {
            next = "self";
        }

        return (forward);

    }
}
