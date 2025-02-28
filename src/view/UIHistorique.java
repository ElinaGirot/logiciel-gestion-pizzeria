package view;

import controller.*;
import java.awt.*;
import javax.swing.*;
import Model.*;
import java.util.*;

public class UIHistorique extends JFrame {
    private UICompte ui;
    private Client client;

    private JPanel panel;
    private JLabel label;
    private JButton retour;

    private Vector<JPanel> panels;

    public UIHistorique(UICompte u, Client c) {
        ui = u;
        client = c;

        panel = new JPanel();
        JPanel cont = new JPanel();
        cont.setLayout(new BorderLayout(15, 15));
        JPanel cont2 = new JPanel();

        label = new JLabel(" Toutes vos anciennes commandes sont ici : ");

        retour = new JButton("<- Retour au compte");
        Retour r = new Retour(ui, this);
        retour.addActionListener(r);

        cont.add(BorderLayout.NORTH, panel);
        panel.add(retour);
        panel.add(label);

        panels = new Vector<JPanel>(0, 1);

        for (int i = 0; i < client.getHistory().capacity(); i++) {
            panels.add(new JPanel(new GridLayout(5, 1)));

            JLabel informations = new JLabel("Commandé à " + client.getHistory().get(i).getDateCom());
            informations.setHorizontalAlignment(JLabel.CENTER);
            JLabel prix = new JLabel(" Prix de la commande : " + client.getHistory().get(i).devis(false) + " euros");
            JLabel statut;
            JLabel livraison;
            if (client.getHistory().get(i).getLivreur() != null) {
                livraison = new JLabel(" Livrée par " + client.getHistory().get(i).getLivreur().getPrenom() + " en "
                        + client.getHistory().get(i).getLivreur().getVehicule());
                statut = new JLabel(" Livrée : " + client.getHistory().get(i).getStatut());
            } else {
                livraison = new JLabel(" Vous n'avez pas demandé à être livré pour cette commande.");
                statut = new JLabel(" Retirée : " + client.getHistory().get(i).getStatut());
            }

            JLabel lieu = new JLabel(
                    " Vous avez commandé à la pizzeria " + client.getHistory().get(i).getPizzeria().getNom());

            panels.get(i).add(informations);
            panels.get(i).add(prix);
            panels.get(i).add(statut);
            panels.get(i).add(livraison);
            panels.get(i).add(lieu);

            cont2.add(panels.get(i));
        }

        cont2.setLayout(new GridLayout(1 + panels.capacity(), 1, 10, 10));
        cont.add(BorderLayout.CENTER, cont2);
        this.getContentPane().add(cont);
        this.setVisible(true);
        this.pack();
    }

    public void update() {

    }

}
