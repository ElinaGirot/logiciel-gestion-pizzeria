package controller;
import java.awt.event.*;
import view.*;

public class Retour implements ActionListener{
    UIPanier pagePanier;
    UICom uicom;
    UICompte uicompte;
    UIHistorique uiHistorique;

    public Retour(UICom uc, UIPanier p){
        pagePanier = p;
        uicom = uc;
    }

    public Retour(UICom uc,UICompte uct){
        uicompte=uct;
        uicom=uc;
    }
    public Retour(UICompte uip, UIHistorique uih){
        uicom=null;
        uicompte=uip;
        uiHistorique=uih;
    }


    public void actionPerformed(ActionEvent e){
        if (pagePanier!=null){
            pagePanier.dispose();;
            uicom.setVisible(true);
        }
        else if (uicom == null){
            uiHistorique.dispose();
            uicompte.setVisible(true);
        }
        else{
            uicompte.dispose();;
            uicom.setVisible(true);
        }
    }
}