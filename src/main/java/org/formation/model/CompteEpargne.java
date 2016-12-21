package org.formation.model;

import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * @author Nabila Marc-Antoine Quentin Classe qui hérite de compte
 */
@Entity
public class CompteEpargne extends Compte {

	public CompteEpargne() {

	}

	public CompteEpargne(double montant, LocalDate dateOuverture) {
		super(montant, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompteEpargne numero = " + getId() + " solde = " + +getMontant() + " €";
	}

}
