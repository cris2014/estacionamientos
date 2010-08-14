/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.forms;

import java.util.ArrayList;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Jefferson
 */
public class RegistroReporteForm extends ActionForm{
    private String operacion;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String telefono;

    public ArrayList getLstEstacionamiento() {
        return lstEstacionamiento;
    }

    public void setLstEstacionamiento(ArrayList lstEstacionamiento) {
        this.lstEstacionamiento = lstEstacionamiento;
    }

    private ArrayList lstEstacionamiento;

    public String getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(String estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
    private String estacionamiento;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
}
