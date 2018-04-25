/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.entity.vistatabla;

import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author rodrigo
 */
public class SeleccionMuestraVista {
    
    
  private IntegerProperty id;
  private StringProperty nombre;
  private DoubleProperty peso;
  private ObjectProperty<Date> fecha;
  
  
  public SeleccionMuestraVista() {}
  
  public SeleccionMuestraVista(int id, String nombre, Double peso, Date fecha) {
      
      
        this.id=new SimpleIntegerProperty(id); 
	this.fecha = new SimpleObjectProperty<Date>(fecha);
	this.nombre = new SimpleStringProperty(nombre);
        this.peso=new SimpleDoubleProperty(peso);
                
  
  }
  
  
  //Propiedades ID
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id.set(id);
	}
	public IntegerProperty idProperty() {
        return id;
    }
        
    //Nombre
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	public StringProperty nombreProperty() {
        return nombre;
    }
        
    public Double getPeso() {
		return peso.get();
	}
	public void setPeso(Double peso) {
		this.peso.set(peso);
	}
	public DoubleProperty pesoProperty() {
        return peso;
    }
        
    //Propiedades pergamino
	public Date getFecha() {
		return fecha.get();
	}
	public void setFecha(Date fecha) {
		this.fecha.set(fecha);;
	}
	public ObjectProperty<Date> fechaProperty() {
        return fecha;
    }
  
	
       
    
}
