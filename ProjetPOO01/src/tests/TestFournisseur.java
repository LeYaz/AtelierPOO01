package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projPOO01.GestionAchat.Achat;
import projPOO01.GestionAchat.commande;
import projPOO01.GestionPersonnes.Fournisseur;

public class TestFournisseur {
	
	private Fournisseur f;
	private commande c;
	private final String ointitule ="intitule";
	private final Integer oqte= new Integer(10);
	private final Date od = new Date();
	private final String onom ="Personne";
	private final String oprenom ="Test";
	private final String oville ="Lyon";
	private final String oadresse ="Rue";
	private final String ocodepostal ="69000";
	private final int oidfournisseur = 1;
	private final int setidfournisseur = 10;
	private List<commande> commandes= new ArrayList<commande>();
	private final String ts= "Fournisseur [nom=" + onom + ", prenom=" + oprenom + ", adresse=" + oadresse + ", ville=" + oville
			+ ", codepostal=" + ocodepostal + "]" + "[idfournisseur=" + oidfournisseur + ", commandes=" + commandes.toString()+"]";

	
	@Before
	public void init() {
		f = new Fournisseur(onom,oprenom,oadresse,oville,ocodepostal,oidfournisseur);
		c = new commande(od,ointitule,oqte);
		commandes.add(c);
	}
	@Test
	public void testToString() {
		assertEquals(ts,f.toString());
	}

	@Test
	public void testFournisseurStringStringStringStringStringInt() {
		assertNotNull(f);
	}

	@Test
	public void testGetIdfournisseur() {
		assertEquals(oidfournisseur,f.getIdfournisseur());
	}

	@Test
	public void testSetIdfournisseur() {
		f.setIdfournisseur(setidfournisseur);
		assertEquals(setidfournisseur,f.getIdfournisseur());
	}

	@Test
	public void testGetCommandes() {
		this.testCommande();
		assertEquals(commandes,f.getCommandes());
	}
	@Test
	public void testAchete() {
//		fail("Not yet implemented");
	}

	@Test
	public void testPaie() {
//		fail("Not yet implemented");
	}

	@Test
	public void testLivre() {
		assertTrue(f.livre());
	}

	@Test
	public void testCommande() {
		f.commande(commandes);
		assertEquals(commandes,f.getCommandes());
	}

	@Test
	public void testIsClient() {
		assertFalse(f.isClient());
	}

	@Test
	public void testIsFournisseur() {
		assertTrue(f.isFournisseur());
	}


}
