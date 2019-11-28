package projPOO01.GestionPersonnes;

import java.util.List;

import projPOO01.GestionAchat.commande;

public interface IFournisseur {
	public boolean livre();
	public void commande(List<commande> listcommande);
	public boolean isFournisseur();
}
