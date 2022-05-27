package models;

public class Client implements IAffiche {
    private int numero;
    private String nom;
    private String prenom;
    private static int nbre;
    public Client() {
        nbre++;
        numero=nbre;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Override
    public void affiche() {
        // TODO Auto-generated method stub
        System.out.println("Numero: " + numero + "Nom : "+ nom + " Prenom: "+ prenom );
    }
}
