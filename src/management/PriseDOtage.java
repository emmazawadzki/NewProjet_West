/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import character.Brigand;

/**
 *
 * @author zawae
 */
public class PriseDOtage {
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //position doit être récupérer dans eventPosition()
    public static void eventPriseDOtage(int numListBrigand,String position){
        Brigand brigand = Brigand.ArrayListBrigand(numListBrigand);
        String brigandName=brigand.GetName();
        System.out.println("Soudain " + brigandName + " surgit et s’approche d’une femme pour la prendre en otage");
        System.out.println(brigandName + "Cette femme retrouvera la liberté lorsque j’aurais reçu 2 000 dollars");
        

        
        //Situation 1: près de l'entrée
        if(position=="à l'entrée"){
            System.out.println("Vous êtes situé dérière "+brigandName);
        }
        
        //Situation 2: entre l'entrée et le bar
        else if(position=="entre l'entrée et le bar"){
            System.out.println("Vous êtes situé à côté de "+brigandName);
        }
        
        //Situation 3: au bar
        else{
            System.out.println("Vous êtes situé devant "+brigandName);
        }
        
    }
    
    public static void AgiteeFoule(String brigandName){
        System.out.println(brigandName + " est agitée");
        System.out.println("Son arme pointe vers la foule");
    }
    
    public static void AgiteeFemme(String brigandName){
        System.out.println(brigandName + " est agitée");
        System.out.println("Son arme pointe vers la femme");
    }
    public static void CalmeFemme(String brigandName){
        System.out.println(brigandName + " est calme");
        System.out.println("Son arme pointe vers la femme");
    }
    
    public static void CalmeFoule(String brigandName){
        System.out.println(brigandName + " est calme");
        System.out.println("Son arme pointe vers la foule");
    }
}
