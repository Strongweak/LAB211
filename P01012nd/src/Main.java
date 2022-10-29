
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

    public static void main(String[] args) {
        List<Employee> EmployeeList = new ArrayList<>();
        Employee employee = new Employee(1,"pham", "manh","0912698911","manh@gmail.com","cao bang","5/9/2002",1,10000,"cb");
        EmployeeList.add(employee);
        Employee employee2 = new Employee(2,"tran", "kien","0123456789","kien@gmail.com","ha noi","1/2/2002",1,20000,"hn");
        EmployeeList.add(employee2);
        Employee employee3 = new Employee(3,"pham", "nhat","0912123461","nhat@gmail.com","cao bang","3/4/2002",1,50000,"cb");
        EmployeeList.add(employee3);
        Employee employee4 = new Employee(4,"long", "huong","0914698911","huong@gmail.com","cao bang","5/6/2002",1,100000,"cb");
        EmployeeList.add(employee4);     
        Employee employee5 = new Employee(5,"ly", "kien","0987654321","likien@gmail.com","hcm","4/10/2002",1,5000,"hcm");
        EmployeeList.add(employee5);          
        while (true) {
            displayMenu();
            ViewEmployee.displayList(EmployeeList);
            int option = InputManager.getInt("Enter option: ", "It must be digit", 1, 6);
            switch (option) {
                case 1:
                    //input employee
                    ViewEmployee.addEmployee(EmployeeList);
                    break;
                case 2:
                    //update employee
                    ViewEmployee.updateEmployee(EmployeeList);
                    break;
                case 3:
                    //remove employee
                    ViewEmployee.deleteEmployee(EmployeeList);
                    break;
                case 4:
                    //search
                    ViewEmployee.searchEmployee(EmployeeList);
                    break;
                case 5:
                    //sort by salary
                    ViewEmployee.sortBySalary(EmployeeList);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("====================== Menu ======================");
        System.out.println("1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit\n"
                + "");

    }

}
