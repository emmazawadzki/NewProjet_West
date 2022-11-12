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
    public String name;
    public String boissonFavorite;
    public Integer nb_balles;
    
    public Humain(String name,String boissonFavorite,Integer nb_balles){
        this.name=name;
        this.boissonFavorite=boissonFavorite;
        this.nb_balles = nb_balles;
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

    public abstract void sePresenter();
    
    public void quelEstTonNom(){
        System.out.println(this.name + ": Bonjour, je m'appelle " + this.name);
    }
    
}