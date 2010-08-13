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

/**
 *
 * @author Jefferson
 */
public class RegistroReporteAction  extends DispatchAction{
 	public ActionForward  irRegistro(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

			ActionForward forward = new ActionForward(); 
                       
                        forward = mapping.findForward(GlobalMappingsEstacionamiento.REGISTRO);
                         
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
                  //forward = mapping.findForward(GlobalMappingsEstacionamiento.REGISTRO);
                  forward = mapping.findForward(GlobalMappingsEstacionamiento.MENU);
                  System.out.println("dquinonez::"+registroReporte.getPlaca());
                  System.out.println("dquinonez::"+registroReporte.getMarca());
                  System.out.println("dquinonez::"+registroReporte.getColor());

                  VehiculoBean vehiculo=new VehiculoBean();

                  UsuarioBean usuario=(UsuarioBean)session.getAttribute("usuario");

                  vehiculo.setPlaca(registroReporte.getPlaca());
                  vehiculo.setModelo(registroReporte.getModelo());
                  vehiculo.setMarca(registroReporte.getMarca());
                  vehiculo.setColor(registroReporte.getColor());
                  vehiculo.setUsuario(usuario);

                  VehiculoDAO vehiculoDAO=new VehiculoDAO();
                  vehiculoDAO.registrarVehiculo(vehiculo,errors);

                  if(!errors.isEmpty()){
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

                  System.out.println("dquinonez::"+registroReporte.getEstacionamiento());
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
   /*                     
	public ActionForward buscarUnidad(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
            
		    HttpSession session=request.getSession();
		    
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); 
                        
			SolicitudOIEquipamientoForm solicitudOIEquipamiento =(SolicitudOIEquipamientoForm) form;
			UnidadBean unidad=new UnidadBean();
			UnidadBean unidadRpta=new UnidadBean();
			ArrayList lstTaller=new ArrayList();
			
			try {
				session.removeAttribute("flagGrabar");
				
				unidad.setEmbarque(solicitudOIEquipamiento.getEmbarque());
				unidad.setNumCase(solicitudOIEquipamiento.getNumCase());
				
				Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");			
				unidad.setIdPuntoVenta(usuario.getPuntoVenta().getId().intValue());
			
				
				SolicitudOIEquipamientoDAO solicitudOIEquipamientoDAO=new SolicitudOIEquipamientoDAO();
				lstTaller=solicitudOIEquipamientoDAO.buscarTaller(errors);
				//////Asignacion de Taller////////
				ArrayList lstFinTaller=new ArrayList();
				TallerBean taller=new TallerBean();
				for(int j=0;j<lstTaller.size();j++){
					taller=(TallerBean)lstTaller.get(j);
					lstFinTaller.add(new org.apache.struts.util.LabelValueBean(taller.getNombreTaller(),taller.getCodTaller()));
				}
				
				session.setAttribute("lstFinTaller",lstFinTaller);
				
				unidadRpta=solicitudOIEquipamientoDAO.buscarUnidad(unidad, errors);
				session.setAttribute("unidad", unidadRpta);
				if (errors.isEmpty()) {
					session.setAttribute("flagGrabar","1");
				}				

			}catch (Exception e) {
				Logger.log(Logger.ERROR, e, "OCURRIO UN ERROR AL BUSCAR UNIDAD", this.getClass().toString());
				if (errors.isEmpty()) {
				    errors.add("error.buscar.Unidad", new ActionError("error.buscar.Unidad"));	
				}
			}

			if (!errors.isEmpty()) {
					saveErrors(request, errors);

			} 

			forward = mapping.findForward(GlobalMappingsVentas.INICIO);
			return (forward);			
		}
*/        
}
