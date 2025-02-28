package view;

import java.awt.*;
import javax.swing.*;
import Model.Pizzeria;
import controller.ValidArticle;
import Model.*;
import java.util.*;

public class UICom extends JFrame {
    private UIMenuBar panelBtn;

    private Client client;
    private Pizzeria pizzeria;

    private JPanel panel;

    private JLabel dateMaj;

    private int etat;

    private Vector<LigneCom> listArticles;
    private Vector<MenuCom> listMenu;

    public UICom(Pizzeria p, Client c) {
        client = c;
        pizzeria = p;

        dateMaj = new JLabel("Dernière mise à jour du catalogue le : "
                + String.format("%1$td-%1$tm-%1$tY", pizzeria.getCatalogue().getDateMaj()));
        dateMaj.setHorizontalAlignment(JLabel.CENTER);

        listMenu = new Vector<MenuCom>(0, 1);
        listArticles = new Vector<LigneCom>(0, 1);

        etat = 1;

        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        panelBtn = new UIMenuBar(this, client);

        panel.add(BorderLayout.NORTH, panelBtn);
        panel.add(BorderLayout.SOUTH, dateMaj);
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void update() {
        switch (etat) {
            case 1: ////////////////////// MENU ////////////////////////
                // Réinitialiser le panel
                panel.removeAll();
                UIMenuBar panelBtnMenu = new UIMenuBar(this, client);
                UIComMenu AllMenu = new UIComMenu(this);

                panel.add(BorderLayout.NORTH, panelBtnMenu);
                panel.add(BorderLayout.SOUTH, AllMenu);
                this.pack();
                break;

            case 2: ////////////////////// PIZZA ////////////////////////
                // Réinitialiser le panel
                panel.removeAll();
                // Creation du panel du menu
                UIMenuBar panelBtnPizza = new UIMenuBar(this, client);
                // Creation du panel des pizzas
                UIComPizza piz = new UIComPizza(this, pizzeria);
                // Ajout de tous les panels
                panel.add(BorderLayout.NORTH, panelBtnPizza);
                panel.add(BorderLayout.SOUTH, dateMaj);
                panel.add(BorderLayout.CENTER, piz);
                this.pack();
                break;

            case 3: ////////////////////// SNACK ////////////////////////
                panel.removeAll();
                UIMenuBar panelBtnSnack = new UIMenuBar(this, client);
                UIComSnack snacks = new UIComSnack(this, pizzeria);
                JButton choixSnack = new JButton("Valider");
                ValidArticle okSnack = new ValidArticle(this, snacks.getSnack(), snacks.getTailleSnack(),
                        snacks.getQuantite());
                choixSnack.addActionListener(okSnack);

                panel.add(BorderLayout.NORTH, panelBtnSnack);
                panel.add(BorderLayout.SOUTH, dateMaj);
                panel.add(BorderLayout.CENTER, snacks);
                this.pack();
                break;

            case 4: ////////////////////// BOISSON ////////////////////////
                panel.removeAll();
                UIMenuBar panelBtnBoisson = new UIMenuBar(this, client);
                UIComBoisson boissons = new UIComBoisson(this, pizzeria);
                JButton choixBoissons = new JButton("Valider");

                ValidArticle okBoisson = new ValidArticle(this, boissons.getBoissons(), boissons.getTailleBoissons(),
                        boissons.getQuantite());
                choixBoissons.addActionListener(okBoisson);

                panel.add(BorderLayout.NORTH, panelBtnBoisson);
                panel.add(BorderLayout.SOUTH, dateMaj);
                panel.add(BorderLayout.CENTER, boissons);
                this.pack();
                break;

            case 5: ////////////////////// DESSERT ////////////////////////
                panel.removeAll();
                UIMenuBar panelBtnDessert = new UIMenuBar(this, client);
                UIComDessert desserts = new UIComDessert(this, pizzeria);
                JButton choixDesserts = new JButton("Valider");

                ValidArticle okDessert = new ValidArticle(this, desserts.getDesserts(), desserts.getTailleDesserts(),
                        desserts.getQuantite());
                choixDesserts.addActionListener(okDessert);

                panel.add(BorderLayout.NORTH, panelBtnDessert);
                panel.add(BorderLayout.SOUTH, dateMaj);
                panel.add(BorderLayout.CENTER, desserts);
                this.pack();

                break;
        }
    }

    public int getEtat() {
        return etat;
    }

    public Client getClient() {
        return client;
    }

    public UIMenuBar getUIComMenu() {
        return panelBtn;
    }

    public Vector<LigneCom> getListArticles() {
        return listArticles;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public Vector<MenuCom> getMenuCom() {
        return listMenu;
    }

    public void setEtat(int i) {
        etat = i;
    }

    public void setChooseLastMenu(Vector<Produit> p) {
        listMenu.get(listMenu.capacity() - 1).choose(p);
        // System.out.println("UICom le menu a article......."+ );
    }

    public void addArticle(LigneCom l) {
        listArticles.add(l);
    }

    public void addMenuCom(MenuCom m) {
        listMenu.add(m);
    }
    public void removeLigneCom(int indice){listArticles.remove(indice);}
    public void removeMenuCom(int indice){listMenu.remove(indice);}

}
