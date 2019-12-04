package tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import projPOO01.Exceptions.ExceptionSaisieCodePostal;
import projPOO01.GestionPersonnes.Personne;

public class TestSaisies {

	private final String cpf="698400";
	private final String cpf1="60cde";
	private final String cpt="69100";
	
	@Test
	public void testCtrlCodePostal(){
		try {
			Personne.CtrlCodePostal(cpt);
			Personne.CtrlCodePostal(cpf);
		}catch(ExceptionSaisieCodePostal e) {
			assertThat(e.getMessage(), is("Le nombre de caractère est différents de 5."));
		}
		try {
			Personne.CtrlCodePostal(cpf1);
		}catch(ExceptionSaisieCodePostal e) {
			assertThat(e.getMessage(), is("Il faut saisir uniquement des chiffres"));
		}
	}
	
	@Test
	public void testCtrlNumSecu() {
		
	}
	
	@Test
	public void testCtrlDoublons() {
		
	}

}
