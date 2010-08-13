/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.dao;

import com.estacionamiento.bean.VehiculoBean;
import java.sql.*;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


public class VehiculoDAO {

	public void registrarVehiculo(VehiculoBean vehiculo,ActionErrors errors){

                Connection con = null;
                PreparedStatement ps=null;
                ResultSet rs = null;
                String cadena;

		try {
                       
                       con=ConexionDAO.getInstance().getConnection();

                       ps=con.prepareStatement("insert into estacionamiento.vehiculo " +
                               " (NU_PLACA,NO_MODELO,CO_MARCA,CO_COLOR,CO_USUARIO ) " +
				" values(?,?,?,?,?)");

                       ps.setString(1,vehiculo.getPlaca());
		       ps.setString(2,vehiculo.getModelo());
                       ps.setInt(3,new Integer(vehiculo.getMarca()).intValue());
                       ps.setInt(4,new Integer(vehiculo.getColor()).intValue());
                       ps.setString(5,vehiculo.getUsuario().getCodigo());

                       ps.executeUpdate();

                       System.out.println(" Registro Correctamente:\n");


		} catch (Exception e) {
			e.printStackTrace();
                        errors.add("error.registrar.vehiculo", new ActionMessage("error.registrar.vehiculo"));
 		}finally{
                        try{
                           ConexionDAO.getInstance().close();
                        }catch(Exception ef){}
                }

	}
}
