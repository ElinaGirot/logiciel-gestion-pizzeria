package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import java.util.Vector;
import Model.*;

public class UIPanier extends JFrame {
    // attributs
    private JLabel p;
    private JLabel total;
    private JLabel pizzaGratuite;

    private JButton retour = new JButton("<- Retour à la carte");
    private JButton passerCom = new JButton("Commander");

    private JCheckBox utiliserPizzas;
    private JCheckBox livre;
    private UICom frame;

    private Vector<LigneCom> listProduits;
    private Vector<JLabel> sumup;
    private Client customer;
    private Commande com;
    private Pizzeria pizzeria;
    private Vector<MenuCom> listMenuCom;
    private Vector<JButton> retirer;
    private Vector<JPanel> panel;

    // constructeur
    public UIPanier(Vector<LigneCom> l, Client c, Pizzeria pi, Vector<MenuCom> mc, UICom uc) {
        listProduits = l;
        customer = c;
        pizzeria = pi;
        listMenuCom = mc;
        frame = uc;

        // Calculer le total de la commande
        com = new Commande(customer, listProduits, listMenuCom);
        double ttc = com.devis(false);
        ttc = Math.round(ttc * 100.0) / 100.0;
        total = new JLabel("Le total est de " + ttc + " euros.");

        p = new JLabel("<html><u>Votre panier :</u></html>");
        p.setHorizontalAlignment(JLabel.CENTER);
        sumup = new Vector<JLabel>();

        pizzaGratuite = new JLabel("(Vous avez " + customer.getPizzaOffertes() + " pizza(s) gratuites).");
        utiliserPizzas = new JCheckBox("Utiliser vos pizzas gratuites");
        UtiliserPizza change = new UtiliserPizza(com, utiliserPizzas, this, customer);
        utiliserPizzas.addActionListener(change);

        livre = new JCheckBox("Livrer à domicile");

        JPanel container = new JPanel();
        JPanel zoneNord = new JPanel();
        JPanel zoneLigneCom = new JPanel();
        JPanel zoneSud = new JPanel();
        JPanel zoneEast = new JPanel();

        container.setLayout(new BorderLayout(10, 10));
        zoneNord.setLayout(new FlowLayout());
        zoneSud.setLayout(new FlowLayout());
        zoneEast.setLayout(new GridLayout(2, 1));
        zoneLigneCom.setLayout(new GridLayout(listProduits.capacity()+listMenuCom.capacity()+ 1, 1, 0, 10));
        zoneLigneCom.add(p);

        passerCom.setHorizontalAlignment(JButton.LEFT);

        retirer = new Vector<JButton>(0,1);
        panel = new Vector<JPanel>(0,1);

        //////// AFFICHER LES ARTICLES//////////
        for (int i = 0; i < listProduits.size(); i++) {
            //Creation du panel pour la ligne de commande
            panel.add(new JPanel(new GridLayout(1, 2)));
            //Affichage de chaque ligne
            this.addJLabel(new JLabel(" Article n°" + (i + 1) + " : " + listProduits.get(i).getProduit().getNom()+ " / Quantité : " + listProduits.get(i).getQuantite() + " / Taille : "+ listProduits.get(i).getTaille() + "\n"));
            //Creation du button avec son action
            retirer.add(new JButton("Retirer"));
            Retirer delete = new Retirer(frame,this,retirer.get(i),i,0);
            retirer.get(i).addActionListener(delete);
            //Ajout de la ligne de commande et du button dans le panel prevu a cette effet
            panel.get(i).add(sumup.get(i));
            panel.get(i).add(retirer.get(i));
            //Et on ajoute ce panel dans la zone prevu pour tous les articles
            zoneLigneCom.add(panel.get(i));
            sumup.get(i).setHorizontalAlignment(JLabel.CENTER);

        }

        //////// AFFICHER LES MENUS//////////
        for (int i = 0; i < listMenuCom.size(); i++) {

            //Creation d'un panel pour le menu
            panel.add(new JPanel(new GridLayout(1, 3)));
            //Creation d'un panel pour les articles du menu
            JPanel affichageProduit = new JPanel();
            //Creation d'un bouton pour retirer le produit
            retirer.add(new JButton("Retirer"));
            Retirer delete = new Retirer(frame,this,retirer.get(i+listProduits.size()),i+listProduits.size(),1);
            retirer.get(i+listProduits.size()).addActionListener(delete);

            panel.get(i+listProduits.size()).setLayout(new GridLayout(1, 3));
            affichageProduit.setLayout(new GridLayout(listMenuCom.get(i).getNbArticle(), 1));

            JLabel nomMenu = new JLabel();
            nomMenu.setText(" Menu n°" + (i + 1) + " : " + listMenuCom.get(i).getNom() + " avec : ");

            Vector<JLabel> produit = new Vector<JLabel>(0, 1);
            for (int j = 0; j < listMenuCom.get(i).getNbArticle(); j++) {
                JLabel temp1 = new JLabel("- " + listMenuCom.get(i).getChoix().get(j).getNom());
                produit.add(temp1);
            }

            for (int j = 0; j < produit.capacity(); j++) {
                affichageProduit.add(produit.get(j));
            }

            panel.get(i+listProduits.capacity()).add(nomMenu);
            panel.get(i+listProduits.capacity()).add(affichageProduit);
            panel.get(i+listProduits.capacity()).add(retirer.get(i+listProduits.capacity()));

            zoneLigneCom.add(panel.get(i+listProduits.capacity()));
        }

        zoneNord.add(retour);
        zoneSud.add(livre);
        zoneSud.add(total);
        zoneSud.add(passerCom);
        zoneNord.add(utiliserPizzas);
        zoneNord.add(pizzaGratuite);
        container.add(BorderLayout.NORTH, zoneNord);
        container.add(BorderLayout.CENTER, zoneLigneCom);
        container.add(BorderLayout.SOUTH, zoneSud);

        this.getContentPane().add(container);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // controller pour quand on appuie sur retour -> revenir sur le menu
        Retour before = new Retour(frame, this);
        retour.addActionListener(before);

        // controller pour quand on appuie sur commander -> met toutes les listCom dans
        // une commande
        PanierCom payer = new PanierCom(this, customer, pizzeria, listProduits, listMenuCom, utiliserPizzas,livre);
        passerCom.addActionListener(payer);

        UtiliserPizza uti = new UtiliserPizza(com, utiliserPizzas, this, customer);
        utiliserPizzas.addActionListener(uti);
    }

    public void addJLabel(JLabel j) {sumup.add(j);}
    

    public void update() {
        // Calculer le total de la commande
        double ttc = com.devis(false);
        ttc = Math.round(ttc * 100.0) / 100.0;
        total.setText("Le total est de " + ttc + " euros.");
        pizzaGratuite = new JLabel("(Vous avez " + customer.getPizzaOffertes() + " pizza(s) gratuites).");

        if (10 - customer.getCompteurPizza() == 0) {
            customer.ajoutPizzaOffertes();

        }
    }

}