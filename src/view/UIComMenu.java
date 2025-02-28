package view;

import java.awt.*;
import javax.swing.*;
import Model.Pizzeria;
import controller.MenuChoose;
import controller.TestPrix;

import java.util.*;

public class UIComMenu extends JPanel {
    private UICom ui;
    private Pizzeria pizzeria;
    private JComboBox<String> menu;
    private JLabel dateMaj;
    private JLabel prix;
    private JButton choisir;
    private JPanel un;

    public UIComMenu(UICom u) {
        ui = u;
        pizzeria = ui.getPizzeria();

        JLabel info = new JLabel("<html><u>Choisissez le menu :</u></html>");
        info.setHorizontalAlignment(JLabel.CENTER);

        un = new JPanel();

        dateMaj = new JLabel("Dernière mise à jour du catalogue le : "
                + String.format("%1$td-%1$tm-%1$tY", pizzeria.getCatalogue().getDateMaj()));
        dateMaj.setHorizontalAlignment(JLabel.CENTER);

        menu = new JComboBox<String>();
        menu.setPreferredSize(new Dimension(300, 20));
        Vector<Model.Menu> listMenuDispo = pizzeria.getCatalogue().getMenu();
        for (int i = 0; i < listMenuDispo.capacity(); i++) {
            menu.addItem(listMenuDispo.get(i).getNom());
        }

        choisir = new JButton("Choisir");
        Model.Menu menuChoisi = pizzeria.getCatalogue().findMenu(menu.getItemAt(menu.getSelectedIndex()));

        prix = new JLabel("Le prix du menu est à : " + menuChoisi.getPrix() + " euros.");
        prix.setHorizontalAlignment(JLabel.CENTER);

        TestPrix prixTest = new TestPrix(this);
        menu.addActionListener(prixTest);

        this.setLayout(new GridLayout(5, 1, 10, 10));
        un.add(menu);
        this.add(info);
        this.add(un);
        this.add(prix);
        this.add(choisir);
        this.add(dateMaj);
        this.setVisible(true);

        MenuChoose choose = new MenuChoose(ui, choisir, menu, this);
        choisir.addActionListener(choose);
    }

    public void update() {
        Model.Menu menuChoisi = pizzeria.getCatalogue().findMenu(menu.getItemAt(menu.getSelectedIndex()));
        prix.setText("Le prix du menu est à : " + menuChoisi.getPrix() + " euros.");
    }
}
