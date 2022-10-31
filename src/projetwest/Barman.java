/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetwest;

/**
 *
 * @author zawae
 */
public class Barman extends Humain{
    private Humain PersonneDialogue;
    
    public static final Barman BARMAN =new Barman("Bob","Biere");
    
    public Barman(String name,String boissonFavorite){
        super(name,boissonFavorite);
    }
    
    public Barman(String name){
        super(name);
    }
    
    public void sePresenter(){
        quelEstTonNom();
    }
    
    public void sert(String name,String boissonFavoriteP, String nameP){
        System.out.println(name +": Voici votre " + boissonFavoriteP + " " + nameP);
    }
}
