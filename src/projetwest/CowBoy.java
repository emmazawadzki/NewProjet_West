/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetwest;

/**
 *
 * @author zawae
 */
public class CowBoy extends Humain{
    
    public static final CowBoy COWBOY1 = new CowBoy("Fred","Beer");
    public static final CowBoy COWBOY2 = new CowBoy("Wilson","Wine");
    public static final CowBoy COWBOY3 = new CowBoy("Nelson","Whisky");
    
    public CowBoy(String name,String boissonFavorite ){
        super(name,boissonFavorite);
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
}
