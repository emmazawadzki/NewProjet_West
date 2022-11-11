/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.util.ArrayList;

/**
 *
 * @author zawae
 */
public class Brigand extends Humain{
    private Boolean estMort;
    
    public static Brigand ArrayListBrigand(ArrayList<Brigand> brigandList,int numList,boolean change) {
        if(change==true){
            brigandList.set(numList,new Brigand("Averell",true));
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
}
