/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules.control.inventario;

import com.excomer.control_calidad.data.consultas.Insert;
import com.excomer.control_calidad.data.consultas.ListaTabla;
import com.excomer.control_calidad.data.consultas.Select;
import com.excomer.control_calidad.entity.Proveedor;
import com.excomer.control_calidad.rules.NumerosControl;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Cell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class ProveedorControl {
    
    private Select se;
    private Insert in;
    private Proveedor pro;
    private int idnuevo;
    private ListaTabla lt;
    private NumerosControl nc;
    
    /*    TextFields   */
    
    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtrepresentante;

    @FXML
    private TextField txttelefono;

    @FXML
    private TextField txtpais;

    @FXML
    private TextField txtciudad;

    @FXML
    private TextField txtdireccion;

    @FXML
    private TextField txtemail;
    
    
    /* Tabla y Columnas */
    
    @FXML
    private TableView<Proveedor> tbproveedor;

    @FXML
    private TableColumn<Proveedor, Integer> clid;

    @FXML
    private TableColumn<Proveedor, String> clnombre;

    @FXML
    private TableColumn<Proveedor, String> clrepresentante;

    @FXML
    private TableColumn<Proveedor, String> clpais;

    @FXML
    private TableColumn<Proveedor, String> clciudad;

    @FXML
    private TableColumn<Proveedor, String> cldireccion;

    @FXML
    private TableColumn<Proveedor, Integer> cltelefono;

    @FXML
    private TableColumn<Proveedor, String> clemail;

    @FXML
    private TableColumn<Proveedor, String> clestado;
        
        @FXML
	private void initialize() throws SQLException{
        
            se = new Select();
            idnuevo = 0;
            idnuevo = se.getIdProveedor() + 1;
            txtid.setText(String.valueOf(idnuevo));
            
            /*Datos Para ver la tabla*/
            //Tabla
		lt = new ListaTabla();
		
                 
		 clnombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
                 clrepresentante.setCellValueFactory(cellData -> cellData.getValue().representanteProperty());
                 clpais.setCellValueFactory(cellData -> cellData.getValue().paisProperty());
                 clciudad.setCellValueFactory(cellData -> cellData.getValue().ciudadProperty());
                 cldireccion.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
                 cltelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty().asObject());
                 clemail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
                 clestado.setCellValueFactory(cellData -> cellData.getValue().estadoProperty());
                 clid.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
                 tbproveedor.setItems(lt.listaProveedor());
		
		
            
            
            
            
        }
        
        public void insert(){
        
        in = new Insert();
        nc = new NumerosControl();
        
        try {
            if(!txtnombre.getText().isEmpty()){
              
                      
                       pro = new Proveedor(Integer.parseInt(txtid.getText()), txtnombre.getText(), txtrepresentante.getText(), txtpais.getText(), txtciudad.getText(), txtdireccion.getText(), Integer.parseInt(txttelefono.getText()), txtdireccion.getText(), txtemail.getText());
                       in.newProveedor(pro);
                       idnuevo = idnuevo + 1;
                       txtid.setText(String.valueOf(idnuevo));
                       System.out.println("Proveedor ingresado exitosamente");
                       tbproveedor.setItems(lt.listaProveedor());
                       System.out.println("Tabla Actualizada");
                    
                  
                
               
            }else{
                System.out.println("---------Error, NO debe dejar vacio el campo nombre-------------");
            
            }
        } catch (Exception e) {
            System.out.println("---------Error-------------");
            System.out.println(e.getCause());
            
        }
        
    }
    
        public void insert1(){
        JOptionPane.showMessageDialog(null, txtnombre.getText());
        }
    
}
