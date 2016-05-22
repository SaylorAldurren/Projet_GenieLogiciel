package fr.univ.projetGL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleResultSet;

public class AuteurDAO extends DAO<Auteur>{

	@Override
	public boolean create(Auteur obj) {
		int id = obj.getIdAuteur();
		String nom = obj.getNom();
		String prenom = obj.getPrenom();
		String ville = obj.getVille();
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			stmt.executeUpdate("INSERT INTO Auteur VALUES ("+id+", '"+nom+"', '"+prenom+"', '"+ville+"')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Auteur obj) {
		int id = obj.getIdAuteur();
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			stmt.executeUpdate("DELETE FROM Auteur where idAuteur ="+id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Auteur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Auteur find(int id) {
		Auteur auteur = new Auteur();
		
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			OracleResultSet rset = (OracleResultSet) stmt.executeQuery("select * from Auteur where idAuteur = "+id);
			rset.next();
			auteur = new Auteur(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return auteur;
	}
	
	public List<Auteur> findAll() {
		List<Auteur> auteur = new ArrayList<Auteur>();
		
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			OracleResultSet rset = (OracleResultSet) stmt.executeQuery("select * from Auteur");
			while (rset.next()) {
				auteur.add(new Auteur(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auteur;
	}
}