package view;

import javax.swing.*;
import java.awt.*;
import controller.*;

public class UIDeco extends JFrame{
    private UICom ui;
    private UICompte uic;
    private UIFin uif;
    
    private JPanel panel;
    private JLabel label;

    private JButton annuler;
    private JButton confirmer;


    public UIDeco(UICom u,UICompte uc) {
        ui=u;
        uic=uc;
        
        panel = new JPanel();
        label = new JLabel(" Voulez-vous vraiment vous déconnecter ? ");

        annuler = new JButton("Annuler");
        confirmer = new JButton("Confirmer");

        Deco d1 = new Deco(ui, this,uic,annuler);
        annuler.addActionListener(d1);

        Deco d2 = new Deco(ui, this,uic,confirmer);
        confirmer.addActionListener(d2);

        panel.setLayout(new GridLayout(1,2));
        panel.add(annuler);
        panel.add(confirmer);

        this.setLayout(new GridLayout(2,1));
        this.add(label);
        this.add(panel);
        
        this.setVisible(true);
        this.pack();
    }
    public UIDeco(UIFin u) {
        uif=u;
        
        panel = new JPanel();
        label = new JLabel(" Voulez-vous vraiment vous déconnecter ? ");

        annuler = new JButton("Annuler");
        confirmer = new JButton("Confirmer");

        Deco d1 = new Deco(uif,this,annuler);
        annuler.addActionListener(d1);

        Deco d2 = new Deco(uif,this,confirmer);
        confirmer.addActionListener(d2);

        panel.setLayout(new GridLayout(1,2));
        panel.add(annuler);
        panel.add(confirmer);

        this.setLayout(new GridLayout(2,1));
        this.add(label);
        this.add(panel);
        
        this.setVisible(true);
        this.pack();
    }
}
