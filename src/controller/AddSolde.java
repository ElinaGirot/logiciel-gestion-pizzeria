package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;

public class AddSolde implements ActionListener {
    UICom ui;
    UIAjoutSolde uia;
    UICompte uic;
    JTextField solde;

    public AddSolde(UICom u,UICompte uc,UIAjoutSolde ua,JTextField s) {
        ui=u;
        uic=uc;
        solde = s;
        uia=ua;
    }

    public void actionPerformed(ActionEvent e) {
        double addSolde = Double.parseDouble(solde.getText());
        ui.getClient().addMoney(addSolde);
        uic.update();
        uia.dispose();
    }
}
