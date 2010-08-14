/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.bean;

import java.io.Serializable;

/**
 *
 * @author pcruces
 */
public class UsuarioBean implements Serializable{
   private String user;
   private String pwd;
   
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}
