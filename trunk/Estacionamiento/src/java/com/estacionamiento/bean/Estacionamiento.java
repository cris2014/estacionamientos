/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.bean;

/**
 *
 * @author jcastro
 */
public class Estacionamiento {

    private Integer codigo;
    private String nombre;
    private String distrito;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String direccion;

}
