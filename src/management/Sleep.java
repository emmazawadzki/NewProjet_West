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
               
                // it will sleep the main thread for 1 sec
                // ,each time the for loop runs
                java.lang.Thread.sleep(time);
               
                // printing the value of the variable
            }
        }
        catch (Exception e) {
           
            // catching the exception
            System.out.println(e);
        }
    
    }
}