package Model;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Client {

    // Attributs
    private String numTel;
    private double solde;
    private int compteurPizza = 0;
    private int pizzaOffertes = 0;
    private Vector<Commande> oldCommandes;

    // Constructeurs
    public Client(String Tel) {
        numTel = Tel;
        solde = 0;
        oldCommandes = new Vector<Commande>(0,1);
    }

    public Client(String Tel, double s) {
        numTel = Tel;
        solde = s;
        oldCommandes = new Vector<Commande>(0,1);
    }

    // Getteur methodes
    public double getSolde() {
        return solde;
    }

    public int getCompteurPizza() {
        return compteurPizza;
    }

    public int getPizzaOffertes() {
        return pizzaOffertes;
    }

    public String getNumTel() {
        return numTel;
    }

    public Vector<Commande> getHistory() {
        return oldCommandes;
    }

    // Setteur methodes
    public void setNumTel(String num) {
        numTel = num;
    }

    public void ajoutPizzaOffertes() {
        pizzaOffertes++;
    }

    public void setPizzaOffertes(int i) {
        pizzaOffertes = i;
    }

    // Methodes
    // Ajouter une commande dans l'historique de commande du client
    public boolean addCommande(Commande com) {
        //Enregistrer le nombre de pizza offerte dans la commande
        com.setNbPizzaGratuite(pizzaOffertes);
        // Tester si le client a un solde suffisant
        if (solde >= com.devis(false)) {
            // Ajouter la commande dans l'historique du client
            oldCommandes.add(com);

            // Ajuster le solde du client
            solde = solde - com.devis(true);

            // Ajouter les pizza au compteur
            for (int i = 0; i < com.getLigneCom().capacity(); i++) {
                if (com.getLigneCom().get(i).getProduit() instanceof Pizza) {
                    compteurPizza = compteurPizza + com.getLigneCom().get(i).getQuantite();
                }
            }
            // Ajouter une ou plusieurs pizza gratuite
            while (compteurPizza >= 10) {
                pizzaOffertes++;
                compteurPizza = compteurPizza - 10;
            }
            return true;
        } else {
            return false;
        }
    }

    public void printAll() {
        // Cette fonction permet de voir le nombre de commande enregistré dans le compte
        // du client
        System.out.println("Le nombre de commandes est : " + oldCommandes.capacity());
        System.out.println("Le compteur de fidélité est à : " + compteurPizza + " pizza(s)");
        System.out.println("Le nombre de pizzas offertes est à : " + pizzaOffertes + " pizza(s)");
        System.out.println("Le solde est de " + solde + " euros");
    }

    public void addCompteurPizza(int n) {
        compteurPizza = compteurPizza + n;
    }

    public void changeNum(String newNum) {
        numTel = newNum;
    }

    public void addMoney(double s) {
        solde = solde + s;
    }

    public void retardCom(Commande com) {
        LocalTime test = LocalTime.now();
        long time = ChronoUnit.MINUTES.between(com.getDateCom(), test);
        if (time >= 30 && !com.getStatut()) {
            com.remboursement();
            System.out.println("La commande est remboursé");
        }
    }
}