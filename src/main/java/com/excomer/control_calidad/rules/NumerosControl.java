/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules;

/**
 *
 * @author rodrigo
 */
public class NumerosControl {
    
    public boolean isNumeric(String cadena){
    	try {
    		Double.parseDouble(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
}
