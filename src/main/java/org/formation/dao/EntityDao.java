package org.formation.dao;


import java.util.List;


/**
 * @author Nabila Marc-Antoine Quentin
 * 
 */

public interface EntityDao<E> {
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * Persistance
	 */
	public void persist(E e) throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * Mise à jour
	 */
	public void merge(E e) throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * Supprimer
	 */
	public void remove(Object id) throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * Trouver par ID
	 */
	public E findById(long id) throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * Liste de tout l'élément
	 */
	public List<E> findAll() throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public List<E> findByProperty(String prop, Object val) throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public List<E> findInRange(int firstResult, int maxResults) throws Exception;
	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public long count() throws Exception;
	
	
}
