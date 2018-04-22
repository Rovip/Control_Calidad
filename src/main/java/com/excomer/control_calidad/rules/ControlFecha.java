/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author rodrigo
 */
public class ControlFecha {
    
    	public Date getFecha(LocalDate ld) {
		LocalDate localDate = ld;
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		return date;
	}
	
	public LocalDate getLocalDate(Date date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		LocalDate ld = LocalDate.parse(String.valueOf(date), formatter);
		return ld;
	}
	
	public LocalDate fechaCorrecta(Date fecha){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String oldDateString;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		oldDateString = sdf.format(fecha);
	    LocalDate localDate = LocalDate.parse(oldDateString, formatter);
	    return localDate;
	}
    
}
