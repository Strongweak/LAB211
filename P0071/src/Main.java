
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
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task("Dev program", 1,"8-4-2022", 10, 12, "Manh", "Lead"));
        //loop until user choose exit
        while (true) {
            displayInterface();
            //get choice from user
            int choice = inputManager.getInt("Enter choice: " , "Choice must be in range 1-4!", 1,4);
            switch (choice) {
                //Add Tasks
                case 1:
                    TaskManager.addTask(taskList);
                    break;
                //Delete Task
                case 2:
                    TaskManager.deleteTask(taskList);
                    break;
                //Show task
                case 3:
                    TaskManager.getDataTasks(taskList);
                    break;
                //Exit
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayInterface() {
        System.out.println("========= Task program =========");
        System.out.println(".   Add Task");
        System.out.println(".   Delete Task");
        System.out.println(".   Display Task");
        System.out.println(".   exit");
    }

}
