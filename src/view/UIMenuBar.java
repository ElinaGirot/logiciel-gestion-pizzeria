package view;

import javax.swing.*;
//import javax.swing.JPopupMenu.Separator;

import java.awt.*;
import controller.*;
import Model.*;

public class UIMenuBar extends JPanel {
    private UICom ui;
    private JButton Menu;
    private JButton Pizzas;
    private JButton Snack;
    private JButton Boisson;
    private JButton Dessert;
    private JButton Panier;
    private JButton compte;

    private JLabel total;

    private Client c;

    public UIMenuBar(UICom u, Client cu) {
        ui = u;
        c = cu;
        this.setLayout(new GridLayout(1, 7));

        Menu = new JButton("Menu");
        Pizzas = new JButton("Pizzas");
        Snack = new JButton("Snack");
        Boisson = new JButton("Boisson");
        Dessert = new JButton("Dessert");
        Panier = new JButton("Panier");
        compte = new JButton("Compte");

        MenuControl btn = new MenuControl(ui, Menu);
        Menu.addActionListener(btn);

        MenuControl btn2 = new MenuControl(ui, Pizzas);
        Pizzas.addActionListener(btn2);

        MenuControl btn3 = new MenuControl(ui, Snack);
        Snack.addActionListener(btn3);

        MenuControl btn4 = new MenuControl(ui, Boisson);
        Boisson.addActionListener(btn4);

        MenuControl btn5 = new MenuControl(ui, Dessert);
        Dessert.addActionListener(btn5);

        GoToCompte go = new GoToCompte(ui, compte, c);
        compte.addActionListener(go);

        GoToPanier panier = new GoToPanier(ui, Panier);
        Panier.addActionListener(panier);

        Commande temp = new Commande(c, ui.getListArticles(), ui.getMenuCom());
        double ttc = temp.devis(false);
        ttc = Math.round(ttc * 100.0) / 100.0;
        total = new JLabel("  TOTAL TTC : " + ttc + "€  ");
        total.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.LIGHT_GRAY));

        this.add(Menu);
        this.add(Pizzas);
        this.add(Snack);
        this.add(Boisson);
        this.add(Dessert);
        this.add(total);
        this.add(compte);
        this.add(Panier);
    }

    public void update() {
        Commande temp = new Commande(c, ui.getListArticles(), ui.getMenuCom());
        double ttc = temp.devis(false);
        System.out.println("Le devis est " + ttc);
        total.setText("  TOTAL TTC kaihf: " + ttc + "€  ");
    }
}
