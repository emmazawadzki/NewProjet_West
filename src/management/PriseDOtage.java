/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import character.*;
import projetwest.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zawae
 */
public class PriseDOtage {
    //Position du personage principale avant que le brigand arrive
    public static boolean eventPriseDOtage(ArrayList<Brigand> brigandList,String nomPersoPrincipal, int numListBrigand,Money money, ArrayList<CowBoy> cowboyList){
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
                System.out.println("Vous êtes situé derrière "+brigandName);
                game=SituationPourcentage(brigandList,brigandName,numListBrigand,95,90,99,99,money,cowboyList);
                break;
                
            //Situation 2: entre l'entrée et le bar
            case 2 :
                System.out.println("Vous êtes situé à côté de "+brigandName);
                game=SituationPourcentage(brigandList,brigandName,numListBrigand,75,70,85,85,money,cowboyList);
                break;
            
            //Situation 3: au bar
            case 3 :
                System.out.println("Vous êtes situé devant "+brigandName);
                game=SituationPourcentage(brigandList,brigandName,numListBrigand,20,20,30,30, money,cowboyList);
                break;
        }
        return game;
    }
    
    public static boolean SituationPourcentage(ArrayList<Brigand> brigandList,String brigandName,int numListBrigand, int pourcentage1,int pourcentage2,int pourcentage3,int pourcentage4,Money money, ArrayList<CowBoy> cowboyList){
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
                game=ChoixIntervention(brigandList,pourcentage1, numListBrigand,money,cowboyList);
                break;
                
            //Situation 2:
            case 1 :
                //Le brigand est agité et son arme pointe vers la femme
                AgiteFemme(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage2, numListBrigand,money,cowboyList);
                break;
            
            //Situation 3:
            case 2 :
                //Le brigand est calme et son arme pointe vers la femme
                CalmeFemme(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage3, numListBrigand, money,cowboyList);
                break;
            
            //Situation 4:
            case 3 :
                //Le brigand est calme et son arme pointe vers la foule
                CalmeFoule(brigandName);
                //Choix : Intervenir ou pas
                game=ChoixIntervention(brigandList,pourcentage4, numListBrigand, money,cowboyList);
                break;  
        }
        return game;
    }
    
    public static boolean ChoixIntervention(ArrayList<Brigand> brigandList,int pourcentageIntervention,int numListBrigand,Money money,ArrayList<CowBoy> cowboyList){
        boolean game=true;
        Scanner keyboard=new Scanner (System.in);
        int choix_Intervention =0;
        while ((choix_Intervention != 1)&& (choix_Intervention != 2) && (choix_Intervention != 3)) {
            try{
                System.out.println("Souhaitez-vous intervenir ou payer?");
                System.out.println("      " + "Intervenir ?[1]");
                System.out.println("      " + "Payer ?     [2]");
                choix_Intervention = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Il n'y a pas ce choix la ...");
            } 
        }
        switch(choix_Intervention){
                case 1 :
                    //utilisation du choix de nombre de balles utlisées
                    int choix_nb_balles = ChoixNbBalles(cowboyList);
                    //conversion du pourcentageIntervention en type double
                    double pourcentageIntervention_tmp = pourcentageIntervention;
                    pourcentageIntervention_tmp = pourcentageIntervention_tmp/100;
                    //calcul proba en fonction du nombre de balles tirées                    
                    pourcentageIntervention = PriseDOtage.calc_pourcentage_balles(choix_nb_balles, pourcentageIntervention_tmp); 
                    game=Intervention(brigandList,pourcentageIntervention,numListBrigand,cowboyList,choix_nb_balles);
                    break;
                    
                case 2 :
                    money.payRançon(2000);
                    System.out.println("Tu n'est pas intervenu");
                    game=true;
                    break;
        }
        return game;
    }
    
        //Choix du nombre de balles
       public static int ChoixNbBalles(ArrayList<CowBoy> persoPrin){
            Scanner keyboard=new Scanner (System.in);
            int choix_nb_balles=0;
            while((choix_nb_balles == 0) || (choix_nb_balles > persoPrin.get(0).nb_balles) || (persoPrin.get(0).nb_balles<=0)){
                try{
                    System.out.println("Combien de balles souhaites-tu utiliser ? IL TE RESTE "+ persoPrin.get(0).nb_balles +" BALLES" );
                    System.out.println("      "+"1 ?[1]" );
                    System.out.println("      "+"2 ?[2]" );
                    System.out.println("      "+"3 ?[3]" );
                    System.out.println("      "+"4 ?[4]" );
                    choix_nb_balles = Integer.parseInt(keyboard.nextLine());
                    if(choix_nb_balles> persoPrin.get(0).nb_balles){
                        System.out.println("Erreur, vous n'avez pas assez de balles");
                    }
                    else if ( choix_nb_balles <= 0){
                        System.out.println("Erreur veuillez réessayer...");
                    }
                }catch(NumberFormatException e){
            System.out.println("Erreur veuillez réessayer...");
            }   
            }  
            persoPrin.get(0).nb_balles = persoPrin.get(0).nb_balles - choix_nb_balles;
            return choix_nb_balles;
}
    
    public static boolean Intervention(ArrayList<Brigand> brigandList,int pourcentageIntervention,int numListBrigand, ArrayList<CowBoy> cowboyList,int choix_nb_balles){
        boolean game=true;
        Random random = new Random();
        int pourcentage = random.nextInt(100);
         
        if (pourcentage < pourcentageIntervention){
            cowboyList.get(0).tirer(choix_nb_balles, brigandList.get(0), cowboyList.get(0));
            Brigand.ArrayListBrigand(brigandList,numListBrigand,true);
            System.out.println("Vous avez tué le brigand");
            game=true;
        }
        else{//pourcentage > pourcentageIntervention // Partie perdu ?
            System.out.println(brigandList.get(0).name + ": MOUHAHAHA ! Tu es à ma merci, prends-ça...");
            int nb_balles = random.nextInt(3);
            if(brigandList.get(0).etat_arme(nb_balles) == false){
                System.out.println(brigandList.get(0).name + ": Zut ! Plus de munitions...");
                game = true;
                return game;
            } 
            else{
                brigandList.get(0).tirer((nb_balles+1), brigandList.get(0), cowboyList.get(0));
                System.out.println("Vous avez perdu");
                game=false;
                return game;
            }
        }
        return game;
    }
    
    //fonction calcul pourcentage que balles touche cibles
    public static int calc_pourcentage_balles(int choix_nb_balles, double pourcentage){
        double result = pourcentage;
        if(choix_nb_balles != 1){
            double pourcentage_acc;
            double tmp = 1; 
            for(int i = 1; i<= (choix_nb_balles-1);i++){
            pourcentage_acc = (1+(1-(pourcentage*tmp)));
            tmp = tmp*pourcentage_acc;       
        }
            result = pourcentage*tmp;
        }
         return (int)(result*100);
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
