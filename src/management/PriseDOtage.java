/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import character.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zawae
 */
public class PriseDOtage {
    
    /**En fonction de la position actuelle de l'utilisateur récupéré dans la classe Position,
     * 3 situations peuvent se produire, l'utilisateur peut se trouver : 
     *   derrière le brigand s'il est près de l'entrée;
     *   à côté du brigand s'il se situe entre l'entrée et le bar; 
     *   devant le brigand s'il se situe au bar.
     * 
     * @param brigandList permet de récupérer les informations des Brigands
     * @param persoPrincipal permet de récupérer les informations de l'utilisateur
     * @param numListBrigand permet de savoir de quel brigand on souhaite récupérer les informations
     * @param money permet de gérer l'argent de l'utilisateur
     * @return permet de retourner l'état actuel de la partie (si game=true la partie continue)
     */
    public static boolean evenementPriseDOtage(ArrayList<Brigand> brigandList, ArrayList<CowBoy> persoPrincipal, int numListBrigand, Money money){
        boolean game=true;
        Sleep sleep = new Sleep();
        
        //Récupération de la position de l'utilisateur
        int position=Position.evenementPosition(persoPrincipal.get(0).getName());
        
        //Information sur brigand
        Brigand brigand = Brigand.arrayListBrigand(brigandList,numListBrigand,false);
        String nomBrigand=brigand.getName();
        
        System.out.println("< Soudain " + nomBrigand + " surgit et s’approche d’une femme pour la prendre en otage >");
        sleep.main(1000);
        System.out.println("< "+nomBrigand + " : Cette femme retrouvera la liberté lorsque j’aurais reçu 2 000 dollars >");
        sleep.main(1000);
        
        //Situation en fonction de la position du personnage principal
        switch(position){
            //Situation 1: près de l'entrée
            case 1 :
                System.out.println("< Vous êtes situé derrière "+nomBrigand+" >");
                sleep.main(1000);
                game=situationPourcentageReussite(brigandList,persoPrincipal,numListBrigand,95,90,99,99,money);
                break;
                
            //Situation 2: entre l'entrée et le bar
            case 2 :
                System.out.println("< Vous êtes situé à côté de "+nomBrigand+" >");
                sleep.main(1000);
                game=situationPourcentageReussite(brigandList,persoPrincipal,numListBrigand,75,70,85,85,money);
                break;
            
            //Situation 3: au bar
            case 3 :
                System.out.println("< Vous êtes situé devant "+nomBrigand+" >");
                sleep.main(1000);
                game=situationPourcentageReussite(brigandList,persoPrincipal,numListBrigand,20,20,30,30, money);
                break;
        }
        return game;
    }
    
    /**En fontion d'un nombre aléatoire compris entre 0 et 3,
     * 4 situations peuvent se présenter :
     *   le brigand est agité et son arme pointe vers la foule; 
     *   le brigand est agité et son arme pointe vers la femme; 
     *   le brigand est calme et son arme pointe vers la femme; 
     *   le brigand est calme et son arme pointe vers la foule.
     * 
     * @param brigandList permet de récupérer les informations des Brigands
     * @param persoPrincipal permet de récupérer les informations de l'utilisateur
     * @param numListBrigand permet de savoir de quel brigand on souhaite récupérer les informations
     * @param pourcentage1 correspond au pourcentage de réussite de l'intervention de la situation 1
     * @param pourcentage2 correspond au pourcentage de réussite de l'intervention de la situation 2
     * @param pourcentage3 correspond au pourcentage de réussite de l'intervention de la situation 3
     * @param pourcentage4 correspond au pourcentage de réussite de l'intervention de la situation 4
     * @param money permet de gérer l'argent de l'utilisateur
     * @return permet de retourner l'état actuel de la partie (si game=true la partie continue)
     */
    public static boolean situationPourcentageReussite(ArrayList<Brigand> brigandList, ArrayList<CowBoy> persoPrincipal,int numListBrigand, int pourcentage1,int pourcentage2,int pourcentage3,int pourcentage4,Money money){
        boolean game=true;
        Random random = new Random();
        int situation = random.nextInt(4);
        
        //Information sur brigand
        Brigand brigand = Brigand.arrayListBrigand(brigandList,numListBrigand,false);
        String nomBrigand=brigand.getName();
        
        //Situation aléaoire du comportement du brigand
        switch(situation){
            //Situation 1 : Le brigand est agité et son arme pointe vers la foule
            case 0 :
                agiteFoule(nomBrigand);
                //Choix d'intervenir
                game=choixIntervention(brigandList,persoPrincipal,numListBrigand,pourcentage1, money);
                break;
                
            //Situation 2 : Le brigand est agité et son arme pointe vers la femme
            case 1 :
                agiteFemme(nomBrigand);
                //Choix d'intervenir
                game=choixIntervention(brigandList,persoPrincipal,numListBrigand,pourcentage2, money);
                break;
            
            //Situation 3 : Le brigand est calme et son arme pointe vers la femme
            case 2 :
                calmeFemme(nomBrigand);
                //Choix d'intervenir
                game=choixIntervention(brigandList,persoPrincipal,numListBrigand,pourcentage3,  money);
                break;
            
            //Situation 4 : Le brigand est calme et son arme pointe vers la foule
            case 3 :
                calmeFoule(nomBrigand);
                //Choix d'intervenir
                game=choixIntervention(brigandList,persoPrincipal,numListBrigand, pourcentage4, money);
                break;  
        }
        return game;
    }
    
    /**L'utilateur va choisir d'intervenir en fonction des donnée qui lui seront transmis,
     * concernant le comportement du brigand et de sa position par rapport au brigand.
     * 
     * Si l'utilisateur choisi d'intervenir, il décide le nombre de balle qu'il souhaite utilisé,
     * sinon, l'utilisateur paye la rançon du brigand afin de libérer l'otage.
     * 
     * @param brigandList permet de récupérer les informations des Brigands
     * @param persoPrincipal permet de récupérer les informations de l'utilisateur
     * @param numListBrigand permet de savoir de quel brigand on souhaite récupérer les informations
     * @param pourcentageIntervention
     * @param money permet de gérer l'argent de l'utilisateur
     * @return permet de retourner l'état actuel de la partie (si game=true la partie continue)
     */
    public static boolean choixIntervention(ArrayList<Brigand> brigandList,ArrayList<CowBoy> persoPrincipal,int numListBrigand,int pourcentageIntervention,Money money){
        boolean game=true;
        Sleep sleep = new Sleep();
        
        Scanner keyboard=new Scanner (System.in);
        int choix_Intervention =0;
        
        while ((choix_Intervention != 1)&& (choix_Intervention != 2) && (choix_Intervention != 3)) {
            try{
                System.out.println("< Souhaitez-vous intervenir ou payer? >");
                sleep.main(1000);
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
                    int choix_nb_balles = choixNbBalles(persoPrincipal);
                    //conversion du pourcentageIntervention en type double
                    double pourcentageIntervention_tmp = pourcentageIntervention;
                    pourcentageIntervention_tmp = pourcentageIntervention_tmp/100;
                    //calcul proba en fonction du nombre de balles tirées                    
                    pourcentageIntervention = PriseDOtage.calc_pourcentage_balles(choix_nb_balles, pourcentageIntervention_tmp); 
                    game=intervention(brigandList,persoPrincipal,numListBrigand,pourcentageIntervention,money,choix_nb_balles);
                    break;
                    
                case 2 :
                    System.out.println("< Vous n'etes pas intervenu >");
                    money.payRançon(2000);
                    game=true;
                    break;
        }
        return game;
    }
    
    /**L'utilisateur choisi le nombre de balle qu'il souhaite utiliser
     * en faisant attention au nombre de balle qu'il lui reste.
     * 
     * @param persoPrincipal permet de récupérer les informations de l'utilisateur
     * @return permet de retourner le nombre de balle choisi par l'utilisateur
     */
    public static int choixNbBalles(ArrayList<CowBoy> persoPrincipal){
        Sleep sleep = new Sleep();
        
        Scanner keyboard=new Scanner (System.in);
        int choix_nb_balles=0;
        while((choix_nb_balles == 0) || (choix_nb_balles > persoPrincipal.get(0).nb_balles) || (persoPrincipal.get(0).nb_balles<=0)){
            try{
                System.out.println("< Combien de balles souhaites-tu utiliser ? IL TE RESTE "+ persoPrincipal.get(0).nb_balles +" BALLES >" );
                sleep.main(1000);
                System.out.println("      "+"1 ?[1]" );
                System.out.println("      "+"2 ?[2]" );
                System.out.println("      "+"3 ?[3]" );
                System.out.println("      "+"4 ?[4]" );
                choix_nb_balles = Integer.parseInt(keyboard.nextLine());
                if(choix_nb_balles> persoPrincipal.get(0).nb_balles){
                    System.out.println("Erreur, vous n'avez pas assez de balles");
                }
                else if ( choix_nb_balles <= 0){
                    System.out.println("Erreur veuillez réessayer...");
                }
            }catch(NumberFormatException e){
                System.out.println("Erreur veuillez réessayer...");
            }   
        }  
        persoPrincipal.get(0).nb_balles = persoPrincipal.get(0).nb_balles - choix_nb_balles;
        return choix_nb_balles;
    }
   
    /**Lorsque l'utilisateur choisi d'intervenir, 
     * 3 situations sont possible en fonction du prencentage d'intervention : 
     * l'utilisateur à réussis à tuer le brigand;
     * l'utilisateur à raté son/ses tire(s), le brigand tire à son tour,le brigand peut ne plus avoir de balle et il s'enfuit;
     * le brigand réussis à s'enfuir.
     * 
     * @param brigandList permet de récupérer les informations des Brigands
     * @param persoPrincipal permet de récupérer les informations de l'utilisateur
     * @param numListBrigand permet de savoir de quel brigand on souhaite récupérer les informations
     * @param pourcentageIntervention
     * @param money permet de gérer l'argent de l'utilisateur
     * @param choix_nb_balles permet de récupérer le choix du nombre de balle que l'utilisateur a choisi
     * @return permet de retourner l'état actuel de la partie (si game=true la partie continue)
     */
    public static boolean intervention(ArrayList<Brigand> brigandList,ArrayList<CowBoy> persoPrincipal,int numListBrigand,int pourcentageIntervention, Money money,int choix_nb_balles){
        boolean game=true;
        Sleep sleep = new Sleep();
        
        Random random = new Random();
        int pourcentage = random.nextInt(100);
         
        if (pourcentage < pourcentageIntervention){
            int situation=random.nextInt(4);
            switch(situation){
                //Situation 1: Le brigand est tué
                case 0,1,2 :
                    persoPrincipal.get(0).tirer(choix_nb_balles, brigandList.get(numListBrigand), persoPrincipal.get(0));
                    Brigand.arrayListBrigand(brigandList,numListBrigand,true);
                    System.out.println("< Vous avez tué le brigand >");
                    game=true;
                    break;
                //Situation 2: Le brigand s'enfuit
                case 3 :    
                    persoPrincipal.get(0).tirer(choix_nb_balles, brigandList.get(numListBrigand), persoPrincipal.get(0));
                    System.out.println("< "+brigandList.get(numListBrigand).name+" a réussi à s'échapperé >");
                    sleep.main(1000);
                    System.out.println("< "+persoPrincipal.get(0).getName()+" : Mince, il est chanceux celui là >");
                    sleep.main(1000);
                    System.out.println("< "+persoPrincipal.get(0).getName()+" : Mais au moins, il est parti les mains vide >");
                    break;
                
            }
            
        }
        else{//pourcentage > pourcentageIntervention // Partie perdu ?
            System.out.println("< "+brigandList.get(numListBrigand).name + ": MOUHAHAHA ! Tu es à ma merci, prends-ça... >");
            sleep.main(1000);
            int nb_balles = random.nextInt(3);
            if(brigandList.get(0).etat_arme(nb_balles) == false){
                System.out.println("< "+brigandList.get(numListBrigand).name + ": Zut ! Plus de munitions... >");
                game = true;                
            } 
            else{
                brigandList.get(0).tirer((nb_balles+1), brigandList.get(numListBrigand), persoPrincipal.get(0));
                //Message de game over dans ProjetWest
                game=false;
            }
        }
        return game;
    }
    
    /**Fonction qui permet de calculer le pourcentage en fonction du nombre de balle choisi par l'utilisateur
     * 
     * @param choix_nb_balles permet de récupérer le choix du nombre de balle que l'utilisateur a choisi
     * @param pourcentage 
     * @return le pourcentage en fonction du nombre de balle choisi par l'utilisateur
     */
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
    
    public static void agiteFoule(String brigandName){
       System.out.println("< "+brigandName + " est agité >");
       System.out.println("< Son arme pointe vers la foule >");
    }
    
    public static void agiteFemme(String brigandName){
        System.out.println("< "+brigandName + " est agité >");
        System.out.println("< Son arme pointe vers la femme >");
    }
    public static void calmeFemme(String brigandName){
        System.out.println("< "+brigandName + " est calme >");
        System.out.println("< Son arme pointe vers la femme >");
    }
    
    public static void calmeFoule(String brigandName){
        System.out.println("< "+brigandName + " est calme >");
        System.out.println("< Son arme pointe vers la foule >");
    }
}
