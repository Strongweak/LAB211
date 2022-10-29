
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //check if date is valid
    public static boolean isValidDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateTest = null;
        dateFormat.setLenient(false);
        try {
            dateTest = dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    //check between current date with input date
    public static boolean checkInputDateWithtodayDate(String dateInput, String currentDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date firstDate;
        Date secondDate;
        try {
            firstDate = dateFormat.parse(dateInput);
            secondDate = dateFormat.parse(currentDate);
            //if first date before second date => return true
            if (firstDate.before(secondDate)) {
                return true;
            }
            //if first date equal second date = > return true           
            else if(firstDate.equals(secondDate)) {
                return true;
            }
            //if first date after second date => return false            
            else{
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }
    }

    //check overlap task
    static boolean checkOverlapTask(String date, double timeFrom, double timeTo, String assignee, List<Task> taskList) {
        //loop for each task in list
        for (Task task : taskList) {
            //if input task have the same day as task in list and two task have the same assignee, process to check overlap
            if (task.getDate().equalsIgnoreCase(date) && task.getAssignee().equalsIgnoreCase(assignee)) {
                //if input timefrom appear in between timefrom and timeto in list
                //-------------[   task   ]-------------
                //--------------{~~~~~~~~{input}-------------
                if (timeFrom > task.getFrom() && timeFrom < task.getTo()) {
                    return true;
                }
                //if input timeto appear in between timefrom and timeto in list
                //------------[   task   ]-------------
                //----{  input }~~~~~~~~~}-------------
                if (timeTo > task.getFrom() && timeTo < task.getTo()) {
                    return true;
                }
                //if timefrom timeto of task in list is between input timefrom and to
                //-------------[ task]-------------
                //---------{~~~{input}~~~}---------
                if (timeFrom<= task.getFrom() && timeTo >= task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    //check duplicate task
    static boolean checkDuplicateTask(String name, int typeID, String date, double timeFrom, double timeTo, String Assignee, String Reviewer, List<Task> taskList) {
        for (Task task : taskList) {
            //if all input from user match with task in list
            if (task.getName().equalsIgnoreCase(name)
                    && task.getTaskTypeID() == typeID
                    && task.getDate().equalsIgnoreCase(date)
                    && task.getFrom() == timeFrom
                    && task.getTo() == timeTo
                    && task.getAssignee().equalsIgnoreCase(Assignee)
                    && task.Reviewer.equalsIgnoreCase(Reviewer)) {
                return true;
            }
        }
        return false;
    }

}
