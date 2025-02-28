package view;

import java.awt.GridLayout;

import javax.swing.*;
import controller.*;

public class UIChangeNum extends JFrame {
    private UICom ui;
    private UICompte uic;
    private JLabel label;
    private JTextField num;
    private JPanel panel;
    private JButton valider;
     
    public UIChangeNum(UICom u,UICompte uc){
        ui=u;
        uic=uc;

        label = new JLabel("Changez votre numéro de téléphone qui vous permettra de vous connecter.");
        num = new JTextField("Rentrez ici votre numéro de téléphone.");
        valider = new JButton("Valider");

        panel = new JPanel(new GridLayout(3, 1));
        ChangeNum change= new ChangeNum(ui,uic,this,num);
        valider.addActionListener(change);

        panel.add(label);
        panel.add(num);
        panel.add(valider);

        this.add(panel);
        this.pack();
    }
}
