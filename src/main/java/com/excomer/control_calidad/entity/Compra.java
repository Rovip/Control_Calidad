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
public class Compra {
    
    //id, numfactura, nombre, fecha, calidad, tipo, proveedor, sacos, peso, estado, cosecha, ubicacion) 
        private IntegerProperty id;
        private IntegerProperty numfactura;
        private StringProperty nombre;
        private ObjectProperty<Date> fecha;
	private IntegerProperty proveedor;
	private IntegerProperty tipo;
	private IntegerProperty calidad;
	private DoubleProperty sacos;
        private DoubleProperty peso;
	private StringProperty estado;
        private StringProperty cosecha;
        private StringProperty ubicacion;
        
	
	public Compra() {
		
	}
	
	public Compra(int id, int numfactura, String nombre, int proveedor, int tipo, int calidad, Double sacos, Double peso,Date fecha, String estado, String cosecha, String ubicacion) {
		this.id=new SimpleIntegerProperty(id);
		this.proveedor=new SimpleIntegerProperty(proveedor);
		this.tipo=new SimpleIntegerProperty(tipo);
		this.calidad=new SimpleIntegerProperty(calidad);
		this.sacos=new SimpleDoubleProperty(sacos);
		this.fecha = new SimpleObjectProperty<Date>(fecha);
		this.estado = new SimpleStringProperty(estado);
                this.numfactura = new SimpleIntegerProperty(numfactura);
                this.nombre = new SimpleStringProperty(nombre);
                this.peso=new SimpleDoubleProperty(peso);
                this.cosecha = new SimpleStringProperty(cosecha);
                this.ubicacion = new SimpleStringProperty(ubicacion);
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
	public int getNumFactura() {
		return id.get();
	}
	public void setNumFactura(int numfactura) {
		this.numfactura.set(numfactura);
	}
	public IntegerProperty numFacturaProperty() {
        return numfactura;
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
	
	//Propiedades Proveedor
	public int getProveedor() {
		return proveedor.get();
	}
	public void setProveedor(int proveedor) {
		this.proveedor.set(proveedor);
	}
	public IntegerProperty proveedorProperty() {
        return proveedor;
    }
	
	//Propiedades Tipo
	public int getTipo() {
		return tipo.get();
	}
	public void setTipo(int tipo) {
		this.tipo.set(tipo);
	}
	public IntegerProperty tipoProperty() {
        return tipo;
    }
	
	//Propiedades Calidad
	public int getCalidad() {
		return calidad.get();
	}
	public void setCalidad(int calidad) {
		this.calidad.set(calidad);
	}
	public IntegerProperty calidadProperty() {
        return calidad;
    }
	
	//Propiedades sacos
	
	public Double getSacos() {
		return sacos.get();
	}
	public void setSacos(Double sacos) {
		this.sacos.set(sacos);
	}
	public DoubleProperty sacosProperty() {
        return sacos;
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
        
        //Propiedades ubicacion
	public String getUbicacion() {
		return ubicacion.get();
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion.set(ubicacion);
	}
	public StringProperty ubicacionProperty() {
        return ubicacion;
    }
        
        //Propiedades ubicacion
	public String getCosecha() {
		return cosecha.get();
	}
	public void setCosecha(String cosecha) {
		this.cosecha.set(cosecha);
	}
	public StringProperty cosechaProperty() {
        return cosecha;
    }
        
        
	

}
