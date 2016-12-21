package org.formation.service;

import java.util.List;

import org.formation.dao.IVirementDao;
import org.formation.model.Compte;
import org.formation.model.Virement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VirementService {

	@Autowired
	IVirementDao virementDao;

	@Autowired
	CompteService compteService;

	/**
	 * @author Nabila Marc-Antoine Quentin Persister un virement
	 */
	public void persist(Virement v) throws Exception {
		virementDao.persist(v);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Mise à jour d'un virement
	 */
	public void merge(Virement v) throws Exception {
		virementDao.merge(v);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Supprmier un virement
	 */
	public void remove(Virement v) throws Exception {
		virementDao.remove(v);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver un virement par son ID
	 */
	public Virement findById(long id) throws Exception {
		return virementDao.findById(id);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver tous les virements
	 */
	public List<Virement> findAll() throws Exception {
		return virementDao.findAll();
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Trouver tous les virements
	 */
	public List<Virement> findByProperty(String prop, Object val) throws Exception {
		return virementDao.findByProperty(prop, val);
	}

	public List<Virement> findInRange(int firstResult, int maxResults) throws Exception {
		return virementDao.findInRange(firstResult, maxResults);
	}

	public long count() throws Exception {
		return virementDao.count();
	}

	/**
	 * 
	 * @param compteExId
	 *            = id compte expediteur / compteEx = compte expediteur
	 * @param compteBeId
	 *            = id compte beneficiaire / compteBe = compte beneficiaire
	 * @return une methode boolean qui nous retourne si le virement a ete
	 *         effectue (true) ou pas (false)
	 */
	public boolean virement(Virement v) {

		System.out.println(v);
		try {
			long compteBeId = v.getCompteBe();
			long compteExId = v.getCompteEx();

			Compte compteBe = compteService.findById(compteBeId);
			Compte compteEx = compteService.findById(compteExId);

			compteBe.setMontant(compteBe.getMontant() + v.getMontant());
			compteEx.setMontant(compteEx.getMontant() - v.getMontant());

			compteService.merge(compteEx);
			compteService.merge(compteBe);

			persist(v);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
