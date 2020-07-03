import java.util.Scanner;
public class APP {
	static String NOMUTIL, access;
	static String Menu1 , Menu2;
	static int NUMCLIENT=0;
	static int NUMCOMMANDE=0;
	static Scanner input= new Scanner(System.in);
	
	//Ceation d'un tableau contenant les clients (max 10 clients)
			static Client[] TABClient = new Client[10];
			
	//Creation d'un tableau de produit (10 Produits)
			static Produit[] TABProduit = new Produit[10];
			
	//Creation d'un tableau de Commandes (10 Commandes)
			static Commande[] TABCommande = new Commande[10];
			
			
	public static void remplirTAB( Produit[] x)
	{
		x[0] = new Produit("CHROLOQUIL",52.500,11);
		x[1] = new Produit("EFFERALGAN",1.550,100);
		x[2] = new Produit("ASPEGIC",1.090,98);
		x[3] = new Produit("VITAMINE C",3.000,25);
		x[4] = new Produit("DOLIPRANE",2.000,11);
		x[5] = new Produit("FLUCAZOLE",29.5,2);
		x[6] = new Produit("PANADOL ",1.550,9);
		x[7] = new Produit("CELEBREX",9.500,91);
		x[8] = new Produit("GRIPEX ",2.200,12);
		x[9] = new Produit("SEDATIL",1.100,19);
	}
	
	
	public static void afficherTABProduit()
	{
		for(int k=0;k<TABProduit.length;k++)
		{
			System.out.println(TABProduit[k].toString());
		}
	}
	
	
	
	//pour ne pas avoir 2 nom d utilisateur semblable
	public static int verifexistance(String x)
	{
		int verif=11;
		for (int i=0;i<NUMCLIENT;i++)
		{
			if ((TABClient[i].NomUtilisateur).compareTo(x)==0)
			{
				System.out.println("Nom d'util existe");
				verif=i;
				break;
			}
		}
		return verif;
	}
	
	
	public static void CreateAccount()

	{
		System.out.println("** Donner votre nom: ");
		String nom= input.nextLine();
		System.out.println("** Donner votre prenom: ");
		String prenom= input.nextLine();
		System.out.println("** Donner votre CIN: ");
		String CIN= input.nextLine();
		if (NUMCLIENT==0)
		{
			System.out.println("** Donner votre NOM UTILISATEUR: ");
			NOMUTIL= input.nextLine();
		}
		else
		{
			do {
		
				//Condition pour ne pas avoir 2 nom d util semblable;
				System.out.println("** Donner votre NOM UTILISATEUR: ");
				NOMUTIL= input.nextLine();
				
			} while((verifexistance(NOMUTIL))!=11);
		}
		
		System.out.println("** Donner votre MOT DE PASSE: ");
		String MDP= input.nextLine();
		
		TABClient[NUMCLIENT]= new Client(nom,prenom,CIN,NOMUTIL,MDP);
		
		System.out.println("Compte est bien créé \n \n**");
		
		
		NUMCLIENT++;
	}

	
	
	
	public static boolean Connexion()
	{
		boolean CON=false;
		System.out.println("Nom d'utilisateur: ");
		access= input.nextLine();
		if(verifexistance(access)!=11)
		{
			System.out.println("Mot de passe: ");
			String mdp= input.nextLine();
			if(mdp.compareTo(TABClient[verifexistance(access)].MDP)==0)
			{
				System.out.println("login approuved");
				CON=true;
				return CON;
			}
			else
			{
				System.out.println("Password incorrect");
			}
		}
		else
		{
			System.out.println("Account not found");
		}
	return CON;
	}
	
	
	public static void ajoutercommande(String nomutilclient)
	{
		int choix3, qte;
		Produit permProd;
		Client permClient = null;
		//avoir les details du client connecté avec son nom d'util
		for(int j=0;j<NUMCLIENT;j++)
		{
			if(TABClient[j].NomUtilisateur.compareTo(access)==0)
			{
				permClient=TABClient[j];
				break;
			}
		}
		
		afficherTABProduit();
		System.out.println("** Donner votre Produit souhaité: ");
		do
		{
		choix3= Integer.parseInt(input.nextLine());
		} while(choix3>10);
		permProd= TABProduit[choix3-1];
		System.out.println("** Donner la quantité souhaité: ");
		qte= Integer.parseInt(input.nextLine());
		//Condition pour ne pas commander une quantite plus que disponible
		if(qte>permProd.quantitéProduit)
		{
			System.out.println("la quantite que vous commandez n'est pas disponible");
		}
		else
		{
			TABCommande[NUMCOMMANDE]=new Commande(permClient,permProd,qte);
			System.out.println("Commande bien reçue");
			//eliminer la qtite commandée de la qtite en stock
			TABProduit[choix3-1].quantitéProduit -=qte;
			NUMCOMMANDE++;
		}
		
	}
	
	
	public static void AfficheCommandeUTIL(String nomutilclient)
	{
		int nbreocc=0;
		for(int i=0;i<NUMCOMMANDE;i++)
		{
			if(TABCommande[i]!=null)
			{
				if((TABCommande[i].client.NomUtilisateur).compareTo(nomutilclient)==0)
				{
					System.out.println(TABCommande[i].toString());
					nbreocc++;
				}
			}
		}
		if(nbreocc==0)
		{
			System.out.println("Aucune Commande sous ce compte");
		}
	}
	
	
	public static void main(String[] args) {
	
		Menu1 ="\n \n ********************* \n1- Create Account \n"
				+ "2- Connect \n3- Show Products \n4- afficher tous les Commandes( Employés seulement) \n0- EXIT";
		Menu2 ="1- Placer une commande \n2- Supprimer une commande \n3- Afficher mes commande \n0- Disconnect";
		remplirTAB(TABProduit);
		int choix1 = 5;
		do
		{
			System.out.println(Menu1);
			System.out.println("** Donner votre choix: ");
			choix1= Integer.parseInt(input.nextLine());
		
			switch(choix1)
			{
				case 1:
				
					//Creation du compte:
					CreateAccount();
					break;
					
				case 2:					
					//Connexion
					boolean etat=Connexion();
					if (etat==true)
					{
						int choix2 = 5;
						do
						{
						System.out.println("\n \n ************************\n Bienvenue Mr "+access+"\n"+Menu2);
						System.out.println("** Donner votre choix: ");
						choix2= Integer.parseInt(input.nextLine());
						switch(choix2)
						{
						case 1:
							//ajouter commande
							ajoutercommande(access);
							break;
						case 2:
							//supprimer commande
							AfficheCommandeUTIL(access);
							System.out.println("\n** Donner le numero de commande a supprimé ");
							int choix4= Integer.parseInt(input.nextLine());
							if(TABCommande[choix4-1].client.NomUtilisateur.compareTo(access)==0)
							{
								TABCommande[choix4-1]=null;
							}
							else
							{
								System.out.println("Aucune Commande ayant ce num");
							}			
							break;
						
						case 3:
							//afficher commande
							AfficheCommandeUTIL(access);
							break;
						case 0:
							//déconnexion
							System.out.println("déconnexion reussite");
				
						default :
							System.out.println("Choix Invalide");
							break;
						}
						} while(choix2 !=0);
					}
					break;
				
				
				
				case 3:
					//afficher les produits
					afficherTABProduit();
					break;
					
				case 4:
					//afficher tous les commandes
					System.out.println("Entrer votre key d'employé");
					String key= input.nextLine();
					if(key.compareTo("ProjetJAVA")==0)
					{
						
						for(int i=0;i<NUMCOMMANDE;i++)
						{
							if(TABCommande[i]!=null)
							{
							System.out.println(TABCommande[i].toString());
							}
						}
					}
					else
					{
						System.out.println("Key erronée. Il faut être employé pour acceder");
					}
					break;
				
				case 0:
				
					System.out.println("Merci de nous visiter");
					break;
					
				default :
					System.out.println("Choix Invalide");
					break;
					
			}
			
		} while ( choix1 != 0);
		
		
		

	}

}
