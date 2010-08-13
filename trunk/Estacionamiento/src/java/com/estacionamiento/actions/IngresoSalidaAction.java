/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.actions;

import com.estacionamiento.bean.EstacionamientoBean;
import com.estacionamiento.bean.UbicacionBean;
import com.estacionamiento.bean.UsuarioBean;
import com.estacionamiento.dao.UsuarioDAO;
import com.estacionamiento.forms.IngresoSalidaForm;
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


public class IngresoSalidaAction extends Action{
   public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {

        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward();
        IngresoSalidaForm ingresoSalidaForm = (IngresoSalidaForm)form;

        HttpSession session=request.getSession();
        String next;

        try{
            session.removeAttribute("ubicacionBean");
            String operacion=ingresoSalidaForm.getOperacion();
            ingresoSalidaForm.getEstacionamiento();
     System.out.println("dquinonez::"+operacion);
     System.out.println("dquinonez::"+ingresoSalidaForm.getEstacionamiento());
     System.out.println("dquinonez::"+ingresoSalidaForm.getUser());

            if(operacion!=null && operacion.equals(GlobalMappingsEstacionamiento.INICIO1)){
                UsuarioDAO usuarioDAO=new UsuarioDAO();
                UsuarioBean usuarioBean=new UsuarioBean();

                if(ingresoSalidaForm.getUser().trim().equals("")){
                    errors.add("error.validacion.usuario", new ActionMessage("error.validacion.usuario"));
                    saveErrors(request, errors);
                    forward = mapping.findForward(GlobalMappingsEstacionamiento.SELF);
                }else{
                   usuarioBean.setCodigo(ingresoSalidaForm.getUser().trim());
                   EstacionamientoBean estacionamientoBean=new EstacionamientoBean();
                   estacionamientoBean.setCodigo(ingresoSalidaForm.getEstacionamiento());

                   UbicacionBean ubicacion=new UbicacionBean();
                   ubicacion=usuarioDAO.obtenerUbicacionIngresoSalida(usuarioBean,estacionamientoBean,errors);

                   if(errors.isEmpty()){
                      if(ubicacion!=null && ubicacion.getFlag().equals("1")){
                         forward = mapping.findForward(GlobalMappingsEstacionamiento.INGRESO);
                      }
                      if(ubicacion!=null && ubicacion.getFlag().equals("2")){
                         forward = mapping.findForward(GlobalMappingsEstacionamiento.SALIDA);
                      }
                      session.setAttribute("ubicacionBean",ubicacion);
                   }else{
                       saveErrors(request, errors);
                       forward = mapping.findForward(GlobalMappingsEstacionamiento.SELF);
                   }

                }

              /*
              ubicacion.setUbicacion("A2-15");
              ubicacion.setUsuario("Rolando Cabrera");
              ubicacion.setNombreEstacionamiento("Estacionamiento1");
              */

            }else  if(operacion!=null && operacion.equals("aceptar")){
                 forward = mapping.findForward(GlobalMappingsEstacionamiento.INICIO);
            }

        }catch(Exception e){
           e.printStackTrace();
        }

        return (forward);

    }
}
