/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import java.util.Random;
import projetwest.*;

/**
 *
 * @author zawae
 */
public class Position {
    Random random = new Random();
    int randomEvent = random.nextInt(3);
    
    public int GetName(){
        if(randomEvent==0){
            CowBoy cowboy = CowBoy.COWBOY1;
            System.out.println(cowboy.GetName()+": Hey NOM, viens te joindre à ma table");
            
            System.out.println("Vous partez rejoindre CowBoy[1] à sa table qui se situe près de l'entrée du saloon");
            return randomEvent;
        }
        else if(randomEvent==1){
            CowBoy cowboy = CowBoy.COWBOY2;
            System.out.println(cowboy.GetName()+": Hey NOM, viens te joindre à ma table");
            
            System.out.println("Vous partez rejoindre CowBoy[1] à sa table qui se situe entre le bar et l'entrée du saloon");
            
            return randomEvent;
        }
        else{
            CowBoy cowboy = CowBoy.COWBOY3;
            System.out.println(cowboy.GetName()+": Hey NOM, quoi de neuf ?");

            //Vous discutez tranquillement avec CowBoy[3] 
            System.out.println("Vous discutez tranquillement avec CowBoy[3]");
            return randomEvent;
        }
    
    }
}
