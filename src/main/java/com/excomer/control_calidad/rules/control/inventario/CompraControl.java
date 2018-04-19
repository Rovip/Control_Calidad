/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules.control.inventario;

import com.excomer.control_calidad.entity.Calidad;
import com.excomer.control_calidad.entity.Compra;
import com.excomer.control_calidad.entity.Proveedor;
import com.excomer.control_calidad.entity.Tipo;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author rodrigo
 */
public class CompraControl {
    
    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtnumfactura;

    @FXML
    private ComboBox<Proveedor> txtproveedor;

    @FXML
    private ComboBox<Calidad> txtcalidad;

    @FXML
    private ComboBox<Tipo> txttipo;

    @FXML
    private TextField txtsacos;

    @FXML
    private TextField txtpeso;

    @FXML
    private TextField txtcosecha;

    @FXML
    private TextField txtubicacion;

    @FXML
    private DatePicker txtfecha;

    @FXML
    private TableView<Compra> tbcompra;

    @FXML
    private TableColumn<Compra, Integer> clid;

    @FXML
    private TableColumn<Compra, String> clnombre;

    @FXML
    private TableColumn<Compra, String> clproveedor;

    @FXML
    private TableColumn<Compra, Double> clsacos;

    @FXML
    private TableColumn<Compra, Double> clpeso;
    
}
