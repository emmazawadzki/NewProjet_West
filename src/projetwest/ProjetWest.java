/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetwest;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat; 

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
        System.out.println("- - - - Nouvelle partie - - - -");
        
        //Création de la date de départ
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String stringDate= format.format(date); 
        
        //Monnaie du jeu
        int solde=10000;
        
        //Element pour scanner (nom, boissonFavorite)
        Scanner keyboard=new Scanner (System.in);
        String nom="";
        String boissonF="";
        
        
        //Création de 1 Barman
        //Fait dans Barman
        
        //Création de 5 Brigands
        //Fait dans classe Brigand
        
        //Demander nom à l'utilisateur + Boisson Favorite
        System.out.println("Avant de commencer, quelle est votre nom :");
        nom=keyboard.nextLine();
        System.out.println("Et quelle est votre boisson favorite :");
        boissonF=keyboard.nextLine();
        
        //Création personnage principale
        CowBoy[] persoPrincipal=new CowBoy[1];
        persoPrincipal[0]=new CowBoy(nom,boissonF);
        
        //Création de 3 CowBoy
        //Fait dans classe cowboy
        
        //Début de la partie
        System.out.println("Début de la partie :");
        
        //La partie continue tant que le solde n'est pas négatif
        while(solde>=0){
            //Affichage de la date
            date=cal.getTime();
            stringDate= format.format(date); 
            System.out.println("Aujourd'hui, nous sommes le " + stringDate);
            
            //Affichage du solde actuelle
            System.out.println("Votre solde est de : " + solde);
        
            //Suite histoire
            System.out.println("Vous venez d'entrer dans un saloon");
            System.out.println("et allez jusqu'au Barman pour commander une boisson.");
            
            //Sert la boisson favorite au perso principal
            Barman barman = Barman.BARMAN;
            barman.sert(barman.GetName(),persoPrincipal[0].GetDrink(),persoPrincipal[0].GetName());
            
            solde-=5000;
            
            // Ajout de 1 jour à la date pour la prochaine partie
            cal.add(Calendar.DATE,1);
        
        System.out.println("Game Over");
        game=false;
        }
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
