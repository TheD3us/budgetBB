package bo;

public class ObjetPourBebe {

	private int id;
	private String nom;
	private Type type;
	private int valeur;
	

	public ObjetPourBebe() {
		super();
	}
	
	public ObjetPourBebe(int id, String nom, Type type, int valeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
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
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
