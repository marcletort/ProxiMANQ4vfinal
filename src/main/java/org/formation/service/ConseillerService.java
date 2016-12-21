package org.formation.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import org.formation.dao.IConseillerDao;
import org.formation.model.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Service
public class ConseillerService implements IConseillerService {

	@Autowired
	IConseillerDao conseillerDao;

	/**
	 * @author Nabila Marc-Antoine Quentin Persister un conseiller
	 */
	public void persist(Conseiller conseiller) throws Exception {
		conseillerDao.persist(conseiller);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Mise à jour d'un conseiller
	 */
	public void merge(Conseiller conseiller) throws Exception {
		conseillerDao.merge(conseiller);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Supprimer un conseiller
	 */
	public void remove(Conseiller id) throws Exception {
		conseillerDao.remove(id.getId());
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver un conseiller par son ID
	 */
	public Conseiller findById(long id) throws Exception {
		return conseillerDao.findById(id);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver tous les conseillers
	 */
	public List<Conseiller> findAll() throws Exception {
		return conseillerDao.findAll();
	}

	public List<Conseiller> findByProperty(String prop, Object val) throws Exception {
		return conseillerDao.findByProperty(prop, val);
	}

	public List<Conseiller> findInRange(int firstResult, int maxResults) throws Exception {
		return conseillerDao.findInRange(firstResult, maxResults);
	}

	public long count() throws Exception {
		return conseillerDao.count();
	}

}
