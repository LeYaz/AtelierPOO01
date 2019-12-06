package projPOO01.Menu;

import java.util.Scanner;
import java.util.stream.Stream;

import projPOO01.Controles.Controles;
import projPOO01.Exceptions.ExceptionInt;
import projPOO01.actions.Effectuer;
import projPOO01.affichages.Affichages;
import projPOO01.saisie.Saisir;

public class Menus {
	public static Scanner sc =null;
	public static int choixmenu;
	
	public static void Menu() {
		
		
		String choix = null;
		boolean erreurint=true;
		Stream<String> txt = Stream.of(
				new String[] {"Taper 1 pour saisir des données",
						"Taper 2 pour Afficher les données",
						"Taper 3 pour saisir des achats",
						"Taper 4 pour saisir des commandes",
						});
		
		 erreurint=true;
			while(erreurint) {
				try {

					txt.forEach(s -> System.out.println(s));
					choix = sc.next();
					Controles.CtrlInt(choix);
					erreurint=false;
					
				}catch(ExceptionInt e) {
					System.out.println(e.getMessage());
				}
			}
			
		
		
		
		switch(Integer.parseInt(choix)) {
		case 1 : Saisir();
		break;
		case 2 : Affichages.Afficher();
		break;
		case 3: Effectuer.EffectuerAchat();
		break;
		case 4: Effectuer.EffectuerCommande();
		default : Menu();
		break;
		}
		
	}
	
	
	public static void RetourMenu() {
		
		System.out.println("Appuyer sur 1 et valider pour afficher le menu");
		Menus.sc.next();
		Menu();
	}
	
	public static void Saisir() {
		String choix = null;
		boolean erreurint=true;
		Stream<String> txt = Stream.of(
				new String[] {"Taper 1 pour saisir toutes les données",
						"Taper 2 pour saisir les salariés",
						"Taper 3 pour saisir les clients",
						"Taper 4 pour saisir les fournisseur",
						"Taper 5 pour saisir le patron",
						"Taper 6 pour retourner au menu"});
		
		erreurint=true;
		while(erreurint) {
			try {
			
				txt.forEach(s -> System.out.println(s));
				
				choix =sc.next();
				Controles.CtrlInt(choix);
				erreurint=false;
				
				
			}catch(ExceptionInt e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		choixmenu=Integer.parseInt(choix);
		
		switch(choixmenu) {
		case 1 : Saisir.SaisirAll();
		break;
		case 2 : Saisir.SaisirSalarie();
		break;
		case 3 : Saisir.SaisirClient();
		break;
		case 4 : Saisir.SaisirFournisseur();
		break;
		case 5 : Saisir.SaisirPatron();
		break;
		case 6 : Menu();
		break;
		default : Saisir();
		break;
		}
		
	}
}
