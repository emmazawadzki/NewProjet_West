/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drink;

/**
 *
 * @author zawae
 */
public class AlcoholDrink extends Drink{
    private int alcoholLevel;
    
    public static final AlcoholDrink Beer= new AlcoholDrink("Beer",25,8.0f,10);
    
    public AlcoholDrink(String name, int size, float price, int alcoholLevel){
        super(name,size,price);
        this.alcoholLevel=alcoholLevel;
    }
    
    public int getAlcoholLevel(){
        return this.alcoholLevel;
    }
}
