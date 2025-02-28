package controller;

import java.awt.event.*;
import view.*;

public class OpenSolde implements ActionListener{
    UICom ui;
    UICompte uic;
    public OpenSolde(UICom u,UICompte uc){
        ui=u;
        uic=uc;
    }
    public void actionPerformed(ActionEvent e){
        UIAjoutSolde frame = new UIAjoutSolde(ui,uic);
        frame.setVisible(true);
    }
}
