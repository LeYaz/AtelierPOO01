package projPOO01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projPOO01.Exceptions.ExceptionDate;
import projPOO01.Exceptions.ExceptionInt;
import projPOO01.Exceptions.ExceptionNumeroUnique;
import projPOO01.Exceptions.ExceptionSaisiNumeroSecu;
import projPOO01.Exceptions.ExceptionSaisieCodePostal;
import projPOO01.GestionAchat.Achat;
import projPOO01.GestionPersonnes.Client;
import projPOO01.GestionPersonnes.Fournisseur;
import projPOO01.GestionPersonnes.IClient;
import projPOO01.GestionPersonnes.Patron;
import projPOO01.GestionPersonnes.Personne;
import projPOO01.GestionPersonnes.Salarie;


public class Programme {
	
	private static ArrayList<Personne> listclient = new ArrayList<Personne>();
	private static ArrayList<Personne> listsalarie = new ArrayList<Personne>();
	private static ArrayList<Personne> listfournisseur = new ArrayList<Personne>();
	private static List<IClient> listeclient = new ArrayList<IClient>();
	private static int choixmenu;
	private static Scanner sc = new Scanner(System.in);
	private static Patron patron = new Patron();

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
		
		
		String choix = null;
		boolean erreurint=true;
		
		 erreurint=true;
			while(erreurint) {
				try {
					System.out.println("Taper 1 pour Saisir des données");
					System.out.println("Taper 2 pour Afficher les données");
					System.out.println("Taper 3 pour saisir des achats");
					choix = sc.next();
					CtrlInt(choix);
					erreurint=false;
					
				}catch(ExceptionInt e) {
					System.out.println(e.getMessage());
				}
			}
			
		
		
		
		switch(Integer.parseInt(choix)) {
		case 1 : Saisir();
		break;
		case 2 : Afficher();
		break;
		case 3: EffectuerAchat();
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
				CtrlInt(choix);
				erreurint=false;
				
				
			}catch(ExceptionInt e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		choixmenu=Integer.parseInt(choix);
		
		switch(choixmenu) {
		case 1 : SaisirAll();
		break;
		case 2 : SaisirSalarie();
		break;
		case 3 : SaisirClient();
		break;
		case 4 : SaisirFournisseur();
		break;
		case 5 : SaisirPatron();
		break;
		case 6 : Menu();
		break;
		default : Saisir();
		break;
		}
		
	}
	
	public static void Afficher() {
		int choix;
		ArrayList<Personne> listpatron = new ArrayList<Personne>();
		listpatron.add(patron);
		
		System.out.println("Taper 1 pour afficher toutes les données");
		System.out.println("Taper 2 pour afficher les salariés");
		System.out.println("Taper 3 pour afficher les clients");
		System.out.println("Taper 4 pour afficher les fournisseur");
		System.out.println("Taper 5 pour afficher le patron");
		System.out.println("Taper 6 pour retourner au menu");
		
		choix=Programme.sc.nextInt();
		
		switch(choix) {
		case 1 : AfficherCommun(Programme.GrouperAffichage());
		break;
		case 2 : AfficherCommun(Programme.listsalarie);
		break;
		case 3 : AfficherCommun(Programme.listclient);
		break;
		case 4 : AfficherCommun(Programme.listfournisseur);
		break;
		case 5 : AfficherCommun(listpatron);
		break;
		case 6 : Menu();
		break;
		default : Afficher();
		break;
		}
	}
	
	
	public static void AfficherCommun(ArrayList<Personne> list ) {
		for(Personne p:list) {
			System.out.println(p.toString());
		}
		RetourMenu();
	}
	
	public static ArrayList<Personne> GrouperAffichage() {
		ArrayList<Personne> list = new ArrayList<Personne>();
		list.addAll(Programme.listsalarie);
		list.addAll(Programme.listclient);
		list.addAll(Programme.listfournisseur);
		list.add(patron);
		
		return list;
	}
	
	
	public static void SaisirAll(){
		
		Programme.SaisirSalarie();
		Programme.SaisirClient();
		Programme.SaisirFournisseur();
		Programme.SaisirPatron();
		Menu();
	}
	
	public static void SaisirPatron() {
		boolean erreurcp;
		boolean erreurns;
		System.out.println("Saisir le nom du patron");
		patron.setNom(sc.next());
		System.out.println("Saisir le prenom du patron");
		patron.setPrenom(sc.next());
		System.out.println("Saisir l'adresse du patron");
		patron.setAdresse(sc.next());
		System.out.println("Saisir la ville du patron");
		patron.setVille(sc.next());
		erreurcp = true;
		while(erreurcp) {
			try {
				System.out.println("Saisir le codepostal du patron");
				patron.setCodepostal(sc.next());
				Salarie.CtrlCodePostal(patron.getCodepostal());
				erreurcp = false;
			} catch (ExceptionSaisieCodePostal e) {
				// TODO Auto-generated catch block
				
				System.out.println(e.getMessage());
			}
		}
		
		erreurns=true;
		while(erreurns) {
			try {
				System.out.println("Saisir le numero de sécurité sociale du patron");
				patron.setSecu(sc.next());
				Salarie.CtrlSaisiNumeroSecu(patron.getSecu());
				erreurns = false;
			} catch (ExceptionSaisiNumeroSecu e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
		
		
		System.out.println("Saisir le salaire du patron");
		while(sc.hasNext())
		{
			
			if (sc.hasNextDouble()) {
	            patron.setSalaire(sc.nextDouble());
	            break;
	         }
			else
			{
				System.out.println("Saisir le salaire du patron");
				sc.next();
			}
				
		}
		if(choixmenu!=1) {
			Menu();
		}
		return;
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
		
		listsalarie = new ArrayList<Personne>(sl);
		if(choixmenu!=1) {
			Menu();
		}
		return;
	}
	
	public static void SaisirClient(){
		
		ArrayList<Client> cl = new ArrayList<Client>();
		String nom, prenom, adresse, ville, codepostal="";
		String idclient="";
		boolean testid=false;
		boolean erreurcp = true;
		
		
		for(int i=0;i<2; i++) {
			System.out.println("Saisir le nom du client");
			nom = sc.next();
			System.out.println("Saisir le prenom du client");
			prenom = sc.next();
			System.out.println("Saisir l'adresse du client");
			adresse = sc.next();
			System.out.println("Saisir la ville du client");
			ville = sc.next();
			erreurcp = true;
			while(erreurcp) {
				try {
					System.out.println("Saisir le codepostal du client");
					codepostal = sc.next();
					Salarie.CtrlCodePostal(codepostal);
					erreurcp = false;
				} catch (ExceptionSaisieCodePostal e) {
					// TODO Auto-generated catch block
					
					System.out.println(e.getMessage());
				}
			}
			
			testid=true;
			while(testid) {
				try{
					System.out.println("Saisir le numero unique client");
					idclient =sc.next();
					Client.CtrlNumeroUniqueClient(idclient,cl);
					testid=false;
					
				}catch(ExceptionNumeroUnique e) {
					System.out.println(e.getMessage());
				}
				
			}
			

			Client c = new Client(nom, prenom, adresse, ville, codepostal, Integer.parseInt(idclient));
			
			cl.add(c);
		}
		
		
		listclient = new ArrayList<Personne>(cl);
		if(choixmenu!=1) {
			Menu();
		}
		return;
	}
	
	public static void SaisirFournisseur(){
		
		ArrayList<Fournisseur> cl = new ArrayList<Fournisseur>();
		String nom, prenom, adresse, ville, codepostal="";
		String idfournisseur="";
		
		boolean erreurcp=true;
		boolean numunique = true;
		
		for(int i=0;i<3; i++) {
			System.out.println("Saisir le nom du fournisseur");
			nom = sc.next();
			System.out.println("Saisir le prenom du fournisseur");
			prenom = sc.next();
			System.out.println("Saisir l'adresse du fournisseur");
			adresse = sc.next();
			System.out.println("Saisir la ville du fournisseur");
			ville = sc.next();
			erreurcp = true;
			while(erreurcp) {
				try {
					System.out.println("Saisir le codepostal du fournisseur");
					codepostal = sc.next();
					Salarie.CtrlCodePostal(codepostal);
					erreurcp = false;
				} catch (ExceptionSaisieCodePostal e) {
					// TODO Auto-generated catch block
					
					System.out.println(e.getMessage());
				}
			}
			numunique=true;
			while(numunique) {
				try{
					System.out.println("Saisir le numero unique fournisseur");
					idfournisseur =sc.next();
					Fournisseur.CtrlNumeroUniqueFournisseur(idfournisseur,cl);
					numunique=false;
					
				}catch(ExceptionNumeroUnique e) {
					System.out.println(e.getMessage());
				}
				
			}
			

			
			Fournisseur c = new Fournisseur(nom, prenom, adresse, ville, codepostal, Integer.parseInt(idfournisseur));
			
			cl.add(c);
		}
		
		
		listfournisseur= new ArrayList<Personne>(cl);
		if(choixmenu!=1) {
			Menu();
		}
		return;
	}
	
	
	/**
	 * Methode permettant de remplir un tableau d'achat
	 * @return ArrayList<Achat>
	 */
	public static ArrayList<Achat> SaisirAchat(){
		ArrayList<Achat> achats = new ArrayList<Achat>();
		Date d = null; 
		String intitule;
		String qte = null;
		boolean b = true;
		boolean erreurint=true;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		boolean erreurdate=true;
		String date;
		
		while(b) {
			System.out.println("Entrez l'intitulé de votre achat");
			 intitule =sc.next();
			 erreurint=true;
			 while(erreurint) {
				 System.out.println("Saisir la quantité ");
				 try {
					 qte=sc.next();
					 CtrlInt(qte);
					 erreurint=false;
					 
				 }catch(ExceptionInt e) {
					 System.out.println(e.getMessage());
				 }
				 
			 }
			 
			 erreurdate=true;
			 while(erreurdate) {
				 System.out.println("veuillez saisir la date au format dd-MM-yyyy");
				  date =sc.next();	 
				 try {
					d= CtrlDate(date);
					
					erreurdate=false;
				} catch (ExceptionDate e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			 }
			 
			 
			 Achat a = new Achat(d, intitule, Integer.parseInt(qte));
			 achats.add(a);
			 System.out.println("Voulez vous poursuivre vos achats si oui entrer oui ");
			 if(sc.next().equals("oui")) {
				 b=true;
			 }else {
				 b=false;
			 }
		}
		
		return achats;
		
	}
	
	/**
	 * Méthode permettant de regrouper les IClient 
	 * 
	 * @return List<IClient>  pour qui isClient() est vrai
	 */
	public static void RegrouperIClient() {
		List<IClient> list = new ArrayList<IClient>();
		ArrayList<Personne> plist = new ArrayList<Personne>();
		plist= GrouperAffichage();
		Programme.listeclient.clear();
		for(Personne p: plist) {
			if(p instanceof IClient)  {
				list.add((IClient)p);
			}
		}
		
		for(IClient c:list) {
			if(c.isClient()) {
				Programme.listeclient.add(c);
			}
		}
		
	}

	/**
	 * Methode permettant d'afficher et de choisir un IClient
	 * @param listc liste de IClient
	 * @return IClient choisi par l'utilisateur
	 */
	public static IClient ChoisirIClient(List<IClient> listc) {
		System.out.println("choix du client :");
		String choix = null;
		boolean erreurint = true;
		for(IClient c:listc) {
			
			System.out.println("Taper : " +listc.indexOf(c)+ " pour choisir : " + c.toString() );
		}
		
		 erreurint=true;
		while(erreurint) {
			try {
				choix = sc.next();
				CtrlInt(choix);
				erreurint=false;
				
			}catch(ExceptionInt e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		IClient c = listc.get(Integer.parseInt(choix));
		
		return c;
	}
	
	public static void EffectuerAchat() {
		RegrouperIClient();
		IClient client = ChoisirIClient(Programme.listeclient);
		List<Achat> a = SaisirAchat();
		client.achete(a);
		Menu();	
	}
	
	public static Date CtrlDate(String d) throws ExceptionDate{
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		sd.setLenient(false);
		Date dt = new Date();
		try {
			dt =sd.parse(d);
			
		}catch(Exception e) {
			throw new ExceptionDate("Mauvais format de date saisi");
		}
		return dt;
//		if(dt.getDay()>31) {
//			
//		}else {
//			throw new ExceptionDate("Le jour n'est pas valide");
//		}
//		if(dt.getMonth()>12) {
//			
//		}else {
//			throw new ExceptionDate("Le mois n'est pas valide");
//		}
	}
	
	public static void CtrlInt(String ns) throws ExceptionInt{
		int n=0;
		try {
			 n = Integer.parseInt(ns);
			
				
			
		}catch(Exception e) {
			throw new ExceptionInt("Veuillez saisir un entier");
		}
		
		}
	
	public static void gereclient(IClient client, List<Achat> listachat) {
		client.achete(listachat);
		client.paie();
	}

}
