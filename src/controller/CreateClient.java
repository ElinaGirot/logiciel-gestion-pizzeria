package controller;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import view.*;

public class CreateClient implements ActionListener{
    JTextField num;
    JButton ok;
    JComboBox<String> pizzeria;
    UINewClient ui;
    public CreateClient(JTextField n, JButton o, JComboBox<String> p,UINewClient u){
        num=n;
        ok=o;
        pizzeria=p;
        ui=u;
    }
    public void actionPerformed(ActionEvent e) {
        Pizzeria pizzeriaSelectionne=MainProg.listPizzerias.get(pizzeria.getSelectedIndex());
        pizzeriaSelectionne.addClient(new Client(num.getText()));
        ui.setVisible(false);
        ui.update();
    }
}
