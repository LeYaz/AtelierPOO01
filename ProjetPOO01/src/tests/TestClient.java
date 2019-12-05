package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projPOO01.GestionAchat.Achat;
import projPOO01.GestionPersonnes.Client;


public class TestClient {
	
	private Client c;
	private Achat a;
	private final String ointitule ="intitule";
	private final Integer oqte= new Integer(10);
	private final Date od = new Date();
	private final String onom ="Personne";
	private final String oprenom ="Test";
	private final String oville ="Lyon";
	private final String oadresse ="Rue";
	private final String ocodepostal ="69000";
	private final int oidclient = 1;
	private final int setidclient = 10;
	private List<Achat> achats = new ArrayList<Achat>();
	private final String ts= "Client [nom=" + onom + ", prenom=" + oprenom + ", adresse=" + oadresse + ", ville=" + oville
			+ ", codepostal=" + ocodepostal + "]" + "[idclient=" + oidclient + ", achats=" + achats.toString()+"]";

	
	@Before
	public void init() {
		c = new Client(onom, oprenom, oadresse, oville, ocodepostal, oidclient);
		a = new Achat(od,ointitule,oqte);
		achats.add(a);
	}
	
	@Test
	public void testToString() {
		assertEquals(ts, c.toString());
	}

	@Test
	public void testClient() {
		assertNotNull(c);
	}
	
	@Test
	public void testGetAchat() {
		this.testAchete();
		assertEquals(achats,c.getAchats());
		
	}

	@Test
	public void testGetIdclient() {
		assertEquals(oidclient, c.getIdclient());
	}

	@Test
	public void testSetIdclient() {
		c.setIdclient(setidclient);
		assertEquals(setidclient,c.getIdclient());
	}

	@Test
	public void testLivre() {
		assertTrue(c.livre());
	}

	@Test
	public void testCommande() {
//		fail("Not yet implemented");
	}

	@Test
	public void testAchete() {
		c.achete(achats);
		assertEquals(achats, c.getAchats());
	}

	@Test
	public void testPaie() {
		assertTrue(c.paie());
	}

	@Test
	public void testIsClient() {
		assertTrue(c.isClient());
	}

	@Test
	public void testIsFournisseur() {
		assertFalse(c.isFournisseur());
	}



}
