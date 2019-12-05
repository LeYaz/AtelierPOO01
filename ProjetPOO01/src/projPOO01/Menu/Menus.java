package projPOO01.Menu;

import java.util.Scanner;

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
		
		 erreurint=true;
			while(erreurint) {
				try {
					System.out.println("Taper 1 pour Saisir des données");
					System.out.println("Taper 2 pour Afficher les données");
					System.out.println("Taper 3 pour saisir des achats");
					System.out.println("Taper 4 pour saisir des commandes");
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
		
		
		erreurint=true;
		while(erreurint) {
			try {
				System.out.println("Taper 1 pour saisir toutes les données");
				System.out.println("Taper 2 pour saisir les salariés");
				System.out.println("Taper 3 pour saisir les clients");
				System.out.println("Taper 4 pour saisir les fournisseur");
				System.out.println("Taper 5 pour saisir le patron");
				System.out.println("Taper 6 pour retourner au menu");
				
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
