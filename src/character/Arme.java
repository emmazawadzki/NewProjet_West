/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package character;


/**
 *
 * @author ferja
 */
public interface Arme {
    //public final static int nb_balles = 5;
    
    public abstract void tirer(int choix_nb_balles, Brigand brigand, CowBoy cowboy); 
    public abstract boolean etat_arme(int nb_balles);
}
