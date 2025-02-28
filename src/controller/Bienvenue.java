package controller;
import java.awt.event.*;
import javax.swing.*;
import view.*;

public class Bienvenue implements ActionListener{
    JButton bienvenueButton;
    UIBienvenue ui;

    public Bienvenue(JButton b,UIBienvenue u){
        bienvenueButton=b;
        ui=u;
    }
    public void actionPerformed(ActionEvent e){
        ui.setEtat(1);
        UINum model2 = new UINum();
		model2.setVisible(true);
	    ui.dispose();
    }
}
