package projPOO01.GestionPersonnes;

import java.util.Dictionary;
import java.util.List;

import ProjetPOO01.Enumerations.EFournisseur;
import projPOO01.GestionAchat.Achat;
import projPOO01.GestionAchat.commande;

public class Fournisseur extends Personne implements IClient, IFournisseur {

	private int idfournisseur;

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, int idfournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		// TODO Auto-generated constructor stub
		this.idfournisseur = idfournisseur;
	}
	
	public Fournisseur(Dictionary<EFournisseur, String> di) {
		super(di.get(EFournisseur.nom), di.get(EFournisseur.prenom), di.get(EFournisseur.adresse), di.get(EFournisseur.ville), di.get(EFournisseur.codepostal));
		this.idfournisseur= Integer.parseInt(di.get(EFournisseur.idfournisseur));
	}

	
	
	@Override
	public String toString() {
		return super.toString() + "[idfournisseur=" + idfournisseur + "]";
	}



	public int getIdfournisseur() {
		return idfournisseur;
	}


	public void setIdfournisseur(int idfournisseur) {
		this.idfournisseur = idfournisseur;
	}


	@Override
	public void achete(List<Achat> listachat) {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur achete");
	}

	@Override
	public boolean paie() {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur paie");
		return true;
	}

	@Override
	public boolean livre() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void commande(List<commande> listcommande) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isClient() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isFournisseur() {
		// TODO Auto-generated method stub
		return true;
	}

}
