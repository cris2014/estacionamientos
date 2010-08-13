/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Fecha {

	public static final int NUM_ANOS_ANTES = 5;
	public static final int NUM_ANOS_DESPUES = 2;
	//public static final String FORMATO_DATE_DB2 = "MM/dd/yy";

	public static Fecha instance = null;

	public static Fecha getInstance(){
		if (instance == null){
			instance = new Fecha();
		}
		return instance;
	}

	public Date getToday(){
		Date fecha = new Date();
		return new Date(fecha.getTime());
	}

	public Time getNow(){
		Date fecha = new Date();
		return new Time(fecha.getTime());
	}


	public static String getFormattedDate(Date d, String format) {
		if ( format==null || d==null )
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}


	private static Date transformarFechaSQLaUtil(java.sql.Date fechaSQL){
		Date fechaUtil=new Date();
		fechaUtil.setDate(fechaSQL.getDate());
		fechaUtil.setMonth(fechaSQL.getMonth());
		fechaUtil.setYear(fechaSQL.getYear());
		return fechaUtil;
	}

	public static String getFormattedDateSQL(java.sql.Date d, String format) {
		if ( format==null || d==null )
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date fechaUtil=transformarFechaSQLaUtil(d);
		return sdf.format(fechaUtil);
	}

	public static List getListaAnos(int iAnoIni){
		int iAnoActual = Calendar.getInstance().get( Calendar.YEAR );

		return getListaAnos(iAnoIni, iAnoActual);
	}

	public static List getListaAnosVigentes(){
		int iAnoActual = Calendar.getInstance().get( Calendar.YEAR );

		return getListaAnos(iAnoActual-NUM_ANOS_ANTES, iAnoActual+NUM_ANOS_DESPUES);
	}

	public static List getListaAnosVigentes2(){
		ArrayList listaAnos = new ArrayList();
		int iAnoActual = Integer.parseInt(Fecha.getFormattedDate(new Date(),"yyyy"));
		for (int i = iAnoActual; i >= iAnoActual-NUM_ANOS_ANTES; i--){
			listaAnos.add(String.valueOf(i));
		}
		return listaAnos;
	}

	public static List getListaAnos(int desde, int hasta) {
		ArrayList listaAnos = new ArrayList();

		int iAnoActual = Integer.parseInt(Fecha.getFormattedDate(new Date(),"yyyy"));

		for (int i=desde; i<=hasta; i++)
			listaAnos.add( String.valueOf(i) );

		return listaAnos;
	}

	public static Date getDateFromString(String s, String format) {
		Date nuevaFecha;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try{
			nuevaFecha = sdf.parse(s);
		}catch(Exception e){
			nuevaFecha = Fecha.getInstance().getToday();
		}
		return nuevaFecha;
	}

	public static String getAbreviaturaMes(int numeroMes) {
		switch(numeroMes){
			case 1:
				return "ENE";
			case 2:
				return "FEB";
			case 3:
				return "MAR";
			case 4:
				return "ABR";
			case 5:
				return "MAY";
			case 6:
				return "JUN";
			case 7:
				return "JUL";
			case 8:
				return "AGO";
			case 9:
				return "SET";
			case 10:
				return "OCT";
			case 11:
				return "NOV";
			case 12:
				return "DIC";
			default:
				return "";
		}
	}

	public static short getDiferenciaDias(long tiempoInicial){
		//long tiempoFinal = java.util.Calendar.getInstance().getTime().getTime();
		//long resta= tiempoFinal - tiempoInicial;
		//double diasRestantes = 1;
		//diasRestantes = Math.floor(resta/(1000 * 60 * 60 * 24));
		//short diasRestan = (short)diasRestantes;
		return (short)(Math.floor((( java.util.Calendar.getInstance().getTime().getTime()) - tiempoInicial)/(1000 * 60 * 60 * 24)));
	}

}





