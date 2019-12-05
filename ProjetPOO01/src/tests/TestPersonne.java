package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projPOO01.GestionPersonnes.Personne;
public class TestPersonne {
	
	private Personne p;
	private final String onom ="Personne";
	private final String oprenom ="Test";
	private final String oville ="Lyon";
	private final String oadresse ="Rue";
	private final String ocodepostal ="69000";
	private final String setnom ="";
	private final String setprenom ="";
	private final String setville ="";
	private final String setadresse ="";
	private final String setcodepostal ="";
	private final String ts= "Personne [nom=" + onom + ", prenom=" + oprenom + ", adresse=" + oadresse + ", ville=" + oville
			+ ", codepostal=" + ocodepostal + "]";
			
	@Before
	public void init() {
		p = new Personne(onom,oprenom,oadresse,oville,ocodepostal);
	}

	@Test
	public void testPersonne() {
		assertNotNull(p);
	}

	@Test
	public void testToString() {
		assertEquals(ts,p.toString());
	}

	@Test
	public void testGetNom() {
		assertEquals(onom, p.getNom());
	}

	@Test
	public void testSetNom() {
		p.setNom(setnom);
		assertEquals(setnom,p.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals(oprenom,p.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		p.setPrenom(setprenom);
		assertEquals(setprenom,p.getPrenom());
	}

	@Test
	public void testGetAdresse() {
		assertEquals(oadresse,p.getAdresse());
	}

	@Test
	public void testSetAdresse() {
		p.setAdresse(setadresse);
		assertEquals(setadresse,p.getAdresse());
	}

	@Test
	public void testGetVille() {
		assertEquals(oville,p.getVille());
	}

	@Test
	public void testSetVille() {
		p.setVille(setville);
		assertEquals(setville,p.getVille());
	}

	@Test
	public void testGetCodepostal() {
		assertEquals(ocodepostal,p.getCodepostal());
	}

	@Test
	public void testSetCodepostal() {
		p.setCodepostal(setcodepostal);
		assertEquals(setcodepostal,p.getCodepostal());
	}



}
