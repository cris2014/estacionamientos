/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.bean;

/**
 *
 * @author jcastro
 */
public class Usuario {
        private String codigo;
        private String clave;
	private String  nombre;
        private String  apellido;
        private Integer celular;
        private String  tipousuario;

    public Usuario(){
         
     }
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

}
