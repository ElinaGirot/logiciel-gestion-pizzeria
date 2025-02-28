package view;

import java.awt.*;
import javax.swing.*;
import Model.Pizzeria;
import java.util.*;
import Model.*;
import controller.*;

public class UIComDessert extends JPanel {
    private UICom ui;
    private Pizzeria pizzeria;
    private JComboBox<String> desserts;
    private JComboBox<String> tailleDessert;
    private JTextField quantiteDessert;
    private double prix;
    private JLabel prixLabel;
    private JButton validation;

    private JPanel un;
    private JPanel deux;
    private JPanel trois;

    public UIComDessert(UICom u, Pizzeria p) {
        ui = u;
        pizzeria = p;

        JLabel textDessert = new JLabel("<html><u>Choisissez votre dessert :</u></html>");
        textDessert.setHorizontalAlignment(JLabel.CENTER);

        un = new JPanel();
        deux = new JPanel();
        trois = new JPanel();

        desserts = new JComboBox<String>();
        desserts.setPreferredSize(new Dimension(300, 20));
        tailleDessert = new JComboBox<String>();
        tailleDessert.setPreferredSize(new Dimension(300, 20));
        // Prendre ce qui est dispo dans la pizzeria (les catalogue peuvent differer en
        // fonction de la pizzeria)
        Vector<Dessert> listDessertDispo = pizzeria.getCatalogue().getDessert();

        for (int i = 0; i < listDessertDispo.capacity(); i++) {
            desserts.addItem(listDessertDispo.get(i).getNom());
        }

        quantiteDessert = new JTextField("1");
        quantiteDessert.setPreferredSize(new Dimension(300, 20));

        prixLabel = new JLabel("Prix : " + prix + " euros.");
        prixLabel.setHorizontalAlignment(JLabel.RIGHT);

        TestPrix testPrix = new TestPrix(this);
        tailleDessert.addActionListener(testPrix);
        quantiteDessert.addActionListener(testPrix);
        desserts.addActionListener(testPrix);

        // Mettre des tailles différentes
        tailleDessert.addItem("Normale");

        validation = new JButton("Valider");
        ValidArticle okPizza = new ValidArticle(ui, desserts, tailleDessert, quantiteDessert);
        validation.addActionListener(okPizza);

        this.setLayout(new GridLayout(6, 1, 10, 10));
        un.add(desserts);
        deux.add(tailleDessert);
        trois.add(quantiteDessert);
        this.add(textDessert);
        this.add(un);
        this.add(deux);
        this.add(trois);
        this.add(prixLabel);
        this.add(validation);

        update();
    }

    public void update() {
        double prixDessert = pizzeria.getCatalogue().findProduit(desserts.getItemAt(desserts.getSelectedIndex()))
                .getPrix();
        double prix = prixDessert * Double.valueOf(quantiteDessert.getText());
        prix = Math.round(prix * 100.0) / 100.0;
        prixLabel.setText("  Prix : " + prix + " euros.");
    }

    public JComboBox<String> getDesserts() {
        return desserts;
    }

    public JComboBox<String> getTailleDesserts() {
        return tailleDessert;
    }

    public JTextField getQuantite() {
        return quantiteDessert;
    }
}
