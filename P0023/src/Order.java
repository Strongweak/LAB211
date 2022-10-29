
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
public class Order {
    private String nameCustomer;
    private List<Fruit> fruitList;

    public Order(String nameCustomer, List<Fruit> fruitList) {
        this.nameCustomer = nameCustomer;
        this.fruitList = fruitList;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public List<Fruit> getfruitList() {
        return fruitList;
    }

    public void setfruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    
    
}
