/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.actions;

import com.estacionamiento.bean.UbicacionBean;
import com.estacionamiento.bean.UsuarioBean;
import com.estacionamiento.bean.VehiculoBean;
import com.estacionamiento.dao.DisponibilidadDAO;
import com.estacionamiento.dao.VehiculoDAO;
import com.estacionamiento.forms.RegistroReporteForm;
import com.estacionamiento.util.GlobalMappingsEstacionamiento;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class RegistroReporteAction  extends DispatchAction{
 	public ActionForward  irRegistro(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

			ActionForward forward = new ActionForward(); 
                        ActionErrors errors = new ActionErrors();
                        RegistroReporteForm registroReporte =(RegistroReporteForm) form;
                        HttpSession session=request.getSession();
                        forward = mapping.findForward(GlobalMappingsEstacionamiento.REGISTRO);

                try{
                    ArrayList lstColor=new ArrayList();
                    ArrayList lstMarca=new ArrayList();
                    VehiculoDAO vehiculo=new VehiculoDAO();
                    lstColor=vehiculo.obtenerLstColor(errors);


                    if(!errors.isEmpty()){
                       saveErrors(request, errors);
                     }else{
                       lstMarca=vehiculo.obtenerLstMarca(errors);
                       if(!errors.isEmpty()){
                           saveErrors(request, errors);
                       }
                     }
                    UsuarioBean usuario=(UsuarioBean)session.getAttribute("usuario");


                    if(usuario.getFlag().equals("2")){
                       VehiculoBean vehiculobean=new VehiculoBean();
                       vehiculobean=usuario.getVehiculo();

                       registroReporte.setPlaca(vehiculobean.getPlaca());
                       registroReporte.setModelo(vehiculobean.getModelo());

                       request.setAttribute("codColor",vehiculobean.getColor());
                       request.setAttribute("codMarca",vehiculobean.getMarca());

                    }else{
                        registroReporte.setPlaca("");
                        registroReporte.setModelo("");
                        request.removeAttribute("codColor");
                        request.removeAttribute("codMarca");
                    }
                    
                      session.setAttribute("lstColor", lstColor);
                      session.setAttribute("lstMarca", lstMarca);

                }catch(Exception e){
                   e.printStackTrace();
                }

                return (forward);
                        
        }                
    	public ActionForward  irReporte(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

                        ActionErrors errors = new ActionErrors();
                        RegistroReporteForm registroReporte =(RegistroReporteForm) form;
			ActionForward forward = new ActionForward(); 
                        HttpSession session=request.getSession();
               try{
                  session.removeAttribute("lstEstacionamiento");
                  ArrayList lstEstacionamiento=new ArrayList();
                  DisponibilidadDAO disponibilidad=new DisponibilidadDAO();

                  lstEstacionamiento=disponibilidad.obtenerUbicaciones_x_Estacionamiento(1,errors);
                 
                  if(errors.isEmpty()){
                     registroReporte.setLstEstacionamiento(lstEstacionamiento);
                     session.setAttribute("lstEstacionamiento",lstEstacionamiento);                  
                  }else{
                     saveErrors(request, errors);
                  }
                  request.setAttribute("codEsta","1");
                  /*
                  UbicacionBean ubicacion=new UbicacionBean();
                  ubicacion.setNombreEstacionamiento("E1");
                  ubicacion.setUbicacion("A1");
                  ubicacion.setPlaca("123456");
                  ubicacion.setEstado("OCUPADO");
                  UbicacionBean ubicacion2=new UbicacionBean();
                  ubicacion2.setNombreEstacionamiento("E1");
                  ubicacion2.setUbicacion("A2");
                  ubicacion2.setPlaca("123457");
                  ubicacion2.setEstado("DISPONIBLE");
                  lstEstacionamiento.add(ubicacion);
                  lstEstacionamiento.add(ubicacion2);
                  */

                 
               }catch(Exception e){
                  e.printStackTrace();
               }
                forward = mapping.findForward(GlobalMappingsEstacionamiento.REPORTE);
                         
                return (forward);
                        
        }
 	public ActionForward  retornarMenu(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

			ActionForward forward = new ActionForward();

                        forward = mapping.findForward(GlobalMappingsEstacionamiento.MENU);

                        return (forward);

        }
     	public ActionForward  registrarVehiculo(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

	       ActionForward forward = new ActionForward();
               ActionErrors errors = new ActionErrors();
               RegistroReporteForm registroReporte =(RegistroReporteForm) form;
               HttpSession session=request.getSession();

               try{
                  forward = mapping.findForward(GlobalMappingsEstacionamiento.MENU);

                  VehiculoBean vehiculo=new VehiculoBean();

                  UsuarioBean usuario=(UsuarioBean)session.getAttribute("usuario");

                  vehiculo.setPlaca(registroReporte.getPlaca());
                  vehiculo.setModelo(registroReporte.getModelo());
                  vehiculo.setMarca(registroReporte.getMarca());
                  vehiculo.setColor(registroReporte.getColor());
                  vehiculo.setUsuario(usuario);


                  VehiculoDAO vehiculoDAO=new VehiculoDAO();
                  int rpta=vehiculoDAO.registrarVehiculo(vehiculo,errors);

                  if(errors.isEmpty() && rpta==2){
                      usuario.setFlag(""+rpta);
                      usuario.setVehiculo(vehiculo);
                      session.setAttribute("usuario",usuario);
                  }else {
                       saveErrors(request, errors);
                       forward = mapping.findForward(GlobalMappingsEstacionamiento.SELF);
                  }


               }catch(Exception e){
                   e.printStackTrace();
               
               }         
         
               return (forward);
                        
        }     
    	public ActionForward  cambiarEstacionamiento(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

                        RegistroReporteForm registroReporte =(RegistroReporteForm) form;
			ActionForward forward = new ActionForward();
                        ActionErrors errors = new ActionErrors();
                        HttpSession session=request.getSession();
               try{

                  session.removeAttribute("lstEstacionamiento");
                  ArrayList lstEstacionamiento=new ArrayList();
                  DisponibilidadDAO disponibilidad=new DisponibilidadDAO();
                  int codEsta=new Integer(registroReporte.getEstacionamiento()).intValue();

                  lstEstacionamiento=disponibilidad.obtenerUbicaciones_x_Estacionamiento(codEsta,errors);

                  if(errors.isEmpty()){
                     registroReporte.setLstEstacionamiento(lstEstacionamiento);
                     session.setAttribute("lstEstacionamiento",lstEstacionamiento);

                     //registroReporte.setEstacionamiento(""+codEsta);
                  }else{
                     saveErrors(request, errors);
                  }
                  request.setAttribute("codEsta",""+codEsta);
                  /*
                  UbicacionBean ubicacion=new UbicacionBean();
                  ubicacion.setNombreEstacionamiento("E2");
                  ubicacion.setUbicacion("B1");
                  ubicacion.setPlaca("123456");
                  ubicacion.setEstado("OCUPADO");
                  UbicacionBean ubicacion2=new UbicacionBean();
                  ubicacion2.setNombreEstacionamiento("E1");
                  ubicacion2.setUbicacion("B2");
                  ubicacion2.setPlaca("123457");
                  ubicacion2.setEstado("DISPONIBLE");
                  lstEstacionamiento.add(ubicacion);
                  lstEstacionamiento.add(ubicacion2);
                  */
              
               }catch(Exception e){
                  e.printStackTrace();
               }
               forward = mapping.findForward(GlobalMappingsEstacionamiento.REPORTE);
                         
               return (forward);
                        
        }
}
