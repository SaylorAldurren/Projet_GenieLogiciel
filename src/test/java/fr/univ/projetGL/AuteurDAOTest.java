package fr.univ.projetGL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class AuteurDAOTest {
	@Test
	public void testFindAll() throws SQLException{
        Connection c=Mockito.mock(Connection.class);
        ResultSet rset=Mockito.mock(ResultSet.class);
        Statement stmt=Mockito.mock(Statement.class);
        String req="SELECT * FROM Auteur"; 
        
        final List<Auteur> exp=new ArrayList<Auteur>();
		exp.add(new Auteur(1,"GOODKIND","Terry","Omaha"));
		exp.add(new Auteur(2,"EDDINGS","David","Carson City"));
		exp.add(new Auteur(3,"CYMES","Michel","Paris"));
		
        Mockito.when(c.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(req)).thenReturn(rset);
        
        Mockito.when(rset.next()).thenAnswer(new Answer<Boolean>() {
                int c=0;
                public Boolean answer(InvocationOnMock invocation) throws Throwable {
                        return (c++<exp.size());
                }
        });
        
        Mockito.when(rset.getInt(1)).thenAnswer(new Answer<Integer>() {
                int c=0;
                public Integer answer(InvocationOnMock invocation) throws Throwable {
                        return exp.get(c++).getIdAuteur();
                }
        });

        Mockito.when(rset.getString(2)).thenAnswer(new Answer<String>() {
                int c=0;
                public String answer(InvocationOnMock invocation) throws Throwable {
                		return exp.get(c++).getNom();
                }
        });
        
        Mockito.when(rset.getString(3)).thenAnswer(new Answer<String>() {
	            int c=0;
	            public String answer(InvocationOnMock invocation) throws Throwable {
	            		return exp.get(c++).getPrenom();
	            }
        });
        Mockito.when(rset.getString(3)).thenAnswer(new Answer<String>() {
	            int c=0;
	            public String answer(InvocationOnMock invocation) throws Throwable {
	            		return exp.get(c++).getVille();
	            }
        });
        
        AuteurDAO l=new AuteurDAO();
        List<Auteur> res=l.findAll();
        for(int i=0;i<res.size();i++){
                System.out.println(res.get(i).toString());
        }
	}
	
	@Test
	public void testDelete() throws SQLException {
		Auteur auteurTest = new Auteur(4,"GOODKIND","Terry","Omaha");
        Connection c=Mockito.mock(Connection.class);
        Statement stmt=Mockito.mock(Statement.class);
        String req="DELETE FROM Auteur where idAuteur ="+auteurTest.getIdAuteur();
        int value=1;
        
        Mockito.when(c.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeUpdate(req)).thenReturn(value);
        System.out.println("================= \n Ligne supprimee \n \n");
	}
	
	@Test
	public void testCreate() throws SQLException {
		Auteur auteurTest = new Auteur(4,"GOODKIND","Terry","Omaha");
        Connection c=Mockito.mock(Connection.class);
        Statement stmt=Mockito.mock(Statement.class);
        String req="INSERT INTO Auteur VALUES ("+auteurTest.getIdAuteur()+", '"+auteurTest.getNom()+"', '"+auteurTest.getPrenom()+"', "+auteurTest.getVille()+")";
        int value=1;
        
        Mockito.when(c.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeUpdate(req)).thenReturn(value);
        System.out.println("================= \n Ligne ajoutee ");
	}
}

