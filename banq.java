package bank;

class compte{
	private int numero;
	private double solde;
	private static int Nbrcompt=0;
	
	public int getNum() {
		return numero;
	}
	public compte() {
		this.numero=++Nbrcompt;
	}
	public compte(double solde) {
		this.solde=solde;
	}
	public static compte plusSolde(compte c1,compte c2) {
		if(c1.getSolde()>c2.getSolde()) {
			return c1;
		}else {
			return c2;
		}
	}
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}else {
			compte cp = (compte) o;
			if(numero == cp.numero) {
				return true;
			}else {
				return false;
			}
		}
	}
	public void depot(double val) {
		solde+=val;
	}
	public void retrait(double val) {
		solde-=val;
	}
	public double getSolde() {
		return solde;
	}
	public void afficherSolde() {
		System.out.println("votre solde : "+solde);
	}
	public void setSolde(double s) {
		if(s>0) {
			solde=s;
		}else {
			System.out.println("Error montant inferieur a 0");
		}
	}
	public String toString() {
		return "numero est "+numero+"\nsolde est "+solde;
	}
	public void virer(float valeur, compte destinataire) {
		if(valeur>0) {
			this.retrait(valeur);
			destinataire.depot(valeur);
		}else {
			System.out.println("transfort failed");
		}
	}
}

class client{
	private compte[] cmp;
	private String nom;
	private int Nbrcomp=0;
	private static int maxaccounts=100;
	
	public client(String nom) {
		this.nom = nom;
		this.cmp = new compte[maxaccounts];
		this.Nbrcomp=0;
	}
	public String getNom() {
		return nom;
	}
	public double getSolde() {
		double total=0;
		for (int i=0;i<this.getNbrcomp();i++) {
			total+=cmp[i].getSolde();
		}
		return total;
	}
	public void afficherSolde() {
		System.out.println(toString());
	}
	public String toString() {
		return "nom est "+nom+"\ntotal solde est "+this.getSolde();
	}
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}else {
			client cl = (client) o;
			if(nom==cl.getNom() && cmp.equals(cl.cmp)) {
				return true;
			}else {
				return false;
			}
		}
	}
	public int getNbrcomp() {
		return Nbrcomp;
	}
	public void ajoutcompte(double solde) {
		if(Nbrcomp < maxaccounts) {
			cmp[Nbrcomp] = new compte(solde);
			Nbrcomp++;
		}else {
			System.out.println("montant invalide");
		}
	}
}
public class Banque {
	public static void main(String[] params) {
		client cl = new client("aziz");
		cl.ajoutcompte(1000.0f);
		cl.ajoutcompte(1000.0f);
		cl.afficherSolde();
		client cl2 = new client("ahmed");
		cl2.ajoutcompte(1000.0f);
		cl2.ajoutcompte(500.0f);
		cl2.afficherSolde();
	}
}
