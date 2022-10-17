/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetwest;

/**
 *
 * @author zawae
 */
public class Brigand extends Humain{
    private Boolean estEnPrison;
    private Boolean estMort;
    
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
