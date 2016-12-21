package org.formation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @author Nabila Marc-Antoine Quentin Lien avec Adresse en Embedded Persistance
 *         en base de donnée et lien entre les tables client/conseiller/compte
 */
@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;

	private String email;

	@Embedded
	Adresse adresse;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conseiller_id")
	private Conseiller conseiller;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	CompteCourant compteCourant;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	CompteEpargne compteEpargne;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Client() {

	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client(String nom, String prenom, String email, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;

	}

}
