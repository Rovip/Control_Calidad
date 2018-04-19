/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.data.consultas;
import com.excomer.control_calidad.data.connection.Persistence;
import com.excomer.control_calidad.entity.Compra;
import com.excomer.control_calidad.entity.Proveedor;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class Select {
    
    private Persistence per;
    private ResultSet rs;
    private String sql = "";
    private Proveedor pro;
    private Compra com;
    private List<Proveedor> listaProveedor;
    private List<Compra> listaCompra;
    private int idactual;
    
    //Proveedor
    
    public Proveedor getProveedor(int id){
        
        try {
        
            per = new Persistence();
            rs = per.consult("SELECT id, nombre, representante, pais, ciudad, direccion, telefono, email, estado FROM inventario.proveedor WHERE id =" + id);
            while(rs.next()){
                pro = new Proveedor(rs.getInt("id"), rs.getString("nombre"), rs.getString("representante"), rs.getString("pais"), rs.getString("ciudad"), rs.getString("direccion"), rs.getInt("telefono"), rs.getString("email"), rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return pro;
    }
    
    public List<Proveedor> getProveedor(String condicion){
        
        String sql = " ";
        
        if(condicion.equals("T")){
            sql = "SELECT id, nombre, representante, pais, ciudad, direccion, telefono, email, estado FROM inventario.proveedor";
        }else if(condicion.equals("A")){
            sql = "SELECT id, nombre, representante, pais, ciudad, direccion, telefono, email, estado FROM inventario.proveedor WHERE estado = 'A'";
        }
        
        
        try {
            listaProveedor = new ArrayList<Proveedor>();
            per = new Persistence();
            rs = per.consult(sql);
            while(rs.next()){
                pro = new Proveedor(rs.getInt("id"), rs.getString("nombre"), rs.getString("representante"), rs.getString("pais"), rs.getString("ciudad"), rs.getString("direccion"), rs.getInt("telefono"), rs.getString("email"), rs.getString("estado"));
                listaProveedor.add(pro);
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return listaProveedor;
    }
    
    public int getIdProveedor(){
    
        try {
            idactual = 0;
            per = new Persistence();
            rs = per.consult("SELECT COUNT(id) as actual FROM inventario.proveedor");
            while(rs.next()){
              idactual = rs.getInt("actual");
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return idactual;
    }
    
    /* --- --- ---  Metodos Compra --- --- --- */
    
    
    public Compra getCompra(int id){
        
        try {
        
            per = new Persistence();
            rs = per.consult("SELECT id, numfactura, nombre, fecha, calidad, tipo, proveedor, sacos, peso, estado, cosecha, ubicacion FROM inventario.compra WHERE id =" + id);
            while(rs.next()){
                com = new Compra();
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return com;
    }
    
    public List<Compra> getCompra(String condicion){
        
        String sql = " ";
        
        if(condicion.equals("T")){
            sql = "SELECT id, nombre, representante, pais, ciudad, direccion, telefono, email, estado FROM inventario.proveedor";
        }else if(condicion.equals("A")){
            sql = "SELECT id, nombre, representante, pais, ciudad, direccion, telefono, email, estado FROM inventario.proveedor WHERE estado = 'A'";
        }
        
        
        try {
            listaCompra = new ArrayList<Compra>();
            per = new Persistence();
            rs = per.consult(sql);
            while(rs.next()){
                com = new Compra();
                listaCompra.add(com);
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return listaCompra;
    }
    
    public int getIdCompra(){
    
        try {
            idactual = 0;
            per = new Persistence();
            rs = per.consult("SELECT COUNT(id) as actual FROM inventario.compra");
            while(rs.next()){
              idactual = rs.getInt("actual");
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return idactual;
    }
}
