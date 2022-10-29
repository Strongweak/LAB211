
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
class FruitManager {

    //add fruit to list
    public static void createFruit(List<Fruit> fruitList) {
        //loop until user choose no
        while(true){
        int id = getIDInput(fruitList);
        String name = getNameInput();
        double price = getPriceInput();
        int quantity = getQuantityInput();
        String origin = getOriginInput();

        //check if user want to continue add more fruit

        boolean isDuplicate = Validation.checkDuplicateFruit(fruitList, name, origin);
        //if input fruit is duplicate with fruit exist in list
        if (isDuplicate == true) {
            System.out.println("Duplicated!!!Cannot add!!!");
        } else {
            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruitList.add(fruit);
            System.out.println("Add sucessful!!!");
        }
        //check if user want to continue add more fruit
        if(Validation.checkYesNo("Do you want to continue (Y/N)?: ") == true){
            continue;
        }        
        else{
            displayList(fruitList);
            break;
        }
        }
    }

    //display custommer orders
    static void viewOrder(List<Order> orderList) {
        //if order list is empty
        if (orderList.isEmpty()) {
            System.out.println("Order is empty!!!");
            return;
        }
        for (Order order : orderList) {
            int total = 0;
            System.out.println("Custommer: " + order.getNameCustomer());
            System.out.println(" Product | Quantity | Price | Amount");
            for (int i = 1; i <= order.getfruitList().size(); i++) {
                System.out.printf(i + ".%-11s%-8s%-9s%-10s\n",
                order.getfruitList().get(i - 1).getFruitName(),
                order.getfruitList().get(i - 1).getQuantity(),
                order.getfruitList().get(i - 1).getPrice(),
                order.getfruitList().get(i - 1).getAmount());
                total += order.getfruitList().get(i-1).getAmount();
            }
            System.out.println("Total:" + total + "$");
            
        }
    }

    //shopping
    static void shopping(List<Fruit> fruitList, List<Order> orderList) {
        List<Fruit> invoiceList = new ArrayList<>();
        //if the list is empty
        if (fruitList.isEmpty()) {
            System.out.println("Fruit was sold out today!!!");
            return;
        }
        //loop until user stop order
        while (true) {
            //if the list is empty
            if (fruitList.isEmpty()) {
                System.out.println("Fruit was sold out today!!!");
                break;
            }
            displayList(fruitList);
            Fruit fruit;
            //call customer selects Item, loop until get item
            while (true) {
                int item = inputManager.getInt("Pleases choose item: ", " input must be digit!", 1, Integer.MAX_VALUE);
                fruit = Validation.getFruit(fruitList, item);
                //if cannot found any fruit
                if (fruit == null) {
                    System.out.println("Fruit(Item) not exist!!!");
                } else {
                    break;
                }
            }
            System.out.println("You selected " + fruit.getFruitName());

            //after choose item, call user input quanity, loop until get valid quanity
            int quanityOrder;
            while (true) {
                quanityOrder = getQuanityInput();
                //if user input quanity is larger than fruit quanity
                if (Validation.checkQuanityValidation(quanityOrder, fruit) == false) {
                    System.out.println("Quanity remaining is: " + fruit.getQuantity());
                } else {
                    break;
                }
            }

            //set quanity remaining of fruit
            fruit.setQuantity(fruit.getQuantity() - quanityOrder);
            //if that fruit quantity = 0, remove it from list
            if (fruit.getQuantity() == 0) {
                fruitList.remove(fruit);
            }

            //create order
            Fruit fruitOrder = new Fruit();
            fruitOrder.setFruitId(fruit.getFruitId());
            fruitOrder.setFruitName(fruit.getFruitName());
            fruitOrder.setQuantity(quanityOrder);
            fruitOrder.setPrice(fruit.getPrice());
            fruitOrder.setOrigin(fruit.getOrigin());

            //find fruit by id in invoicelist
            Fruit fruitCurrent = Validation.getFruit(invoiceList, fruitOrder.getFruitId());
            //if this fruit order id is already exist in list, addition the buy quanity
            if (fruitCurrent != null) {
                fruitCurrent.setQuantity(quanityOrder + fruitCurrent.getQuantity());
            } //if not ,add order to list
            else {
                invoiceList.add(fruitOrder);
            }
            //ask user if they want to create order now ?
            //if user choose no, continue the loop
            if (Validation.checkYesNo("Do you want to order now (Y/N)?: ") == false) {
                continue;
            } //if user choose yes, end the loop
            else {
                break;
            }
        }

        //call user enter their name
        displayInvoiceList(invoiceList);
        String custommer = inputManager.getString("Enter your name: ", "It must be letter or digit!", "[a-zA-Z0-9 ]+");
        orderList.add(new Order(custommer, invoiceList));

    }

    //get id from user
    public static int getIDInput(List<Fruit> fruitList) {
        while (true) {
            int id = inputManager.getInt("Enter id: ", "Id must be real number!", 0, Integer.MAX_VALUE);
            if (!Validation.checkDuplicateID(id, fruitList)) {
                return id;
            }
        }
    }

    //get name from user
    public static String getNameInput() {
        String name = inputManager.getString("Enter name: ", "It must be letter or digit!", "[a-zA-Z0-9 ]+");
        return name;
    }

    //get price from user
    public static double getPriceInput() {
        double price = inputManager.getDouble("Enter price: ", "It must be number!", 0, Double.MAX_VALUE);
        return price;
    }

    //get quanity from user
    public static int getQuantityInput() {
        int quantity = inputManager.getInt("Enter quantity: ", "It must be digit!", 0, Integer.MAX_VALUE);
        return quantity;
    }

    //get origin from user
    public static String getOriginInput() {
        String origin = inputManager.getString("Enter origin: ", "It must be letter or digit!", "[a-zA-Z0-9 ]+");
        return origin;
    }

    public static void displayList(List<Fruit> fruitList) {
        System.out.println("\n\nList of Fruit:");
        System.out.println("|++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ | ");
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }

        System.out.println("\n");

    }

    public static int getQuanityInput() {
        int quanity = inputManager.getInt("Enter quantity: ", "It must be digit", 0, Integer.MAX_VALUE);
        return quanity;
    }

    public static void displayInvoiceList(List<Fruit> invoiceList) {
        int total = 0;
        System.out.println(" Product | Quantity | Price | Amount");
        for (Fruit fruit : invoiceList) {
            total += fruit.getAmount();
            System.out.printf(" %-12s%-8s%-9s%-10s\n", fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getAmount());
        }

        System.out.println("Total:" + total + "$");
    }
}
