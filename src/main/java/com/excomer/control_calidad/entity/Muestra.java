/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.entity;

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
public class Muestra {
    
    private IntegerProperty id;
    private IntegerProperty idreferencia;
    private StringProperty nombre;
    private ObjectProperty<Date> fecha;
    private DoubleProperty tamano;
    private StringProperty estado;
    
public Muestra() {}

public Muestra(int id, int idreferencia, String nombre, Date fecha, Double tamano, String estado) {
    
    this.id=new SimpleIntegerProperty(id);	
    this.fecha = new SimpleObjectProperty<Date>(fecha);
    this.estado = new SimpleStringProperty(estado);
    this.idreferencia = new SimpleIntegerProperty(idreferencia);
    this.nombre = new SimpleStringProperty(nombre);
    this.tamano = new SimpleDoubleProperty(tamano);
                

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
        
        //Propiedades NUm Factura
	public int getIdReferencia() {
		return idreferencia.get();
	}
	public void setIdReferencia(int idreferencia) {
		this.idreferencia.set(idreferencia);
	}
	public IntegerProperty idreFerenciaProperty() {
        return idreferencia;
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
        
    public Double getTamano() {
		return tamano.get();
	}
	public void setTamano(Double tamano) {
		this.tamano.set(tamano);
	}
	public DoubleProperty tamanoProperty() {
        return tamano;
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
	
	//Propiedades estado
	public String getEstado() {
		return estado.get();
	}
	public void setEstado(String estado) {
		this.estado.set(estado);
	}
	public StringProperty estadoProperty() {
        return estado;
    }
  
    
}
