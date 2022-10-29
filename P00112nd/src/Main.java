
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
        //Required user choose the base number input ( example 1 is binary, 2 is decimal,  3 is hexadecimal)
        int inputBase = inputBaseFrom();
        //Required user choose the base number out ( example 1 is binary, 2 is decimal,  3 is hexadecimal)
        int outputBase = inputBaseTo();
        //Required user enter the input value;
        String input = inputValue(inputBase);
        //Program process and print output value;
        convertProcess(inputBase, outputBase, input);
        }
    }

    //call user input choice
    private static int inputBaseFrom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose input base number:");
        System.out.println("1: Binary");
        System.out.println("2: Decimal");
        System.out.println("3: Hexadecimal");
        System.out.println("4: Exit");
        int option = GetInput.getInt("Enter option:", "Wrong format!", 1, 4);
        switch (option) {
            case 1:
                return 2;
            case 2:
                return 10;
            case 3:
                return 16;
            case 4:
                System.exit(0);
                break;
        }
        return 0;
    }

    private static int inputBaseTo() {
        System.out.println("Please choose output base number:");
        System.out.println("1: Binary");
        System.out.println("2: Decimal");
        System.out.println("3: Hexadecimal");
        System.out.println("4: Exit");
        int option = GetInput.getInt("Enter option:", "Wrong format!", 1, 4);
        switch (option) {
            case 1:
                return 2;
            case 2:
                return 10;
            case 3:
                return 16;
            case 4:
                System.exit(0);
                break;
        }
        return 0;
    }

    private static String inputValue(int inputBaseFrom) {
        String input = null;
        switch (inputBaseFrom) {
            case 2:
                input = GetInput.getString("Enter binary number:", "Binary only "
                        + "have 0 and 1 character!", "[0-1]+");
                break;
            case 10:
                input = GetInput.getString("Enter decimal number:", "Decimal only "
                        + "have digit!", "[0-9]+");
                break;
            case 16:
                input = GetInput.getString("Enter hexadecimal number:", "Hexadecimal"
                        + " only have character from range 0 to 9 and A to F", "[0-9a-fA-F]+");
                break;
        }
        return input.toUpperCase();
    }

    private static void convertProcess(int inputBaseFrom, int inputBaseTo, String input) {
        switch (inputBaseFrom) {
            case 2:
                if (inputBaseTo == 2) {
                    //convert from binary to itself
                    System.out.println("Result:" + input);
                } else if (inputBaseTo == 10) {
                    //convert from 2 => 10
                    System.out.println("Result: " + convertManager.
                            convertToDecimal(input, inputBaseFrom));
                    
                } else {
                    //convert from 2 => 10 => 16
                    System.out.println("Result: " + convertManager.convertDecimalToOther(
                            convertManager.convertToDecimal(input, inputBaseFrom),inputBaseTo));
                }
                break;
            case 10:
                if (inputBaseTo == 2) {
                    //convert from 10 => 2
                    System.out.println("Result: " + convertManager.
                            convertDecimalToOther(input, inputBaseTo));
                } else if (inputBaseTo == 10) {
                    //convert from decimal to itself
                    System.out.println("result:" + input);
                } else {
                    //convert from 10 => 16
                    System.out.println("Result: " + convertManager.
                            convertDecimalToOther(input, inputBaseTo));                    
                }
                break;
            case 16:
                if (inputBaseTo == 2) {
                    //convert from 16 => 10 => 2
                    System.out.println("Result: " + convertManager.convertDecimalToOther(
                            (convertManager.convertToDecimal(input, inputBaseFrom)),inputBaseTo));
                } else if (inputBaseTo == 10) {
                    //convert from 16 => 10
                    System.out.println("Result: " + convertManager.
                            convertToDecimal(input, inputBaseFrom));
                } else {
                    //convert from hexadecimal to itself
                    System.out.println("Result:" + input);
                }
                break;
        }
    }

}
