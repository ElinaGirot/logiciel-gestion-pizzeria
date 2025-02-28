package controller;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import view.*;
import java.util.*;

public class ValidationNum implements ActionListener{
    JComboBox<String> pizzeriaComboBox;
    Vector <Pizzeria> pizzeriaVector;
    JTextField text;
    UINum ui;
    
    public ValidationNum(JTextField t,JComboBox<String> p,Vector <Pizzeria> vp,UINum u){
        text=t;
        pizzeriaComboBox = p;
        pizzeriaVector=vp;
        ui=u;
    }

    public void actionPerformed(ActionEvent e){
        String numTel=text.getText();
        Pizzeria pizzeriaSelectionne=pizzeriaVector.get(pizzeriaComboBox.getSelectedIndex());
        if (pizzeriaSelectionne.searchClient(numTel)==null){
            JFrame frame=new JFrame();
            JLabel nop = new JLabel("Cet utilisateur n'existe pas, vérifiez vos informations de connexion ou veuillez créer un compte");
            nop.setHorizontalAlignment(JLabel.CENTER);
            frame.add(nop);
            frame.setSize(650, 100);
            frame.setVisible(true);
        }
        else{
            ui.dispose();

            UICom model = new UICom(pizzeriaSelectionne,pizzeriaSelectionne.searchClient(numTel));
            model.setVisible(true);
            //doit ouvrir la page suivante avec en paramètre le client
        }
    }
}
