package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.delegacion;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;

public class InsertDelegController implements Initializable {

	
	/** GESTOR DE PERSISTENCIA ENITTY MANAGER (EM) */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    /** CONTROLES VENTANA */

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane insertDeleg;

    @FXML
    private TextField txtDelegId;

	@FXML
    private TextField txtDelegCiudad;

    @FXML
    private Button btnInsertDeleg;

	
    @FXML
    void initialize() {
        assert insertDeleg != null : "fx:id=\"insertDeleg\" was not injected: check your FXML file 'InsertDelegVista.fxml'.";
        assert txtDelegId != null : "fx:id=\"txtDelegId\" was not injected: check your FXML file 'InsertDelegVista.fxml'.";
        assert txtDelegCiudad != null : "fx:id=\"txtDelegCiudad\" was not injected: check your FXML file 'InsertDelegVista.fxml'.";
        assert btnInsertDeleg != null : "fx:id=\"btnInsertDeleg\" was not injected: check your FXML file 'InsertDelegVista.fxml'.";
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	/** MENU--> DELEGACIONES--> INSERTAR (METODO) */
	
	public void insertDeleg() {
		EntityManager man = emf.createEntityManager();
		
		delegacion deleg = new delegacion(Long.parseLong(this.txtDelegId.getText()), this.txtDelegCiudad.getText());
		man.getTransaction().begin();
		man.persist(deleg);		
		man.getTransaction().commit();
		
		man.close();
		
		Stage myStage = (Stage) this.btnInsertDeleg.getScene().getWindow();
		myStage.close();
	}

}