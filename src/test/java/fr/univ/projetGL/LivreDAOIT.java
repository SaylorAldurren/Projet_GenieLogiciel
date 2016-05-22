package fr.univ.projetGL;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LivreDAOIT {
	
	@Test
	public void testFindAll() {
		LivreDAO l = new LivreDAO();
		List<Livre> res = l.findAll();
		
		List<Livre> exp = new ArrayList<Livre>();
		exp.add(new Livre(1, "L epee de verite tome 1", "Heroic Fantasy", 1));
		exp.add(new Livre(2, "La redemption d Althalus", "Heroic Fantasy",1));
		exp.add(new Livre(3, "Hippocrate aux enfers", "Litterature et Documentation",3));
	
		for(int i=0;i<res.size();i++){
			// Compare les deux objets
            Assert.assertEquals(exp.get(i).getIdLivre(), res.get(i).getIdLivre());
		}
	}
	
	@Test
	public void testDelete() {
		LivreDAO l = new LivreDAO();
		l.create(new Livre(4, "Hippocrate aux enfers", "Litterature et Documentation",3));
		// Verifie si l.delete retourne bien true
		Assert.assertTrue(l.delete(new Livre(4, "Hippocrate aux enfers", "Litterature et Documentation",3)));
	}
	
	@Test
	public void testCreate() {
		LivreDAO l = new LivreDAO();
		// Verifie si l.create retourne bien true
		Assert.assertTrue(l.create(new Livre(4, "L epee de verite tome 1", "Heroic Fantasy", 1)));
		l.delete(new Livre(4, "L epee de verite tome 1", "Heroic Fantasy", 1));
	}
}