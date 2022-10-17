/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetwest;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zawae
 */
public class GestionEvent {
    public static void main(String[] args) {       //Génère un évènement aléatoire de prob 0.5  
        Random random = new Random();
        int randomEvent = random.nextInt(2);
        if (randomEvent == 0) {
            //event1();
        } else {
            //event2();
        }
    }
    
    public static void eventBarman(){
        System.out.println("event1");
    }
    
    
    public static void eventBandit(){
        System.out.println("Soudain un bandit arrive...");
        System.out.println("Décidez-vous de sortir votre revolver de votre étui ? [O/N]");
        
        Scanner keyboard=new Scanner (System.in);
        String tirRevolver = keyboard.nextLine();
        
        if(tirRevolver.equals("O")){
            eventTir();       
        }
        
        else if(tirRevolver.equals("N")){
            
        }    
    }
    
    public static void eventTir(){
        Random random = new Random();
        int randomEvent = random.nextInt(3);        
        if (randomEvent == 0 || randomEvent == 1) {
            System.out.println("BAAAAANNNGGGG...Vous avez tué le brigand");
        } else {
            System.out.println("Mince...Loupé, le brigand s'enfui...");
        }
    }  

}
