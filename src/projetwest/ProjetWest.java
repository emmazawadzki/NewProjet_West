/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetwest;


import java.util.Scanner;
import java.util.ArrayList;

import java.util.Date;

import management.*;
import character.*;
import drink.*;

/**
 *
 * @author zawae
 */
///
public class ProjetWest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //La variable game correspond à l'état de la partie
        //Si game=true, la partie est toujours en cours sinon, la partie est fini
        boolean game=true;
        
        boolean partieGagnee=false;
        
        while(game==true){
        //déclaration des classes    
        Scanner keyboard=new Scanner (System.in);
        
        
        //initialisation du choix de la boisson
        Drink boissonF = new Drink("",10,10);

    
            
            
        
        //déclaration des variables   
        //Monnaie du jeu
        Money money = new Money();
        money.initialiseMoney(10000);
        
        
        
        Sleep sleep = new Sleep();
        
        Armurerie armurerie = new Armurerie();
        
        
        System.out.println("- - - - Nouvelle partie - - - -");
        
        
        
        //Création de 1 Barman
        //Fait dans Barman
        
        //Création de 5 Brigands
        ArrayList<Brigand> brigandList = new ArrayList <Brigand>();
        brigandList.add( new Brigand("Joe",false));
        brigandList.add( new Brigand("Averell",false));
        brigandList.add( new Brigand("Jack",false));
        brigandList.add( new Brigand("William",false));
        brigandList.add( new Brigand("Rantanplan",false));
        
        //Demander nom à l'utilisateur + Boisson Favorite
        System.out.println("Avant de commencer, quelle est votre nom :");
        String nom=keyboard.nextLine();
        System.out.println("Et quelle est votre boisson favorite :");
        boissonF.name = keyboard.nextLine();
        
        //Création personnage principale
        ArrayList<CowBoy> persoPrin = new ArrayList<CowBoy>();
        persoPrin.add( new CowBoy(nom,boissonF.name,5));
                
        //Création de 3 CowBoy
        //Fait dans classe cowboy
        
        //Début de la partie
        System.out.println("Début de la partie :");
        sleep.main(1000); 
        
        //Création de la date de départ
        Time time = new Time(); //Création de la date de départ
        Date date=time.newTime();
        int nbDeJour=0;
        
        int i=0;
        
        //La partie continue tant que le solde n'est pas négatif
        while(money.getMoney()>=0 && i<5 && game==true){
            
            //Affichage de la date
            time.displayTime(date);
            
            //Affichage du solde actuelle
            money.displayMoney(money.getMoney());
        
            //Suite histoire
            System.out.println("< Vous venez d'entrer dans un saloon >");
            sleep.main(1000); 
            System.out.println("< et allez jusqu'au Barman pour commander une boisson. >");
            sleep.main(1000); 
            
            //Sert la boisson favorite au perso principal
            int drink_price = Barman.barman.introduction(boissonF, nom);
            money.buyDrink(drink_price);
            money.displayMoney(money.getMoney());
            
            if(money.getMoney()>=0){
                if(i<5){
                    //Position du personage principale avant que le brigand arrive
                    game=PriseDOtage.evenementPriseDOtage(brigandList,persoPrin,i,money);
                    if(Brigand.arrayListBrigand(brigandList,i,false).getEstMort()==true){
                        i++;
                    }
                    if(i==4){
                        partieGagnee=true;
                    }
                }   
            }
            
            if(game==true){
            if(persoPrin.get(0).nb_balles == 0 && money.getMoney()>=0){//0 balles, il faut passer à l'armurerie
                sleep.main(1000);
                System.out.println("< Vous n'avez-plus de munitions, rendez-vous à l'armurerie... >");
                armurerie.acheterMunitions(persoPrin, money);
            }
            
            else if (persoPrin.get(0).nb_balles > 0 && game==true && money.getMoney()>=0){//Voulez-vous aller à l'armurerie ?
                String answer ="";
                while((answer.equals("O") != true) && (answer.equals("o") != true)&& (answer.equals("N") != true)&& (answer.equals("n") != true)){
                    sleep.main(1000);
                    System.out.println("< Voulez-vous passez à l'armurerie faire le plein de munitions ? (O/N): >");  
                    answer=keyboard.nextLine();
                    if(answer.equals("O") || answer.equals("o") ){
                        armurerie.acheterMunitions(persoPrin, money);
                    }
                    else if(answer.equals("N") || answer.equals("n")){
                        break ;
                    }
                    else{
                        //A Modifier
                        System.out.println("Erreur...");
                    } 
                }
            }
            }
            if(money.getMoney()<=0){
                System.out.println("< Vous êtes ruiné malheuresement...> ");
            }
            
            
            if(i==5){
                partieGagnee = true;
            }
            
            // Ajout de 1 jour à la date pour la prochaine partie
            date=time.addDay();
            nbDeJour+=1;
            
        }
        
        game=false;
        
        if (partieGagnee==false){
            System.out.println("< Vous avez perdu >");
        }
        else{
            System.out.println("< Bravo !!! >");
            sleep.main(1000);
            System.out.println("< Vous avez tué les 5 brigands en "+nbDeJour+" jours>");
        }
        
        String nouvellePartie="";
        
        System.out.println("- - - - Fin de la partie - - - -");
        
        System.out.println("< Voulez-vous rejouez (O/N): >");
        nouvellePartie=keyboard.nextLine();
        
        
        
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
