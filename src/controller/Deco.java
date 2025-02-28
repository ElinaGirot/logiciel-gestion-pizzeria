package controller;
import java.awt.event.*;
import javax.swing.*;
import view.*;

public class Deco implements ActionListener {
    UICom ui;
    UIDeco uid;
    UIFin uif;
    UICompte uic;
    JButton button;

    public Deco(UICom u, UIDeco ud,UICompte uc,JButton b){
        ui=u;
        uid=ud;
        uic=uc;
        button=b;
    }
    public Deco(UIFin u, UIDeco ud,JButton b){
        uif=u;
        uid=ud;
        button=b;
        ui=null;
    }
    public void actionPerformed(ActionEvent e) {
        if (ui==null){
            if (button.getText()=="Confirmer"){
                uif.dispose();
                UIBienvenue model = new UIBienvenue();
                model.setVisible(true);
                uid.dispose();
            }
            else{
                uid.dispose();
            }
        }
        else{
            if (button.getText()=="Confirmer"){
                uic.dispose();
                ui.dispose();
                UIBienvenue model = new UIBienvenue();
                model.setVisible(true);
                uid.dispose();
            }
            else{
                uid.dispose();
            }
        }  
    }
}
