
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
class TaskManager {

    //add task
    public static void addTask(List<Task> taskList) {
        String name = inputManager.getRequirementName();
        int typeID = inputManager.getTaskTypeID();
        String date = inputManager.getDateTask();
        double timeFrom = inputManager.getPlanFrom();
        double timeTo = inputManager.getPlanTo();
        String Assignee = inputManager.getAssignee();
        String Reviewer = inputManager.getReviewer();

        //check if this task is the same to any task in list
        if (!Validation.checkDuplicateTask(name, typeID, date, timeFrom, timeTo, Assignee, Reviewer, taskList)) {
            if (!Validation.checkOverlapTask(date, timeFrom, timeTo, Assignee, taskList)) {
                Task task = new Task(name, typeID, date, timeFrom, timeTo, Assignee, Reviewer);
                taskList.add(task);
                System.out.println("Add Succesful!");
            } else {
                System.out.println("Overlap Tasks!!!");
            }
        } else {
            System.out.println("This task is already exist!!!");
        }
    }

    //delete task
    public static void deleteTask(List<Task> taskList) {
        int idInput = inputManager.getIDInput();
        Task task = getTaskByID(idInput, taskList);
        //if cannot found any id in list match with user input id
        if (task == null) {
            System.out.println("Cannot found this task");
            return;
        }
        taskList.remove(task);
    }

    //display task
    public static void getDataTasks(List<Task> taskList) {
        //if there are no task in list
        if (taskList.size() == 0) {
            System.out.println("There are no task!!!");
            return;
        }
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-15s %-15s\n", "ID",
                "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    //find task by id
    private static Task getTaskByID(int idInput, List<Task> taskList) {
        for (Task task : taskList) {
            if (task.getId() == idInput) {
                return task;
            }
        }
        return null;
    }

}
