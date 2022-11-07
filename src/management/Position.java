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
    
    public static void eventPosition(String nomPersoPrincipal){
        Random random = new Random();
        int randomCowBoy = random.nextInt(3);
        CowBoy cowboy = CowBoy.ArrayListCowBoy(randomCowBoy);
        
        int randomEvent = random.nextInt(2);
        
        //Element aléatoire:
        //Quelqu'un interpelle le personnage principal pour qu'il le rejoindre
        //Ou
        //Le personnage principal choisi où il souhaite s'asseoir
        if(randomEvent==0){
            int randomPos = random.nextInt(3);
            //Le personnage va rejoindre un cowboy situé à l'entrée
            if(randomPos==0){
                position="à l'entrée";
                System.out.println(cowboy.GetName()+": Hey "+ nomPersoPrincipal + ", viens te joindre à ma table");
            
                System.out.println("Vous partez rejoindre "+ cowboy.GetName() +" à sa table qui se situe près de l'entrée du saloon");
            
            }
            //Le personnage va rejoindre un cowboy situé entre l'entrée et le bar
            else if(randomPos==1){
                position="entre l'entrée et le bar";
                System.out.println(cowboy.GetName()+": Hey "+ nomPersoPrincipal + ", viens te joindre à ma table");
            
                System.out.println("Vous partez rejoindre "+ cowboy.GetName() +" à sa table qui se situe entre le bar et l'entrée du saloon");
            }
            //Le personnage va rejoindre un cowboy situé au bar
            else{
                position="au bar";
                System.out.println(cowboy.GetName()+": Hey "+ nomPersoPrincipal + ", quoi de neuf ?");

                //Vous discutez tranquillement avec CowBoy[3] 
                System.out.println("Vous discutez tranquillement avec "+ cowboy.GetName() +" au bar");
            
            }
        }
        else{
            Scanner keyboard=new Scanner (System.in);
            String choix_Pos="";
            while (!choix_Pos.equalsIgnoreCase("Entree") && !choix_Pos.equalsIgnoreCase("Bar")&& !choix_Pos.equalsIgnoreCase("Milieu")) {
                System.out.println("Où souhaitez-vous vous asseoir?");
                System.out.println("      " + "Entree  ?");
                System.out.println("      " + "Bar     ?");
                System.out.println("      " + "Milieu  ?");
                choix_Pos = keyboard.nextLine();
            }
            if (choix_Pos.equalsIgnoreCase("Entree")) {
                position="à l'entrée";
                System.out.println("Vous partez vous installez à une table près de l'entrée");
            }
            else if (choix_Pos.equalsIgnoreCase("Bar")) {
                position="au bar";
                System.out.println("Vous choisissez une chaise pour vous installez au bar");
            } 
            else{
                position="entre l'entrée et le bar";
                System.out.println("Vous partez vous installez à une table situé entre l'entrée et le bar");
            }


        }
    
    }
}

