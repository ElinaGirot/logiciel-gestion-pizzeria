package controller;

import java.awt.event.*;
import view.*;

public class OpenNum implements ActionListener{
    UICom ui;
    UICompte uic;
    public OpenNum(UICom u,UICompte uc){
        ui=u;
        uic=uc;
    }

    public void actionPerformed(ActionEvent e) {
        UIChangeNum change = new UIChangeNum(ui,uic);
        change.setVisible(true);
    }
}
