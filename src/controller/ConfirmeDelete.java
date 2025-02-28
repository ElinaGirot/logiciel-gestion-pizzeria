package controller;
import java.awt.event.*;
import view.*;

public class ConfirmeDelete implements ActionListener {
    UICom ui;
    UICompte uic;

    public ConfirmeDelete(UICom u,UICompte uc) {
        ui=u;
        uic=uc;
    }
    public void actionPerformed(ActionEvent e) {
        UICompteDelete frame = new UICompteDelete(ui,uic);
        frame.setVisible(true);
    }
}
