package view;

import java.awt.*;
import javax.swing.*;
import Model.Pizzeria;
import java.util.*;
import Model.*;
import controller.*;

public class UIComSnack extends JPanel {
    private Pizzeria pizzeria;
    private UICom ui;
    private JComboBox<String> snacks;
    private JComboBox<String> tailleSnack;
    private JTextField quantiteSnack;
    private double prix;
    private JLabel prixLabel;
    private JButton validation;

    private JPanel un;
    private JPanel deux;
    private JPanel trois;

    public UIComSnack(UICom u, Pizzeria p) {
        pizzeria = p;
        ui = u;

        JLabel textSnack = new JLabel("<html><u>Choisissez votre snack :</u></html>");
        textSnack.setHorizontalAlignment(JLabel.CENTER);

        un = new JPanel();
        deux = new JPanel();
        trois = new JPanel();

        snacks = new JComboBox<String>();
        snacks.setPreferredSize(new Dimension(300, 20));
        tailleSnack = new JComboBox<String>();
        tailleSnack.setPreferredSize(new Dimension(300, 20));
        Vector<Snack> listSnack = pizzeria.getCatalogue().getSnack();
        for (int i = 0; i < listSnack.capacity(); i++) {
            snacks.addItem(listSnack.get(i).getNom());
        }

        quantiteSnack = new JTextField("1");
        quantiteSnack.setPreferredSize(new Dimension(300, 20));
        tailleSnack.addItem("Normale");
        tailleSnack.addItem("Double");

        prixLabel = new JLabel("Prix : " + prix + " euros.");
        prixLabel.setHorizontalAlignment(JLabel.RIGHT);

        TestPrix testPrix = new TestPrix(this);
        tailleSnack.addActionListener(testPrix);
        quantiteSnack.addActionListener(testPrix);
        snacks.addActionListener(testPrix);

        validation = new JButton("Valider");
        ValidArticle okPizza = new ValidArticle(ui, snacks, tailleSnack, quantiteSnack);
        validation.addActionListener(okPizza);

        un.add(snacks);
        deux.add(tailleSnack);
        trois.add(quantiteSnack);

        this.setLayout(new GridLayout(6, 1, 10, 10));
        this.add(textSnack);
        this.add(un);
        this.add(deux);
        this.add(trois);
        this.add(prixLabel);
        this.add(validation);

        update();
    }

    public void update() {
        double prixSnack = pizzeria.getCatalogue().findProduit(snacks.getItemAt(snacks.getSelectedIndex())).getPrix();
        String strTaille = tailleSnack.getItemAt(tailleSnack.getSelectedIndex());
        double prix = prixSnack * Double.valueOf(quantiteSnack.getText());
        if (strTaille == "Double") {
            prix = 2 * prix;
        }
        prix = Math.round(prix * 100.0) / 100.0;
        prixLabel.setText("  Prix : " + prix + " euros.");
    }

    public JComboBox<String> getSnack() {
        return snacks;
    }

    public JComboBox<String> getTailleSnack() {
        return tailleSnack;
    }

    public JTextField getQuantite() {
        return quantiteSnack;
    }
}
