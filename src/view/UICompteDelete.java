package view;

import javax.swing.*;
import java.awt.*;
import controller.*;

public class UICompteDelete extends JFrame{
    private UICom ui;
    private UICompte uic;

    private JPanel panel;

    private JLabel label;

    private JButton annuler;
    private JButton confirmer;

    public UICompteDelete(UICom u, UICompte uc) {
        ui=u;
        uic=uc;

        panel = new JPanel();
        label = new JLabel(" Voulez-vous vraiment supprimer votre compte ? Cette action est irréversible. ");

        annuler = new JButton("Annuler");
        confirmer = new JButton("Confirmer");

        CompteDelete c1 = new CompteDelete(ui,this,uic,annuler);
        annuler.addActionListener(c1);

        CompteDelete c2 = new CompteDelete(ui,this,uic,confirmer);
        confirmer.addActionListener(c2);

        panel.setLayout(new GridLayout(1,2));
        panel.add(annuler);
        panel.add(confirmer);


        this.setLayout(new GridLayout(2,1));
        this.add(label);
        this.add(panel);

        this.pack();
        this.setVisible(true);
    }
}
