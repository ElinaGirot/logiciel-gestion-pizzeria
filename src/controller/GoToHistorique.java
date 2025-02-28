package controller;

import java.awt.event.*;
import view.*;
import Model.*;

public class GoToHistorique implements ActionListener{
    UICompte ui;
    Client client;

    public GoToHistorique(UICompte u,Client c){
        ui=u;
        client=c;
    }
    public void actionPerformed(ActionEvent e){
        UIHistorique frame = new UIHistorique(ui,client);
        ui.setVisible(false);
        frame.setVisible(true);
    }
}
