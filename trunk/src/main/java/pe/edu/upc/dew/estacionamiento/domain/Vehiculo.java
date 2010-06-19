/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.estacionamiento.domain;

/**
 *
 * @author jcastro
 */
public class Vehiculo {

    private Integer numeroplaca;
     private String modelo;
     private String marca;
     private String color;

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

    public Integer getNumeroplaca() {
        return numeroplaca;
    }

    public void setNumeroplaca(Integer numeroplaca) {
        this.numeroplaca = numeroplaca;
    }

}
