package services;

import models.Client;
import models.Compte; 

public interface IService {
      //1-Creer client
      void  addClient(Client client); 
      //2-Lister les Clients
      void showClient();
      //3-Creer un Compte, on lui affecte un client
      void addCompte(Compte compte,Client client);            
      //4-Lister les Comptes
      void showCompte();
      //5-Lister les comptes par Type
      void showCompte(String type);
      //6-Lister les comptes d'un client
      void showCompte(Client client);
      //7-Faire une Operation
      Compte findCompteByNum(int num);
      Client findClientByNum(int num);
           //1-Depot
           //2-Retrait
           //3-Virement
           //4-Consultation
}
