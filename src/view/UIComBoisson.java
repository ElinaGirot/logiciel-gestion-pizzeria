package view;

import java.awt.*;
import javax.swing.*;
import Model.Pizzeria;
import java.util.*;
import Model.*;
import controller.*;

public class UIComBoisson extends JPanel {
    private JComboBox<String> boissons;
    private JComboBox<String> tailleBoissons;
    private JTextField quantiteBoisson;
    private JLabel prixLabel;
    private JButton validation;
    private JPanel un;
    private JPanel deux;
    private JPanel trois;

    private UICom ui;
    private Pizzeria pizzeria;
    private double prix;

    public UIComBoisson(UICom u, Pizzeria p) {
        pizzeria = p;
        ui = u;

        JLabel textBoisson = new JLabel("<html><u>Choisissez votre boisson :</u></html>");
        textBoisson.setHorizontalAlignment(JLabel.CENTER);

        un = new JPanel();
        deux = new JPanel();
        trois = new JPanel();

        boissons = new JComboBox<String>();
        boissons.setPreferredSize(new Dimension(300, 20));
        tailleBoissons = new JComboBox<String>();
        tailleBoissons.setPreferredSize(new Dimension(300, 20));

        Vector<Boisson> listBoissonsDispo = pizzeria.getCatalogue().getBoisson();

        for (int i = 0; i < listBoissonsDispo.capacity(); i++) {
            boissons.addItem(listBoissonsDispo.get(i).getNom());
        }

        quantiteBoisson = new JTextField("1");
        quantiteBoisson.setPreferredSize(new Dimension(300, 20));
        // Mettre des tailles différentes
        tailleBoissons.addItem("Canette");
        tailleBoissons.addItem("Bouteille");

        TestPrix testPrix = new TestPrix(this);
        tailleBoissons.addActionListener(testPrix);
        quantiteBoisson.addActionListener(testPrix);
        boissons.addActionListener(testPrix);

        prixLabel = new JLabel("Prix : " + prix + " euros.");
        prixLabel.setHorizontalAlignment(JLabel.RIGHT);

        validation = new JButton("Valider");
        ValidArticle okPizza = new ValidArticle(ui, boissons, tailleBoissons, quantiteBoisson);
        validation.addActionListener(okPizza);

        un.add(boissons);
        deux.add(tailleBoissons);
        trois.add(quantiteBoisson);
        this.setLayout(new GridLayout(6, 1, 10, 10));
        this.add(textBoisson);
        this.add(un);
        this.add(deux);
        this.add(trois);
        this.add(prixLabel);
        this.add(validation);

        update();

    }

    public void update() {
        double prixBoisson = pizzeria.getCatalogue().findProduit(boissons.getItemAt(boissons.getSelectedIndex()))
                .getPrix();
        String strTaille = tailleBoissons.getItemAt(tailleBoissons.getSelectedIndex());
        double prix = prixBoisson * Double.valueOf(quantiteBoisson.getText());
        if (strTaille == "Bouteille") {
            prix = 2 * prix;
        }
        prix = Math.round(prix * 100.0) / 100.0;
        prixLabel.setText("  Prix : " + prix + " euros.");
    }

    public JComboBox<String> getBoissons() {
        return boissons;
    }

    public JComboBox<String> getTailleBoissons() {
        return tailleBoissons;
    }

    public JTextField getQuantite() {
        return quantiteBoisson;
    }
}
