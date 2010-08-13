/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.dao;

import com.estacionamiento.bean.EstacionamientoBean;
import com.estacionamiento.bean.UbicacionBean;
import java.sql.*;
import java.util.ArrayList;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;


public class DisponibilidadDAO {

	public ArrayList obtenerDispoEstacionamiento(ActionErrors errors){

                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;
                ArrayList lstEstacionamiento=new ArrayList();
		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();

                       String query1="select u.co_estacionamiento,count(*),e.NO_ESTACIONAMIENTO "+
                                     " from ubicacion u,estacionamiento e "+
                                     " where e.CO_ESTACIONAMIENTO=u.CO_ESTACIONAMIENTO "+
                                     " group by (1)";

                       String query2="select co_estacionamiento,count(*) from estacionamiento.ubicacion "+
                                    " where tx_estado='D' group by (1)";

                        
                        rs = select.executeQuery(query1);
                        ArrayList aux=new ArrayList();
                        while(rs.next()){
                            EstacionamientoBean estacionamiento=new EstacionamientoBean();
                            estacionamiento.setCodigo(""+rs.getInt(1));
                            estacionamiento.setTotal(rs.getInt(2));
                            estacionamiento.setNombre(rs.getString(3));
                            aux.add(estacionamiento);
                            //lstEstacionamiento.add(estacionamiento);
                        }
                        rs=null;
                        rs = select.executeQuery(query2);
                        EstacionamientoBean estacionamientoAux;
                        while(rs.next()){
                            for(int i=0;i<aux.size();i++){
                                estacionamientoAux=(EstacionamientoBean)aux.get(i);
                                if(estacionamientoAux.getCodigo().equals(""+rs.getInt(1))){
                                   estacionamientoAux.setDisponibles(rs.getInt(2));
                                   lstEstacionamiento.add(estacionamientoAux);
                                }
                            }
                        }
                        rs=null;


		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.obtener.disponilibidad", new ActionMessage("error.obtener.disponilibidad"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
                return lstEstacionamiento;

	}

	public ArrayList obtenerUbicaciones_x_Estacionamiento(int codEstacionamiento,ActionErrors errors){

                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;
                ArrayList lstUbicaciones=new ArrayList();
		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();


                       String query="select tx_nivel,nu_sector,nu_posicion,tx_estado,data1.nu_placa,"+
                                     " data1.tx_nombre,data1.tx_apellido,u.co_usuario "+
                                     " from estacionamiento.ubicacion u left join "+
                                     "(select us.co_usuario,v.nu_placa,us.tx_nombre,us.tx_apellido "+
                                     " from estacionamiento.usuario us left join estacionamiento.vehiculo v "+
                                     " on us.co_usuario=v.co_usuario) as data1 "+
                                     " on u.co_usuario=data1.co_usuario "+
                                     " where u.co_estacionamiento="+codEstacionamiento;

                        rs = select.executeQuery(query);
                        String nombres="";
                        while(rs.next()){
                            UbicacionBean ubicacion=new UbicacionBean();
                            ubicacion.setUbicacion(rs.getString(1)+rs.getInt(2)+"-"+rs.getInt(3));
                            if(rs.getString(4)!=null){
                               if(rs.getString(4).equals("D")) ubicacion.setEstado("Disponible");
                               if(rs.getString(4).equals("O")) ubicacion.setEstado("Ocupado");
                            }else{
                                 ubicacion.setEstado("");
                            }

                            ubicacion.setPlaca(rs.getString(5));
                            nombres=((rs.getString(6)!=null)?rs.getString(6):"")+" "+((rs.getString(7)!=null)?rs.getString(7):"");
                            ubicacion.setUsuario(nombres);

                            lstUbicaciones.add(ubicacion);
                            
                        }
                        rs=null;

		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.obtener.ubicaciones", new ActionMessage("error.obtener.ubicaciones"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
                return lstUbicaciones;

	}

}
