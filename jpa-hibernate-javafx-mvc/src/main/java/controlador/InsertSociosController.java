package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.socios;

public class InsertSociosController implements Initializable {
	
	/** GESTOR DE PERSISTENCIA ENITTY MANAGER (EM) */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	
    /** CONTROLES VENTANA */
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane insertSocios;

    @FXML
    private TextField txtSociosId;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnInsertSocios;

    @FXML
    private TextField txtCuota;


    @FXML
    void initialize() {
        assert insertSocios != null : "fx:id=\"insertSocios\" was not injected: check your FXML file 'InsertSociosVista.fxml'.";
        assert txtSociosId != null : "fx:id=\"txtDelegId\" was not injected: check your FXML file 'InsertSociosVista.fxml'.";
        assert txtNombre != null : "fx:id=\"txtDelegCiudad\" was not injected: check your FXML file 'InsertSociosVista.fxml'.";
        assert btnInsertSocios != null : "fx:id=\"btnInsertSocios\" was not injected: check your FXML file 'InsertSociosVista.fxml'.";
        assert txtCuota != null : "fx:id=\"txtDelegCiudad1\" was not injected: check your FXML file 'InsertSociosVista.fxml'.";
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	/** MENU--> SOCIOS--> INSERTAR (METODO) */
	
	public void insertSocios() {
		EntityManager man = emf.createEntityManager();
		
		socios soci = new socios(Long.parseLong(this.txtSociosId.getText()), this.txtNombre.getText(), Double.parseDouble(this.txtCuota.getText()));
		man.getTransaction().begin();
		man.persist(soci);		
		man.getTransaction().commit();
		
		man.close();
		
		Stage myStage = (Stage) this.btnInsertSocios.getScene().getWindow();
		myStage.close();
	}
}