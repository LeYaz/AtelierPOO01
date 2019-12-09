package projPOO01.actions;

import java.util.ArrayList;
import java.util.List;

import projPOO01.GestionPersonnes.IClient;
import projPOO01.GestionPersonnes.IFournisseur;
import projPOO01.GestionPersonnes.Personne;
import projPOO01.affichages.Affichages;

public class Regrouper {

	public static List<IClient> listeclient = new ArrayList<IClient>();
	public static List<IFournisseur> listifournisseur = new ArrayList<IFournisseur>();

	/**
	 * Méthode permettant de regrouper les IClient
	 * 
	 * @return List<IClient> pour qui isClient() est vrai
	 */
	public static void RegrouperIClient() {
		List<IClient> list = new ArrayList<IClient>();
		ArrayList<Personne> plist = new ArrayList<Personne>();
		plist = Affichages.GrouperAffichage();
		listeclient.clear();

		plist.forEach(p -> {
			if (p instanceof IClient) {
				list.add((IClient) p);
			}
		});
		list.forEach(c -> {
			if (c.isClient()) {
				listeclient.add(c);
			}
		});

	}

	public static void RegrouperIFournisseur() {
		List<IFournisseur> list = new ArrayList<IFournisseur>();
		ArrayList<Personne> plist = new ArrayList<Personne>();
		plist = Affichages.GrouperAffichage();
		listifournisseur.clear();
		plist.forEach(p->{
			if (p instanceof IFournisseur) {
				list.add((IFournisseur) p);
			}
		});
		
		list.forEach(f->{
			if (f.isFournisseur()) {
				listifournisseur.add(f);
			}
		});
		
			
		

	}

}
