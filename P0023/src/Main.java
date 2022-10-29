
import java.util.ArrayList;
import java.util.List;

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
        List<Fruit> fruitList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        fruitList.add(new Fruit(1, "Coconut", 2, 50, "Vietnam"));
        fruitList.add(new Fruit(2, "Orange", 3, 20, "US"));
        fruitList.add(new Fruit(3, "Apple", 4, 100, "Thailand"));
        fruitList.add(new Fruit(4, "Grape", 6, 100, "France"));
        while (true) {
            //Display a menu and ask users to select an option.
            displayInterface();
            int choice = inputManager.inputChoice(1, 4);
            switch (choice) {
                //Create product (Fruit)
                case 1:
                    FruitManager.createFruit(fruitList);
                    break;
                //View order list    
                case 2:
                    FruitManager.viewOrder(orderList);
                    break;
                //Shopping    
                case 3:
                    FruitManager.shopping(fruitList, orderList);
                    break;
                case 4:
                    //exit the program
                    System.exit(0);
                    break;
            }

        }
    }

    private static void displayInterface() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("        1.Create Fruit");
        System.out.println("        2.View orders");
        System.out.println("        3.Shopping (for buyer)");
        System.out.println("        4.Exit");
        System.out.println(" (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
    }

}
