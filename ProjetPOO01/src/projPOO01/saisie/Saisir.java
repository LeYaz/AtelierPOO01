package projPOO01.saisie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
	private static String t = "";

	public static void SaisirAll() {

		Saisir.SaisirSalarie();
		Saisir.SaisirClient();
		Saisir.SaisirFournisseur();
		Saisir.SaisirPatron();
		Menus.Menu();
	}

	public static void SaisirPatron() {

		boolean erreurns;
		SaisirGeneric(patron);

		erreurns = true;
		while (erreurns) {
			try {
				System.out.println("6: Saisir le numero de sécurité sociale du patron");
				patron.setSecu(Menus.sc.nextLine());
				Salarie.CtrlSaisiNumeroSecu(patron.getSecu());
				erreurns = false;
			} catch (ExceptionSaisiNumeroSecu e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		System.out.println("7: Saisir le salaire du patron");
		while (Menus.sc.hasNext()) {

			if (Menus.sc.hasNextDouble()) {
				patron.setSalaire(Menus.sc.nextDouble());
				Menus.sc.nextLine();
				break;
			} else {
				System.out.println("7: Saisir le salaire du patron");
				Menus.sc.nextLine();
			}

		}
		if (Menus.choixmenu != 1) {
			Menus.Menu();

		}
		return;
	}

	public static void SaisirSalarie() {

		ArrayList<Salarie> sl = new ArrayList<Salarie>();
		String secu = null;
		double salaire = 0;
		boolean erreurns = true;

		for (int i = 0; i < 5; i++) {
			Salarie salarie = new Salarie();
			SaisirGeneric(salarie);
			
			erreurns = true;
			while (erreurns) {
				try {
					System.out.println("6: Saisir le numero de sécurité sociale du salarie");
					secu = Menus.sc.nextLine();
					Salarie.CtrlSaisiNumeroSecu(secu);
					erreurns = false;
				} catch (ExceptionSaisiNumeroSecu e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() + " " + secu.length());
				}
			}

			salaire = 0;
			System.out.println("7: Saisir le salaire du salarie");
			while (Menus.sc.hasNext() && salaire == 0) {

				if (Menus.sc.hasNextDouble()) {
					salaire = Menus.sc.nextDouble();
					break;
				} else {
					System.out.println("7: Saisir le salaire du salarie");
					Menus.sc.nextLine();
				}

			}

			Salarie s = new Salarie(salarie.getNom(), salarie.getPrenom(), salarie.getAdresse(), salarie.getVille(), salarie.getCodepostal(), secu, salaire);

			sl.add(s);
		}

		listsalarie = new ArrayList<Personne>(sl);
		if (Menus.choixmenu != 1) {
			Menus.Menu();
		}
		return;
	}

	public static void SaisirClient() {

		ArrayList<Client> cl = new ArrayList<Client>();
		String idclient = "";
		boolean testid = false;


		for (int i = 0; i < 2; i++) {
			Client client = new Client();
			SaisirGeneric(client);

			testid = true;
			while (testid) {
				try {
					System.out.println("6: Saisir le numero unique client");
					idclient = Menus.sc.nextLine();
					Client.CtrlNumeroUniqueClient(idclient, cl);
					testid = false;

				} catch (ExceptionNumeroUnique e) {
					System.out.println(e.getMessage());
				}

			}

			Client c = new Client(client.getNom(), client.getPrenom(), client.getAdresse(), client.getVille(), client.getCodepostal(), Integer.parseInt(idclient));

			cl.add(c);
		}

		listclient = new ArrayList<Personne>(cl);
		if (Menus.choixmenu != 1) {
			Menus.Menu();
		}
		return;
	}

	public static void SaisirFournisseur() {

		ArrayList<Fournisseur> cl = new ArrayList<Fournisseur>();
		String idfournisseur = "";
		boolean numunique = true;

		for (int i = 0; i < 3; i++) {
			Fournisseur f = new Fournisseur();
			SaisirGeneric(f);
//			
			numunique = true;
			while (numunique) {
				try {
					System.out.println("6: Saisir le numero unique fournisseur");
					idfournisseur = Menus.sc.nextLine();
					Fournisseur.CtrlNumeroUniqueFournisseur(idfournisseur, cl);
					numunique = false;

				} catch (ExceptionNumeroUnique e) {
					System.out.println(e.getMessage());
				}

			}

			Fournisseur c = new Fournisseur(f.getNom(), f.getPrenom(), f.getAdresse(), f.getVille(), f.getCodepostal(), Integer.parseInt(idfournisseur));

			cl.add(c);
		}

		listfournisseur = new ArrayList<Personne>(cl);
		if (Menus.choixmenu != 1) {
			Menus.Menu();
		}
		return;
	}

	/**
	 * Methode permettant de remplir un tableau d'achat
	 * 
	 * @return ArrayList<Achat>
	 */
	public static ArrayList<Achat> SaisirAchat() {
		ArrayList<Achat> achats = new ArrayList<Achat>();
		Date d = null;
		String intitule;
		String qte = null;
		boolean b = true;
		boolean erreurint = true;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		boolean erreurdate = true;
		String date;

		while (b) {
			System.out.println("Entrez l'intitulé de votre achat");
			intitule = Menus.sc.nextLine();
			erreurint = true;
			while (erreurint) {
				System.out.println("Saisir la quantité ");
				try {
					qte = Menus.sc.nextLine();
					Controles.CtrlInt(qte);
					erreurint = false;

				} catch (ExceptionInt e) {
					System.out.println(e.getMessage());
				}

			}

			erreurdate = true;
			while (erreurdate) {
				System.out.println("veuillez saisir la date au format dd/MM/yyyy");
				date = Menus.sc.nextLine();
				try {
					d = Controles.CtrlDate(date);

					erreurdate = false;
				} catch (ExceptionDate e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}

			Achat a = new Achat(d, intitule, Integer.parseInt(qte));
			achats.add(a);
			System.out.println("Voulez vous poursuivre vos achats si oui entrer oui ");
			if (Menus.sc.nextLine().equals("oui")) {
				b = true;
			} else {
				b = false;
			}
		}

		return achats;

	}

	public static ArrayList<commande> SaisirCommande() {
		ArrayList<commande> cmd = new ArrayList<commande>();
		Date d = null;
		String intitule;
		String qte = null;
		boolean b = true;
		boolean erreurint = true;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		boolean erreurdate = true;
		String date;

		while (b) {
			System.out.println("Entrez l'intitulé de votre commande");
			intitule = Menus.sc.nextLine();
			erreurint = true;
			while (erreurint) {
				System.out.println("Saisir la quantité ");
				try {
					qte = Menus.sc.nextLine();
					Controles.CtrlInt(qte);
					erreurint = false;

				} catch (ExceptionInt e) {
					System.out.println(e.getMessage());
				}

			}

			erreurdate = true;
			while (erreurdate) {
				System.out.println("veuillez saisir la date au format dd/MM/yyyy");
				date = Menus.sc.nextLine();
				try {
					d = Controles.CtrlDate(date);

					erreurdate = false;
				} catch (ExceptionDate e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}

			commande c = new commande(d, intitule, Integer.parseInt(qte));
			cmd.add(c);
			System.out.println("Voulez vous poursuivre vos commande si oui entrer oui ");
			if (Menus.sc.nextLine().equals("oui")) {
				b = true;
			} else {
				b = false;
			}
		}

		return cmd;

	}

	/**
	 * Méthode permettant de saisir les différents attributs de personne appelé lors de la saisi d'un patron, client, fournisseur ou salarie
	 * @see SaisirPatron(), SaisirSalarie(), SaisirClient, SaisirFournisseur()
	 * @param o paramètre de type personne 
	 */
	public static void SaisirGeneric(Personne o) {

		Map<String, iSaisie> m = new TreeMap<String, iSaisie>();
		m.put("1: Saisir le nom du " + o.getClass().getSimpleName(), (z) -> {
			z = Menus.sc.nextLine();
			o.setNom(z);
		});
		m.put("2: Saisir le prenom du " + o.getClass().getSimpleName(), (t) -> {
			t = Menus.sc.nextLine();
			o.setPrenom(t);
		});
		m.put("3: Saisir l'adresse du " + o.getClass().getSimpleName(), (t) -> {
			t = Menus.sc.nextLine();
			o.setAdresse(t);
		});
		m.put("4: Saisir la ville du " + o.getClass().getSimpleName(), (t) -> {
			t = Menus.sc.nextLine();
			o.setVille(t);
		});
		m.put("5: Saisir le code postal du " + o.getClass().getSimpleName(), (t) -> {
			boolean erreur = true;
			while(erreur) {
				try {
					t = Menus.sc.nextLine();
					Salarie.CtrlCodePostal(t);
					o.setCodepostal(t);
					erreur = false;
				} catch (ExceptionSaisieCodePostal e) {
					System.out.println(e.getMessage());
				}	
			}
			
		});

		m.entrySet().stream().forEach(s -> {
			System.out.println(s.getKey());
			s.getValue().Set(t);

		});

	}
}
