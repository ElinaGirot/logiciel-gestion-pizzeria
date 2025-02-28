package controller;
import java.awt.event.*;
import javax.swing.*;
import view.*;

public class MenuChoose implements ActionListener{
    JButton choisir;
    UIComMenu ui2;
    UICom ui;
    JComboBox<String> combo;
    
    Model.Menu menu;

    public MenuChoose(UICom u, JButton c,JComboBox<String> cb,UIComMenu u2) {
        choisir=c;
        ui=u;
        ui2=u2;
        combo=cb;
    }
    public void actionPerformed(ActionEvent e) {
        menu=ui.getPizzeria().getCatalogue().findMenu(combo.getItemAt(combo.getSelectedIndex()));
        UIMenuChoose choose = new UIMenuChoose(ui,menu);
        choose.setVisible(true);
        
    }
}
