package controller;
import java.awt.event.*;
import javax.swing.*;
import view.*;

public class NewClient implements ActionListener{
    JButton newC;
    public NewClient(JButton C){
        newC=C;
    }
    public void actionPerformed(ActionEvent e){
        UINewClient nouveau = new UINewClient();
        nouveau.setVisible(true);
    }
}
