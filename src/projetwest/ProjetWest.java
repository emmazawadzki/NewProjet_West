/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetwest;


import java.util.Scanner;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat; 

import management.*;
import character.*;
import drink.*;

/**
 *
 * @author zawae
 */
public class ProjetWest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean game=true;
        
        while(game==true){
        //déclaration des classes    
        Scanner keyboard=new Scanner (System.in);
        
        
        //initialisation du choix de la boisson
        Drink boissonF = new Drink("",10,5000);

    
            
            
        
        //déclaration des variables   
        //Monnaie du jeu
        Money money = new Money();
        money.initialiseMoney(10000);
        
        
        
        Sleep sleep = new Sleep();
        
        
        System.out.println("- - - - Nouvelle partie - - - -");
        
        //Monnaie du jeu
        int solde=10000;
        
        
        
        //Création de 1 Barman
        //Fait dans Barman
        
        //Création de 5 Brigands
        //Fait dans classe Brigand
        
        //Demander nom à l'utilisateur + Boisson Favorite
        System.out.println("Avant de commencer, quelle est votre nom :");
        String nom=keyboard.nextLine();
        System.out.println("Et quelle est votre boisson favorite :");
        boissonF.name = keyboard.nextLine();
        
        //Création personnage principale
        ArrayList<CowBoy> persoPrin = new ArrayList <CowBoy>();
        persoPrin.add( new CowBoy(nom,boissonF.name));
        
        //Création de 3 CowBoy
        //Fait dans classe cowboy
        
        //Début de la partie
        System.out.println("Début de la partie :");
        sleep.main(1000); 
        
        //Création de la date de départ
        Time time = new Time(); //Création de la date de départ
        Date date=time.newTime();
        
        //La partie continue tant que le solde n'est pas négatif
        while(money.getMoney()>=0){
            
            //Affichage de la date
            time.displayTime(date);
            
            //Affichage du solde actuelle
            money.displayMoney(money.getMoney());
        
            //Suite histoire
            System.out.println("Vous venez d'entrer dans un saloon");
            sleep.main(1000); 
            System.out.println("et allez jusqu'au Barman pour commander une boisson.");
            sleep.main(1000); 
            
            //Sert la boisson favorite au perso principal
            int drink_price = Barman.barman.introduction(boissonF, nom);
            money.buyDrink(drink_price);
            money.displayMoney(money.getMoney());
            
            //Position du personage principale avant que le brigand arrive
            Position.eventPosition(persoPrin.get(0).GetName());
            
            
            
            // Ajout de 1 jour à la date pour la prochaine partie
            date=time.addDay();
            
            game=false;
        }
        System.out.println("Game Over");
        String nouvellePartie="";
        System.out.println("Do you want to play again (O/N):");
        nouvellePartie=keyboard.nextLine();
        System.out.println("Fin de la partie");
        
        
        if(nouvellePartie.equals("O") || nouvellePartie.equals("o") ){
            game=true;
        }
        else if(nouvellePartie.equals("N") || nouvellePartie.equals("n")){
            game=false;
        }
        else{
            //A Modifier
            System.out.println("Erreur");
            game=false;
        }
        }
    }
    
 }
