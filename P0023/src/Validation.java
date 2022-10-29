
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
public class Validation {
    //check duplicate fruit
    public static boolean checkDuplicateFruit(List<Fruit> fruitList, String name, String origin) {
        //for each element in list
        for (Fruit fruit : fruitList) {
            //if input name and origin is match with any fruit in list
            if (fruit.getFruitName().equalsIgnoreCase(name) && fruit.getOrigin().equalsIgnoreCase(origin)) {
                return true;
            }
        }
        return false;
    }

    //check if user input id duplicate with fruit id in list
    static boolean checkDuplicateID(int id, List<Fruit> fruitList) {
        //loop from first element in list to lase element in list
        for (Fruit fruit : fruitList) {
            //check if input id = id in list return true
            if (fruit.getFruitId() == id) {
                System.out.println("This ID is already exist! please enter another ID!!!");
                return true;
            }
        }
        //if not duplicate, return false
        return false;
    } 
    //check if fruit exist
    public static Fruit getFruit(List<Fruit> fruitList, int id) {
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitId()== id) {
                return fruit;
            }
        }
        return null;
    }    
    //check if user input quanity of fruit is valid
    public static boolean checkQuanityValidation(int quanityOrder, Fruit fruit) {
        //if user input quanity is bigger than fruit quanity in list
        if(quanityOrder > fruit.getQuantity()){
            return false;
        }
        return true;
    }
    //check user enter yes or no
    public static boolean checkYesNo(String message) {
        String result = inputManager.getString(message, 
                "It must be Y or N", "[yYnN ]+");
        if (result.equalsIgnoreCase("y") ) {
            return true;
        }
        return false;
    }    
}
