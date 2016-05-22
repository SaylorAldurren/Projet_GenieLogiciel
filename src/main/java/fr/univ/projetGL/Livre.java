package fr.univ.projetGL;

public class Livre {
	private int idLivre = 0;
	private String titre = "";
	private String genre = "";
	private int idAuteur = 0;
	
	public Livre(int idLivre, String titre, String genre, int idAuteur) {
		this.setIdLivre(idLivre);
		this.setTitre(titre);
		this.setGenre(genre);
		this.setIdAuteur(idAuteur);
	}
	
	public Livre() {};
	
	public int getIdLivre() {
		return this.idLivre;
	}
	
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}
	
	public String toString() {
		return idLivre+"  -  "+titre+"  -  "+genre+"  -  "+idAuteur;
	}
}
