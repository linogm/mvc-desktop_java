/** GESTOR PERSISTENCIA */
package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.engine.internal.StatisticalLoggingSessionEventListener;

public class modeloTest {
	
	/** Crear gestor de persistencia EM */
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
		
	public static void main(String[] args) {
		
		//insertInicial();
		printAll();
		
	}
	
	/** INSERTAR DATOS */
	private static void insertInicial() {
		EntityManager man = emf.createEntityManager();
		
		delegacion deleg = new delegacion(3L, "Lincoln");
		man.getTransaction().begin();
		man.persist(deleg);		
		man.getTransaction().commit();
		
		man.close();
	}
	
	/** MODIFICAR DATOS - find (EM global = objeto detached) */
	private static void modificarFind() {
		EntityManager man = emf.createEntityManager();
		
		man.getTransaction().begin();
		delegacion deleg = man.find(delegacion.class, 2L);
		deleg.setCiudad("Kingsbridge");
		man.getTransaction().commit();
		
		man.close();
	}

	/** MODIFICAR DATOS - merge (EM local = objeto managed&closed(=detached)) */
	private static void modificarMerge() {
		EntityManager man = emf.createEntityManager();
		delegacion deleg = new delegacion(3L, "York");
		man.getTransaction().begin();
		man.persist(deleg);		
		man.getTransaction().commit();
		man.close();
		
		printAll();
		
		man = emf.createEntityManager();
		man.getTransaction().begin();
		deleg.setCiudad("Lincoln");
		man.merge(deleg);
		man.getTransaction().commit();
		man.close();
		
		printAll();
	}
	
	/** BORRAR DATOS - transaccion previa (objeto managed&closed*/
	private static void borrar() {
		EntityManager man = emf.createEntityManager();
		delegacion deleg = new delegacion(3L, "York");
		man.getTransaction().begin();
		man.persist(deleg);		
		man.getTransaction().commit();
		man.close();
		
		printAll();
		
		man = emf.createEntityManager();
		man.getTransaction().begin();
		deleg.setCiudad("Lincoln");
		man.remove(deleg);
		man.getTransaction().commit();
		man.close();
		
		printAll();
	}
	
	/** CONSULTAR DATOS */
	@SuppressWarnings("unchecked")
	public static void printAll() {
		EntityManager man = emf.createEntityManager();
		
		List<delegacion> delegs = (List<delegacion>) man.createQuery("FROM delegacion").getResultList();
		for (delegacion deleg : delegs) {
			System.out.println(deleg.toString());
		}
		
		man.close();
	}
}