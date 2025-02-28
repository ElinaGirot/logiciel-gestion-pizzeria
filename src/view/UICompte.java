package view;

import controller.*;
import java.awt.*;
import javax.swing.*;
import Model.*;

public class UICompte extends JFrame {
    private JButton retour = new JButton("<- Retour");
    private JButton addSolde = new JButton("Ajouter du solde");
    private JButton tel = new JButton("Changer votre numéro");
    private JButton supprimer = new JButton("Supprimer votre compte");
    private JButton historiqueCommande = new JButton("Mes commandes");
    private JButton deconnexion = new JButton("Déconnexion");

    private JLabel p;
    private JLabel t;
    private JLabel sold;
    private JLabel pizza;

    private Client cust;
    private UICom frame;

    public UICompte(UICom f, Client c) {
        frame = f;
        cust = c;
        p = new JLabel("<html><u>Vos informations :</u></html>");
        t = new JLabel(" Numéro de téléphone : " + cust.getNumTel());
        sold = new JLabel(" Solde : " + cust.getSolde() + " euros");
        pizza = new JLabel(" Il vous manque " + (10 - cust.getCompteurPizza()) + " pizza(s) avant une offerte.");

        JPanel cont = new JPanel();
        JPanel zoneNord = new JPanel();
        JPanel zoneEst = new JPanel();
        JPanel zoneC = new JPanel();
        JPanel zoneS = new JPanel();

        cont.setLayout(new BorderLayout(30, 30));
        zoneNord.setLayout(new FlowLayout());
        zoneC.setLayout(new GridLayout(3, 1));
        zoneEst.setLayout(new GridLayout(4, 1, 0, 10));
        zoneS.setLayout(new FlowLayout());

        zoneEst.add(historiqueCommande);
        zoneEst.add(addSolde);
        zoneEst.add(tel);
        zoneEst.add(supprimer);

        zoneNord.add(p);

        zoneC.add(t);
        zoneC.add(sold);
        zoneC.add(pizza);

        zoneS.add(retour);

        cont.add(BorderLayout.NORTH, zoneNord);
        cont.add(BorderLayout.EAST, zoneEst);
        cont.add(BorderLayout.CENTER, zoneC);
        cont.add(BorderLayout.SOUTH, zoneS);

        Retour goToBoard = new Retour(frame, this);
        retour.addActionListener(goToBoard);

        OpenSolde openSolde = new OpenSolde(frame, this);
        addSolde.addActionListener(openSolde);

        OpenNum openNum = new OpenNum(frame, this);
        tel.addActionListener(openNum);

        ConfirmeDeco confDeco = new ConfirmeDeco(frame, this);
        deconnexion.addActionListener(confDeco);

        ConfirmeDelete confDele = new ConfirmeDelete(frame, this);
        supprimer.addActionListener(confDele);

        GoToHistorique historique = new GoToHistorique(this, cust);
        historiqueCommande.addActionListener(historique);

        this.getContentPane().add(cont);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void update() {
        sold.setText(" Solde : " + cust.getSolde() + " euros");
        t.setText("Numéro de téléphone : " + cust.getNumTel());
    }

}
