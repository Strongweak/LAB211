
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
public class EmployeeManager {

    //get employee by id
    public static Employee getEmployeeByID(List<Employee> employeeList ,int id) {
        //loop run from first to last element of listEmployees
        for (Employee employee : employeeList) {
            //if duplicate id => return Employee has existed
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    //check duplicate employee
    public static boolean checkDuplicate(String firstName, String lastName,
            String phone, String email, String address, String dob, int sex,
            double salary, String agency,List<Employee> employeeList) {
        //loop run from first to last element of listEmployees
        for (Employee e : employeeList) {
            //check duplicate
            if (e.getPhone().equalsIgnoreCase(phone)
                    && e.getEmail().equalsIgnoreCase(email)
                    && e.getFirstName().equalsIgnoreCase(firstName)
                    && e.getLastName().equalsIgnoreCase(lastName)
                    && e.getDob().equalsIgnoreCase(dob)
                    && e.getSalary()== salary
                    && e.getAddress().equalsIgnoreCase(address)
                    && e.getSexInt()== sex
                    && e.getAgency().equalsIgnoreCase(agency)
                    ) {
                return true;
            }

        }
        return false;

    }
    
    public Employee getEmployeeByName(String name, List<Employee> employeeList) {
        //loop run from first to last element in listEmployees
        for (Employee employee : employeeList) {
            if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                return employee;
            }
        }
        return null;
    }

    public static void updateEmployee(int idUpdate, String firstName, String lastName,
            String phone, String email, String address, String dob, int sex,
            double salary, String agency, Employee employee) {
        employee.setId(idUpdate);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setDob(dob);
        employee.setSex(sex);
        employee.setSalary(salary);
        employee.setAgency(agency);

    }
    public static List<Employee> findEmployeeByName(String name,List<Employee> employeeList) {
        String fullName;
        List<Employee> listSearch = new ArrayList<>();
        //loop run from first to last element in listEmployees
        for (Employee employee : employeeList) {
            
            
            //compare name to find Employee by name then add to listSearch
            if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(employee);
            }
            
        }
        return listSearch.isEmpty() ? null : listSearch;

    }

    public static List<Employee> sortBySalary(List<Employee> employeeList) {
        List<Employee> listSort = new ArrayList<>();
        listSort.addAll(employeeList);

        if (listSort.isEmpty()) {
            return null;
        }

        return listSort;
    }
    
}
