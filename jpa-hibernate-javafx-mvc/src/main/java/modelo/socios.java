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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Entity
@Table(name="socios")
public class socios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** GESTOR DE PERSISTENCIA ENITTY MANAGER (EM) */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	
	/**	ATRIBUTOS */
	
	@Id
	@Column(name="socio_id")
	private Long id;
	
	@Column(name="socio_name")
	private String nombre;
	
	@Column(name="cuota")
	private double cuota;
	
	
	/**	METODOS */
	
	public socios() {
		
	}

	public socios(Long id, String nombre, double cuota) {
		this.id = id;
		this.nombre = nombre;
		this.cuota = cuota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	/** MENU--> SOCIOS--> CONSULTAR (METODO) */
	
	@SuppressWarnings("unchecked")
	public ObservableList<socios> getSocios() {
		EntityManager man = emf.createEntityManager();
		
		ObservableList<socios> obs = FXCollections.observableArrayList();
		
		List<socios> socis = (List<socios>) man.createQuery("FROM socios").getResultList();
		for (socios soci : socis) {
			Long id = soci.getId();
			String nombre = soci.getNombre();
			double cuota = soci.getCuota();
			
			socios s = new socios(id, nombre, cuota);
			obs.add(s);
		}
		
		man.close();
		
		return obs;
	}
	
}