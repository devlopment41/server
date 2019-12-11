package com.db.dao;

import com.utils.PairType;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * EntityDAO was created to provide the default API for entity objects.
 * This class is a base class for all managed entities
 * 
 * @author vitaly
 * @since 2.4.2 <br>
 *        based on JDK 1.7 <br>
 *        created at Nov 17, 2013
 */
public abstract class EntityDAO<ENTITY, KEY extends Serializable>{

	protected Class<ENTITY> entityTypeClass;
	
	@SuppressWarnings("unchecked")
	public EntityDAO(){
		if( getClass().getGenericSuperclass() instanceof ParameterizedType ){
			entityTypeClass = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}else{
			
		}
	}
	/**
	 * Get a reference to the entity class.
	 * @return
	 */
	protected Class<ENTITY> getEntityClass(){
		return entityTypeClass;
	}
	/**
	 * Load an entity according to the passed key
	 * @param key - the entity identifier
	 * @return the reference to the entity is relevant to the passed key or <i>null</i> if no entity is assigned to the specified key.
	 */
	public abstract ENTITY load( KEY key );
	/**
	 * Create a new instance of the entity
	 * @param newEntity - define a new instance would be stored
	 */
	public abstract KEY create( ENTITY newEntity);
	/**
	 * Update an existed instance by a new data.
	 * The update operation can be performed on an existed entity only.
	 * @param updatedEntity
	 */
	public abstract void update( ENTITY updatedEntity );
	/**
	 * Delete entity by id
	 * @param key - define an entity's identifier
	 */
	public abstract void delete( KEY key );
	/**
	 * Bulk delete according to the passed list of keys
	 * @param kyes - define an entity's identifier would be deleted.
	 * @return a number of deleted entities
	 */
	public abstract int deletes( List<KEY> keys );
	/**
	 * Delete all entities.
	 * @return a number of deleted entities
	 */
	public abstract int deleteAll();
	/**
	 * Get a list of entities
	 * TODO: the result could be limited in order to avoid a OOM problem.
	 * @return
	 */
	public abstract List<ENTITY> list();
	/**
	 * Get a list of entities according to the passed keys
	 * If <code>keys</code> parameter is not specified the result is equals to {@link #list()}
	 * @param keys - define an required entities to be loaded. Optional
	 * @return
	 */
	public abstract List<ENTITY> list( List<KEY> keys);
	
	/**
	 * Find entities by property.
	 * If the property describes a string base field the passed value can contains (*) to support wild card. The '*' can be specified at begin or end of value only. 
	 * @param porperty - defines a find criterion.
	 * @return all entities with the specified value for the specified property.
	 */
	public abstract List<ENTITY> findByProperty( String property, Object value );
	/**
	 * Find entities by properties.
	 * If the property describes a string base field the passed value can contains (*) to support wild card. The '*' can be specified at begin or end of value only. 
	 * @param porperty - defines a find criterion.
	 * @return all entities with the specified value for the specified property.
	 */
	public abstract List<ENTITY> findByProperties( @SuppressWarnings("unchecked") PairType<String, Object>...props );
	/**
	 * Find unique entity by property.
	 * If the property describes a string base field the passed value can contains (*) to support wild card. The '*' can be specified at begin or end of value only. 
	 * @param porperty - defines a find criterion.
	 * @return all entities with the specified value for the specified property.
	 */
	public abstract ENTITY findUniqueByProperty( String property, Object value );
	/**
	 * Find unique entity by properties.
	 * If the property describes a string base field the passed value can contains (*) to support wild card. The '*' can be specified at begin or end of value only. 
	 * @param porperty - defines a find criterion.
	 * @return all entities with the specified value for the specified property.
	 */
	public abstract ENTITY findUniqueByProperties(@SuppressWarnings("unchecked") PairType<String, Object> ... props);
}
