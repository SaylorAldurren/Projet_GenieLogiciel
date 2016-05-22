package fr.univ.projetGL;

public class Auteur {
	private int idAuteur = 0;
	private String nom = "";
	private String prenom = "";
	private String ville = "";
	
	public Auteur(int idAuteur, String nom, String prenom, String ville) {
		this.setIdAuteur(idAuteur);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setVille(ville);
	}
	
	public Auteur () {};

	public int getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String toString() {
		return idAuteur+"  -  "+nom+"  -  "+prenom+"  -  "+ville;
	}
}
