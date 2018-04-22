/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excomer.control_calidad.rules.control.inventario;

import com.excomer.control_calidad.data.consultas.ListaTabla;
import com.excomer.control_calidad.data.consultas.Select;
import com.excomer.control_calidad.entity.Compra;
import com.excomer.control_calidad.entity.TablaGenerica;
import com.excomer.control_calidad.entity.vistatabla.CompraVistaTabla;
import com.excomer.control_calidad.rules.ControlFecha;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

/**
 *
 * @author rodrigo
 */
public class CompraControl {
    
    private Compra com;
    private List<Compra> lcom;
    private ListaTabla lt;
    private Select se;
    private ControlFecha cf;
    private int idnuevo = 0;
    
    
    
    @FXML
    private TableView<CompraVistaTabla> tbcompra;

    @FXML
    private TableColumn<CompraVistaTabla, Integer> clid;

    @FXML
    private TableColumn<CompraVistaTabla, Integer> clfactura;

    @FXML
    private TableColumn<CompraVistaTabla, String> clnombre;

    @FXML
    private TableColumn<CompraVistaTabla, String> clproveedor;

    @FXML
    private TableColumn<CompraVistaTabla, String> clcalidad;

    @FXML
    private TableColumn<CompraVistaTabla, String> cltipo;

    @FXML
    private TableColumn<CompraVistaTabla, Double> clsacos;

    @FXML
    private TableColumn<CompraVistaTabla, Double> clpeso;

    @FXML
    private TableColumn<CompraVistaTabla, String> clubicacion;

    @FXML
    private TableColumn<CompraVistaTabla, String> clcosecha;

    @FXML
    private TableColumn<CompraVistaTabla, Date> clfecha;

    @FXML
    private TableColumn<CompraVistaTabla, String> clestado;

    @FXML
    private TextField txtid;

    @FXML
    private ComboBox<TablaGenerica> comboproveedor;

    @FXML
    private DatePicker txtfecha;

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtfactura;

    @FXML
    private ComboBox<TablaGenerica> combocalidad;

    @FXML
    private ComboBox<TablaGenerica> combotipo;

    @FXML
    private TextField txtsacos;

    @FXML
    private TextField txtpeso;

    @FXML
    private TextField txtcosecha;

    @FXML
    private TextField txtubicacion;

    @FXML
    private TableView<Compra> tbcompraactual;

    @FXML
    private TableColumn<Compra, Integer> clidactual;

    @FXML
    private TableColumn<Compra, Double> clsacosactual;

    @FXML
    private TableColumn<Compra, Double> clqqactual;

    @FXML
    private TextField txttotalsacos;

    @FXML
    private TextField txttotalquintales;

    @FXML
    private TableView<CompraVistaTabla> tbvistacompra;

    @FXML
    private TableColumn<CompraVistaTabla, Integer> clvistaid;

    @FXML
    private TableColumn<CompraVistaTabla, String> clvistanombre;

    @FXML
    private TableColumn<CompraVistaTabla, String> clvistaproveedor;

    @FXML
    private TableColumn<CompraVistaTabla, Double> clvistasacos;

    @FXML
    private TableColumn<CompraVistaTabla, Double> clvistapesos;
    
    @FXML
    private void initialize() throws SQLException{
        
                se = new Select();
            idnuevo = 0;
            idnuevo = se.getIdCompra() + 1;
            txtid.setText(String.valueOf(idnuevo));
        
                Date fecha = new Date();
		cf = new ControlFecha();
                txtfecha.setValue(cf.fechaCorrecta(fecha));
 		
        
            lcom = new ArrayList<Compra>();
            lt = new ListaTabla();
            clid.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            clfactura.setCellValueFactory(cellData -> cellData.getValue().numFacturaProperty().asObject());
            clnombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
            clproveedor.setCellValueFactory(cellData -> cellData.getValue().proveedorProperty());
            cltipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
            clcalidad.setCellValueFactory(cellData -> cellData.getValue().calidadProperty());
            clsacos.setCellValueFactory(cellData -> cellData.getValue().sacosProperty().asObject());
            clpeso.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
            clfecha.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
            clcosecha.setCellValueFactory(cellData -> cellData.getValue().cosechaProperty());
            clubicacion.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
            clestado.setCellValueFactory(cellData -> cellData.getValue().estadoProperty());
            tbcompra.setItems(lt.listaCompraNombres());
            
            
            clidactual.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            clsacosactual.setCellValueFactory(cellData -> cellData.getValue().sacosProperty().asObject());
            clqqactual.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
            
            clvistaid.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            clvistanombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
            clvistaproveedor.setCellValueFactory(cellData -> cellData.getValue().proveedorProperty());
            clvistasacos.setCellValueFactory(cellData -> cellData.getValue().sacosProperty().asObject());
            clvistapesos.setCellValueFactory(cellData -> cellData.getValue().pesoProperty().asObject());
            tbvistacompra.setItems(lt.listaCompraNombres());
            
            se = new Select();
		combotipo.setButtonCell(new ObjetoListCell());
		combotipo.setCellFactory(new Callback<ListView<TablaGenerica>, ListCell<TablaGenerica>>() {
			
			@Override
			public ListCell<TablaGenerica> call(ListView<TablaGenerica> param) {
				// TODO Auto-generated method stub
				return new ObjetoListCell();
			}
		});	
		combotipo.getItems().removeAll(combotipo.getItems());
		for(int i = 0; i<se.obtenerObjetoTipo().size(); i++) {
			combotipo.getItems().add(se.obtenerObjetoTipo().get(i));
		}
		
 		comboproveedor.setButtonCell(new ObjetoListCell());
		comboproveedor.setCellFactory(new Callback<ListView<TablaGenerica>, ListCell<TablaGenerica>>() {
			
			@Override
			public ListCell<TablaGenerica> call(ListView<TablaGenerica> param) {
				// TODO Auto-generated method stub
				return new ObjetoListCell();
			}
		});	
		comboproveedor.getItems().removeAll(comboproveedor.getItems());
		
		
		
		for(int i = 0; i<se.obtenerObjetoProveedor().size(); i++) {
			comboproveedor.getItems().add(se.obtenerObjetoProveedor().get(i));
		}
		
		
		
		combocalidad.setButtonCell(new 	ObjetoListCell());
		combocalidad.setCellFactory(new Callback<ListView<TablaGenerica>, ListCell<TablaGenerica>>() {
			
			@Override
			public ListCell<TablaGenerica> call(ListView<TablaGenerica> param) {
				// TODO Auto-generated method stub
				return new ObjetoListCell();
			}
		});	
		combocalidad.getItems().removeAll(combocalidad.getItems());
		for(int i = 0; i<se.obtenerObjetoCalidad().size(); i++) {
			combocalidad.getItems().add(se.obtenerObjetoCalidad().get(i));
		}
            
        
        }
        
    
    
    
    
    public Compra createObjCompra(int id, int numfactura, String nombre, int proveedor, int tipo, int calidad, Double sacos, Double peso,Date fecha, String estado, String cosecha, String ubicacion) {
        com = new Compra(id, numfactura, nombre, proveedor, tipo, calidad, sacos, peso, fecha, estado, cosecha, ubicacion);
        return com;
    }
    
    public void addCompra(int id, int numfactura, String nombre, int proveedor, int tipo, int calidad, Double sacos, Double peso,Date fecha, String estado, String cosecha, String ubicacion) throws SQLException{
        lt = new ListaTabla();
        lcom.add(createObjCompra(id, numfactura, nombre, proveedor, tipo, calidad, sacos, peso, fecha, estado, cosecha, ubicacion));
        tbcompraactual.setItems(lt.listaCompraNombresAdd(lcom));
    }
    
    public void add() throws SQLException{
        cf = new ControlFecha();
        addCompra(Integer.parseInt(txtid.getText()), Integer.parseInt(txtfactura.getText()), txtnombre.getText(), comboproveedor.getValue().getId(), combotipo.getValue().getId(), combocalidad.getValue().getId(), Double.parseDouble(txtsacos.getText()), Double.parseDouble(txtpeso.getText()), cf.getFecha(txtfecha.getValue()), "A", txtcosecha.getText(), txtubicacion.getText());
        idnuevo = idnuevo +1;
        txtid.setText(String.valueOf(idnuevo));
    }
    
    class ObjetoListCell extends ListCell<TablaGenerica> {
        @Override protected void updateItem(TablaGenerica item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty && item != null) {
                setText(item.getId() + "-"+  item.getNombre());
            } else {
                setText(null);
            }
        }
    }
    
    
}
