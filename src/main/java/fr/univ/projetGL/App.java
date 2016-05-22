package fr.univ.projetGL;

import java.sql.Statement;

import oracle.jdbc.OracleResultSet;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DAO<Livre> livreDAO = new LivreDAO();
    	DAO<Auteur> auteurDAO = new AuteurDAO();
    	Auteur auteur = new Auteur();
    	for(int i = 1; i < 4; i++){
    		Livre livre = livreDAO.find(i);
    	    for (int j = 1; j < 4; j++) {
				if (livre.getIdAuteur() == auteurDAO.find(j).getIdAuteur()) {
					auteur = auteurDAO.find(j);
					break;
				}
    	    }
    	    System.out.println("Livre N°" + livre.getIdLivre() + "  -  " + livre.getTitre() + "  -  " + livre.getGenre()+ "  -  " + auteur.getNom() + "  -  " + auteur.getPrenom());
    	}
    }
}
