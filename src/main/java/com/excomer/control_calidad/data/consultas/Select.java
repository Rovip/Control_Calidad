/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.data.consultas;
import com.excomer.control_calidad.data.connection.Persistence;
import com.excomer.control_calidad.entity.Compra;
import com.excomer.control_calidad.entity.Proveedor;
import com.excomer.control_calidad.entity.TablaGenerica;
import com.excomer.control_calidad.entity.vistatabla.CompraVistaTabla;


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
    private CompraVistaTabla cvt;
    private List<Proveedor> listaProveedor;
    private List<Compra> listaCompra;
    private List<TablaGenerica> listatbg;
    private List<CompraVistaTabla> listaCompraVistaTabla;
    private int idactual;
    
    
    private String select, from, where;
    
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
    
    
    public List<TablaGenerica> obtenerObjetoProveedor(){
		try {
			listatbg = new ArrayList<TablaGenerica>();
			per = new Persistence();
                        rs = per.consult("SELECT id, nombre, estado FROM inventario.proveedor");
			while(rs.next()) {
				listatbg.add(new TablaGenerica(rs.getInt("id"), rs.getString("nombre"), "Nada", rs.getString("estado")));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
			
		}
		return listatbg;
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
    
    public List<CompraVistaTabla> getCompra(String condicion){
        
        select = "SELECT c.id as id, c.numfactura as numfactura, c.nombre as nombre, c.fecha as fecha, ca.nombre as calidad, t.nombre as tipo, p.nombre as proveedor, c.sacos as sacos, c.peso as peso, c.estado as estado, c.cosecha as cosecha, c.ubicacion as ubiacion ";
        from = "FROM inventario.compra as c JOIN inventario.proveedor as p ON (c.proveedor = p.id) JOIN calidad.tipo t ON (c.tipo = t.id) JOIN calidad.calidad ca ON (c.calidad = ca.id) ";
        
        
        
        
        if(condicion.equals("T")){
            where = ";";
        }else if(condicion.equals("A")){
            where = "WHERE c.estado = '" + condicion + "';";
        }
        
        
        try {
            listaCompraVistaTabla = new ArrayList<CompraVistaTabla>();
            per = new Persistence();
            rs = per.consult(select + from + where);
            while(rs.next()){
               cvt = new CompraVistaTabla(rs.getInt("id"), rs.getInt("numfactura"), rs.getString("nombre"), rs.getString("proveedor"), rs.getString("tipo"), rs.getString("calidad"), rs.getDouble("sacos"), rs.getDouble("peso"), rs.getDate("fecha"), rs.getString("estado"), rs.getString("cosecha"), rs.getString("ubicacion"));
                listaCompraVistaTabla.add(cvt);
            }
        } catch (Exception e) {
            System.out.println("********* ERROR ************");
            System.out.println(e.getMessage());
            System.out.println("********* ERROR ************");
        }
        
        return listaCompraVistaTabla;
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
    
    //Metodos para la tabla calidad
    
	
	public List<TablaGenerica> obtenerObjetoCalidad(){
		try {
			listatbg = new ArrayList<TablaGenerica>();
			per = new Persistence();
                        rs = per.consult("SELECT id, nombre, descripcion, estado FROM calidad.calidad");
			while(rs.next()) {
				listatbg.add(new TablaGenerica(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("estado")));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
			
		}
		return listatbg;
	}
        
        //Metodos para la tabla Tipo
    
	
	public List<TablaGenerica> obtenerObjetoTipo(){
		try {
			listatbg = new ArrayList<TablaGenerica>();
			per = new Persistence();
                        rs = per.consult("SELECT id, nombre, descripcion, estado FROM calidad.tipo");
			while(rs.next()) {
				listatbg.add(new TablaGenerica(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("estado")));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
			
		}
		return listatbg;
	}
}
