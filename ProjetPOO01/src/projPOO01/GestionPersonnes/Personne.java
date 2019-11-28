package projPOO01.GestionPersonnes;

import projPOO01.Exceptions.ExceptionSaisieCodePostal;

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
	
	
	public Personne(String nom, String prenom, String adresse, String ville, String codepostal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
	}





	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", ville=" + ville
				+ ", codepostal=" + codepostal + "]";
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	
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
