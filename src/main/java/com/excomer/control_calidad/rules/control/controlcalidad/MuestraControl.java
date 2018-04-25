/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules.control.controlcalidad;

import com.excomer.control_calidad.data.consultas.Insert;
import com.excomer.control_calidad.data.consultas.ListaTabla;
import com.excomer.control_calidad.data.consultas.Select;
import com.excomer.control_calidad.entity.Muestra;
import com.excomer.control_calidad.entity.vistatabla.SeleccionMuestraVista;
import com.excomer.control_calidad.rules.ControlFecha;
import java.sql.SQLException;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class MuestraControl {
    
    private ListaTabla lt;
    private Muestra mue;
    private Insert in;
    private Select se;
    private int idnuevo = 0;
    private ControlFecha cf;
    
    @FXML
    private TableView<SeleccionMuestraVista> tbseleccion;

    @FXML
    private TableColumn<SeleccionMuestraVista, Integer> clid;

    @FXML
    private TableColumn<SeleccionMuestraVista, String> clnombre;

    @FXML
    private TableColumn<SeleccionMuestraVista, Double> clpeso;
    
    @FXML
    private TableColumn<SeleccionMuestraVista, Date> clfecha;

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
    
    
    @FXML
    private void initialize() throws SQLException{
        
        se = new Select();
        idnuevo = 0;
        idnuevo = se.getIdMuestra() + 1;
        txtid.setText(String.valueOf(idnuevo));
        
        Date fecha = new Date();
        cf = new ControlFecha();
        txtfecha.setValue(cf.fechaCorrecta(fecha));
 		
    
        lt = new ListaTabla();
            clid.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
           
            clnombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
            
            clpeso.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
            clfecha.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
            
            tbseleccion.setItems(lt.listaCompraMuestra());
            
            tbseleccion.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
                try {
                    if(newValue != null) {
                    txtreferencia.setText(String.valueOf(newValue.getId()));
                }
		
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error dentro de la tabla: " + e.getMessage());
                }
                
        });
    
    }
    
    public Muestra createMuestra(int id, int idreferencia, String nombre, Date fecha, Double tamano, String estado){
        
        mue = new Muestra(id, idreferencia, nombre, fecha, tamano, estado);
        return mue;
        
    }
    
    public void insert(){
        cf = new ControlFecha();
        in = new Insert();
        in.newMuestra(createMuestra(idnuevo, Integer.parseInt(txtreferencia.getText()), txtnombre.getText(), cf.getFecha(txtfecha.getValue()), Double.parseDouble(txttamano.getText()), "A"));
        idnuevo = idnuevo + 1;
        txtid.setText(String.valueOf(idnuevo));
    }
}
