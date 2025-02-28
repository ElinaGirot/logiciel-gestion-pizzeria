package controller;
import java.awt.event.*;
import javax.swing.*;
import view.*;

public class TestPrix implements ActionListener{
    UIComPizza panel1;
    UIComBoisson panel2;
    UIComDessert panel3;
    UIComSnack panel4;
    UIComMenu panel5;
    UIMenuBar panel6;
    JLabel prixLabel;
    
    public TestPrix(UIComPizza p){panel1=p;}
    public TestPrix(UIComBoisson p){panel2=p;}
    public TestPrix(UIComDessert p){panel3=p;}
    public TestPrix(UIComSnack p){panel4=p;}
    public TestPrix(UIComMenu p){panel5=p;}
    public TestPrix(UIMenuBar p){panel6=p;}

    public void actionPerformed(ActionEvent e){
        if (panel1!=null){panel1.update();}
        else if (panel2!=null){panel2.update();}
        else if (panel3!=null){panel3.update();}
        else if (panel4!=null){panel4.update();}
        else if (panel5!=null){panel5.update();}
        else if (panel6!=null){panel6.update();}
    }
}
