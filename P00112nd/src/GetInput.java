
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetInput {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String msgString, String errorString,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);

        // ask user until true input
        while (true) {
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    // check the range of input
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Invalid. The input must be "
                                + "in range " + min + " to " + max);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(errorString);
            }
        }

    }
    public static String getString(String msgString, String error, String regexString) {       
        // ask user until true input
        while (true) {
            System.out.print(msgString);
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Input can't be empty!!!");
            } // Check the value of user enter is match with the regex?
            // if true then return the string  
              else if (string.matches(regexString)) {                
                return string;
            } else {
                System.out.println(error);
            }
        }
    }
}