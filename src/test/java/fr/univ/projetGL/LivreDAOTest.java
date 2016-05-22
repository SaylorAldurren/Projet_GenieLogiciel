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

public class LivreDAOTest {
	@Test
	public void testFindAll() throws SQLException{
        Connection c=Mockito.mock(Connection.class);
        ResultSet rset=Mockito.mock(ResultSet.class);
        Statement stmt=Mockito.mock(Statement.class);
        String req="SELECT * FROM Livre"; 
        
        final List<Livre> exp=new ArrayList<Livre>();
		exp.add(new Livre(1, "L epee de verite tome 1", "Heroic Fantasy", 1));
		exp.add(new Livre(2, "La redemption d Althalus", "Heroic Fantasy",1));
		exp.add(new Livre(3, "Hippocrate aux enfers", "Litterature et Documentation",3));
		
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
                        return exp.get(c++).getIdLivre();
                }
        });

        Mockito.when(rset.getString(2)).thenAnswer(new Answer<String>() {
                int c=0;
                public String answer(InvocationOnMock invocation) throws Throwable {
                		return exp.get(c++).getTitre();
                }
        });
        
        Mockito.when(rset.getString(3)).thenAnswer(new Answer<String>() {
	            int c=0;
	            public String answer(InvocationOnMock invocation) throws Throwable {
	            		return exp.get(c++).getGenre();
	            }
        });
        Mockito.when(rset.getInt(4)).thenAnswer(new Answer<Integer>() {
	            int c=0;
	            public Integer answer(InvocationOnMock invocation) throws Throwable {
	                    return exp.get(c++).getIdAuteur();
	            }
        });
        
        LivreDAO l=new LivreDAO();
        List<Livre> res=l.findAll();
        for(int i=0;i<res.size();i++){
                System.out.println(res.get(i).toString());
        }
	}
	
	@Test
	public void testDelete() throws SQLException {
		Livre livreTest = new Livre(3, "Hippocrate aux enfers", "Litterature et Documentation",3);
        Connection c=Mockito.mock(Connection.class);
        Statement stmt=Mockito.mock(Statement.class);
        String req="DELETE FROM Livre where idLivre ="+livreTest.getIdLivre();
        int value=1;
        
        Mockito.when(c.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeUpdate(req)).thenReturn(value);
        System.out.println("================= \n Ligne supprimee");
	}
	
	@Test
	public void testCreate() throws SQLException {
		Livre livreTest = new Livre(4, "Hippocrate aux enfers", "Litterature et Documentation",3);
        Connection c=Mockito.mock(Connection.class);
        Statement stmt=Mockito.mock(Statement.class);
        String req="INSERT INTO Livre VALUES ("+livreTest.getIdLivre()+", '"+livreTest.getTitre()+"', '"+livreTest.getGenre()+"', "+livreTest.getIdAuteur()+")";
        int value=1;
        
        Mockito.when(c.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeUpdate(req)).thenReturn(value);
        System.out.println("================= \n Ligne ajoutee ");
	}
}
