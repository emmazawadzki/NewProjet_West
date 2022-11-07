/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drink;

/**
 *
 * @author zawae
 */
public class Drink {
    public String name;
    private int size;
    private int price;
    
    public Drink(String name, int size, int price){
        this.name=name;
        this.size=size;
        this.price=price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getPrice(){
        return this.price;
    }
    
}
