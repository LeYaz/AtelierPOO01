package projPOO01.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import projPOO01.affichages.Affichages;
import projPOO01.saisie.Saisir;

public class Menus {
	public static Scanner sc =null;
	public static int choixmenu;
	private static String choix =null;
	
	public static void Menu() {
		choix=null;
		Map<String, iExecute> im = new HashMap<String, iExecute>();
		im.put("Taper 1 pour saisir des données", Menus::Saisir);
		im.put("Taper 2 pour Afficher les données", Affichages::Afficher);
		im.put("Taper 3 pour saisir des achats",Saisir::SaisirAchat);
		im.put("Taper 4 pour saisir des commandes", Saisir::SaisirCommande);
		

		im.keySet().stream().sorted().forEach(s-> System.out.println(s));

		while(true) {
			
			choix = sc.nextLine();
			
			
			im.entrySet().stream().filter(e->e.getKey().charAt(6) == choix.charAt(0)).
			forEach(e->e.getValue().apply());
						
			}

	}
	
	
	public static void RetourMenu() {
		
		System.out.println("Appuyer sur 1 et valider pour afficher le menu");
		Menus.sc.nextLine();
		Menu();
	}
	
	public static void Saisir() {
		choix=null;
		
		
		Map<String, iExecute> im = new HashMap<String, iExecute>();
		im.put("Taper 1 pour saisir toutes les données", Saisir::SaisirAll);
		im.put("Taper 2 pour saisir les salariés", Saisir::SaisirSalarie);
		im.put("Taper 3 pour saisir les clients",Saisir::SaisirClient);
		im.put("Taper 4 pour saisir les fournisseur", Saisir::SaisirFournisseur);
		im.put("Taper 5 pour saisir le patron",Saisir::SaisirPatron);
		im.put("Taper 6 pour retourner au menu", Menus::Menu);

		im.keySet().stream().sorted().forEach(s-> System.out.println(s));

		while(true) {
			
			choix = sc.nextLine();
			choixmenu = Integer.parseInt(choix);
			
			im.entrySet().stream().filter(e->e.getKey().charAt(6) == choix.charAt(0)).
			forEach(e->e.getValue().apply());
						
			}
		
		
		
	}
}
