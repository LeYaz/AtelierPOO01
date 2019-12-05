package projPOO01.saisie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import projPOO01.Controles.Controles;
import projPOO01.Exceptions.ExceptionDate;
import projPOO01.Exceptions.ExceptionInt;
import projPOO01.Exceptions.ExceptionNumeroUnique;
import projPOO01.Exceptions.ExceptionSaisiNumeroSecu;
import projPOO01.Exceptions.ExceptionSaisieCodePostal;
import projPOO01.GestionAchat.Achat;
import projPOO01.GestionAchat.commande;
import projPOO01.GestionPersonnes.Client;
import projPOO01.GestionPersonnes.Fournisseur;
import projPOO01.GestionPersonnes.Patron;
import projPOO01.GestionPersonnes.Personne;
import projPOO01.GestionPersonnes.Salarie;
import projPOO01.Menu.Menus;

public class Saisir {
	public static Patron patron = new Patron();
	public static ArrayList<Personne> listclient = new ArrayList<Personne>();
	public static ArrayList<Personne> listsalarie = new ArrayList<Personne>();
	public static ArrayList<Personne> listfournisseur = new ArrayList<Personne>();
	
	public static void SaisirAll(){
		
		Saisir.SaisirSalarie();
		Saisir.SaisirClient();
		Saisir.SaisirFournisseur();
		Saisir.SaisirPatron();
		Menus.Menu();
	}
	
	
	public static void SaisirPatron() {
		boolean erreurcp;
		boolean erreurns;
		System.out.println("Saisir le nom du patron");
		patron.setNom(Menus.sc.next());
		System.out.println("Saisir le prenom du patron");
		patron.setPrenom(Menus.sc.next());
		System.out.println("Saisir l'adresse du patron");
		patron.setAdresse(Menus.sc.next());
		System.out.println("Saisir la ville du patron");
		patron.setVille(Menus.sc.next());
		erreurcp = true;
		while(erreurcp) {
			try {
				System.out.println("Saisir le codepostal du patron");
				patron.setCodepostal(Menus.sc.next());
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
				patron.setSecu(Menus.sc.next());
				Salarie.CtrlSaisiNumeroSecu(patron.getSecu());
				erreurns = false;
			} catch (ExceptionSaisiNumeroSecu e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
		
		
		System.out.println("Saisir le salaire du patron");
		while(Menus.sc.hasNext())
		{
			
			if (Menus.sc.hasNextDouble()) {
	            patron.setSalaire(Menus.sc.nextDouble());
	            break;
	         }
			else
			{
				System.out.println("Saisir le salaire du patron");
				Menus.sc.next();
			}
				
		}
		if(Menus.choixmenu!=1) {
			Menus.Menu();
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
			nom = Menus.sc.next();
			System.out.println("Saisir le prenom du salarie");
			prenom = Menus.sc.next();
			System.out.println("Saisir l'adresse du salarie");
			adresse = Menus.sc.next();
			System.out.println("Saisir la ville du salarie");
			ville = Menus.sc.next();
			erreurcp = true;
			while(erreurcp) {
				try {
					System.out.println("Saisir le codepostal du salarie");
					codepostal = Menus.sc.next();
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
					secu = Menus.sc.next();
					Salarie.CtrlSaisiNumeroSecu(secu);
					erreurns = false;
				} catch (ExceptionSaisiNumeroSecu e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage()+ " "+ secu.length());
				}
			}
			
			
			salaire=0;
			System.out.println("Saisir le salaire du salarie");
			while(Menus.sc.hasNext()&& salaire == 0)
			{
				
				if (Menus.sc.hasNextDouble()) {
		            salaire = Menus.sc.nextDouble();
		            break;
		         }
				else
				{
					System.out.println("Saisir le salaire du salarie");
					Menus.sc.next();
				}
					
			}
			
			
			Salarie s = new Salarie(nom, prenom, adresse, ville, codepostal, secu, salaire);
			
			sl.add(s);
		}
		
		listsalarie = new ArrayList<Personne>(sl);
		if(Menus.choixmenu!=1) {
			Menus.Menu();
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
			nom = Menus.sc.next();
			System.out.println("Saisir le prenom du client");
			prenom = Menus.sc.next();
			System.out.println("Saisir l'adresse du client");
			adresse = Menus.sc.next();
			System.out.println("Saisir la ville du client");
			ville = Menus.sc.next();
			erreurcp = true;
			while(erreurcp) {
				try {
					System.out.println("Saisir le codepostal du client");
					codepostal = Menus.sc.next();
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
					idclient =Menus.sc.next();
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
		if(Menus.choixmenu!=1) {
			Menus.Menu();
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
			nom = Menus.sc.next();
			System.out.println("Saisir le prenom du fournisseur");
			prenom = Menus.sc.next();
			System.out.println("Saisir l'adresse du fournisseur");
			adresse = Menus.sc.next();
			System.out.println("Saisir la ville du fournisseur");
			ville = Menus.sc.next();
			erreurcp = true;
			while(erreurcp) {
				try {
					System.out.println("Saisir le codepostal du fournisseur");
					codepostal = Menus.sc.next();
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
					idfournisseur =Menus.sc.next();
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
		if(Menus.choixmenu!=1) {
			Menus.Menu();
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
			 intitule =Menus.sc.next();
			 erreurint=true;
			 while(erreurint) {
				 System.out.println("Saisir la quantité ");
				 try {
					 qte=Menus.sc.next();
					 Controles.CtrlInt(qte);
					 erreurint=false;
					 
				 }catch(ExceptionInt e) {
					 System.out.println(e.getMessage());
				 }
				 
			 }
			 
			 erreurdate=true;
			 while(erreurdate) {
				 System.out.println("veuillez saisir la date au format dd/MM/yyyy");
				  date =Menus.sc.next();	 
				 try {
					d= Controles.CtrlDate(date);
					
					erreurdate=false;
				} catch (ExceptionDate e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			 }
			 
			 
			 Achat a = new Achat(d, intitule, Integer.parseInt(qte));
			 achats.add(a);
			 System.out.println("Voulez vous poursuivre vos achats si oui entrer oui ");
			 if(Menus.sc.next().equals("oui")) {
				 b=true;
			 }else {
				 b=false;
			 }
		}
		
		return achats;
		
	}
	
	public static ArrayList<commande> SaisirCommande(){
		ArrayList<commande> cmd = new ArrayList<commande>();
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
			System.out.println("Entrez l'intitulé de votre commande");
			 intitule =Menus.sc.next();
			 erreurint=true;
			 while(erreurint) {
				 System.out.println("Saisir la quantité ");
				 try {
					 qte=Menus.sc.next();
					 Controles.CtrlInt(qte);
					 erreurint=false;
					 
				 }catch(ExceptionInt e) {
					 System.out.println(e.getMessage());
				 }
				 
			 }
			 
			 erreurdate=true;
			 while(erreurdate) {
				 System.out.println("veuillez saisir la date au format dd/MM/yyyy");
				  date =Menus.sc.next();	 
				 try {
					d= Controles.CtrlDate(date);
					
					erreurdate=false;
				} catch (ExceptionDate e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			 }
			 
			 
			 commande c = new commande(d, intitule, Integer.parseInt(qte));
			 cmd.add(c);
			 System.out.println("Voulez vous poursuivre vos commande si oui entrer oui ");
			 if(Menus.sc.next().equals("oui")) {
				 b=true;
			 }else {
				 b=false;
			 }
		}
		
		return cmd;
		
	}
	
}
