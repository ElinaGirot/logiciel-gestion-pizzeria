package view;

import java.awt.*;
import javax.swing.*;
import Model.*;
import controller.*;

public class UIFin extends JFrame {
    private JLabel phrase;
    private JLabel confirmation;
    private JButton finir = new JButton("Se déconnecter");
    private JButton retour = new JButton("Commander à nouveau");

    private Commande cust;
    private Pizzeria shop;
    private Client client;

    public UIFin(Commande c, Pizzeria p, Client cl) {
        cust = c;
        shop = p;
        client = cl;
        phrase = new JLabel("Merci pour votre commande !");
        confirmation = new JLabel("Votre commande d'un montant de " + Math.round(cust.devis(false) * 100.0) / 100.0
                + " euros a été prise en compte.");

        JPanel cont = new JPanel();
        JPanel bouttons = new JPanel();
        cont.setLayout(new BorderLayout(10, 10));
        bouttons.setLayout(new GridLayout(1, 2));

        ConfirmeDeco deconnexion = new ConfirmeDeco(this);
        finir.addActionListener(deconnexion);

        retour.setSize(new Dimension(250, 100));
        finir.setSize(new Dimension(250, 100));

        cont.add(BorderLayout.NORTH, phrase);
        cont.add(BorderLayout.CENTER, confirmation);
        cont.add(BorderLayout.SOUTH, bouttons);
        bouttons.add(retour);
        bouttons.add(finir);

        this.getContentPane().add(cont);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // appliquer un controller pour le bouton retour
        BacktoMenu back = new BacktoMenu(this, shop, client);
        retour.addActionListener(back);

    }
}
