package controller;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import view.*;
import java.util.*;

public class ValidMenu implements ActionListener{
    UICom ui;
    UIMenuChoose umc;
    JLabel label;
    JButton valider;
    Vector<JComboBox<String>> articles;
    Vector<Produit> chooseArticle;
    Model.Menu menu;
    public ValidMenu(UICom u,UIMenuChoose um,Model.Menu m, Vector<JComboBox<String>> a,JButton v){
        ui=u;
        menu=m;
        articles=a;
        valider=v;
        umc=um;
    }
    public void actionPerformed(ActionEvent e){
        JFrame frame=new JFrame();
        JLabel ok = new JLabel(" Vous avez ajouté un menu dans votre panier. ");

        //transformer un vecteur de combobox en vecteur d'articles choisi
        chooseArticle = new Vector<Produit>(0,1);
        for (int i=0; i<menu.getNbArticle();i++){
            Produit produitTemp = ui.getPizzeria().getCatalogue().findProduit(articles.get(i).getItemAt(articles.get(i).getSelectedIndex()));
            chooseArticle.add(produitTemp);
        }

        ui.addMenuCom(new MenuCom(menu));
        ui.setChooseLastMenu(chooseArticle);
        ok.setHorizontalAlignment(JLabel.CENTER);
        frame.add(ok);
        frame.setSize(650, 100);
        frame.setVisible(true);
        umc.dispose();

    }
}
