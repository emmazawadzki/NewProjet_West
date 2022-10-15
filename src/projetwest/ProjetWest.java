/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetwest;

import java.util.Scanner;

/**
 *
 * @author zawae
 */
public class ProjetWest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard=new Scanner (System.in);
        String nom="";
        String boissonF="";
        
        CowBoy[] persoPrincipal=new CowBoy[1];
    
        System.out.println("Avant de commencer, quelle est votre nom :");
        nom=keyboard.nextLine();
        System.out.println("Et quelle est votre boisson favorite :");
        boissonF=keyboard.nextLine();
        
        persoPrincipal[0]=new CowBoy(nom,boissonF);
        
        System.out.println("Vous venez d'entrer dans un saloon");
        System.out.println("et allez jusqu'au Barman pour commander une boisson.");
    }
    
}
