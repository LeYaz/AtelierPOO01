package projPOO01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projPOO01.Exceptions.ExceptionSaisiNumeroSecu;
import projPOO01.Exceptions.ExceptionSaisieCodePostal;
import projPOO01.GestionAchat.Achat;
import projPOO01.GestionPersonnes.Client;
import projPOO01.GestionPersonnes.Fournisseur;
import projPOO01.GestionPersonnes.IClient;
import projPOO01.GestionPersonnes.Salarie;


public class Programme {
	
	private static ArrayList<Client> listclient = new ArrayList<Client>();
	private static ArrayList<Salarie> listsalarie = new ArrayList<Salarie>();
	private static ArrayList<Fournisseur> listfournisseur = new ArrayList<Fournisseur>();
	private static int choixmenu;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<Client> lc= new ArrayList<Client>();
//		lc=Programme.SaisirClient();
//		for(Client c:lc) {
//			System.out.println(c.toString());
//		}
		
		Programme.Menu();
		
		
		
	}
	
	public static void Menu() {
		
		System.out.println("Taper 1 pour Saisir des données");
		System.out.println("Taper 2 pour Afficher les données");
		int choix;
		
		choix= Programme.sc.nextInt();
		
		switch(choix) {
		case 1 : Saisir();
		break;
		case 2 : Afficher();
		break;
		default : Menu();
		break;
		}
		
	}
	
	public static void RetourMenu() {
		
		System.out.println("Appuyer sur 1 et valider pour afficher le menu");
		Programme.sc.next();
		Menu();
	}
	
	public static void Saisir() {
		int choix;
		
		System.out.println("Taper 1 pour saisir toutes les données");
		System.out.println("Taper 2 pour saisir les salariés");
		System.out.println("Taper 3 pour saisir les clients");
		System.out.println("Taper 4 pour saisir les fournisseur");
		System.out.println("Taper 5 pour retourner au menu");
		
		choix=Programme.sc.nextInt();
		choixmenu=choix;
		
		switch(choix) {
		case 1 : SaisirAll();
		break;
		case 2 : SaisirSalarie();
		break;
		case 3 : SaisirClient();
		break;
		case 4 : SaisirFournisseur();
		break;
		case 5 : Menu();
		break;
		default : Saisir();
		break;
		}
		
	}
	
	public static void Afficher() {
		int choix;
		
		System.out.println("Taper 1 pour afficher toutes les données");
		System.out.println("Taper 2 pour afficher les salariés");
		System.out.println("Taper 3 pour afficher les clients");
		System.out.println("Taper 4 pour afficher les fournisseur");
		System.out.println("Taper 5 pour retourner au menu");
		
		choix=Programme.sc.nextInt();
		
		switch(choix) {
		case 1 : AfficherAll();
		break;
		case 2 : AfficherSalarie();
		break;
		case 3 : AfficherClient();
		break;
		case 4 : AfficherFournisseur();
		break;
		case 5 : Menu();
		break;
		default : Afficher();
		break;
		}
	}
	
	public static void AfficherAll() {
		for(Salarie c:Programme.listsalarie) {
			System.out.println(c.toString());
		}
		for(Client c:Programme.listclient) {
			System.out.println(c.toString());
		}
		for(Fournisseur c:Programme.listfournisseur) {
			System.out.println(c.toString());
		}
		
		RetourMenu();
		
	}
	
	public static void AfficherSalarie() {
		for(Salarie c:Programme.listsalarie) {
			System.out.println(c.toString());
		}
		RetourMenu();
	}
	
	public static void AfficherClient() {
		for(Client c:Programme.listclient) {
			System.out.println(c.toString());
		}
		RetourMenu();
	}
	
	public static void AfficherFournisseur() {
		for(Fournisseur c:Programme.listfournisseur) {
			System.out.println(c.toString());
		}
		RetourMenu();
	}
	
	public static void SaisirAll(){
		
		Programme.SaisirSalarie();
		Programme.SaisirClient();
		Programme.SaisirFournisseur();
		Menu();
	}
	
	
	public static void SaisirSalarie(){
		
		ArrayList<Salarie> sl = new ArrayList<Salarie>();
		String nom, prenom, adresse, ville, codepostal="", secu = null;
		double salaire=0;
		boolean erreurcp = true;
		boolean erreurns =true;
		
		for(int i=0;i<5; i++) {
			System.out.println("Saisir le nom du salarie");
			nom = sc.next();
			System.out.println("Saisir le prenom du salarie");
			prenom = sc.next();
			System.out.println("Saisir l'adresse du salarie");
			adresse = sc.next();
			System.out.println("Saisir la ville du salarie");
			ville = sc.next();
			erreurcp = true;
			while(erreurcp) {
				try {
					System.out.println("Saisir le codepostal du salarie");
					codepostal = sc.next();
					Salarie.CtrlCodePostal(codepostal);
					erreurcp = false;
				} catch (ExceptionSaisieCodePostal e) {
					// TODO Auto-generated catch block
					
					System.out.println(e.getMessage());
				}
			}
			
			erreurns=true;
			while(erreurns) {
				try {
					System.out.println("Saisir le numero de sécurité sociale du salarie");
					secu = sc.next();
					Salarie.CtrlSaisiNumeroSecu(secu);
					erreurns = false;
				} catch (ExceptionSaisiNumeroSecu e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage()+ " "+ secu.length());
				}
			}
			
			
			salaire=0;
			System.out.println("Saisir le salaire du salarie");
			while(sc.hasNext()&& salaire == 0)
			{
				
				if (sc.hasNextDouble()) {
		            salaire = sc.nextDouble();
		            break;
		         }
				else
				{
					System.out.println("Saisir le salaire du salarie");
					sc.next();
				}
					
			}
			
			
			Salarie s = new Salarie(nom, prenom, adresse, ville, codepostal, secu, salaire);
			
			sl.add(s);
		}
		
		listsalarie = sl;
		if(choixmenu!=1) {
			Menu();
		}
		return;
	}
	
	public static void SaisirClient(){
		
		ArrayList<Client> cl = new ArrayList<Client>();
		String nom, prenom, adresse, ville, codepostal;
		int idclient;
		boolean testid=false;
		
		for(int i=0;i<4; i++) {
			System.out.println("Saisir le nom du client");
			nom = sc.next();
			System.out.println("Saisir le prenom du client");
			prenom = sc.next();
			System.out.println("Saisir l'adresse du client");
			adresse = sc.next();
			System.out.println("Saisir la ville du client");
			ville = sc.next();
			System.out.println("Saisir le codepostal du client");
			codepostal = sc.next();
			
			do {
				System.out.println("Saisir le numero unique client");
				
				idclient = sc.nextInt();
				testid=false;
				for(Client c1:cl) {
					if(idclient!=c1.getIdclient()) {
						
					}else {
						System.out.println("numero unique déjà utilisé");
						testid=true;
					}
				}
			}while(testid);
			
			Client c = new Client(nom, prenom, adresse, ville, codepostal, idclient);
			
			cl.add(c);
		}
		
		
		listclient = cl;
		if(choixmenu!=1) {
			Menu();
		}
		return;
	}
	
	public static void SaisirFournisseur(){
		
		ArrayList<Fournisseur> cl = new ArrayList<Fournisseur>();
		String nom, prenom, adresse, ville, codepostal;
		int idfournisseur;
		boolean testid=false;
		
		for(int i=0;i<3; i++) {
			System.out.println("Saisir le nom du fournisseur");
			nom = sc.next();
			System.out.println("Saisir le prenom du fournisseur");
			prenom = sc.next();
			System.out.println("Saisir l'adresse du fournisseur");
			adresse = sc.next();
			System.out.println("Saisir la ville du fournisseur");
			ville = sc.next();
			System.out.println("Saisir le codepostal du fournisseur");
			codepostal = sc.next();
			
			do {
				System.out.println("Saisir le numero unique fournisseur");
				idfournisseur = sc.nextInt();
				testid=false;
				for(Fournisseur c1:cl) {
					if(idfournisseur!=c1.getIdfournisseur()) {
						
					}else {
						System.out.println("numero unique déjà utilisé");
						testid=true;
					}
				}
			}while(testid);
			
			Fournisseur c = new Fournisseur(nom, prenom, adresse, ville, codepostal, idfournisseur);
			
			cl.add(c);
		}
		
		
		listfournisseur = cl;
		if(choixmenu!=1) {
			Menu();
		}
		return;
	}
	

	
	public static void gereclient(IClient client, List<Achat> listachat) {
		client.achete(listachat);
		client.paie();
	}

}
