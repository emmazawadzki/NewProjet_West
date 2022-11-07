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
//    private int alcoholLevel;
    
    public static final AlcoholDrink Biere = new AlcoholDrink("Biere",25,5000);
    public static final AlcoholDrink Vin = new AlcoholDrink("Vin",25,5000);
    public static final AlcoholDrink Whisky = new AlcoholDrink("Whisky",5,5000);
    
    public AlcoholDrink(String name, int size, int price){
        super(name,size,price);
    }
    
//    public int getAlcoholLevel(){
//        return this.alcoholLevel;
//    }
}