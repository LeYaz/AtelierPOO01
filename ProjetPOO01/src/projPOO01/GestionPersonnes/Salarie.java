package projPOO01.GestionPersonnes;

import java.text.DecimalFormat;
import java.util.List;

import projPOO01.Exceptions.ExceptionSaisiNumeroSecu;
import projPOO01.GestionAchat.Achat;

public class Salarie extends Personne implements IClient{

	private String secu;
	private double salaire;

	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String secu, double salaire) {
		super(nom, prenom, adresse, ville, codepostal);
		// TODO Auto-generated constructor stub
		this.salaire = salaire;
		this.secu = secu;
	}
	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return super.toString()+ " [secu=" + secu + ", salaire=" + df.format(salaire) + "]";
	}


	@Override
	public void achete(List<Achat> listachat) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean paie() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static void CtrlSaisiNumeroSecu(String ns) throws ExceptionSaisiNumeroSecu{
		if(ns.length()!=13) {
			throw new ExceptionSaisiNumeroSecu("Le nombre de caractère est différents de 13");
		}
		try {
			Long.parseLong(ns);
		}catch(Exception e) {
			throw new ExceptionSaisiNumeroSecu("Il faut saisir uniquement des chiffres");
		}
	}


	@Override
	public boolean isClient() {
		// TODO Auto-generated method stub
		return false;
	}


	public String getSecu() {
		return secu;
	}


	public void setSecu(String secu) {
		this.secu = secu;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	

}
