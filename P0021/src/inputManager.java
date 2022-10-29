
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
public class inputManager {
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
    //get int from user
    public static int getInt(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            //if input empty then tell user 
            //else is input matches with regex ?                
            if (input.isEmpty()) {
                System.out.println("please enter a value!");
            } else {
                if (input.matches(regex)) {
                    int inputNumber = Integer.parseInt(input);
                    return inputNumber;
                } else {
                    System.out.println(error);
                }
            }
        }
    }
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

    //get id from input
    public static String getId() {
        //[0-9]:matches with character from range 0 to 9
        //+ can be matches multiple times
        String id = getString("Enter id: ", "Please enter number!", "[0-9]+");
        return id;
    }

    //get student name from input
    public static String getStudentName(String id, List<Student> studentList) {
        while (true) {
            //[a-zA-Z ] matches with character from range a to z and A to Z and "space" character
            //+ can be matches multiple times
            String name = getString("Enter name: ", "name must be letter!", "[a-zA-Z ]+");
            if (!Validation.checkworngName(id, name, studentList)) {
                return name;
            }
        }
    }

    //get semester from input
    public static int getSemester() {
        //[0-9]:matches with character from range 0 to 9 and allow only 1 digit
        int semester = getInt("Enter semester: ", "Semester must be digit!", "[0-9]");
        return semester;
    }

    //get course name from input
    public static String getCourseName() {
        //loop until get course
        while (true) {
            //[a-zA-Z.+/ ] matches with character from range a to z and A to Z and "space" character, ".", "+", and "/" character
            //+ can be matches multiple times
            String courseName = getString("Enter course name: ", "course name must be in 3 course(Java,C/C++,.net)", "[a-zA-Z.+/ ]+");
            //if course name in(java,.net,c/c++) then return string
            if (courseName.equalsIgnoreCase("java")
                    || courseName.equalsIgnoreCase(".net")
                    || courseName.equalsIgnoreCase("c")
                    || courseName.equalsIgnoreCase("c++")
                    || courseName.equalsIgnoreCase("c/c++")) {
                return courseName;
            } else {
                System.out.println("course name must be in 3 course(Java,C/C++,.net)");
            }
        }
    }

}
