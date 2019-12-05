package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projPOO01.Exceptions.ExceptionNumeroUnique;
import projPOO01.Exceptions.ExceptionSaisiNumeroSecu;
import projPOO01.Exceptions.ExceptionSaisieCodePostal;
import projPOO01.GestionPersonnes.Client;
import projPOO01.GestionPersonnes.Fournisseur;
import projPOO01.GestionPersonnes.Personne;
import projPOO01.GestionPersonnes.Salarie;

public class TestSaisies {

	private final String cpf="698400";
	private final String cpf1="60cde";
	private final String cpt="69100";
	private final String nsf="12345678901234";
	private final String nsf1="123abcd890123";
	private final String nst="1234567890123";
	private ArrayList<Fournisseur> flist;
	private Fournisseur f;
	private final Integer ofnumunique = 1;
	private final String fnumuniquef ="1";
	private final String fnumuniquef1="a";
	private final String fnumuniquet="2";
	private ArrayList<Client> clist;
	private Client c;
	private final Integer ocnumunique = 1;
	private final String cnumuniquef ="1";
	private final String cnumuniquef1="a";
	private final String cnumuniquet="2";
	
	@Before
	public void init() {
		flist = new ArrayList<Fournisseur>();
		f = new Fournisseur("Fournisseur","test","rue","Lyon","69000",ofnumunique);
		flist.add(f);
		
		clist = new ArrayList<Client>();
		c = new Client("Client","test","rue","Lyon","69000",ocnumunique);	
		clist.add(c);
		
	}
	
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
		try {
			Salarie.CtrlSaisiNumeroSecu(nst);
			Salarie.CtrlSaisiNumeroSecu(nsf);
		}catch(ExceptionSaisiNumeroSecu e) {
			assertThat(e.getMessage(), is("Le nombre de caractère est différents de 13"));
		}
		
		try {
			Salarie.CtrlSaisiNumeroSecu(nsf1);
		}catch(ExceptionSaisiNumeroSecu e) {
			assertThat(e.getMessage(), is("Il faut saisir uniquement des chiffres"));
		}
	}
	
	@Test
	public void testCtrlDoublons() {
		try {
			Fournisseur.CtrlNumeroUniqueFournisseur(fnumuniquet, flist);
			Fournisseur.CtrlNumeroUniqueFournisseur(fnumuniquef, flist);	
		}catch(ExceptionNumeroUnique e ) {
			assertThat(e.getMessage(),is("Le numero unique est déja utilisé"));
		}
		
		try {
			Fournisseur.CtrlNumeroUniqueFournisseur(fnumuniquef1, flist);
		}catch(ExceptionNumeroUnique e ) {
			assertThat(e.getMessage(),is("Le numero saisi n'est pas un entier"));
		}
		
		try {
			Client.CtrlNumeroUniqueClient(cnumuniquet, clist);
			Client.CtrlNumeroUniqueClient(cnumuniquef, clist);	
		}catch(ExceptionNumeroUnique e ) {
			assertThat(e.getMessage(),is("Le numero unique est déja utilisé"));
		}
		
		try {
			Client.CtrlNumeroUniqueClient(cnumuniquef1, clist);
		}catch(ExceptionNumeroUnique e ) {
			assertThat(e.getMessage(),is("Le numero saisi n'est pas un entier"));
		}
		
	}

}
