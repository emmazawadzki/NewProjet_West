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
    private Boolean estEnPrison;
    private Boolean estMort;
    
    public static Brigand ArrayListBrigand(int numList) {
        ArrayList<Brigand> brigandList = new ArrayList <Brigand>();
        brigandList.add( new Brigand("Joe",false,false));
        brigandList.add( new Brigand("Averell",false,false));
        brigandList.add( new Brigand("Jack",false,false));
        brigandList.add( new Brigand("William",false,false));
        brigandList.add( new Brigand("Rantanplan",false,false));
        
        return brigandList.get(numList);
    }
    
    public Brigand(String name){
        super(name);
    }
    
    public Brigand(String name,Boolean estEnPrison, Boolean estMort){
        super(name);
        this.estEnPrison=estEnPrison;
        this.estMort=estMort;
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
}
