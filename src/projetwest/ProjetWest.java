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
        boolean Game1 =true;
        while(Game1==true){
            Partie(Game1);
        }
    }
    
    public static boolean Partie(boolean Game){
        while(Game==true){
        System.out.println("Nouvelle partie");
        
        //Création de la date de départ
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String stringDate= format.format(date); 
        
        //Monnaie du jeu
        int solde=10000;
        
        Scanner keyboard=new Scanner (System.in);
        String nom="";
        String boissonF="";
        
        CowBoy[] persoPrincipal=new CowBoy[1];
    
        System.out.println("Avant de commencer, quelle est votre nom :");
        nom=keyboard.nextLine();
        System.out.println("Et quelle est votre boisson favorite :");
        boissonF=keyboard.nextLine();
        
        persoPrincipal[0]=new CowBoy(nom,boissonF);
        
        System.out.println("Début de la partie :");
        while(solde>=0){
            //Affichage de la date
            date=cal.getTime();
            stringDate= format.format(date); 
            System.out.println("Aujourd'hui, nous sommes le " + stringDate);
            
            //Affichage du salde actuelle
            System.out.println("Votre solde est de : " + solde);
        
            System.out.println("Vous venez d'entrer dans un saloon");
            System.out.println("et allez jusqu'au Barman pour commander une boisson.");
            solde-=5000;
            
            // Ajout de 1 jour à la date pour la prochaine partie
            cal.add(Calendar.DATE,1);
        }
        System.out.println("Game Over");
        Game=false;
        }
        Scanner keyboard=new Scanner (System.in);
        String nouvellePartie="";
        System.out.println("Do you want to play again (O/N):");
        nouvellePartie=keyboard.nextLine();
        System.out.println(nouvellePartie);
        System.out.println("Fin de la partie");
        Game=false;
        if(nouvellePartie.equals("O") ){
            Game=true;
        }
        else if(nouvellePartie.equals("N")){
            Game=false;
        }
        else{
            //A Modifier
            System.out.println("Erreur");
            Game=false;
        }
        return Game;
    }
 }
