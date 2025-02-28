package Model;

import java.util.*;
import java.time.*;

public class Commande {

    // Attributs
    private int numCommande;
    private LocalTime dateCom;
    private Client client;
    private Livreur livreur;
    private Pizzeria pizzeria;
    private Vector<LigneCom> lignesCom;
    private Vector<MenuCom> menuCom;
    private static int compteur = 1;
    private boolean statutLivraison; // Pour pouvoir rembourser si la commande n'est pas livré au bout de 30min
    private boolean selecPizzaOfferte = false;
    private int pizzaGratuites = -1;

    // Constructeur
    public Commande(Client c) {
        numCommande = compteur;
        compteur++;
        client = c;
        dateCom = LocalTime.now();
        lignesCom = new Vector<LigneCom>(0);
        menuCom = new Vector<MenuCom>(0);
        livreur = null;
        statutLivraison = false;
    }

    public Commande(Client c, Vector<LigneCom> l) {
        numCommande = compteur;
        compteur++;
        client = c;
        dateCom = LocalTime.now();
        lignesCom = l;
        menuCom = new Vector<MenuCom>(0);
        livreur = null;
        statutLivraison = false;
    }

    public Commande(Client c, Vector<LigneCom> l, Vector<MenuCom> m) {
        numCommande = compteur;
        compteur++;
        client = c;
        dateCom = LocalTime.now();
        lignesCom = l;
        menuCom = m;
        livreur = null;
        statutLivraison = false;
    }

    // Getting methodes
    public Vector<LigneCom> getLigneCom() {
        return lignesCom;
    }

    public Vector<MenuCom> getMenuCom() {
        return menuCom;
    }

    public int getNumCom() {
        return numCommande;
    }

    public Client getClient() {
        return client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public LocalTime getDateCom() {
        return dateCom;
    }

    public boolean getStatut() {
        return statutLivraison;
    }

    // Methodes
    public void addLigneCom(LigneCom l) {
        lignesCom.add(l);
    }

    public void addMenuCom(MenuCom com) {
        menuCom.add(com);
    }

    public void setPizzaOffertes(boolean b) {
        selecPizzaOfferte = b;
    }
    public void setNbPizzaGratuite(int n) {pizzaGratuites=n;}

    public double devis(boolean b) {
        double sum = 0;
        //Tous d'abord, le but est de savoir le nombre de pizza offerte pour la commande
        //Le problème est que lorsqu'on fait un devis() dans l'historique de commande, c'est les pizzas offertes
        //Sur le compte du client qui est prit en compte. Il y a alors un attribut dans la commande qui enregistre le 
        //Nombre de pizza offerte lorsqu'elle est enregistré avec Client.addCommande(). Elle est de base sur -1 quand
        //Le nombre de pizza offerte n'a pas encore été enregistré (il est enregistré lorsque le client valide la commande)
        int pizzaOffertes;
        if (pizzaGratuites == -1){pizzaOffertes = client.getPizzaOffertes();}
        else{pizzaOffertes=pizzaGratuites;}
        
        for (int i = 0; i < lignesCom.size(); i++) {
            if (lignesCom.get(i).getProduit() instanceof Pizza) {
                if (selecPizzaOfferte) {
                    if (lignesCom.get(i).getTaille() == "Ogresse") {
                        sum = sum + (lignesCom.get(i).getProduit().getPrix() * 4 / 3)
                                * (lignesCom.get(i).getQuantite() - Math.min(lignesCom.get(i).getQuantite(),pizzaOffertes));
                    } else if (lignesCom.get(i).getTaille() == "Humaine") {
                        sum = sum + (lignesCom.get(i).getProduit().getPrix())
                                * (lignesCom.get(i).getQuantite() - Math.min(lignesCom.get(i).getQuantite(),pizzaOffertes));
                    } else if (lignesCom.get(i).getTaille() == "Naine") {
                        sum = sum + (lignesCom.get(i).getProduit().getPrix() * 2 / 3)
                                * (lignesCom.get(i).getQuantite() - Math.min(lignesCom.get(i).getQuantite(),pizzaOffertes));
                    }
                    pizzaOffertes = pizzaOffertes-Math.min(lignesCom.get(i).getQuantite(),pizzaOffertes);
                    //client.setPizzaOffertes(pizzaOffertes);

                } else if (lignesCom.get(i).getTaille() == "Ogresse") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix() * 4 / 3) * lignesCom.get(i).getQuantite();
                } else if (lignesCom.get(i).getTaille() == "Humaine") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix()) * lignesCom.get(i).getQuantite();
                } else if (lignesCom.get(i).getTaille() == "Naine") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix() * 2 / 3) * lignesCom.get(i).getQuantite();
                }
                //client.setPizzaOffertes(pizzaOffertes);
            }
            if (lignesCom.get(i).getProduit() instanceof Dessert) {
                sum = sum + (lignesCom.get(i).getProduit().getPrix()) * lignesCom.get(i).getQuantite();
            }
            if (lignesCom.get(i).getProduit() instanceof Snack) {
                if (lignesCom.get(i).getTaille() == "double") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix()) * lignesCom.get(i).getQuantite() * 1.8;
                } else {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix()) * lignesCom.get(i).getQuantite();
                }
            } else {
                if (lignesCom.get(i).getTaille() == "Canette") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix()) * lignesCom.get(i).getQuantite();
                } else if (lignesCom.get(i).getTaille() == "PetiteBouteille") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix() * 1.5) * lignesCom.get(i).getQuantite();
                } else if (lignesCom.get(i).getTaille() == "GrandeBouteille") {
                    sum = sum + (lignesCom.get(i).getProduit().getPrix() + 1) * lignesCom.get(i).getQuantite();
                }
            }
        }
        // Ajout des supplements des lignes de commandes
        for (int i = 0; i < lignesCom.size(); i++) {
            sum = sum + lignesCom.get(i).getSupplement().size() * 1.2;
        }
        // Ajout des menus
        for (int i = 0; i < menuCom.size(); i++) {
            sum = sum + menuCom.get(i).getPrix();
        }
        if(b){client.setPizzaOffertes(pizzaOffertes);}
        return Math.round(sum * 100.0) / 100.0;
    }

    public void addLivreur(Pizzeria p) {

        if (p==null){livreur=null;}
        else{
            Random random = new Random();
            int nb;
            nb = random.nextInt(p.getLivreur().capacity());
            livreur = p.getLivreur().get(nb);
        } 
    }

    public void changeLivreur(Livreur l) {
        livreur = l;
    }

    public void addPizzeria(Pizzeria p) {
        pizzeria = p;
    }

    protected void remboursement() {
        client.addMoney(devis(false));
    }

}