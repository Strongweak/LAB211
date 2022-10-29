
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Strongest
 */
class getInput {
    // call user enter date
    public static String getString(String stringMsg) {
        Scanner scanner = new Scanner(System.in);
        //loop until get string
        while (true) {
            System.out.print(stringMsg);
            //d{1,2} matches with character have 1 or 2 numbers;
            //[/] matches with character /
            //d{4} matches with character have 4 numbers; 
            String REGEX = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";
            String inputdate = scanner.nextLine().trim();
            if (inputdate.isEmpty()) {
                System.out.println("Input can't be empty!!!");
            } 
            // Check the value of user enter is match with the regex?
            // if true then return the string  
            else if (inputdate.matches(REGEX)) {
                return inputdate;
            }
            //if string is not matches with day format
            else {
                System.out.println("Incorrect date format!");
            }
        }
    }
    // get date from input string
    public static Date inputDate(String message) {
        Date date = null;
        while(true){
        //loop until date input is valid
            try {
                String inputDate = getString("Please enter the " + message + "date: ");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                date = dateFormat.parse(inputDate); 
                return date;
            } catch (ParseException ex){
                System.out.println("Date does not exist!");
            } 
        }
    }
}
