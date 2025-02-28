package controller;
import java.awt.event.*;
import Model.*;
import view.*;


public class BacktoMenu implements ActionListener{
    UIFin ecranFin;
    Pizzeria pizzeria;
    Client cust;

    public BacktoMenu(UIFin ec, Pizzeria p, Client c){
        ecranFin = ec;
        pizzeria = p;
        cust = c;
    }

    public void actionPerformed(ActionEvent e){
        ecranFin.setVisible(false);
        UICom menu = new UICom(pizzeria,cust);
        menu.setVisible(true);
    }
    
}
