/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules.control;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author rodrigo
 */
public class MainControl {
    
    @FXML
    private Button pro;
    
    @FXML
    private BorderPane centro;

    
    public void loadProveedor() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("/fxml/inventario/newproveedor.fxml"));
	BorderPane datos = loader.load();
	centro.setCenter(datos);
    }
    
    public void loadCompra() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("/fxml/inventario/newcompra.fxml"));
	BorderPane datos = loader.load();
	centro.setCenter(datos);
    }
    
}
