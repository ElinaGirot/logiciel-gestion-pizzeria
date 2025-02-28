package Model;
import java.util.*;

public class Pizzeria {
    //Attributs
    private String nom;
    private String adresse;
    private Vector<Commande> historique;
    private Vector<Client> listClient;
    private Catalogue catalogue;
    private Vector <Livreur> listLivreur;


    // Constructeur
    public Pizzeria(String n, String a, Catalogue c) {
        nom = n;
        adresse = a;
        historique = new Vector<Commande>();
        listClient = new Vector<Client>();
        listLivreur = new Vector<Livreur>(0,1);
        catalogue = c;
    }



    // Methodes
    public String getNom() {return nom;}
    public String getAdresse() {return adresse;}
    public Vector<Commande> getHistorique() {return historique;}
    public Vector<Livreur> getLivreur(){return listLivreur;}
    public Catalogue getCatalogue() {return catalogue;}
     
    public void addCommande(Commande com){historique.add(com);}
    public void addCatalogues(Catalogue c) {catalogue=c;}
    public void addClient(Client c){listClient.add(c);}
    public void addLivreur(Livreur l){listLivreur.add(l);}

    public Client searchClient(String n){
        for (Client value :  listClient){
            if (value.getNumTel().equals(n)){return value;}
        }
        return null;
    }

    //Pour supprimer un client de la base de donnée avec son numero en paramètre
    public void removeClient(String n){
        if (searchClient(n)==null){System.out.println("Le client recherché n'existe pas");}
        else{
            listClient.remove(searchClient(n));
        }
    }

    //Pour supprimer un client de la base de donnée avec le client en paramètre
    public void removeClient(Client c){
        listClient.remove(c);
    }

    
    public void viewHistorique(){
        System.out.println("Les numero de commande enregistré à la pizzeria "+nom+" sont :");
        for (Commande value : historique){
            System.out.println(value.getNumCom());
        }
    }

    public void viewCatalogues(){catalogue.view();}
    public void viewMenu(){catalogue.viewMenu();}
    public void viewPizza(){catalogue.viewPizza();}
    public void viewBoisson(){catalogue.viewBoisson();}
    public void viewDessert(){catalogue.viewDessert();}
    public void viewSnack(){catalogue.viewSnack();}
    public void viewMAJCatalogue(){catalogue.viewMAJ();}

    public void add(Pizza pizza){catalogue.getPizza().add(pizza);}
    public void add(Dessert d){catalogue.getDessert().add(d);}
    public void add(Boisson b){catalogue.getBoisson().add(b);}
    public void add(Snack s){catalogue.getSnack().add(s);}
    public void add(Menu m){catalogue.getMenu().add(m);}

    public void addMoney(String num,double t){searchClient(num).addMoney(t);}

}




