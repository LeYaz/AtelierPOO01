package projPOO01.GestionPersonnes;

import projPOO01.Exceptions.ExceptionSaisieCodePostal;

/**
 * Classe permettant d'instancier une personne. 
 * 
 * @author Yazid AADNAN
 * @version 1.0
 * <b>Java Doc pour la POE de Lyon </b>
 *
 */

public class Personne {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codepostal;

//	public Personne() {
//		// TODO Auto-generated constructor stub
////		this.nom ="";
////		this.prenom ="";
////		this.adresse ="";
////		this.ville="";
////		this.codepostal="";
//		
//		this("","","","","");
//	}	
	
	/**
	 * Constructeur de la classe permettant d'instancier une personne
	 * 
	 * @param nom Correspond au nom de la personne
	 * @param prenom Correspond au prenom de la personne
	 * @param adresse Correspond a l'adresse de la personne
	 * @param ville Correspond a la ville de la personne
	 * @param codepostal Correspond au code postal de la personne
	 */
	
	public Personne(String nom, String prenom, String adresse, String ville, String codepostal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
	}




	/**
	 * Surcharge de la méthode toString()
	 * 
	 * @return le type de personne et les différents attributs de la classe
	 *
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", ville=" + ville
				+ ", codepostal=" + codepostal + "]";
	}


	/**
	 *  Méthode permettant de récuperer le nom de la personne
	 * @return le nom de la personne 
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Methode permettant de mettre a jour le nom de la personne
	 * @param nom Nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 *  Méthode permettant de récuperer le prenom de la personne
	 * @return le prenom de la personne 
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * 	Méthode permettant de mettre a jour le prenom de la personne
	 * @param prenom Prenom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 *  Méthode permettant de récuperer l'adresse de la personne
	 * @return l'adresse de la personne 
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * 	Méthode permettant de mettre à jour l'adresse de la personne
	 * @param adresse adresse de la personne
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 *  Méthode permettant de récuperer la ville de la personne
	 * @return la ville de la personne 
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * 	Méthode permettant de mettre a jour la ville de la personne
	 * @param ville ville de la personne
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 *  Méthode permettant de récuperer le code postal de la personne
	 * @return le code postal de la personne 
	 */
	public String getCodepostal() {
		return codepostal;
	}
	
	/**
	 * 	Méthode permettant de mettre a jour le code postal de la personne
	 * @param codepostal Code postal de la personne
	 */
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	
	/**
	 * Méthode permettant de controler le format du code postal saisie
	 * @param cp code postal de la personne
	 * @throws ExceptionSaisieCodePostal est appelé si le nombre de caractère est différents de 5 ou n'est pas composé uniquement de chiffres
	 */
	public static void CtrlCodePostal(String cp) throws ExceptionSaisieCodePostal{
		if (cp.length() != 5) {
			throw new ExceptionSaisieCodePostal("Le nombre de caractère est différents de 5.");
		}
		try {
			Integer.parseInt(cp);
		} catch (Exception e) {

			throw new ExceptionSaisieCodePostal("Il faut saisir uniquement des chiffres");
		}
	}

	
}
