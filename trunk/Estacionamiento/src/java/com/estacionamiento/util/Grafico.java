/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.util;
import java.awt.Color;  

import java.io.File;  

import java.io.IOException;  


import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PiePlot3D;  
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset;  

 

public class Grafico {
    private static final long serialVersionUID =1L;// -8625975218180144099L;

    private String nombre1="";
    private String texto1="";
    private String texto2="";

    private int valor1=0;
    private int valor2=0;

    public void setValores(int valor1,int valor2,String nombre){
        this.texto1="Ocupado "+valor1;
        this.texto2="Disponible "+valor2;
        this.valor1=valor1;
        this.valor2=valor2;
        this.nombre1=nombre;
    }


    public PieDataset createPieDataSet() {

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue(texto1,valor1);
        pieDataset.setValue(texto2,valor2);
        //pieDataset.setValue("Ocupado", 950);
        //pieDataset.setValue("Disponible", 50);

        return pieDataset;

    }

   
     public JFreeChart create3DPieChart(PieDataset dataset) {  

        JFreeChart chart = ChartFactory.createPieChart3D(
        nombre1, dataset, true, true, true);
   

        PiePlot3D p = (PiePlot3D) chart.getPlot();

        p.setForegroundAlpha(0.5f);

        p.setBackgroundAlpha(0.2f);

        chart.setBackgroundPaint(Color.white);

        chart.setAntiAlias(true);

        chart.setBorderVisible(true);

        return chart;
     }  

   

    public void saveChart(JFreeChart chart, String fileLocation) {  

        String fileName = fileLocation;

        try {
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart,440,340);

        } catch (IOException e) {

            e.printStackTrace();

            System.err.println("Problem occurred creating chart.");

        }

    }
    
}
