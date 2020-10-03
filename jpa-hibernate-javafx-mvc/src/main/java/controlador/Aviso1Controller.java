package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Aviso1Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane avisoWin;

    @FXML
    void initialize() {
        assert avisoWin != null : "fx:id=\"avisoWin\" was not injected: check your FXML file 'AvisoVista.fxml'.";

    }
    
	public void closeWindows() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
    		
    		Parent root = loader.load();
    		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		
    		stage.setScene(scene);
    		stage.show();
    		
    	} catch (IOException ex) {
    		Logger.getLogger(MenuController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}

