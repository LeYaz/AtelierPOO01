package projPOO01.affichages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import projPOO01.GestionPersonnes.Personne;
import projPOO01.Menu.Menus;
import projPOO01.saisie.Saisir;

public class Affichages {
	
	private final static ArrayList<Personne> lp1 =  Affichages.GrouperAffichage();
	private static String choix = null;

	public static void Afficher() {
		
		ArrayList<Personne> listpatron = new ArrayList<Personne>();
		listpatron.add(Saisir.patron);
		
		Map<String, iAffiche> im = new HashMap<String, iAffiche>();
		
		im.put("Taper 1 pour afficher toutes les données",(lp1)->Affichages.AfficherCommun(lp1));
		im.put("Taper 2 pour afficher les salariés",(lp1)-> Affichages.AfficherCommun(Saisir.listsalarie));
		im.put("Taper 3 pour afficher les clients",(lp1)->Affichages.AfficherCommun(Saisir.listclient));
		im.put("Taper 4 pour afficher les fournisseur",(lp1)-> Affichages.AfficherCommun(Saisir.listfournisseur));
		im.put("Taper 5 pour afficher le patron",(lp1)->Affichages.AfficherCommun(listpatron));
		im.put("Taper 6 pour retourner au menu", (lp1)->Menus.Menu());
		
		im.keySet().stream().sorted().forEach(s-> System.out.println(s));

		while(true) {
			
			choix = Menus.sc.next();
			
			im.entrySet().stream().filter(e->e.getKey().charAt(6) == choix.charAt(0)).
			forEach(e->e.getValue().afficher(lp1));
						
			}
		
		
	}
	
	
	public static void AfficherCommun(ArrayList<Personne> list ) {
		list.forEach(p -> System.out.println(p.toString()));
		
		Menus.RetourMenu();
	}
	
	public static ArrayList<Personne> GrouperAffichage() {
		ArrayList<Personne> list = new ArrayList<Personne>();
		list.addAll(Saisir.listsalarie);
		list.addAll(Saisir.listclient);
		list.addAll(Saisir.listfournisseur);
		list.add(Saisir.patron);
		
		return list;
	}
	
}
