package org.formation.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import org.formation.dao.ICompteDao;
import org.formation.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Service
public class CompteService {

	@Autowired
	ICompteDao compteDao;

	/**
	 * @author Nabila Marc-Antoine Quentin Persister un compte
	 */
	public void persist(Compte compte) throws Exception {
		compteDao.persist(compte);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Mise à jour d'un compte
	 */
	public void merge(Compte compte) throws Exception {
		compteDao.merge(compte);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Supprimer un compte
	 */
	public void remove(Compte id) throws Exception {
		compteDao.remove(id.getId());
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver un compte par son ID
	 */
	public Compte findById(long id) throws Exception {
		return compteDao.findById(id);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver tous les comptes
	 */
	public List<Compte> findAll() throws Exception {
		return compteDao.findAll();
	}

	public List<Compte> findByProperty(String prop, Object val) throws Exception {
		return compteDao.findByProperty(prop, val);
	}

	public List<Compte> findInRange(int firstResult, int maxResults) throws Exception {
		return compteDao.findInRange(firstResult, maxResults);
	}

	public long count() throws Exception {
		return compteDao.count();
	}
}
