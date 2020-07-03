
public class Commande {
	static int num=1;
	int numCommande;
	Client client;
	Produit achat;
	int QTE;

	
	public Commande(Client client, Produit achat, int quantite ) 
	{
		this.numCommande=num;
		this.client=client;
		this.achat=achat;
		this.QTE=quantite;
		num++;
			
	}
	
	
	public String toString() 
	{
		return numCommande +"- "+ client.Nom + " "+ client.Prenom +"\t"+ achat.nomProduit+"\t QTE:"+ QTE + "\t Prix"+ (achat.prixProduit * QTE);	
	}
	
}
