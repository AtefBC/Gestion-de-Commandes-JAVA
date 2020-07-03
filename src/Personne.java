
public class Personne {
	String Nom;
	String Prenom;
	String CIN;
	public Personne(String nom, String prenom, String CIN)
	{
		this.Nom=nom;
		this.Prenom=prenom;
		this.CIN=CIN;
		
	}
	public void afficherPersonne()
	{
		System.out.println("*** "+this.Nom+" "+ this.Prenom+  " ** CIN= "+CIN +" ***");
	}
	

}
