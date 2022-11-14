/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author zawae
 */
public class Time {
    public Calendar cal = Calendar.getInstance();
    
    public Date newTime() {
        Date date = cal.getTime();
        return date;
    }
    
    public Date addDay() {
        cal.add(Calendar.DATE,1);
        return cal.getTime();
    }
    
    public void displayTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String stringDate= format.format(date); 
        System.out.println("< Aujourd'hui, nous sommes le " + stringDate + " >");
    }
    
}
