
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
class calculatorManager {

    //matrix1 + matrix2
    public static void addtionMatrix() {
        int[][] matrix1 = inputManager.getMatrix(1);
        int[][] matrix2 = inputManager.getMatrix(2);
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        //if 2 matrices are of equal size then do the math and display the result
        if (row1 == row2 && column1 == column2) {

            System.out.println("-------- Result --------");
            displayMatrixInput(matrix1, row1, column1);
            System.out.println("+");
            displayMatrixInput(matrix2, row2, column2);
            System.out.println("=");

            int[][] result = new int[row1][column1];
            //loop for each row of result matrix
            for (int i = 0; i < row1; i++) {
                //loop for each column of result matrix
                for (int j = 0; j < column1; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                    System.out.print("[" + result[i][j] + "]" + "");
                }
                System.out.println();
            }
        } 
        //if not display error
        else {
            System.out.println("Addition not possible");
        }

    }

    //matrix1 - matrix2
    public static void subtractionMatrix() {
        int[][] matrix1 = inputManager.getMatrix(1);
        int[][] matrix2 = inputManager.getMatrix(2);
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        //if 2 matrices are of equal size then do the math and display the result
        if (row1 == row2 && column1 == column2) {
            //display result
            System.out.println("-------- Result --------");
            displayMatrixInput(matrix1, row1, column1);
            System.out.println("-");
            displayMatrixInput(matrix2, row2, column2);
            System.out.println("=");

            int[][] result = new int[row1][column1];
            //loop for each row of result matrix
            for (int i = 0; i < row1; i++) {
                //loop for each column of result matrix
                for (int j = 0; j < column1; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                    System.out.print("[" + result[i][j] + "]" + "");
                }
                System.out.println();
            }
        } //if not, display error
        else {
            System.out.println("Subtraction not possible");
        }
    }

    //matrix1 * matrix2
    public static void multiplicationMatrix() {
        int[][] matrix1 = inputManager.getMatrix(1);
        int[][] matrix2 = inputManager.getMatrix(2);
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        //if the column of matrix 1 is equal to the row of matrix 2 then do the math
        if (column1 == row2) {
            System.out.println("-------- Result --------");
            displayMatrixInput(matrix1, row1, column1);
            System.out.println("*");
            displayMatrixInput(matrix2, row2, column2);
            System.out.println("=");
            
            int[][] result = new int[row1][column2];
            //loop for each row of result matrix
            for (int i = 0; i < row1; i++) {
                //loop for each column of result matrix
                for (int j = 0; j < column2; j++) {
                    result[i][j] = 0;
                    //result element = multiplying addition of the entries of the 
                    //ith row of A and the jth column of B
                    for (int k = 0; k < column1; k++) {
                        result[i][j] = result[i][j] + matrix1[i][k] * matrix2[k][j];                
                    }
                    System.out.print("[" + result[i][j] + "]" + "");
                }
                System.out.println();
            }
            //if not, tell the user
        } else {
            System.out.println("Multiplication not possible");
        }
    }
    //display matrix input
    public static void displayMatrixInput(int[][] matrix, int row, int column) {
        int[][] input = matrix;
        //loop for each row of result matrix
        for (int i = 0; i < row; i++) {
            //loop for each column of result matrix
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]" + "");
            }
            System.out.println();
        }
    }
}
