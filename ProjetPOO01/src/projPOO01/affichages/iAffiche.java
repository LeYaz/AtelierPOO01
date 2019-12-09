package projPOO01.affichages;

import java.util.ArrayList;

import projPOO01.GestionPersonnes.Personne;

@FunctionalInterface
public interface iAffiche {
	public void afficher(ArrayList<Personne> list);
	
}

