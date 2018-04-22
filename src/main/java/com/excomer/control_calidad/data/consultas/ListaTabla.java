/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.data.consultas;

import com.excomer.control_calidad.entity.Compra;
import com.excomer.control_calidad.entity.Proveedor;
import com.excomer.control_calidad.entity.vistatabla.CompraVistaTabla;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rodrigo
 */
public class ListaTabla {
    
     private ObservableList<Proveedor> datoProveedor;
     private List<Proveedor> listaProveedor;
     
     private ObservableList<Compra> datoCompra;
     private List<Compra> listaCompra;
     
     private ObservableList<CompraVistaTabla> datoCompraVistaTabla;
     private List<CompraVistaTabla> listaCompraVistaTabla;
     
     private Select se;
     private Insert in;
    
    
    public  ObservableList<Proveedor> listaProveedor() throws SQLException {
		 se = new Select();
		 datoProveedor = FXCollections.observableArrayList();
                 listaProveedor = se.getProveedor("T");
		 
		 for(int i = 0; i < listaProveedor.size(); i++){
			 datoProveedor.add(listaProveedor.get(i));
		 }
		 return datoProveedor;
	 }
    
    /*
    * Metodos para las tablas de compras
    */
    
    //Vista para ver la tabla sin cambios
    
    
    //VIsta para ver tabla con mas detalles, nombres etc.
    
    public ObservableList<CompraVistaTabla> listaCompraNombres() throws SQLException {
                se = new Select();
                datoCompraVistaTabla = FXCollections.observableArrayList();
                listaCompraVistaTabla = se.getCompra("T");
                
                for(int i = 0; i < listaCompraVistaTabla.size(); i++){
                        datoCompraVistaTabla.add(listaCompraVistaTabla.get(i));
                }
                
                return datoCompraVistaTabla;
        
    }
    
    public ObservableList<Compra> listaCompraNombresAdd(List<Compra> cmp) throws SQLException {
                datoCompra = FXCollections.observableArrayList();
                listaCompra = cmp;
                
                for(int i = 0; i < listaCompra.size(); i++){
                        datoCompra.add(listaCompra.get(i));
                }
                
                return datoCompra;
        
    }
    
    
    
}
