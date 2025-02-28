package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

public class UINum extends JFrame {
    private JLabel numTelLabel;
    private JLabel choixResto;
    private JTextField valeur = new JTextField("");
    private JButton ok = new JButton("Valider");
    private JButton compte = new JButton("Je suis un nouveau client");
    private JComboBox<String> pizzeriaComboBox;

    public UINum() {
        numTelLabel = new JLabel("Rentrez votre numéro de téléphone pour vous identifier :");
        choixResto = new JLabel("Choisissez votre restaurant :");
        numTelLabel.setHorizontalAlignment(JLabel.CENTER);
        choixResto.setHorizontalAlignment(JLabel.CENTER);

        pizzeriaComboBox = new JComboBox<String>();
        for (int i = 0; i < MainProg.listPizzerias.capacity(); i++) {
            pizzeriaComboBox.addItem(MainProg.listPizzerias.get(i).getNom());
        }

        JPanel panel = new JPanel();
        JPanel buttons = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        buttons.setLayout(new GridLayout(1, 2));
        panel.add(numTelLabel);
        panel.add(valeur);
        panel.add(choixResto);

        NewClient nouveau = new NewClient(compte);
        compte.addActionListener(nouveau);

        buttons.add(ok);
        buttons.add(compte);
        this.getContentPane().setLayout(new GridLayout(3, 1));
        this.getContentPane().add(panel);
        this.getContentPane().add(pizzeriaComboBox);
        this.getContentPane().add(buttons);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(400, 400);

        ValidationNum okDacc = new ValidationNum(valeur, pizzeriaComboBox, MainProg.listPizzerias, this);
        ok.addActionListener(okDacc);
    }
}
