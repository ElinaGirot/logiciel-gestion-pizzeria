package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

public class UIAjoutSolde extends JFrame{
    private UICom ui;
    private UICompte uic;
    private JLabel label;
    private JTextField solde;
    private JPanel panel;
    private JButton valider;

    public UIAjoutSolde(UICom u,UICompte uc) {
        ui=u;
        uic=uc;

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        label = new JLabel("De combien souhaitez-vous créditer votre compte ?");
        solde = new JTextField();
        valider = new JButton("Valider");

        AddSolde add = new AddSolde(ui,uic,this,solde);
        valider.addActionListener(add);

        panel.add(label);
        panel.add(solde);
        panel.add(valider);

        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
