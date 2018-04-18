/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author rodrigo
 */
public class MainApp extends Application{
        private Stage primaryStage;
	private static BorderPane mainLayout;
    @FXML
    private BorderPane centro;
   
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
	this.primaryStage.setTitle("ExcomerCafe");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/main.fxml"));
        mainLayout = loader.load();
	Scene scene = new Scene(mainLayout);
	primaryStage.setScene(scene);
	primaryStage.show();
}
    public static void main(String[] args){
        launch(args);
    }
    
    
}
