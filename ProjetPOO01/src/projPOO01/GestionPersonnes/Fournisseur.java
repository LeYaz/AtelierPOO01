package projPOO01.GestionPersonnes;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import ProjetPOO01.Enumerations.EFournisseur;
import projPOO01.Exceptions.ExceptionNumeroUnique;
import projPOO01.GestionAchat.Achat;
import projPOO01.GestionAchat.commande;

public class Fournisseur extends Personne implements IClient, IFournisseur {

	private int idfournisseur;
	private List<commande> commandes = new ArrayList<commande>();

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, int idfournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		// TODO Auto-generated constructor stub
		this.idfournisseur = idfournisseur;
	}
	
	public Fournisseur(Dictionary<EFournisseur, String> di) {
		super(di.get(EFournisseur.nom), di.get(EFournisseur.prenom), di.get(EFournisseur.adresse), di.get(EFournisseur.ville), di.get(EFournisseur.codepostal));
		this.idfournisseur= Integer.parseInt(di.get(EFournisseur.idfournisseur));
	}

	
	
	public List<commande> getCommandes() {
		return commandes;
	}

	@Override
	public String toString() {
		return super.toString() + "[idfournisseur=" + idfournisseur + ", commandes=" + commandes+"]";
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
		this.commandes = listcommande;
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
	
	public static void CtrlNumeroUniqueFournisseur(String ns, ArrayList<Fournisseur> list) throws ExceptionNumeroUnique{
		int n=0;
		try {
			 n = Integer.parseInt(ns);
			
				
			
		}catch(Exception e) {
			throw new ExceptionNumeroUnique("Le numero saisi n'est pas un entier");
		}
		for(Fournisseur c1:list) 
		{
			if(n!=c1.getIdfournisseur()) {
				
			}else {
				throw new ExceptionNumeroUnique("Le numero unique est déja utilisé");
				
			}
		}
		
	}

}
