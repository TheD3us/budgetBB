package bo;

import java.time.LocalDate;

public class ObjetPourBebe {

	private int id;
	private String nom;
	private Type type;
	private double valeur;
	private LocalDate dateCreation;
	private LocalDate dateModification;
	

	public ObjetPourBebe() {
		super();
	}
	
	

	
	public ObjetPourBebe(String nom, Type type, double valeur, LocalDate dateModification) {
		super();
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
		this.dateModification = dateModification;
	}




	public ObjetPourBebe(String nom, Type type, double valeur, LocalDate dateCreation,
			LocalDate dateModification) {
		super();
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDate getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDate dateModification) {
		this.dateModification = dateModification;
	}
	
	
}
