

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
        //Display a menu 
        displayInterface();
        //loop until user choose exit
        while (true) {
            //ask users to select an option
            int choice = inputManager.getChoice();
            //Perform function based on the selected option.
            switch (choice) {
                //Option 1: Addition matrixes
                case 1:                  
                    calculatorManager.addtionMatrix();
                    break;
                //Option 2: Subtraction matrixes    
                case 2:
                    calculatorManager.subtractionMatrix();
                    break;
                //Option 3: Multiplication matrixes    
                case 3:
                    calculatorManager.multiplicationMatrix();
                    break;
                //Option 4: Exit program.    
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }
    //display user interface
    private static void displayInterface() {
        System.out.println("======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

}
