package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;

public class GoToPanier implements ActionListener {
    JButton Panier;
    UICom ui;

    public GoToPanier(UICom u, JButton p) {
        ui = u;
        Panier = p;
    }

    public void actionPerformed(ActionEvent e) {
        UIPanier panier = new UIPanier(ui.getListArticles(), ui.getClient(), ui.getPizzeria(), ui.getMenuCom(), ui);
        panier.setVisible(true);
        ui.setVisible(false);
    }
}
