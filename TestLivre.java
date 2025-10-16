package librairie;

import java.util.Scanner;

class Livre {
	private String titre,auteur;
	private int nbPages;
	private static int nbLivres=0;
	//Constructeur
	//Non le programme ne fonction pas
	public Livre() {
		titre = "titre";
		auteur = "auteur";
		nbLivres++;
	}
	public Livre(String unAuteur,String unTitre) {
		titre = unTitre;
		auteur = unAuteur;
		nbLivres++;
	}
	public Livre(String unAuteur,String unTitre,int unnbPages) {
		titre = unTitre;
		auteur = unAuteur;
		nbPages = unnbPages;
		nbLivres++;
	}
	public static int getNbLivres() {
		return nbLivres;
	}
	//Accesseur
	public String getAuteur() {
		return auteur;
	}
	public String getTitre() {
		return titre;
	}
	public int getNbPg() {
		return nbPages;
	}
	//Modificateur
	public void setNbPages(int nbPages) {
		if(nbPages>0) {
			this.nbPages = nbPages;
		}else {
			System.out.println("nombre de pages strictement positive");
		}
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public void affiche() {
		System.out.println(this.toString());
	}
	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", nbPages=" + nbPages + "]";
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if(obj == null) {
			return false;
		}else {
			Livre livre = (Livre) obj;
			return titre == livre.getTitre() && auteur == livre.getAuteur() && nbPages == livre.getNbPg();
		}
	}
}
public class TestLivres {
	public static void main(String[] params) {
		Livre liv1 = new Livre("Thinking in Java", "Bruce Eckel");
		System.out.println(Livre.getNbLivres());
		Livre liv2 = new Livre("Programmer en Java","Claude Delannoy");
		System.out.println(Livre.getNbLivres());
		System.out.println("l'auteur 1 "+liv1.getAuteur()+"\nl'auteur 2 "+liv2.getAuteur());
		Scanner sc = new Scanner(System.in);
		System.out.println("donner le nombre de pages de livre 1 :");
		int nbr1 = sc.nextInt();
		sc.nextLine();
		liv1.setNbPages(nbr1);
		System.out.println("donner le nombre de pages de livre 2 :");
		int nbr2 = sc.nextInt();
		sc.nextLine();
		liv2.setNbPages(nbr2);
		liv1.affiche();
		liv2.affiche();
		System.out.println("la somme de pages de deux livre : "+(liv1.getNbPg()+liv2.getNbPg()));
		System.out.println(liv1);
		
		Livre lv1 = new Livre();
		System.out.println(Livre.getNbLivres());
		Livre lv2 = new Livre("Thinking in Java","Bruce Eckel");
		System.out.println(Livre.getNbLivres());
		Livre lv3 = new Livre("Programmer en Java","Claude Delannoy",10);
		System.out.println(Livre.getNbLivres());
		lv1.affiche();
		lv2.affiche();
		lv3.affiche();
		System.out.println(liv2==lv3);//L'opérateur == retourne false même si les deux livres ont exactement les mêmes valeurs car il compare les références en mémoire et non leur contenu
		//pour le compaire on utilise un fonction dans class LIVRE qui faire la comparaison
		System.out.println(liv2.equals(lv3));
		sc.close();
	}
}
