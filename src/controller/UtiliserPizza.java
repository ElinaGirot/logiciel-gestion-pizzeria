package controller;

import java.awt.event.*;
import javax.swing.*;
import Model.*;
import view.*;

public class UtiliserPizza implements ActionListener {
    UIPanier ui;
    Commande com;
    JCheckBox box;
    Client cust;

    public UtiliserPizza(Commande c, JCheckBox b, UIPanier u, Client cl) {
        com = c;
        box = b;
        ui = u;
        cust = cl;
    }

    public void actionPerformed(ActionEvent e) {
        com.setPizzaOffertes(box.isSelected());
        ui.update();
    }
}
