package tests;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

import projPOO01.GestionPersonnes.Patron;
import projPOO01.GestionPersonnes.Salarie;

public class TestPatron {

	
	private Patron p, p1;
	private final String onom ="Personne";
	private final String oprenom ="Test";
	private final String oville ="Lyon";
	private final String oadresse ="Rue";
	private final String ocodepostal ="69000";
	private final String osecu = "oopp";
	private final long osalaire =0L;

	
	@Before
	public void init() {
		p = new Patron(onom,oprenom,oadresse,oville,ocodepostal,osecu,osalaire);
		p1 = new Patron();
	}
	
	@Test
	public void testPatron() {
		assertNotNull(p1);
	}

	@Test
	public void testPatronStringStringStringStringStringStringDouble() {
		assertNotNull(p);
	}

	@Test
	public void testEmbauche() {
//		fail("Not yet implemented");
	}

	@Test
	public void testLicencie() {
//		fail("Not yet implemented");
	}

	@Test
	public void testPaieSalarie() {
//		fail("Not yet implemented");
	}

}
