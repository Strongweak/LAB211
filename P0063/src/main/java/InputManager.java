
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class InputManager {

    
    public static String getInputString(String message, String error, String regex) {
        Scanner sc = new Scanner(System.in);
        //loop until user input true value 
        while(true){
                System.out.print(message);
                String input = sc.nextLine().trim();
                if(input.isEmpty()){
                System.out.println("Input not empty");                   
                }
             else {
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

    
    public static double getInputSalary() {
       //loop until user input true value        
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                double salary = Double.parseDouble(sc.nextLine());
                if (salary < 0) {
                    System.out.println("Salary is greater than zero");
                    System.out.print("Please input salary:");
                } else {
                    return salary;
                }
            } catch (NumberFormatException ex) {
                System.out.println("You must input digit");
                System.out.print("Please input salary:");
            }
        }
    }

    
    
}
