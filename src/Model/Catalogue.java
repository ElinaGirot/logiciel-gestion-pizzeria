package Model;
import java.util.*;


public class Catalogue{
    
    //Attributs
    private Vector<Pizza> listPizza;
    private Vector<Snack> listSnack;
    private Vector<Boisson> listBoisson;
    private Vector<Dessert> listDessert;
    private Vector<Menu> listMenu;
    private Date dateMAJ;

    //Constructeur
    public Catalogue(){
        listPizza = new Vector<Pizza>(0,1);
        listSnack = new Vector<Snack>(0,1);
        listBoisson = new Vector<Boisson>(0,1);
        listDessert = new Vector<Dessert>(0,1);
        listMenu = new Vector<Menu>(0,1);
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        dateMAJ=date;
    }

    //Getteur methodes
    public Vector<Pizza> getPizza() {return listPizza;}
    public Vector<Dessert> getDessert() {return listDessert;}
    public Vector<Boisson> getBoisson() {return listBoisson;}
    public Vector<Snack> getSnack() {return listSnack;}
    public Vector<Menu> getMenu() {return listMenu;}
    public Date getDateMaj(){return dateMAJ;}

    //Methodes
    private void majDate(){
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        dateMAJ=date;
    }
    
    public void add(Pizza pizza){
        listPizza.add(pizza);
        majDate();
    }

    public void add(Dessert d){
        listDessert.add(d);
        majDate();
    }

    public void add(Boisson b){
        listBoisson.add(b);
        majDate();
    }

    public void add(Snack s){
        listSnack.add(s);
        majDate();
    }
    public void add(Menu m){
        listMenu.add(m);
        majDate();
    }

    public void viewPizza(){
        System.out.println("\nNos pizzas : ");
        for (int i=0;i<(listPizza.capacity())-1;i++){   
            System.out.print("/"+listPizza.get(i).getNom());
        }
        System.out.println("/"+listPizza.get(listPizza.capacity()-1).getNom()+"\n");
    }
    public void viewDessert(){
        System.out.println("\nNos desserts : ");
        for (int i=0;i<(listDessert.capacity())-1;i++){
            System.out.print("/"+listDessert.get(i).getNom());
        }
        System.out.println("/"+listDessert.get(listDessert.capacity()-1).getNom()+"\n");
    }
    public void viewBoisson(){
        System.out.println("\nNos boissons : ");
        for (int i=0;i<(listBoisson.capacity())-1;i++){
            System.out.print("/"+listBoisson.get(i).getNom());
        }
        System.out.println("/"+listBoisson.get(listBoisson.capacity()-1).getNom()+"\n");
    }

    public void viewSnack(){
        System.out.println("\nNos snacks : ");
        for (int i=0;i<(listSnack.capacity())-1;i++){
            System.out.print("/"+listSnack.get(i).getNom());
        }
        System.out.println("/"+listSnack.get(listSnack.capacity()-1).getNom()+"\n");
    }
    public void viewMenu(){
        System.out.println("\nNos menus : ");
        for (int i=0;i<(listMenu.capacity())-1;i++){
            System.out.print("/"+listMenu.get(i).getNom());
        }
        System.out.println("/"+listMenu.get(listMenu.capacity()-1).getNom()+"\n");
    }

    public void view(){
        viewMenu();
        viewPizza();
        viewSnack();
        viewBoisson();
        viewDessert();
    }

    public void viewMAJ(){
        System.out.println("La date de mise à jour du catalogue est le "+dateMAJ);
    }
    
    public boolean searchPizza(Produit p){
    	for (int i = 0;i<listPizza.capacity();i++){if (listPizza.get(i)==p) {return true;}}
    	return false;
    }

    public Produit findProduit(String s){
        for (int i=0;i<listPizza.capacity();i++){if (listPizza.get(i).getNom()==s){return listPizza.get(i);}}
        for (int i=0;i<listBoisson.capacity();i++){if (listBoisson.get(i).getNom()==s){return listBoisson.get(i);}}
        for (int i=0;i<listSnack.capacity();i++){if (listSnack.get(i).getNom()==s){return listSnack.get(i);}}
        for (int i=0;i<listDessert.capacity();i++){if (listDessert.get(i).getNom()==s){return listDessert.get(i);}}
        return null;
    }

    public Menu findMenu(String s){
        for (int i = 0;i<listMenu.capacity();i++){
            if (listMenu.get(i).getNom()==s){
                return listMenu.get(i);
            }
        }
        return null;
    }

    public boolean searchBoisson(Produit p){
    	for (int i = 0;i<listBoisson.capacity();i++){if (listBoisson.get(i)==p) {return true;}}
    	return false;
    }
    public boolean searchDessert(Produit p){
    	for (int i = 0;i<listDessert.capacity();i++){if (listDessert.get(i)==p) {return true;}}
    	return false;
    }
    public boolean searchSnack(Produit p){
    	for (int i = 0;i<listSnack.capacity();i++){if (listSnack.get(i)==p) {return true;}}
    	return false;
    }
}

