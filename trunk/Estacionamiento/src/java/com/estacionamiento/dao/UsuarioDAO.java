/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.dao;

import com.estacionamiento.bean.EstacionamientoBean;
import com.estacionamiento.bean.UbicacionBean;
import com.estacionamiento.bean.UsuarioBean;
import com.estacionamiento.util.Fecha;
import java.sql.*;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author pcruces
 */
public class UsuarioDAO {

	public UsuarioBean validarLogin(UsuarioBean usuario,ActionErrors errors){

                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;


		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();

                       String query="select co_usuario,fl_tipo,tx_nombre,tx_apellido,tx_celular" +
                               "  from estacionamiento.usuario "+
                                "where no_usuario='"+usuario.getLogin()+"' " +
                                "and tx_clave='"+usuario.getPwd()+"' ";

                        
                        rs = select.executeQuery(query);
                        if(rs.next()){
                           usuario.setCodigo(rs.getString(1));
                           int tipo=rs.getInt(2);
                           
                           switch (tipo){
                               case 1 :
                                   usuario.setTipousuario("ALUMNO");
                                   break;
                               case 2:
                                   usuario.setTipousuario("PROFESOR");
                                   break;
                               default  : 
                                   usuario.setTipousuario("GENERAL");
                                   break;                                           
                           }
             
                           usuario.setNombre(rs.getString(3));
                           usuario.setApellido(rs.getString(4));
                       
                        }else{
                           errors.add("error.login.usuario", new ActionMessage("error.login.usuario"));
                        }

                        rs=null;
                       

		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.login.db", new ActionMessage("error.login.db"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
		return usuario;
	}

 	public UbicacionBean obtenerUbicacionIngresoSalida(UsuarioBean usuario,EstacionamientoBean estacionamiento,ActionErrors errors){

                Connection con = null;
                Statement select = null;
                ResultSet rs = null;
                String cadena;
                UbicacionBean ubicacionBean=new UbicacionBean();

		try {
                       con=ConexionDAO.getInstance().getConnection();

                       select = con.createStatement();

                       String query=" select co_usuario from estacionamiento.usuario  "+
                                    " where co_usuario='"+usuario.getCodigo()+"'";

                       String query2="select co_usuario,b.nu_placa  from estacionamiento.usuario a inner join " +
                               "  estacionamiento.vehiculo b on a.co_usuario = b.co_usuario "+
                                    " where co_usuario='"+usuario.getCodigo()+"'";


                       String query3="select v.co_usuario  from estacionamiento.vehiculo v inner join " +
                               "  estacionamiento.ticket t on v.nu_placa = t.nu_placa inner join"+
                               "  estacionamiento.ubicacion u on t.co_ubicacion=u.co_ubicacion " +

                               " where v.co_usuario='"+usuario.getCodigo()+"'" +
                               " and t.fe_salida is null " +
                               " and u.co_estacionamiento!="+estacionamiento.getCodigo();



                       rs = select.executeQuery(query);
                       if(rs.next()){
                          //Continua
                           rs=null;
                           rs=select.executeQuery(query2);

                           if(rs.next()){
                              String nu_placa=rs.getString(2);
                              rs=null;
                              rs=select.executeQuery(query3);
                               if(!rs.next()){
                                  rs=null;
                                     String query4="select nu_ticket,co_ubicacion from estacionamiento.ticket "+
                                      " where nu_placa='"+nu_placa+"'"+
                                      " and fe_salida is null";
                                      rs=select.executeQuery(query4);
                                      if(rs.next()){
                                          int co_ticket=new Integer(rs.getString(1)).intValue();
                                          int co_ubi=new Integer(rs.getString(2)).intValue();

                                          String fec_sal="2010-08-10 11:10:00";
                                          //Actualiza fecha de salida ticket
                                          String  query6="update estacionamiento.ticket "+
                                                  "  set fe_salida= current_timestamp " + 
                                                  "  where  nu_ticket="+co_ticket;
                                                  
                                           //Actualiza Ubicacion Libera Ubicacion
                                         String query7="update estacionamiento.ubicacion" +
                                            " set tx_estado='D'"+
                                            " where co_ubicacion="+co_ubi;


                                      }else{
                                           
                                          //Inserta ticket
                                          String query8="insert into "

                                          //Asigna Ubicacion y actualiza estado (estacionamiento)
                                      }


                               }else{
                                  //Unidad ingreso en otro estacionamiento
                               }


                           }else{
                              //Mensaje  Usuario no tiene vehiculo registrado
                           }

                       }else{
                          errors.add("error.login.user", new ActionMessage("error.login.user"));

                       }



                       String query1=" select co_ubicacion,tx_nivel,nu_sector,nu_posicion,tx_estado,"+
                                     " e.no_estacionamiento,tx_nombre,tx_apellido "+
                                     " from estacionamiento.ubicacion u,estacionamiento.estacionamiento e," +
                                     " estacionamiento.usuario us " +
                                     " where  us.co_usuario='"+usuario.getCodigo()+"'" +
                                     " and u.co_usuario=us.co_usuario"+
                                     " and u.CO_ESTACIONAMIENTO="+estacionamiento.getCodigo()+
                                     " and e.CO_ESTACIONAMIENTO="+estacionamiento.getCodigo();
                                    // " and tx_estado='D' " +
                                    // " limit 1";
                       String query2=" select co_ubicacion,tx_nivel,nu_sector,nu_posicion,tx_estado,"+
                                     " e.no_estacionamiento,tx_nombre,tx_apellido "+
                                     " from estacionamiento.ubicacion u,estacionamiento.estacionamiento e," +
                                     " estacionamiento.usuario us " +
                                     " where  us.co_usuario='"+usuario.getCodigo()+"'" +
                                     " and u.CO_ESTACIONAMIENTO="+estacionamiento.getCodigo()+
                                     " and e.CO_ESTACIONAMIENTO="+estacionamiento.getCodigo()+
                                     " and tx_estado='D' " +
                                     " limit 1";
                        rs = select.executeQuery(query1);

                        if(rs.next()){
                           //salida
                              int co_ubi=rs.getInt(1);
                              ubicacionBean.setUbicacion(rs.getString(2)+rs.getInt(3)+"-"+rs.getInt(4));
                              ubicacionBean.setNombreEstacionamiento(rs.getString(6));
                              ubicacionBean.setUsuario(rs.getString(7)+" "+rs.getString(8));
                              ubicacionBean.setFlag("2");
                              String query3="update estacionamiento.ubicacion" +
                                            " set tx_estado='D',"+
                                            " co_usuario='' "+
                                            " where co_ubicacion="+co_ubi;

                              select.executeUpdate(query3);


                        }else{ 
                           rs=null;
                           rs = select.executeQuery(query2);
                           if(rs.next()){//Ingreso
                              int co_ubi=rs.getInt(1);

                              ubicacionBean.setUbicacion(rs.getString(2)+rs.getInt(3)+"-"+rs.getInt(4));
                              ubicacionBean.setNombreEstacionamiento(rs.getString(6));
                              ubicacionBean.setUsuario(rs.getString(7)+" "+rs.getString(8));
                              ubicacionBean.setFlag("1");

                              String query3="update estacionamiento.ubicacion" +
                                            " set tx_estado='O',"+
                                            " co_usuario='"+usuario.getCodigo()+"' "+
                                            " where co_ubicacion="+co_ubi;

                              select.executeUpdate(query3);
                           }else{//Usuario No existe
                                 errors.add("error.login.user", new ActionMessage("error.login.user"));
                           }
                        }

                        rs=null;


		} catch (Exception e) {
			e.printStackTrace();
                        ubicacionBean=null;
                        errors.add("error.login.db", new ActionMessage("error.login.db"));
		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }
		return ubicacionBean;
	}

}
