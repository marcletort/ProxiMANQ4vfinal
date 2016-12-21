package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nabila Marc-Antoine Quentin
 * 
 */
@Entity
public class Virement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String date;
	// compteEx = compte expediteur
	private long compteEx;

	// compteBe = compte beneficiaire
	private long compteBe;
	private double montant;

	// getter & setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getCompteEx() {
		return compteEx;
	}

	public void setCompteEx(long compteEx) {
		this.compteEx = compteEx;
	}

	public long getCompteBe() {
		return compteBe;
	}

	public void setCompteBe(long compteBe) {
		this.compteBe = compteBe;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	// constructeurs
	public Virement(String date, long compteEx, long compteBe, double montant) {
		super();
		this.date = date;
		this.compteEx = compteEx;
		this.compteBe = compteBe;
		this.montant = montant;
	}

	public Virement() {
		super();
	}

	@Override
	public String toString() {
		return "Virement [id=" + id + ", date=" + date + ", compteEx=" + compteEx + ", compteBe=" + compteBe
				+ ", montant=" + montant + "]";
	}

}
