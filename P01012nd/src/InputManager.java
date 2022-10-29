
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class InputManager {

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
        Scanner scanner = new Scanner(System.in);
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

    public static double getDouble(String msgString, String error, double d, double f) {
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
                System.out.println(error);
            }
        }
    }

    public static String getDate(String msg) {
        Scanner scanner = new Scanner(System.in);
        Date dateTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(dateTime);
        String date;
        while (true) {
            System.out.print(msg);
            date = scanner.nextLine().trim();

            boolean dateLessThanCurrentDate = checkDate1BeforeDate2(date, currentDate);
            //dateLessThanCurrentDate return true => date input < date current 
            //else date input > date current

            if (date.isEmpty()) {
                System.out.println("Input can't be empty");
            } else if (isValidDate(date) == false) {
                System.out.println("The date does not exist !!!");
            } else if (dateLessThanCurrentDate == false) {
                System.out.println("Date must be less than " + currentDate);
            } else {
                return date;
            }

        }

    }

    public static boolean isValidDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = null;
        dateFormat.setLenient(false);

        try {
            dateTest = dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private static boolean checkDate1BeforeDate2(String dateInput, String currentDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate;
        Date secondDate;

        try {
            firstDate = dateFormat.parse(dateInput);
            secondDate = dateFormat.parse(currentDate);

            //if first date before second date => return true
            //if first date after second date => return false
            //if first date equal second date = > return false
            if (firstDate.before(secondDate)) {
                return true;
            } else {
                return false;
            }

        } catch (ParseException ex) {
            return false;
        }
    }

    /*
         regex:
                a-z: matches character from a-z
                A-Z: matches character from A-Z
                   : matches with SPACE
                +  : matches the previous token between one and unlimited times
                0-9: matches with digit from 0-9
                .  : matches with character .
                /  : matches with character /
                [@]: must have character @
              {1,2}: must have 1 or 2 character
     */
    public static boolean checkWantToUpdate(String message) {
        String test = getString("Do you want to update " + message + " ?: ", "It must be Y or N", "[yYnN]");
        if (test.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public static int getID(List<Employee> employeeList) {
        while (true) {
            int id = InputManager.getInt("Enter id: ", "It must be digit", 0, Integer.MAX_VALUE);
            if (EmployeeManager.getEmployeeByID(employeeList, id) == null) {
                return id;
            } else {
                System.out.println("This is is existed!!!");
            }
        }
    }

    public static String getFirstName() {
        String firstName = InputManager.getString("Enter first name: ", "Wrong format", "[a-zA-Z]+");
        return firstName;
    }

    public static String getLastName() {
        String lastName = InputManager.getString("Enter last name: ", "Wrong format", "[a-zA-Z]+");
        return lastName;
    }

    public static String getPhone() {
        String phone = InputManager.getString("Enter phone(must have 10 digits and start with 0): ", "Wrong format", "[0][0-9]{9,10}");
        return phone;
    }

    public static String getEmail() {

        String email = InputManager.getString("Enter mail: ", "Wrong format", "[a-zA-Z0-9]+[@]([a-zA-Z]+[.]){1,2}[a-zA-Z]+");

        return email;

    }

    public static String getAddress() {
        String address = InputManager.getString("Enter address: ", "Wrong format", "[a-zA-Z0-9 ]+");
        return address;
    }

    public static String getDOB() {
        String dob = InputManager.getDate("Enter date in format (dd/MM/yyyy): ");
        return dob;
    }

    public static int getSex() {
        int sex = InputManager.getInt("Enter sex (1: male || 0: female )", "(1: male || 0: female )", 0, 1);
        return sex;
    }

    public static double getSalary() {
        double salary = InputManager.getDouble("Enter salary: ", "Wrong format", 0, Double.MAX_VALUE);
        return salary;
    }

    public static String getAgency() {
        String agency = InputManager.getString("Enter agency: ", "Wrong format", "[a-zA-Z]+");
        return agency;
    }
}
