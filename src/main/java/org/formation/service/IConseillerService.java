package org.formation.service;

import java.util.List;

import org.formation.model.Conseiller;

public interface IConseillerService {
	/**
	 * @author Nabila Marc-Antoine Quentin Persister un conseiller
	 */
	public void persist(Conseiller conseiller) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Mise à jour d'un conseiller
	 */
	public void merge(Conseiller conseiller) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Supprimer un conseiller
	 */
	public void remove(Conseiller id) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver un conseiller par son ID
	 */
	public Conseiller findById(long id) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver tous les conseillers
	 */
	public List<Conseiller> findAll() throws Exception;

	public List<Conseiller> findByProperty(String prop, Object val) throws Exception;

	public List<Conseiller> findInRange(int firstResult, int maxResults) throws Exception;

	public long count() throws Exception;

}
