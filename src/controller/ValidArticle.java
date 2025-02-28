package controller;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import view.*;
import java.util.*;

public class ValidArticle implements ActionListener{
    UICom ui;
    Produit produit;
    String taille;
    int quantite;
    JComboBox<String> jComboBoxProduit;
    JComboBox<String> jComboBoxTaille;
    JTextField jTextFieldQuantite;

    //Pour les supplements (que pour les pizzas)
    int nbSupplements;
    Vector<JComboBox<String>> supplements;

    public ValidArticle(UICom u,JComboBox<String> nomP,JComboBox<String> t,JTextField q){
        ui=u;
        jComboBoxProduit=nomP;
        jComboBoxTaille=t;
        jTextFieldQuantite=q;
        nbSupplements=0;     
    }
    public ValidArticle(UICom u,JComboBox<String> nomP,JComboBox<String> t,JTextField q,int nbSup,Vector<JComboBox<String>> sup){
        ui=u;
        jComboBoxProduit=nomP;
        jComboBoxTaille=t;
        jTextFieldQuantite=q; 
        nbSupplements=nbSup;
        supplements=sup;    
    }

    public void actionPerformed(ActionEvent e){
        JFrame frame =new JFrame();;
        JLabel ok;
        quantite = Integer.valueOf(jTextFieldQuantite.getText());
        taille=jComboBoxTaille.getItemAt(jComboBoxTaille.getSelectedIndex());
        produit = ui.getPizzeria().getCatalogue().findProduit(jComboBoxProduit.getItemAt(jComboBoxProduit.getSelectedIndex()));

        if (nbSupplements==0){
            
            ok = new JLabel("Vous avez ajouté "+quantite+" "+produit.getNom()+" dans votre panier.");
            ui.addArticle(new LigneCom(produit,quantite, taille));
        }
        else{
            ok = new JLabel("Vous avez ajouté "+quantite+" "+produit.getNom()+" avec "+ nbSupplements +" suppléments dans votre panier.");

            Vector<String> vectorSupplements = new Vector<String>(0,1);
            for (int i = 0; i < nbSupplements; i++){
                vectorSupplements.add(supplements.get(i).getItemAt(supplements.get(i).getSelectedIndex()));
            }

            ui.addArticle(new LigneCom(produit,quantite, taille,vectorSupplements));
        }

        ok.setHorizontalAlignment(JLabel.CENTER);


        frame.add(ok);
        frame.setSize(650, 100);
        frame.setVisible(true);

        ui.getUIComMenu().update();
        ui.update();
    }

}
