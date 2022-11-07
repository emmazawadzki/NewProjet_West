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
public class CowBoy extends Humain{
    
    
    public static CowBoy ArrayListCowBoy(int numList) {
        ArrayList<CowBoy> cowboyList = new ArrayList <CowBoy>();
        cowboyList.add( new CowBoy("Fred","Beer"));
        cowboyList.add( new CowBoy("Wilson","Wine"));
        cowboyList.add( new CowBoy("Nelson","Whisky"));
        
        return cowboyList.get(numList);
    }
    
    public CowBoy(String name,String boissonFavorite ){
        super(name,boissonFavorite);
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
}
