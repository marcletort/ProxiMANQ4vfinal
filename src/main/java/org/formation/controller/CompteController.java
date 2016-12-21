package org.formation.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.formation.model.Client;
import org.formation.model.Compte;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;
import org.formation.service.ClientService;
import org.formation.service.CompteService;
import org.formation.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class CompteController implements Serializable {

	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private Compte compte;
	private double montant;
	private LocalDate dateOuverture;

	@Autowired
	CompteService compteService;

	@Autowired
	ClientService clientService;

	/**
	 * @author Nabila Marc-Antoine Quentin Créer un compte courant
	 */
	public String creerCompteCourant() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		ConseillerService conseillerService = applicationContext.getBean("conseillerService", ConseillerService.class);

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Client clientp = (Client) session.getAttribute("Client");

		dateOuverture = LocalDate.now();
		CompteCourant cc = new CompteCourant(montant, dateOuverture);

		clientp.setCompteCourant(cc);

		try {
			clientService.merge(clientp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		return "accueil.xhtml";

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Créer un compte épargne
	 */
	public String creerCompteEpargne() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		ConseillerService conseillerService = applicationContext.getBean("conseillerService", ConseillerService.class);

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Client clientp = (Client) session.getAttribute("Client");

		dateOuverture = LocalDate.now();
		CompteEpargne ce = new CompteEpargne(montant, dateOuverture);

		clientp.setCompteEpargne(ce);

		try {
			clientService.merge(clientp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		return "accueil.xhtml";

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Avoir tous les comptes
	 */
	public Collection<Compte> getAllComptes() {
		Collection<Compte> comptes = new ArrayList<>();
		try {
			comptes = compteService.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return comptes;

	}

	private static final long serialVersionUID = -8754223287899679722L;

	public void creerComptePourClient(Compte compte, Client client) {

	}

	/**
	 * @author Nabila Marc-Antoine Quentin obtenir le montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @author Nabila Marc-Antoine Quentin mettre un montant
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @author Nabila Marc-Antoine Quentin Obtenir Date ouverture
	 */
	public LocalDate getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * @author Nabila Marc-Antoine Quentin mettre date ouverture
	 */
	public void setDateOuverture(LocalDate dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

}
