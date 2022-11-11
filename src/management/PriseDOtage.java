/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import character.Brigand;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zawae
 */
public class PriseDOtage {
    //Position du personage principale avant que le brigand arrive
    public static boolean eventPriseDOtage(ArrayList<Brigand> brigandList,String nomPersoPrincipal, int numListBrigand,Money money){
        boolean game=true;
        int position=Position.eventPosition(nomPersoPrincipal);
        Brigand brigand = Brigand.ArrayListBrigand(brigandList,numListBrigand,false);
        String brigandName=brigand.GetName();
        System.out.println("Soudain " + brigandName + " surgit et s’approche d’une femme pour la prendre en otage");
        System.out.println(brigandName + " : Cette femme retrouvera la liberté lorsque j’aurais reçu 2 000 dollars");

        //Situation en fonction de la position du personnage principal
        switch(position){
            //Situation 1: près de l'entrée
            case 1 :
                System.out.println("Vous êtes situé dérière "+brigandName);
                game=SituationPourcentage(brigandList,brigandName,numListBrigand,95,90,99,99,money);
                break;
                
            //Situation 2: entre l'entrée et le bar
            case 2 :
                System.out.println("Vous êtes situé à côté de "+brigandName);
                game=SituationPourcentage(brigandList,brigandName,numListBrigand,75,70,85,85,money);
                break;
            
            //Situation 3: au bar
            case 3 :
                System.out.println("Vous êtes situé devant "+brigandName);
                game=SituationPourcentage(brigandList,brigandName,numListBrigand,20,20,30,30, money);
                break;
        }
        return game;
    }
    
    public static boolean SituationPourcentage(ArrayList<Brigand> brigandList,String brigandName,int numListBrigand, int pourcentage1,int pourcentage2,int pourcentage3,int pourcentage4,Money money){
        boolean game=true;
        Random random = new Random();
        int situation = random.nextInt(4);
        
        //Situation aléaoire du comportement du brigand
        switch(situation){
            //Situation 1: 
            case 0 :
                //Le brigand est agité et son arme pointe vers la foule
                AgiteFoule(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage1, numListBrigand,money);
                break;
                
            //Situation 2:
            case 1 :
                //Le brigand est agité et son arme pointe vers la femme
                AgiteFemme(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage2, numListBrigand,money);
                break;
            
            //Situation 3:
            case 2 :
                //Le brigand est calme et son arme pointe vers la femme
                CalmeFemme(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage3, numListBrigand, money);
                break;
            
            //Situation 4:
            case 3 :
                //Le brigand est calme et son arme pointe vers la foule
                CalmeFoule(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage4, numListBrigand, money);
                break;  
        }
        return game;
    }
    
    public static boolean ChoixIntervention(ArrayList<Brigand> brigandList,int pourcentageIntervention,int numListBrigand,Money money){
        boolean game=true;
        Scanner keyboard=new Scanner (System.in);
        int choix_Intervention =0;
        while ((choix_Intervention != 1)&& (choix_Intervention != 2) && (choix_Intervention != 3)) {
            try{
                System.out.println("Souhaitez-vous intervenir ou payer?");
                System.out.println("      " + "Intervenir       ?[1]");
                System.out.println("      " + "Payer        ?[2]");
                choix_Intervention = keyboard.nextInt();
            }
            catch(NumberFormatException e){
                System.out.println("Il n'y a pas ce choix la ...");
            } 
        }
        switch(choix_Intervention){
                case 1 :
                    game=Intervention(brigandList,pourcentageIntervention,numListBrigand);
                    break;
                    
                case 2 :
                    money.buyDrink(2000);
                    System.out.println("Tu n'est pas intervenu");
                    game=true;
                    break;
        }
        return game;
    }
    
    public static boolean Intervention(ArrayList<Brigand> brigandList,int pourcentageIntervention,int numListBrigand){
        boolean game=true;
        Random random = new Random();
        int pourcentage = random.nextInt(100);
        if (pourcentage < pourcentageIntervention){ 
            Brigand.ArrayListBrigand(brigandList,numListBrigand,true);
            System.out.println("Vous avez tué le brigand");
            game=true;
        }
        else{
            System.out.println("Vous avez perdu");
            game=false;
        }
        return game;
    }
    
    public static void AgiteFoule(String brigandName){
       System.out.println(brigandName + " est agité");
       System.out.println("Son arme pointe vers la foule");
    }
    
    public static void AgiteFemme(String brigandName){
        System.out.println(brigandName + " est agité");
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
