/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drink;

/**
 *
 * @author zawae
 */
public class SoftDrink extends Drink{
    
    public static final SoftDrink Eau= new SoftDrink("Eau",25,5);
    public static final SoftDrink Coca= new SoftDrink("Coca",33,10);
    
    public SoftDrink(String name, int size, int price){
        super(name,size,price);
    }
    
    
}
