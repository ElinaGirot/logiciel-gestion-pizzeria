package view;

import Model.*;
import java.util.*;

public class MainProg {

    public static boolean deb;
    public static Vector<Pizza> listPizza;
    public static Catalogue carte;
    public static Vector<Pizzeria> listPizzerias;

    public static void main(String[] args) {
        System.out.println("Debut du programme");

        carte = new Catalogue();

        Vector<String> ingre = new Vector<String>();
        ingre.add("tomate");
        ingre.add("mozzarella");
        ingre.add("basilic");
        Pizza Margherita = new Pizza("Margherita", 11.5, ingre);

        Vector<String> ingre1 = new Vector<String>();
        ingre1.add("jambon");
        ingre1.add("champignon");
        ingre1.add("oignon");
        Pizza Regina = new Pizza("Regina", 11.5, ingre1);

        Vector<String> ingre2 = new Vector<String>();
        ingre2.add("mozzarella");
        ingre2.add("comté");
        ingre2.add("gorgonzola");
        ingre2.add("chèvre");
        Pizza quatreFromage = new Pizza("4-fromages", 13.5, ingre2);

        Vector<String> ingre3 = new Vector<String>();
        ingre3.add("jambon");
        ingre3.add("artichaut");
        ingre3.add("olives noires");
        Pizza quatreSaisons = new Pizza("4-saisons", 12.5, ingre3);

        Vector<String> ingre4 = new Vector<String>();
        ingre4.add("pepperoni");
        ingre4.add("fromage");
        ingre4.add("olives");
        Pizza Pepperoni = new Pizza("Pepperoni", 11.5, ingre4);

        Vector<String> ingre5 = new Vector<String>();
        ingre5.add("boeuf");
        ingre5.add("tomate");
        ingre5.add("mozzarella");
        Pizza Bolognaise = new Pizza("Bolognaise", 12, ingre5);

        Vector<String> ingre6 = new Vector<String>();
        ingre6.add("feuille d'or");
        ingre6.add("caviar");
        ingre6.add("truffe");
        ingre6.add("boeuf de kobe");
        Pizza Richesse = new Pizza("Richesse", 30, ingre6);

        Vector<String> ingre7 = new Vector<String>();
        ingre7.add("reblochon");
        ingre7.add("lardons");
        ingre7.add("oignons");
        ingre7.add("patates");
        Pizza Savoyarde = new Pizza("Savoyarde", 14, ingre7);

        Vector<String> ingre8 = new Vector<String>();
        ingre8.add("Sauce barbecue");
        ingre8.add("mozzarella");
        ingre8.add("poulet");
        ingre8.add("merguez");
        ingre8.add("oeuf");
        Pizza Cannibale = new Pizza("Cannibale", 15, ingre8);

        Vector<String> ingre9 = new Vector<String>();
        ingre9.add("poivrons");
        ingre9.add("courgettes");
        ingre9.add("aubergines");
        Pizza Veggie = new Pizza("Veggie", 12.5, ingre9);

        carte.add(quatreSaisons);
        carte.add(Pepperoni);
        carte.add(Bolognaise);
        carte.add(Richesse);
        carte.add(Savoyarde);
        carte.add(Cannibale);
        carte.add(Veggie);
        carte.add(Margherita);
        carte.add(Regina);
        carte.add(quatreFromage);

        Boisson CocaCola = new Boisson("Coca-Cola", 1.5);
        Boisson Eau = new Boisson("Eau plate", 1.2);
        Boisson FuzeTea = new Boisson("Fuze Tea", 1.5);
        Boisson Fanta = new Boisson("Fanta", 1.5);
        Boisson sevenUp = new Boisson("7up", 1.3);
        Boisson sevenUpMojito = new Boisson("7up mojito", 1.5);
        Boisson OasisTropical = new Boisson("Oasis Tropical", 1.5);

        carte.add(CocaCola);
        carte.add(Eau);
        carte.add(FuzeTea);
        carte.add(Fanta);
        carte.add(sevenUp);
        carte.add(sevenUpMojito);
        carte.add(OasisTropical);

        Dessert TiramisuFramboise = new Dessert("Tiramisu Framboise", 4);
        Dessert TiramisuChocolat = new Dessert("Tiramisu Chocolat", 3.5);
        Dessert PizzaNutella = new Dessert("Pizza au Nutella", 7);
        Dessert GlacePot = new Dessert("Glace en pot", 5);

        carte.add(TiramisuFramboise);
        carte.add(TiramisuChocolat);
        carte.add(PizzaNutella);
        carte.add(GlacePot);

        Snack Tenders = new Snack("5 Tenders", 7);
        Snack MozzaStick = new Snack("4 Mozza Stick", 5);

        carte.add(Tenders);
        carte.add(MozzaStick);

        // Creation des menu
        Menu menuSolo = new Menu("Menu solo", 2);
        Vector<Produit> m1 = new Vector<Produit>(0, 1);
        m1.add(new Pizza());
        m1.add(new Boisson());
        menuSolo.menuSetup(m1, 11);

        Menu menuDuo = new Menu("Menu duo", 3);
        Vector<Produit> m2 = new Vector<Produit>(0, 1);
        m2.add(new Pizza());
        m2.add(new Pizza());
        m2.add(new Boisson());
        menuDuo.menuSetup(m2, 20);

        Menu menuTrio = new Menu("Menu trio", 4);
        Vector<Produit> m3 = new Vector<Produit>(0, 1);
        m3.add(new Pizza());
        m3.add(new Pizza());
        m3.add(new Pizza());
        m3.add(new Boisson());
        menuTrio.menuSetup(m3, 30);

        // Ajout des menu dans le catalogue
        carte.add(menuSolo);
        carte.add(menuDuo);
        carte.add(menuTrio);

        // Creation d'une liste de pizzeria avec le catalogue
        listPizzerias = new Vector<Pizzeria>(0);
        Pizzeria RaPizz = new Pizzeria("RaPizz Evry", "8 rue du test, 91000 Evry-Courcouronnes", carte);
        Pizzeria RaPizz2 = new Pizzeria("RaPizz Marcoussis", "8 rue du test, 91460 Marcoussis", carte);

        listPizzerias.add(RaPizz);
        listPizzerias.add(RaPizz2);

        // Ajout d'un supplement à ligne de commande et a menuCom(1euros 20 le
        // supplement)
        // ligne1.addSupplement("Bacon");
        // ligne1.addSupplement("Bacon");

        // Creation de 2 livreurs
        Livreur l1 = new Livreur("Jerry", "voiture");
        Livreur l2 = new Livreur("Amandine", "moto");
        Livreur l3 = new Livreur("Elina", "moto");
        Livreur l4 = new Livreur("Bastien", "moto");

        listPizzerias.get(0).addLivreur(l1);
        listPizzerias.get(0).addLivreur(l2);
        listPizzerias.get(0).addLivreur(l3);
        listPizzerias.get(0).addLivreur(l4);

        // Creation d'1 client avec un solde pour tester le programme
        Client client2 = new Client("", 22222);

        RaPizz.addClient(client2);

        // Le client clique sur confirmer la commande
        // test1.addLivreur(l2); //Ajout d'un livreur
        // test1.addLivreur(l1); //Changement de livreur

        //////////////////////////////// Début de l'interface graphique
        //////////////////////////////// //////////////////////////////////////////
        UIBienvenue model = new UIBienvenue();
        model.setVisible(true);
    }
}