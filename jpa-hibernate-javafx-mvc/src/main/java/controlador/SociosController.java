package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//import modelo.delegacion;
import modelo.socios;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;

public class SociosController implements Initializable {

    
    /** CONTROLES VENTANA */

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnConsultar1;

    @FXML
    private Button btnConsultar2;

    @FXML
    private TableView<socios> tblSocios;

    @FXML
    private TableColumn<socios, Long> colSociosId;

    @FXML
    private TableColumn<socios, String> colNombre;

    @FXML
    private TableColumn<socios, Double> colCuota;


    @FXML
    void initialize() {
        assert btnConsultar != null : "fx:id=\"btnConsultar\" was not injected: check your FXML file 'SociosVista.fxml'.";
        assert btnConsultar1 != null : "fx:id=\"btnConsultar1\" was not injected: check your FXML file 'SociosVista.fxml'.";
        assert btnConsultar2 != null : "fx:id=\"btnConsultar2\" was not injected: check your FXML file 'SociosVista.fxml'.";
        assert tblSocios != null : "fx:id=\"tblDeleg\" was not injected: check your FXML file 'SociosVista.fxml'.";
        assert colSociosId != null : "fx:id=\"colSociosId\" was not injected: check your FXML file 'SociosVista.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'SociosVista.fxml'.";
        assert colCuota != null : "fx:id=\"colCuota\" was not injected: check your FXML file 'SociosVista.fxml'.";

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
    /** CERRAR VENTANA Y VOLVER AL MENU */

	public void closeWindows() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
    		
    		Parent root = loader.load();
    		
//    		MenuController controlador = loader.getController();
    		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
			stage.setTitle("EntreculturasONG");
    		
    		stage.setScene(scene);
    		stage.show();
    		
    	} catch (IOException ex) {
    		Logger.getLogger(MenuController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	}
	}
	
	
    /** ABRIR VENTANA "AVISO" */
	
	@FXML
    private void goAviso(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AvisoVista.fxml"));
    		
    		Parent root = loader.load();
    		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
			stage.setTitle("EntreculturasONG");
    		
    		stage.setScene(scene);
    		stage.show();
    		
    	} catch (IOException ex) {
    		Logger.getLogger(MenuController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	}
    }
	
	
    /** MOSTRAR LLAMADA AL METODO getSocios() EN TABLA */
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    public void consultSocios(ActionEvent event) {
    	this.colSociosId.setCellValueFactory(new PropertyValueFactory("id"));
		this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
		this.colCuota.setCellValueFactory(new PropertyValueFactory("cuota"));

		
		socios s = new socios();
		ObservableList<socios> items = s.getSocios();
		this.tblSocios.setItems(items);
    }
    
    
    /** ABRIR VENTANA "INSERTAR SOCIOS" */
    
    @FXML
    private void goInsertSocios(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InsertSociosVista.fxml"));
    		
    		Parent root = loader.load();
       		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
			stage.setTitle("EntreculturasONG");
    		
    		stage.setScene(scene);
    		stage.show();
    		
    	} catch (IOException ex) {
    		Logger.getLogger(MenuController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	}
    }
}