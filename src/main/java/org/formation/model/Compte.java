package org.formation.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

/**
 * @author Nabila Marc-Antoine Quentin Classe en héritage pour compte courant et
 *         compte épargne Persistance en base de données Lien avec le client en
 *         table
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double montant;
	private LocalDate dateOuverture;

	@OneToOne(cascade = { CascadeType.PERSIST })
	private Client client;

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDate getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(LocalDate dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Compte(double montant, LocalDate dateOuverture) {
		super();
		this.montant = montant;
		this.dateOuverture = dateOuverture;
	}

	public Compte() {
		super();
	}

}
