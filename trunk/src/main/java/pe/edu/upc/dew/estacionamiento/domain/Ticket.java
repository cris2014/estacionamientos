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
