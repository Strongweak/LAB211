
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
class inputManager {

    //call user enter date 
    public static String getDate() {
        while (true) {
            //d{1,2} matches with character have 1 or 2 numbers;
            //[/] matches with character /
            //d{4} matches with character have 4 numbers;        
            String REGEX = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter date with format [dd/mm/yyyy]:");
            String input = scanner.nextLine().trim();
            //if input is empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } // return input if matches with all condition            
            else if (input.matches(REGEX)) {
                if(isValidDate(input)){
                return input;                    
                }
            } //if string is not matches with day format
            else {
                System.out.println("Incorrect input format!");
            }
        }
    }

    //check if input date exist
    public static boolean isValidDate(String inputDate) {
        Date date = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                date = dateFormat.parse(inputDate);
            } catch (ParseException e) {
                System.out.println("date does not exist!");
                return false;
            }
        return true;
    }
}
