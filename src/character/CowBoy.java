/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.util.ArrayList;
import management.Sleep;

/**
 *
 * @author zawae
 */
public class CowBoy extends Humain implements Arme{
    Sleep sleep = new Sleep();
    
    
    public static CowBoy ArrayListCowBoy(int numList) {
        ArrayList<CowBoy> cowboyList = new ArrayList<CowBoy>();
        cowboyList.add( new CowBoy("Fred","Beer",5));
        cowboyList.add( new CowBoy("Wilson","Wine",5));
        cowboyList.add( new CowBoy("Nelson","Whisky",5));
        
        return cowboyList.get(numList);
    }
    
    public CowBoy(String name,String boissonFavorite,Integer nb_balles){
        super(name,boissonFavorite,nb_balles);
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
    
    @Override
    public void tirer(int choix_nb_balles, Brigand brigand, CowBoy cowboy){//plus le nb de balle choisi est élévé plus chance de toucher la cible *1.2^nb_balles
        System.out.println(cowboy.name + ": Prends-ça saleté...");
        for (int i =0; i<choix_nb_balles;i++ ){
            sleep.main(1000);
            System.out.println("PAN !");
        }
        sleep.main(1000);
    } 
    
    @Override
    public boolean etat_arme(int nb_balles){//pour savoir si le joueur doit acheter des balles
        if(nb_balles <= 0) return false;
        else return true;
    }
    
}
