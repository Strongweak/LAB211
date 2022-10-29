
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Person {
    private String name;
    private String address;
    private double salary;
    
    public Person(){
        
    }
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }     
    // display interface and accept input from user
    public Person getinputPerson (String name, String address, Double salary){       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Information of Person");       
        //use regex to checking format
        //[a-zA-Z ]: matches with character in range of "a" to "z" and "A" to "Z" and SPACE character 
        // + : match as many time as posible
        name = InputManager.getInputString("Please input name:","Input must be letter","[a-zA-Z ]+");
        address = InputManager.getInputString("Please input address:","Input must be letter","[a-zA-Z ]+");
        System.out.print("Please input salary:");
        salary = InputManager.getInputSalary();
        return new Person(name,address,salary);     
    }
    //Display input data
    public void displayPerson(Person persons) {
        
        System.out.println("Name: " + persons.getName());
        System.out.println("Address: " + persons.getAddress());
        System.out.println("Salary: " + persons.getSalary());    
    }           
}
