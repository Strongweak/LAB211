
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
public class Main
{
    public static void main(String[] args) {                      
        //display GUI
        displayGUI();
        // call users input Data.
        Person[] input = inputPersonInfo();
        //Sort person by ascending salary
        sortBySalary(input);
        //display sorted list
        displayPersonInfo(input);
    }
    
    public static void displayGUI(){
        System.out.println("=====Management Person Programmer =====");        
    }
    
    // get input from user 
    public static Person[] inputPersonInfo(){
        // create a new array
        Person persons[] = new Person[3];            
        Person person = new Person();     
        //loop to enter data for each person in array
        for (int i = 0; i < persons.length ; i++){     
                persons[i] = person.getinputPerson(person.getName(), person.getAddress(), person.getSalary());
        }
        return persons;
    }
    
    //display input data
    public static void displayPersonInfo(Person[] persons){         
        Person person = new Person();
        //display array of person
        for (Person p: persons){    
            System.out.println("Information of Person you entered");
            person.displayPerson(p);
            System.out.println();
        }        
    }
    // sort person by salary
    private static void sortBySalary(Person[] persons) {
        //loop to access from the first to the last person of array, one person sorted after each loop
        for(int i=0; i<persons.length;i++){
            /*Loop run from first person to the person stand before the last unsorted person */
            for(int j = 0;j<persons.length - i - 1;j++){
                //Compare each pair adjacent person
                if(persons[j].getSalary() > persons[j+1].getSalary()){
                    //swap between two person
                    Person temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }                              
            }
        }           
    }

}
