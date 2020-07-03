
public class Produit {
	static int num=1;
	int numProduit;
	String nomProduit;
	double prixProduit;
	int quantitéProduit;
	
	public Produit(String nomProduit, double d, int quantitéProduit){
		this.numProduit = num;
		this.nomProduit = nomProduit;
		this.prixProduit = d;
		this.quantitéProduit = quantitéProduit;
		num++;
	}
	
	@Override
	public String toString() {
		return numProduit +"- "+ nomProduit + ", \t \t  prixProduit=" + prixProduit
				+ "dt, \t quantité en stock=" + quantitéProduit;
	}
	
	
	public double getPrixProduit() {
		return prixProduit;
	}
	
	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}
	
	public int getQuantitéProduit() {
		return quantitéProduit;
	}
	
	public void setQuantitéProduit(int quantitéProduit) {
		this.quantitéProduit = quantitéProduit;
	}
	
}
