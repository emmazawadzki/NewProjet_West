/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import character.CowBoy;
import java.util.Random;
import projetwest.*;
import java.util.Scanner;

/**
 *
 * @author zawae
 */
public class Position {
    public static String position;
    
    
    /**
     * 
     * @param nomPersoPrincipal permet de récupérer le nom de l'utilisateur
     * @return la position de l'utilisateur dans le saloon
     */
    public static int evenementPosition(String nomPersoPrincipal){
        Sleep sleep = new Sleep();
        Random random = new Random();
        int randomCowBoy = random.nextInt(3);
        CowBoy cowboy = CowBoy.ArrayListCowBoy(randomCowBoy);
        
        int randomEvent = random.nextInt(2);
        
        //Element aléatoire:
        //Quelqu'un interpelle le personnage principal pour qu'il le rejoindre
        //Ou
        //Le personnage principal choisi où il souhaite s'asseoir
        if(randomEvent==0){
            int randomPos = random.nextInt(3)+1;
            
            switch(randomPos){
                //Le personnage va rejoindre un cowboy situé à l'entrée
                case 1 :
                    position="à l'entrée";
                    System.out.println("< "+cowboy.GetName()+": Hey "+ nomPersoPrincipal + ", viens te joindre à ma table >");
                    sleep.main(1000);
                    System.out.println("< Vous partez rejoindre "+ cowboy.GetName() +" à sa table qui se situe près de l'entrée du saloon >");
                    sleep.main(1000);
                    break;
                //Le personnage va rejoindre un cowboy situé entre l'entrée et le bar
                case 2 :
                    position="entre l'entrée et le bar";
                    System.out.println("< "+cowboy.GetName()+": Hey "+ nomPersoPrincipal + ", viens te joindre à ma table >");
                    sleep.main(1000);
                    System.out.println(" Vous partez rejoindre "+ cowboy.GetName() +" à sa table qui se situe entre le bar et l'entrée du saloon >");
                    sleep.main(1000);
                    break;
                //Le personnage va rejoindre un cowboy situé au bar
                case 3 :
                    position="au bar";
                    System.out.println("< "+cowboy.GetName()+": Hey "+ nomPersoPrincipal + ", quoi de neuf ? >");
                    sleep.main(1000);
                    System.out.println("< Vous discutez tranquillement avec "+ cowboy.GetName() +" au bar >");
                    sleep.main(1000);
                    break;
            }
            return randomPos;
        }
        else{
            Scanner keyboard=new Scanner (System.in);
            int choix_Pos =0;
            while ((choix_Pos != 1)&& (choix_Pos != 2) && (choix_Pos != 3)) {
                try{
                System.out.println("< Où souhaitez-vous vous asseoir? >");
                sleep.main(1000);
                System.out.println("      " + "Entrée         ?[1]");
                System.out.println("      " + "Table centrale ?[2]");
                System.out.println("      " + "Bar            ?[3]");
                choix_Pos = keyboard.nextInt();
                }
                catch(NumberFormatException e){
                    System.out.println("Erreur vous ne pouvez pas aller là...");
                }  
            }
            switch(choix_Pos){
                case 1 :
                    position="à l'entrée";
                    System.out.println("< Vous partez vous installez à une table près de l'entrée >");
                    sleep.main(1000);
                    break;
                case 2 :
                    position="entre l'entrée et le bar";
                    System.out.println("< Vous partez vous installez à une table située au centre du saloon >");
                    sleep.main(1000);
                    break;
                case 3 :
                    position="au bar";
                    System.out.println("< Vous choisissez une chaise pour vous installez au bar >");
                    sleep.main(1000);
                    break;
            }
            
            return choix_Pos;
        }
    
    }
}

