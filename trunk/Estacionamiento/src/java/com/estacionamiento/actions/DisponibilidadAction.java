/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.actions;

import com.estacionamiento.bean.EstacionamientoBean;
import com.estacionamiento.dao.DisponibilidadDAO;
import com.estacionamiento.util.GlobalMappingsEstacionamiento;
import com.estacionamiento.util.Grafico;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Jefferson
 */
public class DisponibilidadAction extends Action{

     public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {

        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward();
      

        HttpSession session=request.getSession();
        String next;
        
        try{
       
           System.out.println("dquinonez3");
           ServletConfig sc=getServlet().getServletConfig();
           ArrayList lstEstacionamiento=new ArrayList();
           DisponibilidadDAO  disponibilidadDAO=new DisponibilidadDAO();
           lstEstacionamiento=disponibilidadDAO.obtenerDispoEstacionamiento(errors);


           if(errors.isEmpty() && lstEstacionamiento!=null){
              EstacionamientoBean estacionamiento;
              for(int j=0;j<lstEstacionamiento.size();j++){
                  estacionamiento=(EstacionamientoBean)lstEstacionamiento.get(j);

                  System.out.println("dq::"+estacionamiento.getCodigo());
                  System.out.println("dq::"+estacionamiento.getTotal());
                  System.out.println("dq::"+estacionamiento.getDisponibles());
                  int h=j+1;
                  String img="/img/chart"+h+".jpg";
                  String fileLocation=sc.getServletContext().getRealPath("/")+img;

                  Grafico chartCreator = new Grafico();
                  chartCreator.setValores(estacionamiento.getTotal()-estacionamiento.getDisponibles(),
                                          estacionamiento.getDisponibles(),estacionamiento.getNombre());
                  PieDataset pieDataset = chartCreator.createPieDataSet();
                  JFreeChart chart = chartCreator.create3DPieChart(pieDataset);

                  chartCreator.saveChart(chart, fileLocation);
               }
               forward = mapping.findForward(GlobalMappingsEstacionamiento.INICIO3);
            }
            if(!errors.isEmpty()){
                 saveErrors(request, errors);
                 forward = mapping.findForward(GlobalMappingsEstacionamiento.INICIO);
            }
        

        }catch(Exception e){
           e.printStackTrace();
           forward = mapping.findForward(GlobalMappingsEstacionamiento.INICIO);
        }


        return (forward);

    }
}
