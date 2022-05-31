package main;

import java.util.Scanner;

import models.Cheque;
import models.Client;
import models.Compte;
import models.Epargne;
import services.Service;

public class Main {
 public static void main(String[] args) {
   int choix,num;
   double mnt;
   Service serv = new Service();
   Client client;
   String nom,prenom,type;
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
                System.out.println("1-Compte Epagne");
                System.out.println("2-Compte Cheque");
                choix=input.nextInt();
                if(choix==1){
                  System.out.println("Donner le numero du client: ");
                  num = input.nextInt();
                  client =serv.findClientByNum(num);
                  Compte cptEpargne= new Epargne();
                  serv.addCompte(cptEpargne, client);
                }else{
                  System.out.println("Donner le numero du client: ");
                  num = input.nextInt();
                  client =serv.findClientByNum(num);
                  Compte cptCheque=new Cheque();
                  serv.addCompte(cptCheque, client);
                }
                break;
              
                case 4:
                  serv.showCompte();
                  break;
                
                case 5:
                  System.out.println("Donner le type de compte: ");
                  type=input.nextLine();
                  serv.showCompte(type);

                  break;

                case 6:
                  System.out.println("Donner le numero du client: ");
                  num=input.nextInt();
                  client=serv.findClientByNum(num);
                  serv.showCompte(client);

                  break;
                case 7:
                  System.out.println("1-Depot");
                  System.out.println("2-Retrait");
                  System.out.println("3-Virement");
                  System.out.println("4-Consultation");
                  choix=input.nextInt();
                  switch (choix) {
                    case 1:
                      System.out.println("Entrer le numero de compte: ");
                      num=input.nextInt();
                      compte = serv.findCompteByNum(num);
                      System.out.println("Donner le montant: ");
                      mnt=input.nextDouble();
                      compte.depot(mnt);
                      break;

                    case 2:
                      System.out.println("Entrer le numero de compte: ");
                      num=input.nextInt();
                      compte = serv.findCompteByNum(num);
                      System.out.println("Donner le montant: ");
                      mnt=input.nextDouble();
                      compte.retrait(mnt);
                      break;

                    case 3:
                      System.out.println("Entrer le numero de compte: ");
                      num=input.nextInt();
                      compte = serv.findCompteByNum(num);
                      System.out.println("Entrer le numero de compte du destinataire: ");
                      num=input.nextInt();
                      Compte cptVir = serv.findCompteByNum(num);
                      System.out.println("Donner le montant: ");
                      mnt=input.nextDouble();
                      compte.virement(mnt, cptVir);
                      break;

                    case 4:
                      System.out.println("Entrer le numero de compte: ");
                      num=input.nextInt();
                      compte = serv.findCompteByNum(num);
                      compte.consultation();
                      break;
                  
                    default:
                      break;
                  }
                  break;
            
              default:
                break;
            }

          }while(choix!=8);
            input.close();

  }
}
