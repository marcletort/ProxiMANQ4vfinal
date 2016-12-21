package org.formation.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javassist.bytecode.SignatureAttribute.TypeVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formation.dao.EntityDao;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

public class EntityDaoImpl<E> implements EntityDao<E> {
	/**
	 * @author Nabila Marc-Antoine Quentin Persistance
	 */
	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;

	protected E instance;
	private Class<E> entityClass;

	/**
	 * @author Nabila Marc-Antoine Quentin Transaction Persistance
	 */
	@Transactional
	public void persist(E e) throws HibernateException {
		getEntityManager().persist(e);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Transaction Mise à jour
	 */
	@Transactional
	public void merge(E e) throws HibernateException {
		getEntityManager().merge(e);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Transation Supprimer
	 */
	@Transactional
	public void remove(Object id) throws Exception {
		getEntityManager().remove((E) getEntityManager().find(getEntityClass(), id));
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Transaction trouver par un ID
	 */
	@Transactional(readOnly = true)
	public E findById(long id) throws Exception {
		return (E) getEntityManager().find(getEntityClass(), id);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Transaction trouver tout
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<E> findAll() throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
				.getResultList();
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<E> findByProperty(String prop, Object val) throws Exception {
		return (List<E>) getEntityManager()
				.createQuery("select x from " + getEntityClass().getSimpleName() + " x where x." + prop + " = ?1")
				.setParameter(1, val).getResultList();
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<E> findInRange(int firstResult, int maxResults) throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
				.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	@Transactional(readOnly = true)
	public long count() throws Exception {
		return (Long) getEntityManager().createQuery("Select count(t) from " + getEntityClass().getSimpleName() + " t")
				.getSingleResult();
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public void setEntityManager(EntityManager entityManager) throws Exception {
		this.entityManager = entityManager;
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() throws Exception {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				if (paramType.getActualTypeArguments().length == 2) {
					if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
						throw new IllegalArgumentException("Can't find class using reflection");
					} else {
						entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
					}
				} else {
					entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
				}
			} else {
				throw new Exception("Can't find class using reflection");
			}
		}
		return entityClass;
	}

}
