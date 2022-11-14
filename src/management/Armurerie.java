/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import character.*;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author ferja
 */
public class Armurerie {
    
    Sleep sleep = new Sleep();
    Scanner keyboard = new Scanner (System.in);

    
    public void acheterMunitions(ArrayList<CowBoy> cowboy,Money money){
        System.out.println("< Vendeur : Bonjour ! Bienvenue chez WesternGuns Company >");

        int choix_nb_cartouches=0;
        int prix_cartouche_unite=500;

        
        while((choix_nb_cartouches > 10) || (choix_nb_cartouches <= 0)){
            try{
            System.out.println("< Vendeur : Combien de cartouches avez-vous besoin ? " +" VOUS AVEZ ACTUELLEMENT "+ cowboy.get(0).nb_balles +" MUNITIONS >"); 
            choix_nb_cartouches = Integer.parseInt(keyboard.nextLine());
            if (choix_nb_cartouches > 10 ){
                System.out.println("< Vendeur : Hahaha... >");
                sleep.main(1000);
                System.out.println("< Vendeur : Vous comptez dévaliser l'armurie sérieusement ? >");
                sleep.main(1000);
            }
            else if (choix_nb_cartouches <= 0 ){
                System.out.println("Vendeur : Ne repartez pas les mains vite tonerre de West ! >");
            }
            else {
                System.out.println("< Vendeur : Hop-là tenez ! >");
                sleep.main(1000);
                cowboy.get(0).nb_balles = cowboy.get(0).nb_balles + choix_nb_cartouches;
                money.money =  money.money - (choix_nb_cartouches*prix_cartouche_unite);
                System.out.println("< VOUS AVEZ DESORMAIS "+ cowboy.get(0).nb_balles +" MUNITIONS >");
                sleep.main(1000);
                System.out.println("< Vendeur : A très vite ! >");
                sleep.main(1000);
                System.out.println("< VOTRE SOLDE ACTUELLE EST DE "+ money.money +" € >");
            }
            }catch(NumberFormatException e){
            System.out.println("< Vendeur : Nous n'avons pas ça en stock désolé... >");
            }
  
        }
  
}
    
}