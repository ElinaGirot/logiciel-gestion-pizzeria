package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import Model.*;

public class MenuControl implements ActionListener {
    JButton menu;
    UICom ui;
    Client cust;

    public MenuControl(UICom u, JButton m, Client cl) {
        ui = u;
        menu = m;
        cust = cl;
    }

    public MenuControl(UICom u, JButton m) {
        ui = u;
        menu = m;
    }

    public void actionPerformed(ActionEvent e) {
        switch (menu.getText()) {
            case "Menu":
                ui.setEtat(1);
                ui.update();
                break;

            case "Pizzas":
                ui.setEtat(2);
                ui.update();
                break;

            case "Snack":
                ui.setEtat(3);
                ui.update();
                break;

            case "Boisson":
                ui.setEtat(4);
                ui.update();
                break;

            case "Dessert":
                ui.setEtat(5);
                ui.update();
                break;

        }
    }
}
