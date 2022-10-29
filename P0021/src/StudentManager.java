
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.ir.ContinueNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Strongest
 */
class StudentManager {

    //create a student
    public static void createStudent(List<Student> studentList) {
        //check if student list have more than 10 students
        if (studentList.size() > 10) {
            //check whether user choose yes or no
            if (!Validation.checkYesNo()) {
                return;
            }
        }
        String id = inputManager.getId();
        String name = inputManager.getStudentName(id, studentList);
        int semester = inputManager.getSemester();
        String courseName = inputManager.getCourseName();
        //check if not duplicaate then add student into list
        if (!Validation.checkDuplicate(id, semester, courseName, studentList)) {
            studentList.add(new Student(id, name, semester, courseName));
            return;
        }
    }

    //find student and sort student by matching to search input
    public static void findAndSort(List<Student> studentList) {
        String name = inputManager.getString("Enter name you want to find: ", "name must be letter!", "[a-zA-Z ]+");
        List<Student> listFound = new ArrayList<>();
        for (Student student : studentList) {
            //if student name in list contain student input name, add to listFound
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listFound.add(student);
            }
        }
        //if listfound empty, return
        if (listFound.size() == 0) {
            System.out.println("Not Found!!!");
            return;
        }
        //display student found
        displayStudent(listFound);        
        //use sort method in collection library to compare and swap between 2 student by they name
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        System.out.println("Student sort by name:");
        displayStudent(studentList);
    }

    //update or delete student in list
    public static void updateOrDelete(List<Student> studentList) {
        String id = inputManager.getId();
        //check if student already exist or not 
        if (Validation.checkStudentExist(id, studentList) == false) {
            System.out.println("Cannot found this student!");
            return;
        }
        List<Student> listFoundByID = findStudentByID(id, studentList);
        //if user choose u => true
        //else choose d => false
        if (Validation.checkUpdateOrDelete() == true) {
            updateStudent(listFoundByID, studentList);
        } else {
            deleteStudent(listFoundByID, studentList);
        }
    }

    //show report of student list
    public static void report(List<Student> studentList) {
        List<Report> reportList = new ArrayList<>();
        //loop for each student in list 
        for (Student firstStudent : studentList) {
            int total = 0;
            //loop for each student in list to check the outer loop student with every student in inner loop
            for (Student secondStudent : studentList) {
                //if outer loop student name and course match with inner student infp, then total+1
                if (firstStudent.getCourseName().equalsIgnoreCase(secondStudent.getCourseName())
                        && firstStudent.getId().equalsIgnoreCase(secondStudent.getId())) {
                    total++;
                }
            }
            //check if the student were exist in the list
            if (Validation.checkExistReport(firstStudent, reportList) == false) {
                reportList.add(new Report(firstStudent.getStudentName(), firstStudent.getCourseName(), total));
            }
        }
        for (Report report : reportList) {
            System.out.println(report);
        }
    }

    //display student list
    public static void displayStudent(List<Student> studentList) {
        System.out.println("==========================STUDENT LIST==============================");
        System.out.printf("%-10s%-20s%-10s%-10s\n", "ID", "Name", "Semester", "Course");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    //add student in list that have id match with input id to a list call "listFound"
    private static List<Student> findStudentByID(String id, List<Student> studentList) {
        List<Student> listFoundByID = new ArrayList<>();
        //loop from first to last element of listStudents
        for (Student student : studentList) {
            //if student has ID equal to id input => add that student into listFoundByID
            if (student.getId().equalsIgnoreCase(id)) {
                listFoundByID.add(student);
            }
        }
        return listFoundByID;
    }

    //call user choose a student to update
    private static void updateStudent(List<Student> listFoundByID, List<Student> studentList) {
        displayStudentUpdateList(listFoundByID);
        int choice = inputManager.inputChoice(0, listFoundByID.size() - 1);

        Student studentChoice = listFoundByID.get(choice);

        String id = inputManager.getId();
        String name = inputManager.getString("Enter name: ", "Name must be letter!", "[a-zA-Z ]+");
        int semester = inputManager.getSemester();
        String courseName = inputManager.getCourseName();

        //check if user can update this student or not
        if (Validation.checkNotUpdate(id, name, semester, courseName, studentChoice) == true) {
            System.out.println("Update has been cancel!!!");
            return;
        }
        //if id, semester, course is not equal to student in list,then update student
        if (!Validation.checkDuplicate(id, semester, courseName, studentList)) {
            studentList.get(studentList.indexOf(studentChoice)).setId(id);
            updateNameOfStudent(id, name, studentList);
            studentList.get(studentList.indexOf(studentChoice)).setSemester(semester);
            studentList.get(studentList.indexOf(studentChoice)).setCourseName(courseName);
        }
    }

    //call user choose a student to delete
    private static void deleteStudent(List<Student> listFoundByID, List<Student> studentList) {
        displayStudentUpdateList(listFoundByID);
        int choice = inputManager.inputChoice(0, listFoundByID.size() - 1);
        Student studentChoice = listFoundByID.get(choice);

        studentList.remove(studentChoice);
    }

    // update all student have have the id equal to id input
    private static void updateNameOfStudent(String id, String name, List<Student> studentList) {
        //loop from first to last element to update all name of student have id input
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.setStudentName(name);
            }
        }
    }

    //display student list found by id to update
    public static void displayStudentUpdateList(List<Student> studentList) {
        int count = 0;
        System.out.println("==========================STUDENT FOUND=================================");
        System.out.printf("%-10s %-10s%-20s%-10s%-10s\n", "Choice", "ID", "Name", "Semester", "Course");
        for (Student student : studentList) {
            System.out.printf("%-10s %-10s\n", count, student);
            count++;
        }
    }
}
