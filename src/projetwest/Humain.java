/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetwest;

/**
 *
 * @author zawae
 */
public class Humain {
    private String name;
    private String boissonFavorite;
    
    public Humain(String name,String boissonFavorite ){
        this.name=name;
        this.boissonFavorite=boissonFavorite;
    }

    
    public void sePresenter(String name){
        this.name=name;
        quelEstTonNom();
    }
    
    public void quelEstTonNom(){
        System.out.println("Bonjour, je m'appelle " + this.name);
    }
    
}
