package projPOO01;

import java.util.Scanner;

import projPOO01.Menu.Menus;


public class Programme {

	
	private static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menus.sc = Programme.sc;
		
		Menus.Menu();

	}
	
	
//	public static void gereclient(IClient client, List<Achat> listachat) {
//		client.achete(listachat);
//		client.paie();
//	}

}
