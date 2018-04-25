/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.data.consultas;

import com.excomer.control_calidad.data.connection.Persistence;
import com.excomer.control_calidad.entity.Compra;
import com.excomer.control_calidad.entity.Muestra;
import com.excomer.control_calidad.entity.Proveedor;


/**
 *
 * @author rodrigo
 */
public class Insert {
 
    private Persistence per;
    private boolean resultado = true;
    private Proveedor pro;
    private Compra com;
    private Muestra mue;
    
    /* Proveedor */
    
    public void newProveedor(Proveedor proveedor){
        pro = proveedor;
       
        try {
            per = new Persistence();
            per.persist("INSERT INTO inventario.proveedor(id, nombre, representante, pais, ciudad, direccion, telefono, email, estado) VALUES (" + pro.getId() + ", '" +  pro.getNombre() + "', '" + pro.getRepresentante() + "', '" + pro.getPais() + "', '" + pro.getCiudad() + "', '" + pro.getDireccion() + "', " + pro.getTelefono() + ", '" + pro.getEmail() + "', " + " 'A');");
            
        } catch (Exception e) {
            System.out.println("/*/*/*/ Error");
            System.out.println(e.getMessage());
            
        }
    }
    
    public void newCompra(Compra compra) {
        com = compra;
        
        try {
            per = new Persistence();
            per.persist("INSERT INTO inventario.compra(id, numfactura, nombre, fecha, calidad, tipo, proveedor, sacos, peso, estado, cosecha, ubicacion) VALUES (" + com.getId() +", " +com.getNumFactura() +", '"+ com.getNombre() +"', '" +com.getFecha() +"', " +com.getCalidad() +", " +com.getTipo() +", " +com.getProveedor() +", " +com.getSacos()+ ", " +com.getPeso()+ ", 'A ', '"+ com.getCosecha()+"', '"+ com.getUbicacion()+"');");
        } catch (Exception e) {
            
            System.out.println("/*/*/*/ Error");
            System.out.println(e.getMessage());
        }
    }
    
    public void newMuestra(Muestra muestra) {
    
        mue = muestra;
        
        try {
            per = new Persistence();
            per.persist("INSERT INTO calidad.muestracompra(id, idcompra, nombre, fecha, tamano, estado) VALUES (" + mue.getId() +","+ mue.getIdReferencia() +",'"+ mue.getNombre() +"','"+ muestra.getFecha() +"',"+ mue.getTamano() +",'"+ mue.getEstado() + "');");
        } catch (Exception e) {
            
             System.out.println("/*/*/*/ Error");
            System.out.println(e.getMessage());
        }
    
    }
    
    
}
