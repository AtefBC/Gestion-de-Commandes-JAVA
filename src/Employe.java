
public class Employe extends Personne{
	String Ville;
	int Salaire;
	String key;

	public Employe(String nom, String prenom, String CIN, String Ville, int Salaire) {
		super(nom,prenom,CIN);
		this.Ville=Ville;
		this.Salaire=Salaire;
		this.key="ProjetJAVA";
	}
	public void afficherEmploye()
	{
		System.out.println("*** "+this.Nom+" "+ this.Prenom+  " ** CIN= "+CIN +" ** "+this.Ville+" ** "+this.Salaire+" ***");
	}


}
