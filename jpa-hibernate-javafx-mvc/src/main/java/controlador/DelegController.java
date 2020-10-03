package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import com.sun.glass.ui.Window.Level;
import java.util.logging.*;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.delegacion;

public class DelegController implements Initializable {

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
    private TableView<delegacion> tblDeleg;

    @FXML
    private TableColumn<delegacion, Long> colDelegId;

    @FXML
    private TableColumn<delegacion, String> colCiudad;

    @FXML
    void initialize() {
        assert btnConsultar != null : "fx:id=\"btnConsultar\" was not injected: check your FXML file 'DelegVista.fxml'.";
        assert btnConsultar1 != null : "fx:id=\"btnConsultar1\" was not injected: check your FXML file 'DelegVista.fxml'.";
        assert btnConsultar2 != null : "fx:id=\"btnConsultar2\" was not injected: check your FXML file 'DelegVista.fxml'.";
        assert tblDeleg != null : "fx:id=\"tblDeleg\" was not injected: check your FXML file 'DelegVista.fxml'.";
        assert colDelegId != null : "fx:id=\"colDelegId\" was not injected: check your FXML file 'DelegVista.fxml'.";
        assert colCiudad != null : "fx:id=\"colCiudad\" was not injected: check your FXML file 'DelegVista.fxml'.";
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	
    /** CERRAR VENTANA Y VOLVER AL MENU */

	public void closeWindows() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
    		
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
	
    
    /** ABRIR VENTANA "AVISO" */
	
	@FXML
    private void goAviso(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AvisoVista.fxml"));
    		
    		Parent root = loader.load();
    		
    		//AvisoController controlador = loader.getController();
    		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
			stage.setTitle("EntreculturasONG");
    		
    		stage.setScene(scene);
    		stage.show();    		
    		
    	} catch (IOException ex) {
    		Logger.getLogger(MenuController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	}
    }
    
    /** MOSTRAR LLAMADA AL METODO getDelegs() EN TABLA */
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    public void consultDelegs(ActionEvent event) {
    	this.colDelegId.setCellValueFactory(new PropertyValueFactory("id"));
		this.colCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
		
		delegacion d = new delegacion();
		ObservableList<delegacion> items = d.getDelegs();
		this.tblDeleg.setItems(items);
    }
    
    
    /** ABRIR VENTANA "INSERTAR DELEGACION" */
    
    @FXML
    private void goInsertDeleg(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InsertDelegVista.fxml"));
    		
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