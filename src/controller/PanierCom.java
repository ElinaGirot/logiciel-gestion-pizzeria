package controller;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import view.*;
import java.util.Vector;


public class PanierCom implements ActionListener{
    UIPanier panier;
    Client customer;
    Pizzeria pizzeria;
    Commande comm;
    Vector<LigneCom> tab;
    Vector<MenuCom> menus;
    JCheckBox check;
    JCheckBox livraison;


    public PanierCom(UIPanier p,Client c, Pizzeria pi, Vector<LigneCom> t,Vector<MenuCom> m,JCheckBox ch,JCheckBox li){
        panier = p;
        customer = c;
        pizzeria = pi;
        tab = t;
        menus=m;
        comm = new Commande(customer,tab,menus);
        comm.addPizzeria(pizzeria);
        check=ch;
        livraison=li;
    }

    public void actionPerformed(ActionEvent e){
        comm.setPizzaOffertes(check.isSelected());
        if(comm.devis(false)<=customer.getSolde()){
            //Ajouter un livreur ou pas
            if (livraison.isSelected()){comm.addLivreur(pizzeria);}
            else{comm.addLivreur(null);}
            customer.addCommande(comm);
            panier.setVisible(false);
            UIFin pagefin = new UIFin(comm,pizzeria,customer);
            pagefin.setVisible(true);
            pizzeria.addCommande(comm);
        }
        else{
            JFrame no = new JFrame();
            JLabel pasAssez = new JLabel("Votre solde n'est pas suffisant pour valider la commande.");
            no.add(pasAssez);
            no.setVisible(true);
            no.pack();
        }
    }
    
}
