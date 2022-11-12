/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.util.ArrayList;
import management.*;

/**
 *
 * @author zawae
 */
public class Brigand extends Humain implements Arme{
    private Boolean estMort;
    Sleep sleep = new Sleep();
    
    
    public static Brigand ArrayListBrigand(ArrayList<Brigand> brigandList,int numList,boolean change) {
        if(change==true){
            Brigand brigand=brigandList.get(numList);
            String nomBrigand=brigand.GetName();
            brigandList.set(numList,new Brigand(nomBrigand,true));
        }
    
        return brigandList.get(numList);
    }
    
    
    public Brigand(String name, Boolean estMort){
        super(name);
        this.estMort=estMort;
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
    public Boolean GetEstMort(){
        return this.estMort;
    }
    
    
    
    
    @Override
    public void tirer(int choix_nb_balles, Brigand brigand, CowBoy cowboy){//utilisé en cas de Game Over
        for (int i =0; i<choix_nb_balles;i++ ){
            sleep.main(1000);
            System.out.println("PAN !");
        }
        sleep.main(1000);
    }
    
     
    
    @Override
    public boolean etat_arme(int nb_balles){//nb de balles générés au hasard pour savoir si le brigand bluff ou pas si il bluff alors il ne pourra pas tuer le perso principal s'il rate sa cible.
        if(nb_balles <= 0) return false;
        else return true;
    }
}
