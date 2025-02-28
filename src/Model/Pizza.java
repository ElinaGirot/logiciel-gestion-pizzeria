package Model;
import java.util.*;

public class Pizza extends Produit{
    private Vector<String> ingredients;
   
    //Constructeur
    public Pizza(String n, double p, Vector<String> ing) {
        super(n,p);
        ingredients = new Vector<String>();
    }
    public Pizza(){}

    //Methodes
    public Vector<String> getIngredients() {return ingredients;}
}



