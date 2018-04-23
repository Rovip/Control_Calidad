/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules.control.controlcalidad;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author rodrigo
 */
public class MuestraControl {
    
    @FXML
    private TableView<?> tbseleccion;

    @FXML
    private TableColumn<?, ?> clid;

    @FXML
    private TableColumn<?, ?> clnombre;

    @FXML
    private TableColumn<?, ?> clpeso;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtreferencia;

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txttamano;

    @FXML
    private DatePicker txtfecha;

    @FXML
    private CheckBox chcompra;

    @FXML
    private CheckBox chmescla;

    @FXML
    private CheckBox chpatron;
    
}
