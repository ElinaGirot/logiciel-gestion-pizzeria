package Model;
import java.util.Vector;

public class Produit{

    //Attributs
    private String nom;
    private double prix;
    private Vector<String> supplements;


    //Constructeurs
    public Produit(String n, double p) {
        nom = n;
        prix = p;
        supplements = new Vector<String>(0);
    }
    public Produit(){}

    //Methodes
    public String getNom() {return nom;}
    public double getPrix() {return prix;}

    public void addSupplements(String n){
        supplements.add(n);
    }
}



