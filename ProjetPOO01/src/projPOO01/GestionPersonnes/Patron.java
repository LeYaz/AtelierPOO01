package projPOO01.GestionPersonnes;

public class Patron extends Salarie implements IPatron {

	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String secu,
			double salaire) {
		super(nom, prenom, adresse, ville, codepostal, secu, salaire);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void embauche() {
		// TODO Auto-generated method stub

	}

	@Override
	public void licencie() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paieSalarie() {
		// TODO Auto-generated method stub
		
	}

}
