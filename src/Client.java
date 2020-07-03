
public class Client extends Personne {
	String NomUtilisateur;
	String MDP;

	public Client(String nom, String prenom, String CIN, String NomUtilisateur, String MDP) {
		super(nom,prenom,CIN);
		this.NomUtilisateur= NomUtilisateur;
		this.MDP=MDP;
	}
	
	
	public void afficherClient()
	{
		System.out.println("*** "+this.Nom+" "+ this.Prenom+  " ** CIN= "+CIN +" ** "+this.NomUtilisateur+" ** "+this.MDP+" ***");
	}

}
