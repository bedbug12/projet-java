package models;

public class Cheque extends Compte {
    private  double frais;

    public Cheque() {
        type="Cheque";
    }
    public Cheque(double frais) {
        type="Cheque";
        this.frais=frais;
    }
    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    @Override
    public void depot(double mnt) {
        solde-=solde +mnt -frais;
    }

    @Override
    public void affiche() {
        // TODO Auto-generated method stub
        super.affiche();
        System.out.println("Frais: " + frais);
    }
    
}
