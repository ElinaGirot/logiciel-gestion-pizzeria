package view;

import java.awt.*;
import javax.swing.*;
import Model.*;
import java.util.*;
import controller.*;

public class UIComPizza extends JPanel {
    private UICom ui;
    private Pizzeria pizzeria;
    private JComboBox<String> pizzas;
    private JComboBox<String> taillePizzas;
    private JTextField quantitePizzas;
    private JComboBox<String> nbSupplements;
    private JPanel panelSupplements;
    private JLabel textPizza;
    private JLabel labelSupplement;
    private JLabel prixLabel;
    private JButton validation;
    private double prix;
    private ValidArticle okPizza;
    private Vector<JComboBox<String>> supplements = new Vector<JComboBox<String>>(0, 1);
    private int nbSupplement;

    private JPanel un;
    private JPanel deux;
    private JPanel trois;
    private JPanel container;

    public UIComPizza(UICom u, Pizzeria p) {
        pizzeria = p;
        ui = u;
        panelSupplements = new JPanel(new GridLayout(2, 1));

        textPizza = new JLabel("<html><u>Choisissez votre pizza :</u></html>");
        labelSupplement = new JLabel(" Envie d'un supplément ? (50 cents)");
        textPizza.setHorizontalAlignment(JLabel.CENTER);

        un = new JPanel();
        deux = new JPanel();
        trois = new JPanel();
        container = new JPanel();
        container.setLayout(new GridLayout(7, 1, 0, 0));

        pizzas = new JComboBox<String>();
        pizzas.setPreferredSize(new Dimension(300, 20));
        taillePizzas = new JComboBox<String>();
        taillePizzas.setPreferredSize(new Dimension(300, 20));
        nbSupplements = new JComboBox<String>();

        for (int i = 0; i <= 10; i++) {
            nbSupplements.addItem(Integer.toString(i));
        }

        Vector<Pizza> listPizzasDispo = pizzeria.getCatalogue().getPizza();
        for (int i = 0; i < listPizzasDispo.capacity(); i++) {
            pizzas.addItem(listPizzasDispo.get(i).getNom());
        }

        quantitePizzas = new JTextField("1");
        quantitePizzas.setPreferredSize(new Dimension(300, 20));
        validation = new JButton("Valider");
        okPizza = new ValidArticle(ui, pizzas, taillePizzas, quantitePizzas, nbSupplement, supplements);
        validation.addActionListener(okPizza);

        // Mettre des tailles différentes
        taillePizzas.addItem("Naine");
        taillePizzas.addItem("Humaine");
        taillePizzas.addItem("Ogresse");

        prixLabel = new JLabel("Prix : " + prix + " euros. \n");
        prixLabel.setHorizontalAlignment(JLabel.RIGHT);

        TestPrix testPrix = new TestPrix(this);
        taillePizzas.addActionListener(testPrix);
        quantitePizzas.addActionListener(testPrix);
        pizzas.addActionListener(testPrix);
        nbSupplements.addActionListener(testPrix);

        un.add(pizzas);
        deux.add(taillePizzas);
        trois.add(quantitePizzas);
        panelSupplements.add(labelSupplement);
        panelSupplements.add(nbSupplements);
        this.add(container);

        container.add(textPizza);
        container.add(un);
        container.add(deux);
        container.add(trois);
        container.add(panelSupplements);
        container.add(prixLabel);
        container.add(validation);
        update();
    }

    public void update() {

        nbSupplement = Integer.valueOf(nbSupplements.getItemAt(nbSupplements.getSelectedIndex()));
        panelSupplements.removeAll();
        panelSupplements.add(labelSupplement);
        panelSupplements.add(nbSupplements);

        supplements.removeAllElements();

        for (int i = 0; i < nbSupplement; i++) {
            supplements.add(new JComboBox<String>(new Vector<String>(Arrays.asList("Mozzarella", "Bacon", "Chèvre","Sauce Barbecue", "Oeufs", "Jambon", "Saumon", "Feuille d'or"))));
            panelSupplements.add(supplements.get(i));
        }
        panelSupplements.setLayout(new GridLayout(3, 2 + (nbSupplement / 2)));

        validation.removeActionListener(okPizza);

        okPizza = new ValidArticle(ui, pizzas, taillePizzas, quantitePizzas, nbSupplement, supplements);
        validation.addActionListener(okPizza);

        double prixPizza = pizzeria.getCatalogue().findProduit(pizzas.getItemAt(pizzas.getSelectedIndex())).getPrix();
        String strTaille = taillePizzas.getItemAt(taillePizzas.getSelectedIndex());
        double prix = prixPizza * Double.valueOf(quantitePizzas.getText());
        if (strTaille == "Ogresse") {
            prix = 4 * prix / 3;
        }
        if (strTaille == "Naine") {
            prix = 2 * prix / 3;
        }
        prix = prix + 0.5 * nbSupplement;
        prix = Math.round(prix * 100.0) / 100.0;
        prixLabel.setText("  Prix : " + prix + " euros. \n");

        ui.pack();
        this.updateUI();
    }

    public JComboBox<String> getPizzas() {
        return pizzas;
    }

    public JComboBox<String> getTaillePizzas() {
        return taillePizzas;
    }

    public JTextField getQuantite() {
        return quantitePizzas;
    }

    public double getPrix() {
        return prix;
    }
}
