/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;
import drink.*;

import projetwest.*;
import management.*;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.lang.Thread;
import java.lang.NumberFormatException;

/**
 *
 * @author zawae
 */
public class Barman extends Humain{
    
    public static final Barman barman = new Barman("Bob");
    
    
    public Barman(String name){
        super(name);
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
    public void serveDrink(String name,String choix_boisson, String nomPersoP){
        System.out.println(name +": Voici votre " + choix_boisson + " " + nomPersoP);
    }
    
//    public void serveDrink(String name,String boissonFavoriteP, String nameP){
//        System.out.println(name +": Voici votre " + boissonFavoriteP + " " + nameP);
//    }
    
    
    public int introduction(Drink boissonF, String nomPersoP){
        Scanner keyboard=new Scanner (System.in);   
        int choix_type_boisson =0;
        //String choix_boisson = "";
        int c_boisson = 0;

        Drink choix_boisson = new Drink ("",1,1); 
     
            while((choix_type_boisson != 1)  && (choix_type_boisson != 2) && (choix_type_boisson != 3)){
                try{
            System.out.println("Bonjour ! Que puis-je vous servir ?");
            System.out.println("      "+"Boisson alcolisee  ? [1]");
            System.out.println("      "+"Boisson soft       ? [2]");
            System.out.println("      "+"Boisson favorite   ? [3]");  
            choix_type_boisson = Integer.parseInt(keyboard.nextLine());
            if ((choix_type_boisson != 1 ) && (choix_type_boisson != 2) && (choix_type_boisson != 3)){
            System.out.println("Nous n'avons pas ça en stock désolé...");
            }
            } catch(NumberFormatException e){
            System.out.println("Nous n'avons pas ça en stock désolé...");
            }
            }
            
            switch(choix_type_boisson){
                case 1 :            
                    while((c_boisson != 1 ) && (c_boisson != 2) && (c_boisson != 3)){
                    try{
                    System.out.println("Quel alcool voulez-vous ?");
                    System.out.println("      "+"Biere  ? [1]");
                    System.out.println("      "+"Vin    ? [2]");
                    System.out.println("      "+"Whisky ? [3]");
                    c_boisson = Integer.parseInt(keyboard.nextLine());
                    if ((c_boisson != 1 ) && (c_boisson != 2) && (c_boisson != 3)){
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                    }
                    } catch(NumberFormatException e){
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                    }
        }
                    switch (c_boisson){
                        case 1 :
                            choix_boisson = AlcoholDrink.Biere ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoP);
                            return choix_boisson.getPrice();
                        case 2 :
                            choix_boisson = AlcoholDrink.Vin ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoP);
                            return choix_boisson.getPrice();
                        case 3 :
                            choix_boisson = AlcoholDrink.Whisky ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoP);
                            return choix_boisson.getPrice();
                    }
                break;
                case 2 :
                    
                    while((c_boisson != 1 ) && (c_boisson != 2)){
                        try{
                            System.out.println("Quel soft voulez-vous ?");
                            System.out.println("      "+"Eau  ?      [1]");
                            System.out.println("      "+"Coca-Cola ? [2]");
                            c_boisson = Integer.parseInt(keyboard.nextLine());
                            if ((c_boisson != 1 ) && (c_boisson != 2)){
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                        }
                        } catch(NumberFormatException e){
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                    }
                    

                    }
                    switch (c_boisson){
                        case 1 :
                            choix_boisson = SoftDrink.Eau ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoP);
                            return choix_boisson.getPrice();
                        case 2 :
                            choix_boisson = SoftDrink.Coca ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoP);
                            return choix_boisson.getPrice();
                    }
                    
                break;
                case 3 :
                    serveDrink(barman.GetName(),boissonF.name, nomPersoP);
                    return boissonF.getPrice();
            }
            return 0;       
         
    }

}