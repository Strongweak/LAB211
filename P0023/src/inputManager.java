
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

    //get choice from user
    public static int inputChoice(int a, int b) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input;
                System.out.print("Enter choice: ");
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Please enter choice!");
                } else {
                    int choice = Integer.parseInt(input);
                    if (choice >= a && choice <= b) {
                        return choice;
                    } else {
                        System.out.println("Input must be in range from " + a + " - " + b + "!");
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Wrong format!");
            }
        }
    }

    //get string from user
    public static String getString(String msgString, String error, String regexString) {
        // ask user until true input
        while (true) {
            Scanner scanner = new Scanner(System.in);
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

    //get double from user
    public static double getDouble(String msgString, String error, double d, double f) {
        // ask user until true input
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    double floatInput = Double.parseDouble(input);
                    return floatInput;
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }
    //get int from user
    public static int getInt(String msgString, String errorString, int min, int max) {
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
}
