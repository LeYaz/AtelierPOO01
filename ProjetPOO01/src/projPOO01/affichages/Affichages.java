package projPOO01.affichages;

import java.util.ArrayList;
import java.util.stream.Stream;

import projPOO01.GestionPersonnes.Personne;
import projPOO01.Menu.Menus;
import projPOO01.saisie.Saisir;

public class Affichages {

	public static void Afficher() {
		int choix;
		ArrayList<Personne> listpatron = new ArrayList<Personne>();
		listpatron.add(Saisir.patron);
		Stream<String> txt = Stream.of(
				new String[] {
						"Taper 1 pour afficher toutes les données",
						"Taper 2 pour afficher les salariés",
						"Taper 3 pour afficher les clients",
						"Taper 4 pour afficher les fournisseur",
						"Taper 5 pour afficher le patron",
						"Taper 6 pour retourner au menu"
				});
		txt.forEach(t -> System.out.println(t));

		
		choix=Menus.sc.nextInt();
		
		switch(choix) {
		case 1 : AfficherCommun(Affichages.GrouperAffichage());
		break;
		case 2 : AfficherCommun(Saisir.listsalarie);
		break;
		case 3 : AfficherCommun(Saisir.listclient);
		break;
		case 4 : AfficherCommun(Saisir.listfournisseur);
		break;
		case 5 : AfficherCommun(listpatron);
		break;
		case 6 : Menus.Menu();
		break;
		default : Afficher();
		break;
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
