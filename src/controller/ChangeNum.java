package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;

public class ChangeNum implements ActionListener {
    UICom ui;
    UICompte uic;
    UIChangeNum uicn;
    JTextField num;
    public ChangeNum(UICom u,UICompte uc,UIChangeNum un,JTextField n){
        ui=u;
        uic=uc;
        num=n;
        uicn=un;
    }
    public void actionPerformed(ActionEvent e) {
        String numChoisi = num.getText();
        ui.getClient().setNumTel(numChoisi);
        uic.update();
        uicn.dispose();
    }
}
