package view;
import java.awt.*;
import javax.swing.*;
import Model.*;
import controller.*;
import java.util.*;

public class UIMenuChoose extends JFrame{
    private UICom ui;
    private JLabel label;
    private JButton valider;
    private Vector<JLabel> labelChoose;
    private Vector<JComboBox<String>> articles;
    private Vector<JPanel> afficheArticle;
    private Model.Menu menu;
    public UIMenuChoose(UICom u ,Model.Menu m){
        menu=m;
        ui=u;
        afficheArticle = new Vector<JPanel>(0);
        articles = new Vector<JComboBox<String>>(0);
        labelChoose= new Vector<JLabel>(0);
        label = new JLabel(" Choisissez vos articles ");

        Vector<Pizza> listPizzasDispo=ui.getPizzeria().getCatalogue().getPizza();
        Vector<Boisson> listBoissonDispo=ui.getPizzeria().getCatalogue().getBoisson();
        Vector<Dessert> listDessertDispo=ui.getPizzeria().getCatalogue().getDessert();
        Vector<Snack> listSnackDispo=ui.getPizzeria().getCatalogue().getSnack();

        this.add(label);
        for (int i=0;i<menu.getNbArticle();i++){
            if(menu.getSetup().get(i)instanceof Pizza){
                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new GridLayout(1,2));
                JLabel temp1 = new JLabel(" Choisissez une pizza ");
                labelChoose.add(temp1);
                JComboBox<String> temp2 = new JComboBox<String>();
                for (int j=0;j<listPizzasDispo.capacity();j++){
                    temp2.addItem(listPizzasDispo.get(j).getNom());
                }
                articles.add(temp2);
                tempPanel.add(labelChoose.get(i));
                tempPanel.add(articles.get(i));
                afficheArticle.add(tempPanel);
                this.add(tempPanel);
            }
            else if(menu.getSetup().get(i)instanceof Boisson){
                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new GridLayout(1,2));
                JLabel temp1 = new JLabel(" Choisissez une boisson ");
                labelChoose.add(temp1);
                JComboBox<String> temp2 = new JComboBox<String>();
                for (int j =0;j<listBoissonDispo.capacity();j++){
                    temp2.addItem(listBoissonDispo.get(j).getNom());
                }
                articles.add(temp2);
                tempPanel.add(labelChoose.get(i));
                tempPanel.add(articles.get(i));
                this.add(tempPanel);
            }
            else if(menu.getSetup().get(i)instanceof Snack){
                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new GridLayout(1,2));
                JLabel temp1 = new JLabel(" Choisissez un snack ");
                labelChoose.add(temp1);
                JComboBox<String> temp2 = new JComboBox<String>();
                for (int j =0;j<listSnackDispo.capacity();j++){
                    temp2.addItem(listSnackDispo.get(j).getNom());
                }
                articles.add(temp2);
                tempPanel.add(labelChoose.get(i));
                tempPanel.add(articles.get(i));
                this.add(tempPanel);
            }
            else{
                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new GridLayout(1,2));
                JLabel temp1 = new JLabel(" Choisissez un Dessert ");
                labelChoose.add(temp1);
                JComboBox<String> temp2 = new JComboBox<String>();
                for (int j =0;j<listDessertDispo.capacity();j++){
                    temp2.addItem(listDessertDispo.get(j).getNom());
                }
                articles.add(temp2);
                tempPanel.add(labelChoose.get(i));
                tempPanel.add(articles.get(i));
                this.add(tempPanel);
            }       
        }
        valider = new JButton( "Valider");
        ValidMenu ok = new ValidMenu(ui,this,menu,articles,valider);
        valider.addActionListener(ok);
        this.add(valider);
        this.setLayout(new GridLayout(menu.getNbArticle()+2,1));
        this.pack();
		this.setVisible(true);
    }
}
