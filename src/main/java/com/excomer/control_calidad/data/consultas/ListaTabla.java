/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.data.consultas;

import com.excomer.control_calidad.entity.Proveedor;
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
    
    
    
}
