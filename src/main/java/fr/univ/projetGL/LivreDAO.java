package fr.univ.projetGL;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleResultSet;

public class LivreDAO extends DAO<Livre>{
	
	public LivreDAO() {
	}

	@Override
	public boolean create(Livre obj) {
		int id = obj.getIdLivre();
		String titre = obj.getTitre();
		String genre = obj.getGenre();
		int idaut = obj.getIdAuteur();
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			stmt.executeUpdate("INSERT INTO Livre VALUES ("+id+", '"+titre+"', '"+genre+"', "+idaut+")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Livre obj) {
		int id = obj.getIdLivre();
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			int res = stmt.executeUpdate("DELETE FROM Livre where idLivre ="+id);
			if (res != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Livre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Livre find(int id) {
		Livre livre = new Livre();
		
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			OracleResultSet rset = (OracleResultSet) stmt.executeQuery("select * from Livre where idlivre = "+id);
			rset.next();
			livre = new Livre(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return livre;
	}
	
	public List<Livre> findAll() {
		List<Livre> livre = new ArrayList<Livre>();
		
		try {
			Statement stmt = Connexion.GetInstance().createStatement();
			OracleResultSet rset = (OracleResultSet) stmt.executeQuery("select * from Livre");
			while (rset.next()) {
				livre.add(new Livre(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livre;
	}
}
