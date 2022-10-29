
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Strongest
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //User enter date with [dd/mm/yyyy] format             
        String date = inputManager.getDate();
        //Check user input date exits
        if(inputManager.isValidDate(date))
        //Determine day of week with input date
        determineDayOfWeek(date);
              
    }

    //determine and dsiplay day of week 
    private static void determineDayOfWeek(String input) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(input);
            //EEEE: display full day name
            SimpleDateFormat day = new SimpleDateFormat("EEEE");
            String dayOfWeek = day.format(date);
            System.out.println("Your day is " + dayOfWeek);
        } catch (ParseException e) {
        }
    }
}
