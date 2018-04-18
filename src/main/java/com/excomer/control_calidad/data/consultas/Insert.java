/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.data.consultas;

import com.excomer.control_calidad.entity.Proveedor;
import data.conection.Persistence;

/**
 *
 * @author rodrigo
 */
public class Insert {
 
    private Persistence per;
    private boolean resultado = true;
    private Proveedor pro;
    
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
    
    
}
