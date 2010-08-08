/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.tdd;

import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author u913970
 */
public class CalculadoraTest {
    @Test
    public void testSumar(){
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.sumar(3,2);
        Assert.assertEquals(5, resultado);

        //prueba HOY 08/08/10

        // otra prueba

    }

}
