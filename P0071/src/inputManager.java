
import java.text.DateFormat;
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

    //get int from user
    public static int getInt(String message, String error, int a, int b) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input;
                System.out.print(message);
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println(error);
                } else {
                    int choice = Integer.parseInt(input);
                    if (choice >= a && choice <= b) {
                        return choice;
                    } else {
                        System.out.println(error);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Wrong format!");
            }
        }
    }

    //get string from user
    public static String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            //if input empty then tell user 
            //else is input matches with regex ?
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                //if input matches with regex then return input
                //else announce error
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    //get string date from user
    public static String getDate(String msg, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        Date dateTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormat.format(dateTime);
        String date;
        while (true) {
            System.out.print(msg);
            date = scanner.nextLine().trim();
            //check if employees date of birth is after current(today) date
            boolean dateLessThanCurrentDate = Validation.checkInputDateWithtodayDate(date, currentDate);
            //if input is empty
            if (date.isEmpty()) {
                System.out.println("Input can't be empty");
            } //if input is not match regex
            else if (!date.matches(regex)) {
                System.out.println(error);
            } //if date is not exist
            else if (Validation.isValidDate(date) == false) {
                System.out.println("The date does not exist !!!");
            } //if input is larger than today date
            else if (dateLessThanCurrentDate == false) {
                System.out.println("Date must be less or equal than " + currentDate);
            } else {
                return date;
            }

        }

    }

    //get double from user
    public static double getDouble(String message, double d, double f) {
        Scanner scanner = new Scanner(System.in);
        // ask user until true input
        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    double floatInput = Double.parseDouble(input);
                    //if floatInput not divide to 0.5 then tell user
                    if (floatInput % 0.5 != 0) {
                        System.out.println("It must be divide to 0.5");
                    } // check the range of input
                    else if (d <= floatInput && floatInput <= f) {
                        return floatInput;
                    } else {
                        System.out.println("Invalid. The input must be in range "
                                + d + " to " + f);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Input must be digit!!!");
            }
        }
    }

    //get type id from user
    public static int getTaskTypeID() {
        int typeID = getInt("Task Type: ", "It must be \n 1.Code \n 2.Test \n 3.Design \n 4.Review", 1, 4);
        return typeID;
    }

    //get name from user
    public static String getRequirementName() {
        String name = getString("Requirement Name: ", "It must be letter or digit",
                "[a-zA-Z0-9 ]+");
        return name;
    }

    //get date task from user
    public static String getDateTask() {
        String date = getDate("Date: ", "It must be format dd-mm-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
        return date;
    }
    // get plan time from from user

    public static double getPlanFrom() {
        double planFrom = getDouble("From: ", 8, 17);
        return planFrom;
    }
    // get plan time to from user

    public static double getPlanTo() {
        double planTo = getDouble("To: ", 8, 17.5);
        return planTo;
    }
    //get assignee from user

    public static String getAssignee() {
        String assignee = getString("Assignee: ", "It must be letter or digit",
                "[a-zA-Z0-9 ]+");
        return assignee;
    }
    //get reviewer from user

    public static String getReviewer() {
        String reviewer = getString("Reviewer: ", "It must be letter or digit",
                "[a-zA-Z0-9 ]+");
        return reviewer;
    }

    //get id from user 
    public static int getIDInput() {
        int id = getInt("Enter ID: ", "It must be digit", 1, Integer.MAX_VALUE);
        return id;
    }
}
