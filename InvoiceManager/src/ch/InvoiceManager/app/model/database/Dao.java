package ch.InvoiceManager.app.model.database;

import javax.persistence.RollbackException;




/**
 * Haupt Dao-Interface welches alle elementaren CRUD Methoden zur Verfügung stellt.
 * 
 * @author Fabian Gotzen, Oliver Faust
 *
 * @param <K>
 * @param <E> Enität
 */
public interface Dao<K, E> {
	
	/**
	 * Speichert ein Objekt in der Datenbank
	 * 
	 * @param entity zu speicherndes Objekt
	 */
	void persist(E entity);

	/**
	 * Entfernt ein Objekt aus der Datenbank
	 * 
	 * @param entity zu entfernendes Objekt
	 */
	void remove(E entity) throws RollbackException;

	/**
	 * Aktuallisiert ein bereits bestehendes Objekt. 
	 * Der unterschied zwischen persist und update besteht darin, dass bei update die Methode "merge" auf dem EntityManager aufgerufen wird.
	 * 
	 * @param entity zu aktuallisierendes Objekt
	 */
	void update(E entity);

	/**
	 * Gibt ein Objekt anhand der Id zurück. 
	 * 
	 * @param id Objekt Id
	 * @return Objekt mir der entsprechenden Id
	 */
	E findById(K id);
}