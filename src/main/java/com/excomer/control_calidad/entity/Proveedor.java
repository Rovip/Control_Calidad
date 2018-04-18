/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.entity;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author rodrigo
 */
public class Proveedor {
    
        private IntegerProperty id;
	private StringProperty nombre;
	private StringProperty representante;
        private IntegerProperty telefono;
        private StringProperty pais;
        private StringProperty ciudad;
	private StringProperty direccion;
        private StringProperty email;
	private StringProperty estado;
        
	
	

	public Proveedor() {
		
	}
	
	public Proveedor(int id, String nombre, String representante, String pais, String ciudad, String direccion, int telefono, String email, String estado) {
		this.id= new SimpleIntegerProperty(id);
		this.nombre = new SimpleStringProperty(nombre);
		this.representante=new SimpleStringProperty(representante);
                this.telefono= new SimpleIntegerProperty(telefono);
                this.pais=new SimpleStringProperty(pais);
                this.ciudad=new SimpleStringProperty(ciudad);
		this.direccion=new SimpleStringProperty(direccion);
                this.email=new SimpleStringProperty(email);
		this.estado = new SimpleStringProperty(estado);
	}
	
	//id
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
	
	//Representante0
	public String getRepresentante() {
		return representante.get();
	}
	public void setRepresentante(String representante) {
		this.representante.set(representante);
	}
	
	public StringProperty representanteProperty() {
        return representante;
    }
        
        //telefono
	public int getTelefono() {
		return telefono.get();
	}
	public void setTelefono(int telefono) {
		this.telefono.set(telefono);
	}
	public IntegerProperty telefonoProperty() {
        return telefono;
    }
        
        //pais
	public String getPais() {
		return pais.get();
	}
	public void setPais(String pais) {
		this.pais.set(pais); 
	}
	
	public StringProperty paisProperty() {
        return pais;
    }
	
	//ciudad
	public String getCiudad() {
		return ciudad.get();
	}
	public void setCiudad(String ciudad) {
		this.ciudad.set(ciudad); 
	}
	
	public StringProperty ciudadProperty() {
        return ciudad;
    }
        
        
	//Direccion
	public String getDireccion() {
		return direccion.get();
	}
	public void setDireccion(String direccion) {
		this.direccion.set(direccion); 
	}
	
	public StringProperty direccionProperty() {
        return direccion;
    }
        
        //Email
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email); 
	}
	
	public StringProperty emailProperty() {
        return email;
    }
	

	//Estado
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
