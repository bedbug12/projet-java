package main;

import java.util.Scanner;

import models.Client;
import services.Service;

public class Main {
 public static void main(String[] args) {
   int choix;
   Service serv = new Service();
   Client client;
   String nom,prenom;

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
                System.out.println("Entrer le nom du client");
                nom=input.nextLine();
                System.out.println("Entrer le prenom du client");
                prenom=input.nextLine();
                client = new Client();
                client.setNom(nom);
                client.setPrenom(prenom);
                serv.addClient(client);

                break;
              case 2:
                serv.showClient();
                break;
            
              default:
                break;
            }

          }while(choix!=8);
            input.close();

  }
}
