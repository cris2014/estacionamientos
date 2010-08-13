/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.dao;

import java.sql.*;


public class Coneccion {
    public static void main(String args[]){

       String cadena;
      // Definición del URL necesario para accesar la base de datos
      String url = "jdbc:mysql:localhost:3306/ESTACIONAMIENTO";
      Connection conn = null;
      try{
          // Definición del nombre COMPLETO de la clase que sirve como driver
          String driver = "org.gjt.mm.mysql.Driver";
          // Aquí se registra el driver de la base de datos
          //Class.forName(driver).newInstance();
          Class.forName("com.mysql.jdbc.Driver").newInstance();

      }catch (Exception e){
          // Ocurrió un error al registrar el driver
         System.out.println("No se pudo cargar el driver PostgreSQL.");
         e.printStackTrace();
         return;
      }

       try{
            // De esta forma se obtiene la conexión
            //con = DriverManager.getConnection(url,"sa","sa");
             conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1/ESTACIONAMIENTO?user=root&password=sa");



            System.out.println("Conexión establecida.");
            Statement select = null;
            ResultSet result = null;
            try{
               // Primero se debe crear un Statement ligado a la conexión
              select = conn.createStatement();
              // Después, se ejecuta la consulta utilizando ese Statement
              //CONSULTA
              System.out.println(" Mostrar usuarios y pass:\n");
              result = select.executeQuery("select * from usuario");
              while (result.next()){ // Mientras se pueda seguir avanzando
                     cadena = result.getString(1); // Valor de columna 1 como cadena
                   if (result.wasNull()){
                       cadena = null;
                   }
                   // Aquí se imprimen los resultados:
                   System.out.println("Usuario ==== " + cadena);
              }

       }
 finally {
         if (result != null){
             result.close();
         }
         if (select != null){
             select.close();
         }
       }
}catch (SQLException sqle){
     // Ocurrió un error con la base de datos (conexión o consulta)
       System.out.println("Error con la base de datos:");
       sqle.printStackTrace();
}finally{
// Por último, se debe asegurar el cierre de la conexión
if (conn != null)
{
try
{
conn.close();
System.out.println("Conexion terminada.");
}
catch (SQLException sqle)
{
sqle.printStackTrace();
}
}
}
}

}
