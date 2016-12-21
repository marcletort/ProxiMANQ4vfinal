package org.formation.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.formation.model.Adresse;
import org.formation.model.Client;
import org.formation.model.Conseiller;
import org.formation.service.ClientService;
import org.formation.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController implements Serializable {
	private static final long serialVersionUID = 8301632515717827415L;
	String nom;
	String prenom;
	String email;
	String rue;
	String ville;
	String numero;
	String codePostal;

	// Conseiller conseiller = new Conseiller("Dieu", "Notre père", "dieu",
	// "dieu");

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Autowired
	ClientService clientService;
	@Autowired
	ConseillerService conseillerService;

	/**
	 * @author Nabila Marc-Antoine Quentin créer un client
	 */
	public String creerClient() throws Exception {
		// ApplicationContext applicationContext = new
		// ClassPathXmlApplicationContext(
		// "/META-INF/spring/applicationContext-db-mysql.xml");
		// ClientService clientService =
		// applicationContext.getBean("clientService", ClientService.class);
		// ConseillerService conseillerService =
		// applicationContext.getBean("conseillerService",
		// ConseillerService.class);

		Adresse adresse = new Adresse(numero, rue, ville, codePostal);
		Client client = new Client(nom, prenom, email, adresse);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Conseiller conseiller = (Conseiller) session.getAttribute("Conseiller");
		// System.out.println(conseiller);
		// conseiller.getListClients().add(client);

		// System.out.println(conseiller);
		// client.setConseiller(conseiller);
		// System.out.println(client);
		// System.out.println(conseiller);

		// conseillerService.merge(conseiller);
		clientService.createClient(client);

		// clientService.merge(client);
		return "accueil.xhtml";

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Supprimer un client
	 */
	public void supprimerClient(Client client) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		// ConseillerService conseillerService =
		// applicationContext.getBean("conseillerService",
		// ConseillerService.class);

		// HttpSession session = (HttpSession)
		// FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		// Client clientp = (Client) session.getAttribute("Client");
		clientService.remove(client);
	}

	/**
	 * @author Nabila Marc-Antoine Quentin modifier un client
	 */
	public String modifierClient() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-db-mysql.xml");
		ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
		ConseillerService conseillerService = applicationContext.getBean("conseillerService", ConseillerService.class);

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Client clientp = (Client) session.getAttribute("Client");
		Adresse adressep = clientp.getAdresse();
		clientp.setEmail(email);
		clientp.setNom(nom);
		clientp.setPrenom(prenom);
		adressep.setCodePostal(codePostal);
		adressep.setNumero(numero);
		adressep.setRue(rue);
		adressep.setVille(ville);
		clientp.setAdresse(adressep);

		clientService.merge(clientp);
		return "accueil.xhtml";

	}

	/**
	 * @author Nabila Marc-Antoine Quentin Afficher le détail d'un client
	 */
	public String detailsClient(Client client) throws Exception {
		System.out.println(client);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("Client", client);
		setNom(client.getNom());
		setPrenom(client.getPrenom());
		setEmail(client.getEmail());
		setRue(client.getAdresse().getRue());
		setNumero(client.getAdresse().getNumero());
		setCodePostal(client.getAdresse().getCodePostal());
		setVille(client.getAdresse().getVille());
		return "detailsClient.xhtml";
	}

}
