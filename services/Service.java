package services;

import models.Client;
import models.Compte;

public class Service implements IService {
    private final int N=100;
    private int indexCompte;
    private int indexClient;
    private Compte comptes[]=new Compte[N];
    private Client clients[]=new Client[N];
    @Override
    public void addClient(Client client) {
        // TODO Auto-generated method stub
        if(indexClient<N){
            clients[indexClient]=client;
            indexClient++;
        
        }else{
            System.out.println("Le tableau est plein.");
        }
        
    }

    @Override
    public void addCompte(Compte compte, Client client) {
        // TODO Auto-generated method stub
        if(indexCompte<comptes.length){
            //L'affectation du client au compte
            compte.setClient(client);
            comptes[indexCompte]=compte;
            indexCompte++;
        
        }else{
            System.out.println("Le tableau est plein.");
        }
    }

    @Override
    public Compte findCompteByNum(int num) {
        // TODO Auto-generated method stub
        for(Compte compte:comptes){
            if(compte!=null && compte.getNumero()==num){
                compte.affiche();
            }
        }
        System.out.println("Le compte n'existe pas");
        return null;
    }

    @Override
    public void showClient() {
        // TODO Auto-generated method stub
        for(Client client:clients){
            if(client!=null){
                client.affiche();
            }
        }
        
    }

    @Override
    public void showCompte() {
        // TODO Auto-generated method stub
        for(Compte compte:comptes){
            if(compte!=null){
                compte.affiche();
            }
        }
        
    }

    @Override
    public void showCompte(String type) {
        // TODO Auto-generated method stub
        for(Compte compte:comptes){
            if(compte!=null && compte.getType()==type){
                compte.affiche();
            }
        }
    }

    @Override
    public void showCompte(Client client) {
        // TODO Auto-generated method stub
        for(Compte compte:comptes){
            if(compte!=null && compte.getClient()==client){
                compte.affiche();
            }
        }
    }

    @Override
    public Client findClientByNum(int Num) {
        // TODO Auto-generated method stub
        for(Client client:clients){
            if(client!=null && client.getNumero()==Num){
                return client;
            }
        }
        System.out.println("Le client n'existe pas");
        return null;
    }
    
}
