package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MenuController implements Initializable {
	
    /** CONTROLES VENTANA */

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDeleg;

    @FXML
    private Button btnEmpleados;

    @FXML
    private Button btnSocios;

    @FXML
    void initialize() {
        assert btnDeleg != null : "fx:id=\"btnDeleg\" was not injected: check your FXML file 'MenuVista.fxml'.";
        assert btnEmpleados != null : "fx:id=\"btnEmpleados\" was not injected: check your FXML file 'MenuVista.fxml'.";
        assert btnSocios != null : "fx:id=\"btnSocios\" was not injected: check your FXML file 'MenuVista.fxml'.";
      
    }
	
    public void initialize(URL arg0, ResourceBundle arg1) {
    	  Stage stage = new Stage();
          stage.setTitle("EntreculturasONG");
    }
    
    
    /** ABRIR VENTANA "DELEGACIONES" */

    @FXML
    private void goDelegaciones(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DelegVista.fxml"));
    		
    		Parent root = loader.load();
    		
    		DelegController controlador = loader.getController();
    		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
			stage.setTitle("EntreculturasONG");
    		
    		stage.setScene(scene);
    		stage.show();
    		
    		stage.setOnCloseRequest(e -> controlador.closeWindows());
    		
    		Stage myStage = (Stage) this.btnDeleg.getScene().getWindow();
    		myStage.close();
    		
    	} catch (IOException ex) {
    		Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }
    
    
    /** ABRIR VENTANA "AVISO" */

//    @FXML
//    private void goAviso1(ActionEvent event) {
//    	try {
//    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Aviso1Vista.fxml"));
//    		
//    		Parent root = loader.load();
//    		
//    		Aviso1Controller controlador = loader.getController();
//    		
//    		Scene scene = new Scene(root);
//    		Stage stage = new Stage();
//			stage.setTitle("EntreculturasONG");
//    		
//    		stage.setScene(scene);
//    		stage.show();
//    		
////    		stage.setOnCloseRequest(e -> controlador.closeWindows());
////    		
////    		Stage myStage = (Stage) this.btnConsultar2.getScene().getWindow();
////    		myStage.close();
//    		
//    	} catch (IOException ex) {
//    		Logger.getLogger(MenuController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    	}
//    }
    
    
    /** ABRIR VENTANA "SOCIOS" */
    
    @FXML
    private void goSocios(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SociosVista.fxml"));
			
			Parent root = loader.load();
			
			SociosController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("EntreculturasONG");
			
			stage.setScene(scene);
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindows());
			
			Stage myStage = (Stage) this.btnSocios.getScene().getWindow();
			myStage.close();
			
		} catch (IOException ex) {
			Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    
    

    @FXML
	private void click(ActionEvent event) {
		System.out.println("hola cracks");
	}


}
