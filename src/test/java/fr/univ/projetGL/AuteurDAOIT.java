package fr.univ.projetGL;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AuteurDAOIT {
	
	@Test
	public void testFindAll() {
		AuteurDAO a = new AuteurDAO();
		List<Auteur> res = a.findAll();
		
		List<Auteur> exp = new ArrayList<Auteur>();
		exp.add(new Auteur(1,"GOODKIND","Terry","Omaha"));
		exp.add(new Auteur(2,"EDDINGS","David","Carson City"));
		exp.add(new Auteur(3,"CYMES","Michel","Paris"));
	
		for(int i=0;i<res.size();i++){
			// Compare les deux objets
            Assert.assertEquals(exp.get(i).getIdAuteur(), res.get(i).getIdAuteur());
		}
	}
	
	@Test
	public void testDelete() {
		AuteurDAO a = new AuteurDAO();
		a.create(new Auteur(4,"GOODKIND","Terry","Omaha"));
		// Verifie si l.delete retourne bien true
		Assert.assertTrue(a.delete(new Auteur(4,"GOODKIND","Terry","Omaha")));
	}
	
	@Test
	public void testCreate() {
		AuteurDAO a = new AuteurDAO();
		// Verifie si l.create retourne bien true
		Assert.assertTrue(a.create(new Auteur(4,"GOODKIND","Terry","Omaha")));
		a.delete(new Auteur(4,"GOODKIND","Terry","Omaha"));
	}
}
