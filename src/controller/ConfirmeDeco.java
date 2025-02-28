package controller;
import java.awt.event.*;
import view.*;

public class ConfirmeDeco implements ActionListener {
    UICom ui;
    UICompte uic;
    UIFin uif;
    public ConfirmeDeco(UICom u, UICompte uc){
        ui=u;
        uic=uc;
    }
    public ConfirmeDeco(UIFin u){
        uif=u;
        ui=null;
    }
    public void actionPerformed(ActionEvent e) {
        if(ui==null){
            UIDeco frame = new UIDeco(uif);
            frame.setVisible(true);
        }
        else{
            UIDeco frame = new UIDeco(ui,uic);
            frame.setVisible(true);
        }
    }
}
