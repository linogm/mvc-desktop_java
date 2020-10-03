package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

//import controlador.InsertDelegController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Entity
@Table(name="delegaciones")
public class delegacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** GESTOR DE PERSISTENCIA ENITTY MANAGER (EM) */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	
	/**	ATRIBUTOS */
	
	@Id
	@Column(name="delegacion_id")
	private Long id;
	
	@Column(name="ciudad")
	private String ciudad;
	
	
	/**	METODOS */
	
	public delegacion() {
		
	}

	public delegacion(Long id, String ciudad) {
		this.id = id;
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "delegacion [id=" + id + ", ciudad=" + ciudad + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	/** MENU--> DELEGACIONES--> CONSULTAR (METODO) */
	
	@SuppressWarnings("unchecked")
	public ObservableList<delegacion> getDelegs() {
		EntityManager man = emf.createEntityManager();
		
		ObservableList<delegacion> obs = FXCollections.observableArrayList();
		
		List<delegacion> delegs = (List<delegacion>) man.createQuery("FROM delegacion").getResultList();
		for (delegacion deleg : delegs) {
			Long id = deleg.getId();
			String ciudad = deleg.getCiudad();
			
			delegacion d = new delegacion(id, ciudad);
			obs.add(d);
		}
		
		man.close();
		
		return obs;
	}
}