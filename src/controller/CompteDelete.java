package controller;
import java.awt.event.*;
import javax.swing.*;
import view.*;


public class CompteDelete implements ActionListener {
    UICom ui;
    UICompteDelete uid;
    UICompte uic;
    JButton button;

    public CompteDelete(UICom u, UICompteDelete ud, UICompte uc,JButton b) {
        ui=u;
        uid=ud;
        uic=uc;
        button=b;
    }
    public void actionPerformed(ActionEvent e) {
        if(button.getText()=="Confirmer"){
            ui.getPizzeria().removeClient(ui.getClient());
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
