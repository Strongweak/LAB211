
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
    public static int getChoice() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Your choice:");
                String choice = scanner.nextLine();
                // if input is empty, tell user
                if (choice.isEmpty()) {
                    System.out.println("please choose choice!");
                } else {
                    int choiceNumber = Integer.parseInt(choice);
                    if (choiceNumber <= 0 || choiceNumber > 4) {
                        System.out.println("Please enter choice from 1 to 4!");
                    } else {
                        return choiceNumber;
                    }
                }
                //if string is worng format
            } catch (NumberFormatException ex) {
                System.out.println("Please input digit!");
            }

        }
    }
    //get int from user
    public static int getInt() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                // if input is empty, tell user
                if (input.isEmpty()) {
                    System.out.print("please enter a value!:");
                }
                else {
                    int inputNumber = Integer.parseInt(input);
                    return inputNumber;
                }
                //if string is worng format
            } catch (NumberFormatException ex) {
                System.out.print("Please enter digit!:");
            }

        }
    }
    //get int from user
    public static int getMatrixValue(String message, int i, int j) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                // if input is empty, tell user
                if (input.isEmpty()) {
                    System.out.print("please enter a value!:");
                } else {
                    int inputNumber = Integer.parseInt(input);
                    return inputNumber;
                }
                //if string is worng format
            } catch (NumberFormatException ex) {
                System.out.println("Value of matrix is digit");
                System.out.print("Enter Matrix"+message+"["+i+"]"+"["+j+"]:");
            }

        }
    }
    //get matrix from user input
    public static int[][] getMatrix(int n) {
        System.out.print("Enter Row Matrix " + n+ ":");
        int row = inputManager.getInt();
        System.out.print("Enter Column Matrix " + n+ ":");
        int column = inputManager.getInt();
        int[][] matrix = new int[row][column];
        //loop for each row of matrix
        for (int i = 0; i < row; i++) {
            //loop for each column of matrix
            for (int j = 0; j < column; j++) {
                System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = inputManager.getMatrixValue("1", i + 1, j + 1);
            }
        }
        return matrix;

    }    
    
}
