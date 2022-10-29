
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

        //User enter the first date with [dd/mm/yyyy] format 
        Date firstDate = getInput.inputDate("first");
        //User enter the second date with [dd/mm/yyyy] format 
        Date secondDate = getInput.inputDate("second");
        //Compare and display
        CompareDate(firstDate, secondDate);
    }

    //compare first date and second date and display result
    private static void CompareDate(Date firstDate, Date secondDate) {
        //if first date is before second date
        if (firstDate.before(secondDate)) {
            System.out.println();
            System.out.println("Date1 is before Date2");
        //if first date is after second date    
        } else if (firstDate.after(secondDate)) {
            System.out.println();
            System.out.println("Date1 is after Date2");
        //if first date is equal to second date    
        } else {
            System.out.println();
            System.out.println("Date1 is equal Date2");
        }
    }

}
