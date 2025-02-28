package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import Model.*;

public class GoToCompte implements ActionListener {
    JButton compte;
    UICom ui;
    Client cust;

    public GoToCompte(UICom u, JButton p, Client c) {
        ui = u;
        compte = p;
        cust = c;
    }

    public void actionPerformed(ActionEvent e) {
        UICompte account = new UICompte(ui ,cust);
        ui.setVisible(false);
        account.setVisible(true);
    }
}
