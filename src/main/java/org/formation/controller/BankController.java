package org.formation.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.formation.model.Adresse;

import org.formation.model.Client;
import org.formation.model.Conseiller;
import org.formation.service.ClientService;
import org.formation.service.ConseillerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class BankController implements Serializable {
	private static final long serialVersionUID = 3457285546581409379L;
	// Banquier banq = new Banquier();
	String login;
	String password;
	List<Client> listClient = new ArrayList<Client>();

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Pour l'Authentification
	// public String seConnecter(Model model) throws Exception {
	// int varpers = 0;
	//
	// // Méthode inachevée
	//
	// List<Conseiller> conseillers = conseillerService.findAll();
	//
	// for (Conseiller conseiller : conseillers) {
	//
	// if ((conseiller.getLogin().equals(login)) &&
	// (conseiller.getMotDePasse().equals(password))) {
	// HttpSession session = (HttpSession)
	// FacesContext.getCurrentInstance().getExternalContext()
	// .getSession(true);
	// session.setAttribute("ConseillerConnecté", banq);
	// return "acceuil.xhtml";
	// } else {
	// return "home.xhtml";
	// }
	// }
	// return "";
	//
	// }

	// model.addAttribute("conseillerConnecté",new Conseiller("Dieu","Notre
	// père","dieu","dieu"));if(varpers==1)
	//
	// {
	// return "acceuil.xhtml";
	// }else if(varpers==2)
	// {
	// return "acceuilGerant.xhtml";
	// }else
	// {
	// return "home.xhtml";
	// }
	// }

	/**
	 * @author Nabila Marc-Antoine Quentin Login
	 */
	public String chargerCons() throws Exception {
		Boolean bool = false;
		Conseiller conseiller = new Conseiller("admin", "admin", "admin", "admin");

		if (("admin".equals(login)) && ("admin".equals(password))) {

			bool = true;
		} else {
			bool = false;
		}

		if (bool) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("Conseiller", conseiller);
			return "accueil.xhtml";
		} else {

			return "error.xhtml";
		}

		// ApplicationContext applicationContext = new
		// ClassPathXmlApplicationContext(
		// "/META-INF/spring/applicationContext-db-mysql.xml");
		// ConseillerService conseillerService =
		// applicationContext.getBean("conseillerService",
		// ConseillerService.class);
		// HttpSession session = (HttpSession)
		// FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		//
		// List<Conseiller> listCons = conseillerService.findAll();
		// System.out.println(listCons);
		// System.out.println("Après liste");
		// // System.out.println("Avant Boucle Conseiller");
		// // for (Conseiller conseiller2 : listCons) {
		// // if (conseiller2.getId() == 62) {
		// // System.out.println("trouvé : " + conseiller2);
		// // conseiller = conseiller2;
		// // }
		// // }
		// // System.out.println("Avant find");
		// // Conseiller conseiller = conseillerService.findById(62L);
		// // System.out.println(conseiller);
		// // System.out.println("Après find");
		// // System.out.println(conseiller.getNom());
		// Conseiller conseiller = new Conseiller();
		// Boolean bool = false;
		// for (Conseiller conseiller2 : listCons) {
		// if ((conseiller2.getLogin().equals(login)) &&
		// (conseiller2.getMotDePasse().equals(password))) {
		// conseiller = conseiller2;
		// System.out.println(conseiller);
		//
		// bool = true;
		// } else {
		// bool = false;
		// }
		// }
		// if (bool) {
		// session.setAttribute("Conseiller", conseiller);
		//
		// return "accueil.xhtml";
		// } else {
		//
		// return "login.xhtml";
		// }

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Création conseiller sur la page home
	 *         qui n'est plus utilisé
	 */
	public void creerCons() throws Exception {

		Conseiller conseiller = new Conseiller("Dieu", "Notre père", "dieu", "dieu");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		session.setAttribute("Conseiller", conseiller);
		ConseillerService conseillerService = applicationContext.getBean("conseillerService", ConseillerService.class);
		conseillerService.persist(conseiller);

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Afficher la liste des clients sur la
	 *         page accueil
	 */
	public List<Client> obtenirListeClients() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ConseillerService conseillerService = applicationContext.getBean("conseillerService", ConseillerService.class);
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		Conseiller cons = (Conseiller) session.getAttribute("Conseiller");
		List<Client> listClientTot = clientService.findAll();

		// System.out.println(listClientTot);
		// System.out.println(cons);
		// System.out.println(cons.getId());
		// for (Client client : listClientTot) {
		// System.out.println(client.getNom());
		// System.out.println(clientService.findById(client.getId()).getConseiller());
		// // System.out.println(client.getNom() + " " +
		// // client.getConseiller());
		// Conseiller consI = client.getConseiller();
		// if (consI.equals(cons)) {
		// listClient.add(client);
		// System.out.println(client);
		// }
		// }
		// listClient = cons.getListClients();

		// listclient.add(client);
		return listClientTot;

	}

	public Integer obtenirNombreCompte() {
		return 0;

	}

}
