/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package management;
/**
*
* @author ferja
*/
public class Money {
    public int money;
    
    public int initialiseMoney(int money){
        return this.money = money;
    }
    
    public int getMoney(){
        return this.money;
    }
    
    public void displayMoney(int money){
        System.out.println("< Votre solde est de : " + money + " € >");
    }
    
    public int buyDrink(int cost){
        return this.money = (this.money-cost);      
    }
    
    public int payRançon(int rançon){
        return this.money = (this.money-rançon);      
    }
    
      
     
    
}