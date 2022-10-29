
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

    //check if user want to add a student to list have more than 10 student
    static boolean checkYesNo() {
        //[nNyY]: only return string if it String only have one letter and matches with n,N,y or Y
        String result = inputManager.getString("Do you want to continue Y/N. Choose Y "
                + "to continue, N to return "
                + "main screeen: ", "It must be Y or N", "[nNyY]");
        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    //check if input student duplicate with any student in list 
    static boolean checkDuplicate(String id, int semester, String courseName, List<Student> studentList) {
        for (Student student : studentList) {
            // if id, name, semester, and course is duplicate return true
            if (student.getId().equalsIgnoreCase(id)
                    && student.getSemester() == semester
                    && student.getCourseName().equalsIgnoreCase(courseName)) {
                System.out.println(student.getStudentName() + " was already have course " + student.getCourseName() + " and semester " + student.getSemester());
                return true;
            }
        }
        //if not return false
        return false;
    }
    
    //check if user input name of an id matches with student name have an id
    static boolean checkworngName(String id, String studentName, List<Student> studentList) {
        //loop from first element in list to lase element in list
        for (Student student : studentList) {
            //check if input id = id in list and input studentName != name in list 
            //have that id  => worng name, return true
            if (student.getId().equalsIgnoreCase(id) && student.getStudentName().equalsIgnoreCase(studentName) == false) {
                System.out.println("Id already has name: " + student.getStudentName() + ", please enter again!");
                return true;
            }
        }
        //if not wrong name, return false
        return false;
    }

    //check if what student id in list matches with input search id
    static boolean checkStudentExist(String id, List<Student> studentList) {
        for (Student student : studentList) {
            //if student id matches with id search input, return true
            if (student.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    //check if user want to update or delete the student
    static boolean checkUpdateOrDelete() {
        //[udUD]: only return string if it String only have one letter and matches with u,U,d, or D
        String result = inputManager.getString("Do you want to update (U) or delete (D)"
                + " student. Choose U to update, D to delete: ", "It must be U or D", "[uUdD]");
        //if user choose update return true
        if (result.equalsIgnoreCase("u")) {
            return true;
        }
        //if user choose delete return false
        return false;
    }
    
    //check if student can update or not
    static boolean checkNotUpdate(String id, String name, int semester, String courseName, Student studentChoice) {
        //if user input match with any student in list 
        if (studentChoice.getId().equalsIgnoreCase(id)
                && studentChoice.getStudentName().equalsIgnoreCase(name)
                && studentChoice.getSemester() == (semester)
                && studentChoice.getCourseName().equalsIgnoreCase(courseName)) {
            //return true if can not update
            return true;
        }
        return false;
    }
    //check if student exist in the list
    static boolean checkExistReport(Student firstStudent, List<Report> reportList) {
        //loop for each student in report list
        for(Report report: reportList){
            //if the student already exist in the reportlist, return true
            if(report.getName().equalsIgnoreCase(firstStudent.getStudentName()) 
                    && report.getCourse().equalsIgnoreCase(firstStudent.getCourseName())){
                return true;
            }
        }
        return false;
    }
}
