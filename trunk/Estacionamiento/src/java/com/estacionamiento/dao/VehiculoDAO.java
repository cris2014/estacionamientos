/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.dao;

import com.estacionamiento.bean.ColorBean;
import com.estacionamiento.bean.EstacionamientoBean;
import com.estacionamiento.bean.MarcaBean;
import com.estacionamiento.bean.VehiculoBean;
import java.sql.*;
import java.util.ArrayList;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


public class VehiculoDAO {

        public ArrayList obtenerLstColor(ActionErrors errors){
                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;
                ArrayList lstColor=new ArrayList();

		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();

                       String query="select co_color,tx_color from estacionamiento.color ";

                        rs = select.executeQuery(query);
                        while(rs.next()){
                             ColorBean color=new ColorBean();
                             color.setCodigo(""+rs.getInt(1));
                             color.setNombre(rs.getString(2));

                             lstColor.add(color);
                        }

                        rs=null;


		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.obtener.color", new ActionMessage("error.obtener.color"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
		return lstColor;
        }
        public ArrayList obtenerLstMarca(ActionErrors errors){
                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;
                ArrayList lstMarca=new ArrayList();

		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();

                       String query="select co_marca,no_marca from estacionamiento.marca order by co_marca ";

                        rs = select.executeQuery(query);
                        while(rs.next()){
                             MarcaBean marca=new MarcaBean();
                             marca.setCodigo(""+rs.getInt(1));
                             marca.setNombre(rs.getString(2));

                             lstMarca.add(marca);
                        }

                        rs=null;


		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.obtener.marca", new ActionMessage("error.obtener.marca"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
		return lstMarca;
        }
        public ArrayList obtenerLstEstacionamiento(ActionErrors errors){
                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;
                ArrayList lstEstacionamiento=new ArrayList();

		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();

                       String query="select co_estacionamiento,no_estacionamiento from estacionamiento.estacionamiento ";

                        rs = select.executeQuery(query);
                        while(rs.next()){
                             EstacionamientoBean estacionamiento=new EstacionamientoBean();
                             estacionamiento.setCodigo(""+rs.getInt(1));
                             estacionamiento.setNombre(rs.getString(2));

                             lstEstacionamiento.add(estacionamiento);
                        }

                        rs=null;


		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.obtener.estacionamiento", new ActionMessage("error.obtener.estacionamiento"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
		return lstEstacionamiento;
        }

	public int registrarVehiculo(VehiculoBean vehiculo,ActionErrors errors){

                Connection con = null;
                PreparedStatement ps=null;
                ResultSet rs = null;
                String cadena;
                Statement select = null;
                int rpta=-1;

		try {
                       
                       con=ConexionDAO.getInstance().getConnection();

                       if(vehiculo.getUsuario().getFlag().equals("1")){
                             select = con.createStatement();
                             String query="select nu_placa from estacionamiento.vehiculo" +
                                     " where nu_placa='"+vehiculo.getPlaca()+"'";

                             
                              rs = select.executeQuery(query);
                             if(rs.next()){
                                 errors.add("error.validar.placa", new ActionMessage("error.validar.placa"));
                             }else{
                                  rs=null;

                                  ps=con.prepareStatement("insert into estacionamiento.vehiculo " +
                                  " (NU_PLACA,NO_MODELO,CO_MARCA,CO_COLOR,CO_USUARIO ) " +
				  " values(?,?,?,?,?)");

                                  ps.setString(1,vehiculo.getPlaca());
		                  ps.setString(2,vehiculo.getModelo());
                                  ps.setInt(3,new Integer(vehiculo.getMarca()).intValue());
                                  ps.setInt(4,new Integer(vehiculo.getColor()).intValue());
                                  ps.setString(5,vehiculo.getUsuario().getCodigo());

                                  ps.executeUpdate();
                                  rpta=2;
                             }
                       }else if(vehiculo.getUsuario().getFlag().equals("2")){
                              select = con.createStatement();
                              String query="select nu_placa from estacionamiento.vehiculo" +
                                     " where nu_placa='"+vehiculo.getPlaca()+"'"+
                                     " and co_usuario!='"+vehiculo.getUsuario().getCodigo()+"'";


                               rs = select.executeQuery(query);
                               if(rs.next()){
                                  errors.add("error.validar.placa", new ActionMessage("error.validar.placa"));
                               }else{
                                  rs=null;
                                  ps=con.prepareStatement("update estacionamiento.vehiculo " +
                                    " set nu_placa=? ," +
                                    "     no_modelo=? ,"+
                                    "     co_marca=? ,"+
                                    "     co_color=? "+
                                    "where co_usuario= ? ");

                                  ps.setString(1,vehiculo.getPlaca());
		                  ps.setString(2,vehiculo.getModelo());
                                  ps.setInt(3,new Integer(vehiculo.getMarca()).intValue());
                                  ps.setInt(4,new Integer(vehiculo.getColor()).intValue());
                                  ps.setString(5,vehiculo.getUsuario().getCodigo());

                                  ps.executeUpdate();
                                  rpta=2;
                               }


                       }

                       

                       System.out.println(" Registro Correctamente:\n");


		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.registrar.vehiculo", new ActionMessage("error.registrar.vehiculo"));
 		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
                return rpta;

	}
}
