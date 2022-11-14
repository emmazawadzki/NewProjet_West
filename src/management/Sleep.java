/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package management;



/**
*
* @author ferja
*/
public class Sleep {
    public static void main(int time){
    try {
            for (int i = 0; i < 1*(time/1000); i++) {
               
                // cela va faire attendre le main 1 seconde
                java.lang.Thread.sleep(time);
               
                // printing the value of the variable
            }
        }
        catch (Exception e) {
           
            // catch l'exception
            System.out.println(e);
        }
    
    }
}