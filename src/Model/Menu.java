package Model;
import java.util.*;

public class Menu {

    // Attributs
    Scanner scan = new Scanner(System.in);  // Create a Scanner object
    protected String nom;
    protected double prix;
    protected Vector<Produit> descriptif;
    protected int nbProduit;


    // Constructeurs
    public Menu(String n,int nbProd){
        nbProduit=nbProd;
        nom=n;
        descriptif = new Vector<Produit>(0);
    }
    public Menu(){}



    //Methodes
    public String getNom(){return nom;}
    public double getPrix(){return prix;}
    public Vector<Produit> getSetup(){return descriptif;}
    public int getNbArticle(){return nbProduit;}

    public void addPrix(double price){prix=price;}

    //Pour configurer le setup (exemple si prod = {"Pizza","Boisson"} le menu aura une pizza et une boisson)
    public void menuSetup(Vector<Produit> prod, double p){
        descriptif = prod;
        prix = p;
    }
}
