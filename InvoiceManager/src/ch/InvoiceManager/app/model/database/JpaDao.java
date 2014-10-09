package ch.InvoiceManager.app.model.database;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;

import org.apache.log4j.Logger;

import ch.feukora.a2.common.app.database.entities.AbstractPerson;
import ch.feukora.a2.common.app.database.entities.Facility;

/**
 * JPA Implementation des Data Access Objects. 
 * @author Fabian Gotzen, Oliver Faust
 *
 * @param <K>
 * @param <E>
 */
public abstract class JpaDao<K, E> implements Dao<K, E> {
	
    /** The Constant logger. */
	private final static Logger logger = Logger
			.getLogger("ch.feukora.a2.server.app.database");
	
	/**
	 * Entsprechende Entität
	 */
	protected Class<E> entityClass;

	/**
	 * Eclipselink EntityManager (stellt Verbindung zu Datenbank zur Verfügung)
	 */
	@PersistenceContext
	protected EntityManager entityManager = JpaUtil.createEntityManager();


	@SuppressWarnings("unchecked")
	public JpaDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	@Override
	public void persist(E entity) {
		entityManager.getTransaction().begin();

		// benoetigt, damit adresse nicht neu erstellt wird, wenn sie bereits
		// vorhanden ist
		if (entity instanceof AbstractPerson || entity instanceof Facility) {
			entityManager.merge(entity);
		} else {
			entityManager.persist(entity);
		}

		entityManager.getTransaction().commit();
		
		
		logger.info("Objekt "+ entity.toString() + " gespeichert!");
	}

	@Override
	public void remove(E entity) throws RollbackException {

	
		
			try {
				entity = entityManager.merge(entity);

				entityManager.getTransaction().begin();
				entityManager.remove(entity);
				entityManager.getTransaction().commit();
				
				
				logger.info("Objekt "+ entity.toString() + " gelöscht!");
			} catch (RollbackException e) {
				
				//Wird geworfen wenn ein Objekt mit einem anderen Objekt in Beziehung steht und somit nicht gelöscht werden kann.
				throw e;
				
			}
	
		
		
	}

	@Override
	public void update(E entity) {

		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		
		logger.info("Objekt "+ entity.toString() + " aktuallisiert!");
	}

	@Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}