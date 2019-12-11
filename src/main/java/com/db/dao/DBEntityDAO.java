package com.db.dao;

import com.db.model.HibernateUtil;
import com.utils.ArrayUtils;
import com.utils.PairType;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * DBEntityDAO was created to provide the basic API for the persistent in the
 * database objects. This class is a basic class for all persistent in the
 * database entities.
 * 
 * @author vitaly
 * @since 2.4.2 <br>
 *        based on JDK 1.7 <br>
 *        created at Nov 17, 2013
 */
public abstract class DBEntityDAO<ENTITY, KEY extends Serializable> extends EntityDAO<ENTITY, KEY> {

	private static final Logger LOG = LoggerFactory.getLogger(DBEntityDAO.class);
	/**
	 * Reference to the session factory
	 */


/*	private Session sessionFactory;

	*//**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 *//*
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = HibernateUtil.getSessionFactory().openSession();;
	}*/

	@SuppressWarnings("unchecked")
	public ENTITY load(KEY key) {
		return (ENTITY) getSession().get(getEntityClass(), key);
	}

	/**
	 * Create a new instance of the entity
	 * 
	 * @param newEntity
	 *            - define a new instance would be stored
	 */
	@SuppressWarnings("unchecked")
	public KEY create(ENTITY newEntity) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		KEY key = (KEY) session.save(newEntity);
		tx.commit();
		return key;
	}

	/**
	 * Update an existed instance by a new data
	 * 
	 * @param updatedEntity
	 */
	public void update(ENTITY updatedEntity) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		 session.update(updatedEntity);
		tx.commit();
	}

	/**
	 * Delete entity by id
	 * 
	 * @param key
	 */
	public void delete(KEY key) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.delete(key);
		tx.commit();
	}

	/**
	 * Bulk delete according to the passed list of keys
	 * 
	 * @param kyes
	 *            - define an entity's identifier would be deleted.
	 * @return a number of deleted entities
	 */
	public int deletes(List<KEY> keys) {
		Query crit = getSession().createQuery("delete " + getEntityClass().getSimpleName() + " entity where entity.id in( :ids )");
		crit.setParameterList("ids", keys);
		return crit.executeUpdate();
	}

	/**
	 * Delete all entities.
	 * 
	 * @return a number of deleted entities
	 */
	public int deleteAll() {
		Query crit = getSession().createQuery("delete " + getEntityClass().getSimpleName());
		return crit.executeUpdate();
	}

	/**
	 * Get a list of entities
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> list() {
		Criteria crit = getSession().createCriteria(getEntityClass());
		return crit.list();
	}

	/**
	 * Get a list of entities according to the passed keys
	 * 
	 * @param kyes
	 *            - define an required entities to be loaded
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> list(List<KEY> keys) {
		if (keys != null) {
			Criteria crit = getSession().createCriteria(getEntityClass()).add(Restrictions.in("id", keys));
			return crit.list();
		} else {
			return list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ENTITY> findByProperty(String property, Object value) {
		return findByProperties(new PairType<String, Object>(property, value) );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ENTITY> findByProperties(PairType<String, Object>... props) {
		
		if( props == null ){
			throw new DAOException("At least one property must be specified.");
		}
		Criteria crit = getSession().createCriteria(getEntityClass());
		for (PairType<String, Object> pair : props) {
			String property = pair.getProperty();
			Field propertyField = getFieldByName(property);
			
			if (String.class.isAssignableFrom(propertyField.getType()) && ((String)pair.getValue()).contains("*")) {
				String value = (String) pair.getValue();
				if( value.startsWith("*") && value.endsWith("*")){
					crit = crit.add(Restrictions.ilike(property, value.replace("*", ""), MatchMode.ANYWHERE));
				}else if (value.startsWith("*")) {
					crit = crit.add(Restrictions.ilike(property, value.replace("*", ""), MatchMode.END));
				} else if (value.endsWith("*")) {
					crit = crit.add(Restrictions.ilike(property, value.replace("*", ""), MatchMode.START));
				} else {
					throw new DAOException("Unsupported case. The '*' symbol is specified inside of the passed value.");
				}
			} else {
				crit = crit.add(Restrictions.eq(property, pair.getValue()));
			}
		}
		return crit.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public ENTITY findUniqueByProperty(String property, Object value) {
		return findUniqueByProperties(new PairType<String, Object>(property, value) );
	}
	@Override
	public ENTITY findUniqueByProperties(@SuppressWarnings("unchecked") PairType<String, Object> ... props) {
		List<ENTITY> result = findByProperties(props);
		if( result.size() == 0 ){
			return null;
		}else if(result.size() > 1 ){
			throw new DAOException("Non unique result for entity="+getEntityClass()+"by properties:"+ArrayUtils.toString(props));
		}else{
			return result.get(0);
		}
	}
	/**
	 * Get the appropriated field for the specified property.
	 * @param property - define a entity's field name.
	 * @return reference to the field, or <i>null</i> if no field was found according to the passed property.
	 */
	private Field getFieldByName( String property ){
		Class<?> clazz = getEntityClass();
		while( clazz != Object.class ){
			for (Field field : clazz.getDeclaredFields() ) {
				field.setAccessible( true );
				if( field.getName().equals( property ) ){
					return field;
				}
			}
			clazz = clazz.getSuperclass();
		}
		return null;
	}

	/**
	 * Get the reference to the current opened session
	 * 
	 * @return
	 */
	protected Session getSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		return session;
	}

	/**
	 * Get reference to the named query interface
	 * 
	 * @param queryClass
	 *            define an interface which describe the named queries for the
	 *            specific DAO
	 * @return
	 */
/*
	@SuppressWarnings("unchecked")
	protected final <T> T getNamedQuery() {
		return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { getQueryClass() }, new NamedQueryHandler(entityTypeClass.getSimpleName(), getSession()));
	}
*/

	/**
	 * Get a class which represents all named queries for the current DAO
	 * 
	 * @return
	 */
	/*protected <T extends EntityNamedQueries> Class<T> getQueryClass() {
		throw new UnsupportedOperationException();
	}
*/
	/**
	 * Wrap the runnable by own transaction.
	 * 
	 * @param run
	 *            - define a functionality would be run inside its own
	 *            transaction.
	 */
	public static void wrappedByTransaction(final Runnable run, final DBEntityDAO<?, ?> dao) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// open a new session
				Session session = dao.getSession();
				Transaction transaction = session.beginTransaction();
				try {
					run.run();
					transaction.commit();
				} catch (Throwable th) {
					LOG.error("DB error:", th);
					transaction.rollback();
				}finally{
					session.close();
				}
			}
		});
		try {
			thread.join();
		} catch (InterruptedException e) {
			LOG.warn("Wrapped thread was interrupted.", e);
		}
	}
}
