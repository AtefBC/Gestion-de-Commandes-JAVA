
public class Produit {
	static int num=1;
	int numProduit;
	String nomProduit;
	double prixProduit;
	int quantit�Produit;
	
	public Produit(String nomProduit, double d, int quantit�Produit){
		this.numProduit = num;
		this.nomProduit = nomProduit;
		this.prixProduit = d;
		this.quantit�Produit = quantit�Produit;
		num++;
	}
	
	@Override
	public String toString() {
		return numProduit +"- "+ nomProduit + ", \t \t  prixProduit=" + prixProduit
				+ "dt, \t quantit� en stock=" + quantit�Produit;
	}
	
	
	public double getPrixProduit() {
		return prixProduit;
	}
	
	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}
	
	public int getQuantit�Produit() {
		return quantit�Produit;
	}
	
	public void setQuantit�Produit(int quantit�Produit) {
		this.quantit�Produit = quantit�Produit;
	}
	
}