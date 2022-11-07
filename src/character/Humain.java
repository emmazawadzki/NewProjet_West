/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

/**
 *
 * @author zawae
 */
public abstract class Humain {
    private String name;
    private String boissonFavorite;
    
    public Humain(String name,String boissonFavorite){
        this.name=name;
        this.boissonFavorite=boissonFavorite;
    }
    
    public Humain(String name){
        this.name=name;
    }
    
    public String GetName(){
        return this.name;
    }
    
    public String GetDrink(){
        return this.boissonFavorite;
    }

    public void sePresenter(String name){
        this.name=name;
        quelEstTonNom();
    }
    
    public void quelEstTonNom(){
        System.out.println(this.name + ": Bonjour, je m'appelle " + this.name);
    }
    
}
