package main;

import java.util.Scanner;

import models.Cheque;
import models.Client;
import models.Compte;
import models.Epargne;
import services.Service;

public class Main {
 public static void main(String[] args) {
   int choix,num,type,choix2;
   double mnt,frais;
   Service serv = new Service();
   Client client;
   double solde;
   String nom,prenom,types;
   Compte compte;

      Scanner input= new Scanner(System.in);
    do{

          
      System.out.println("1-Creer un client");
            System.out.println("2-Lister les clients");
            System.out.println("3-Creer un compte ");
            System.out.println("4-Lister les comptes");
            System.out.println("5-Lister les comptes par type");
            System.out.println("6-Lister les comptes d'un client");
            System.out.println("7-Faire une operation");
            System.out.println("8-Quitter");
            System.out.println("Faite votre choix");
            choix=input.nextInt();
            input.nextLine();
            switch (choix) {
              case 1:
                System.out.println("Entrer le nom du client: ");
                nom=input.nextLine();
                System.out.println("Entrer le prenom du client: ");
                prenom=input.nextLine();
                client = new Client();
                client.setNom(nom);
                client.setPrenom(prenom);
                serv.addClient(client);

                break;

              case 2:
                serv.showClient();

                break;

              case 3:
               /**
                * 1-Saisi des attributs de la classe mère
                * 2-Saisir le type de classe fille à creer
                * 3-saisir les attributs de la  classe fille crée
                * 4-Creer l'objet de la classe fille suivant le type
                * 5-Hydrater l'objet de la classe fille à travers le down casting
                  ou la surchage
                  6-hydratation des attribut de la classe mere
                * 7-appelle au ajout
                * 
                */

                System.out.println("Entrer le solde du client");
                solde=input.nextDouble();
                
                
                do{
                  System.out.println("Entrer le type de compte ");
                  System.out.println("1-Epargne\n 2-Cheque");
                  type=input.nextInt();
                }while(type<1 || type>2);

                if(type==1){
                  compte=new Epargne();//UPCASTING
                  
                }else{
                  System.out.println("Donner les frais");
                  frais=input.nextDouble();
                  compte=new Cheque(frais);//UPCASTING
                  //hydratation de l'objet compte
                  // ((Cheque)compte).setFrais(frais); //DOWNCASTING 

                }
                compte.setSolde(solde);

                // Realisation de l'association ManyToOne entre compte et client
                System.out.println("Donner l'ID du client");
                num=input.nextInt();
                client=serv.findClientByNum(num);
                if(client!=null){
                  serv.addCompte(compte, client);
                }else{
                  System.out.println("Le client n'existe pas");
                }
                

                break;
              
                case 4:
                  serv.showCompte();
                  break;
                
                case 5:
                  System.out.println("Donner le type de compte: ");
                  types=input.nextLine();
                  serv.showCompte(types);

                  break;

                case 6:
                  System.out.println("Donner le numero du client: ");
                  num=input.nextInt();
                  client=serv.findClientByNum(num);
                  if(client!=null){
                    serv.showCompte(client);
                  }else{
                    System.out.println("Le client n'existe pas");
                  }
                  break;
                case 7:
                System.out.println("Entrer le numero de compte: ");
                num=input.nextInt();
                compte = serv.findCompteByNum(num);
                if(compte!=null){
                  System.out.println("1-Depot");
                  System.out.println("2-Retrait");
                  System.out.println("3-Virement");
                  System.out.println("4-Consultation");
                  choix2=input.nextInt();
                  switch (choix2) {
                    case 1:
     
                      System.out.println("Donner le montant: ");
                      mnt=input.nextDouble();
                      compte.depot(mnt);
                      break;

                    case 2:
                      
                      System.out.println("Donner le montant: ");
                      mnt=input.nextDouble();
                      compte.retrait(mnt);
                      break;

                    case 3:
                      
                      System.out.println("Entrer le numero de compte du destinataire: ");
                      num=input.nextInt();
                      Compte cptVir = serv.findCompteByNum(num);
                      System.out.println("Donner le montant: ");
                      mnt=input.nextDouble();
                      compte.virement(mnt, cptVir);
                      break;

                    case 4:
                      compte.consultation();
                      break;
                  
                    default:
                      break;
                  }
                }
                  
                  break;
            
              default:
                break;
            }

          }while(choix!=8);
            input.close();

  }
}
