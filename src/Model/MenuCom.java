package Model;
import java.util.*;

public class MenuCom extends Menu{

    //Attributs
    private Vector<Produit> choix;
    private Vector<String> supplements;


    // Constructeur
    public MenuCom(Menu n){
        nom=n.nom;
        prix=n.prix;
        descriptif = n.descriptif;
        nbProduit = n.nbProduit;
        choix = new Vector<Produit>(0);
        supplements = new Vector<String>(0);
    }


    // Methodes
    public Vector<Produit> getChoix(){return choix;}
    public Vector<String> getSupplements(){return supplements;}

    public void choose(Vector<Produit> p){
        for (int i=0;i<descriptif.capacity();i++){
            if (descriptif.get(i) instanceof Pizza){
                if (p.get(i) instanceof Pizza){choix.add(p.get(i));}
                else{System.out.println("erreur lors du choix du menu");}
            }

            else if (descriptif.get(i) instanceof Boisson){
                if (p.get(i) instanceof Boisson){choix.add(p.get(i));}
                else{System.out.println("erreur lors du choix du menu");}
            }

            else if (descriptif.get(i) instanceof Snack){
                if (p.get(i) instanceof Snack){choix.add(i,p.get(i));}
                else{System.out.println("erreur lors du choix du menu");}
            }

            else{System.out.println("erreur lors du choix du menu");}
        }
    }

    public void addSupplement(String s){supplements.add(s);}
    
}
