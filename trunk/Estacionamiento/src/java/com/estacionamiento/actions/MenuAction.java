/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.actions;
import com.estacionamiento.forms.MenuForm;
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
 * @author iluna
 */
public class MenuAction extends Action{

   public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();
                        MenuForm menuForm = (MenuForm)form;

                        String operacion=menuForm.getOperacion();

                        if(operacion!=null && operacion.equals("1")){
			    forward = mapping.findForward(GlobalMappingsEstacionamiento.REGISTRO);
                        }else{
                            if (operacion!=null && operacion.equals("2")){
                                forward = mapping.findForward(GlobalMappingsEstacionamiento.REPORTE);
                            }

                        }

                        return (forward);

		}
}
