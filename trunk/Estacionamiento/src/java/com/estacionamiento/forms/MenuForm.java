/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estacionamiento.forms;

import org.apache.struts.action.ActionForm;
/**
 *
 * @author iluna
 */
public class MenuForm extends ActionForm{
   private String operacion=null;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}