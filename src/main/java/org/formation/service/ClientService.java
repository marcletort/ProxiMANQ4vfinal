package org.formation.service;

import java.util.List;

import org.formation.dao.IClientDao;
import org.formation.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {

	@Autowired
	IClientDao clientDao;

	/**
	 * @author Nabila Marc-Antoine Quentin Créer une client
	 */
	public void createClient(Client c) throws Exception {
		clientDao.persist(c);

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Mise un jour d'un client
	 */
	public void merge(Client c) throws Exception {
		clientDao.merge(c);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Suprimer un client
	 */
	public void remove(Client id) throws Exception {

		clientDao.remove(id.getId());
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Retrouver un client par son ID
	 */
	public Client findById(long id) throws Exception {
		return clientDao.findById(id);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Retrouver tous les clients
	 */
	public List<Client> findAll() throws Exception {
		return clientDao.findAll();
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public List<Client> findByProperty(String prop, Client motcle) throws Exception {
		return clientDao.findByProperty(prop, motcle);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public List<Client> findInRange(int firstResult, int maxResults) throws Exception {
		return clientDao.findInRange(firstResult, maxResults);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin
	 * 
	 */
	public long count() throws Exception {
		return clientDao.count();

	}
}
