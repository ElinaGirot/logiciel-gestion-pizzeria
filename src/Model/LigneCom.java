package Model;
import java.util.Vector;

public class LigneCom {
    // Attributs
    private Produit produit;
    private int quantite;
    private String taille;
    private Vector<String> supplements;  //Vector<String> supplements;


    // Constructeur
    public LigneCom(Produit p, int q,String t) {
        produit=p;
        quantite=q;
        taille=t;
        supplements = new Vector<String>(0);
    }
    public LigneCom(Produit p, int q,String t,Vector<String> supplement) {
        produit=p;
        quantite=q;
        taille=t;
        supplements = supplement;
    }


    // Methodes
    public Produit getProduit(){return produit;}
    public int getQuantite(){return quantite;}
    public String getTaille(){return taille;}
    public Vector<String> getSupplement(){return supplements;}
    
    public void addSupplement(String s){
        supplements.add(s);
    }
}


