
import java.util.ArrayList;
import java.util.List;
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
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("1", "Vu Ha", 2, "C"));
        studentList.add(new Student("2", "Mai Anh", 1, "C++"));
        studentList.add(new Student("3", "Hong Huy", 3, "c"));
        studentList.add(new Student("4", "Tran Minh", 3, "java"));
        studentList.add(new Student("1", "Vu Ha", 3, "java"));
        studentList.add(new Student("3", "Hong Huy", 1, "c++"));
        studentList.add(new Student("3", "Hong Huy", 2, ".net"));
        studentList.add(new Student("5", "Ha Anh", 1, "java"));
        studentList.add(new Student("4", "Tran Minh", 1, "java"));
        //loop until user choose exit
        while (true) {
            //display user interface
            displayInterface();
            StudentManager.displayStudent(studentList);
            int choice = inputManager.inputChoice(1, 5);
            switch (choice) {
                case 1:
                    // user creates student by inputting information from keyboard
                    StudentManager.createStudent(studentList);
                    break;
                case 2:
                    //Find and list student (by name) and sort by name
                    StudentManager.findAndSort(studentList);
                    break;
                case 3:
                    //find a student by ID
                    StudentManager.updateOrDelete(studentList);
                    break;
                case 4:
                    //display student(s) with total Courses of this student
                    StudentManager.report(studentList);
                    break;
                case 5:
                    //exit the program
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayInterface() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to"
                + " Update/Delete, 4 to Report and 5 to Exit program).");
    }
}
