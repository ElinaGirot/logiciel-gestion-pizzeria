package Model;

public class Livreur {
    private String prenom;
    private String vehicule;
    

    //constructeur
    public Livreur(String pn, String v){
        prenom = pn;
        vehicule = v;
    }


    //methodes
    public String getPrenom(){return prenom;}
    public String getVehicule(){return vehicule;}
}