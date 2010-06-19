/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.estacionamiento.domain;

import java.util.Date;

/**
 *
 * @author jcastro
 */
public class Ticket {

    private Integer numeroticket;
    private String fechaingreso;
    private String fechasalida;
    private Vehiculo vehiculo;
    private Locacion locacion;

    public Integer getNumeroticket() {
        return numeroticket;
    }

    public void setNumeroticket(Integer numeroticket) {
        this.numeroticket = numeroticket;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }



    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }


    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Integer getNumero() {
        return numeroticket;
    }

    public void setNumero(Integer numero) {
        this.numeroticket = numeroticket;
    }




}
