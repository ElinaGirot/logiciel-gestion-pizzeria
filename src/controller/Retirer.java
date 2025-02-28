package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;

public class Retirer implements ActionListener {
    UICom uic;
    UIPanier uip;
    JButton btnRetirer;
    int indice; //Si indice vaut 0, c'est une ligneCom qui va être retirer, si il vaut 1, c'est un menu
    int nb;
    public Retirer(UICom ui,UIPanier up,JButton retirer,int ind,int n){
        uic=ui;
        uip=up;
        btnRetirer=retirer;
        indice=ind;
        nb=n;
    }
    public void actionPerformed(ActionEvent e) {
        if(nb==0){uic.removeLigneCom(indice);}
        else{uic.removeMenuCom(indice);}
        uip.dispose();
        UIPanier panier = new UIPanier(uic.getListArticles(), uic.getClient(), uic.getPizzeria(), uic.getMenuCom(), uic);
        panier.setVisible(true);
        uic.setVisible(false);
    }
}
