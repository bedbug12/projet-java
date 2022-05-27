package models;

public class Epargne extends Compte {
    public static final double  TAUX=0.18;

    public Epargne(){
        super();//Constructeur de Compte
        type="Epargne";
    }

    @Override //Reecrite ou Redefinie
    public void depot(double mnt) {
          solde+=mnt+ mnt*TAUX;
    }

    @Override
    public void retrait(double mnt) {
        System.out.println("Ce Compte est bloque  ");
    }

    @Override
    public void virement(double mnt, Compte cptVir) {
        System.out.println("Ce Compte est bloque  ");
    }

    @Override
    public void affiche() {
        // TODO Auto-generated method stub
        super.affiche();
        System.out.println("Taux: " + TAUX);
    }
    
}

//Epargne ep=new Epargne()  =>  new Compte()
