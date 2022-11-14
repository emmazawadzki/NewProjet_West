/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;
import drink.*;

import management.*;
import java.util.Scanner;


/**
 *
 * @author zawae
 */
public class Barman extends Humain{
    
    public static final Barman barman = new Barman("Bob");
    Sleep sleep = new Sleep();
    
    public Barman(String name){
        super(name);
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
    public void serveDrink(String name,String choix_boisson, String nomPersoP){
        System.out.println("< "+name +" : Voici votre " + choix_boisson + " " + nomPersoP+" >");
    }
    
    
    /**Interaction entre le barman et l'utilisateur pour commander une boisson
     * 
     * @param boissonFavorite permet de récupérer la boison favorite de l'utilisateur
     * @param nomPersoPrincipal permet de récupérer le nom de l'utilisateur
     * @return le prix de la boisson choisi par l'utilisateur
     */
    public int introduction(Drink boissonFavorite, String nomPersoPrincipal){
        Scanner keyboard=new Scanner (System.in);   
        int choix_type_boisson =0;
        //String choix_boisson = "";
        int c_boisson = 0;

        Drink choix_boisson = new Drink ("",1,1); 
     
            while((choix_type_boisson != 1)  && (choix_type_boisson != 2) && (choix_type_boisson != 3)){
                try{
            System.out.println("< Bonjour ! Que puis-je vous servir ? >");
            sleep.main(1000);
            System.out.println("      "+"Boisson alcolisee  ? [1]");
            System.out.println("      "+"Boisson soft       ? [2]");
            System.out.println("      "+"Boisson favorite   ? [3]");  
            choix_type_boisson = Integer.parseInt(keyboard.nextLine());
            if ((choix_type_boisson != 1 ) && (choix_type_boisson != 2) && (choix_type_boisson != 3)){
                sleep.main(1000);
                System.out.println("Nous n'avons pas ça en stock désolé...");
            }
            } catch(NumberFormatException e){
                sleep.main(1000);            
                System.out.println("Nous n'avons pas ça en stock désolé...");
            }
            }
            
            switch(choix_type_boisson){
                case 1 :            
                    while((c_boisson != 1 ) && (c_boisson != 2) && (c_boisson != 3)){
                    try{
                    System.out.println("< Quel alcool voulez-vous ? >");
                    sleep.main(1000);
                    System.out.println("      "+"Biere  ? [1]");
                    System.out.println("      "+"Vin    ? [2]");
                    System.out.println("      "+"Whisky ? [3]");
                    c_boisson = Integer.parseInt(keyboard.nextLine());
                    if ((c_boisson != 1 ) && (c_boisson != 2) && (c_boisson != 3)){
                        sleep.main(1000);
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                    }
                    } catch(NumberFormatException e){
                        sleep.main(1000);
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                    }
        }
                    switch (c_boisson){
                        case 1 :
                            choix_boisson = AlcoholDrink.Biere ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoPrincipal);
                            return choix_boisson.getPrice();
                        case 2 :
                            choix_boisson = AlcoholDrink.Vin ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoPrincipal);
                            return choix_boisson.getPrice();
                        case 3 :
                            choix_boisson = AlcoholDrink.Whisky ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoPrincipal);
                            return choix_boisson.getPrice();
                    }
                break;
                case 2 :
                    
                    while((c_boisson != 1 ) && (c_boisson != 2)){
                        try{
                            System.out.println("< Quel soft voulez-vous ? >");
                            sleep.main(1000);
                            System.out.println("      "+"Eau  ?      [1]");
                            System.out.println("      "+"Coca-Cola ? [2]");
                            c_boisson = Integer.parseInt(keyboard.nextLine());
                            if ((c_boisson != 1 ) && (c_boisson != 2)){
                                sleep.main(1000);                      
                                System.out.println("Nous n'avons pas ça en stock désolé...");
                        }
                        } catch(NumberFormatException e){
                        sleep.main(1000);
                        System.out.println("Nous n'avons pas ça en stock désolé...");
                    }
                    

                    }
                    switch (c_boisson){
                        case 1 :
                            choix_boisson = SoftDrink.Eau ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoPrincipal);
                            return choix_boisson.getPrice();
                        case 2 :
                            choix_boisson = SoftDrink.Coca ;
                            serveDrink(barman.GetName(),choix_boisson.name, nomPersoPrincipal);
                            return choix_boisson.getPrice();
                    }
                    
                break;
                case 3 :
                    serveDrink(barman.GetName(),boissonFavorite.name, nomPersoPrincipal);
                    return boissonFavorite.getPrice();
            }
            return 0;       
         
    }

}