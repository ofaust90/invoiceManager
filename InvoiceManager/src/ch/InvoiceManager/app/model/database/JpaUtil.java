package ch.InvoiceManager.app.model.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Diese Klasse stellt die Datenbank Verbindung zur Verfügung.
 * 
 * @author 1:1 uebernommen aus der Vorlesung
 *
 */
public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory = null;

	static {
		try {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("hslu_feukora_database");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}