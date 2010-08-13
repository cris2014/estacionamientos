/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.dao;

import java.sql.*;


public class ConexionDAO {
    public static Connection conn = null;
    public static ConexionDAO instance = null;

    public static ConexionDAO getInstance()throws Exception{
		if (instance == null){
			instance = new ConexionDAO();
		}
		return instance;
    }
    
    public Connection getConnection(){

       String cadena;
       String url = "jdbc:mysql:localhost:3306/ESTACIONAMIENTO";
       try{

           //String driver = "org.gjt.mm.mysql.Driver";
           String driver = "com.mysql.jdbc.Driver";

           // Aquí se registra el driver de la base de datos
          Class.forName(driver).newInstance();
          //Class.forName("com.mysql.jdbc.Driver").newInstance();

      }catch (Exception e){
          // Ocurrió un error al registrar el driver
         System.out.println("No se pudo cargar el driver PostgreSQL.");
         e.printStackTrace();
      }
       try{
            // De esta forma se obtiene la conexión
            //con = DriverManager.getConnection(url,"sa","sa");
             conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1/ESTACIONAMIENTO?user=root&password=40292950");

            System.out.println("Conexión establecida.");

       }catch (SQLException sqle){
              // Ocurrió un error con la base de datos (conexión o consulta)
              System.out.println("Error con la base de datos:");
              sqle.printStackTrace();
      }
      return conn;
    }


	public void close()throws Exception{
		try {
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
