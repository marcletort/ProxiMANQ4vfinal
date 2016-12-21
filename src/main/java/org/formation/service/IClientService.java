package org.formation.service;

import java.util.List;

import org.formation.model.Client;

public interface IClientService {
	public void persist(Client c) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Persister un client
	 */
	public void merge(Client c) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Mise à jour d'un client
	 */
	public void remove(Client c) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Supprimer un client
	 */
	public Client findById(long id) throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver un client par son ID
	 */
	public List<Client> findAll() throws Exception;

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver tous les clients
	 */
	public List<Client> findByProperty(String prop, Object val) throws Exception;

	public List<Client> findInRange(int firstResult, int maxResults) throws Exception;

	public long count() throws Exception;
}
