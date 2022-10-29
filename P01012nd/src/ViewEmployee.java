
import java.util.Collections;
import java.util.Comparator;
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
class ViewEmployee {

    public static void addEmployee(List<Employee> EmployeeList) {
        int id = InputManager.getID(EmployeeList);
        String firstName = InputManager.getFirstName();
        String lastName = InputManager.getLastName();
        String phone = InputManager.getPhone();
        String email = InputManager.getEmail();
        String address = InputManager.getAddress();
        String dob = InputManager.getDOB();
        int sex = InputManager.getSex();
        double salary = InputManager.getSalary();
        String agency = InputManager.getAgency();

        Employee employee = new Employee(id, firstName, lastName, phone,
                email, address, dob, sex, salary, agency);
        if (EmployeeManager.checkDuplicate(firstName, lastName, phone, email, address, dob, sex, salary, agency, EmployeeList) == true) {
            System.out.println("Duplicated!!!");
        } else {
            EmployeeList.add(employee);
        }
        displayList(EmployeeList);
    }
    //update employee
    public static void updateEmployee(List<Employee> EmployeeList) {
        String firstName;
        String lastName;
        String phone;
        String email;
        String address;
        String dob;
        int sex;
        double salary;
        String agency;
        displayList(EmployeeList);
        int idFind = InputManager.getInt("Enter id: ", "It must be digit", 0, Integer.MAX_VALUE);
        Employee employee = EmployeeManager.getEmployeeByID(EmployeeList, idFind);
        if (employee == null) {
            System.out.println("NOT FOUND ID");
            return;
        }

        int idUpdate;
        //check update ID, true => update
        while (true) {

            if (InputManager.checkWantToUpdate("id") == true) {
                idUpdate = InputManager.getID(EmployeeList);
                //check employee has ID, !null => duplicate
                if (EmployeeManager.getEmployeeByID(EmployeeList, idUpdate) != null) {
                    System.out.println("DUPLICATE ID");
                } else {
                    employee.setId(idUpdate);
                    break;
                }
            } else {
                idUpdate = employee.getId();
                break;
            }
        }
        if (InputManager.checkWantToUpdate("update") == true) {
            //check update first name, true => update
            if (InputManager.checkWantToUpdate("first name") == true) {
                firstName = InputManager.getFirstName();
            } else {
                firstName = employee.getFirstName();
            }

            //check update last name, true => update
            if (InputManager.checkWantToUpdate("lastName") == true) {
                lastName = InputManager.getLastName();
            } else {
                lastName = employee.getLastName();
            }

            //check update phone, true => update
            if (InputManager.checkWantToUpdate("phone") == true) {
                phone = InputManager.getPhone();
            } else {
                phone = employee.getPhone();
            }

            //check update email, true => update
            if (InputManager.checkWantToUpdate("email") == true) {
                email = InputManager.getEmail();
            } else {
                email = employee.getEmail();
            }

            //check update address, true => update
            if (InputManager.checkWantToUpdate("address") == true) {
                address = InputManager.getAddress();
            } else {
                address = employee.getAddress();
            }
            //check update DOB, true => update
            if (InputManager.checkWantToUpdate("dob") == true) {
                dob = InputManager.getDOB();
            } else {
                dob = employee.getDob();
            }
            //check update sex, true => update
            if (InputManager.checkWantToUpdate("sex") == true) {
                sex = InputManager.getSex();
            } else {
                sex = employee.getSexInt();
            }
            //check update salary, true => update
            if (InputManager.checkWantToUpdate("salary") == true) {
                salary = InputManager.getSalary();
            } else {
                salary = employee.getSalary();
            }
            //check update agency, true => update
            if (InputManager.checkWantToUpdate("agency") == true) {
                agency = InputManager.getAgency();
            } else {
                agency = employee.getAgency();
            }
            //if user didnt change data of a employee
            if (EmployeeManager.checkDuplicate(firstName, lastName, phone, email, address, dob, sex, salary, agency, EmployeeList) == true) {
                System.out.println("Duplicated!!!");
            } else {
                EmployeeManager.updateEmployee(idUpdate, firstName, lastName, phone, email, address,
                        dob, sex, salary, agency, employee);
                System.out.println("UPDATE SUCCESSFULL");
            }
            displayList(EmployeeList);
        } else {
            System.out.println("Cancel!!!");
            return;
        }
    }
    //delete employee
    public static void deleteEmployee(List<Employee> EmployeeList) {
        displayList(EmployeeList);
        int id = InputManager.getInt("Enter id: ", "It must be digit", 0, Integer.MAX_VALUE);
        Employee employee = EmployeeManager.getEmployeeByID(EmployeeList, id);

        if (employee == null) {
            System.out.println("NOT FOUND");
            return;
        }

        EmployeeList.remove(employee);
        System.out.println("REMOVE SUCCESSFULL");

    }
    //search employee
    public static void searchEmployee(List<Employee> employeeList) {
        String name = InputManager.getString("Enter name: ", "It must be string!!", "[a-zA-Z]+");

        List<Employee> listfound = EmployeeManager.findEmployeeByName(name, employeeList);
        if (listfound == null) {
            System.out.println("NOT FOUND !!");
        } else {
            displayList(listfound);
        }

    }

    //sort by salary
    public static void sortBySalary(List<Employee> EmployeeList) {
        Collections.sort(EmployeeList, new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(),(o1.getSalary()));
            }
        });
        if (EmployeeList == null) {
            System.out.println("NO EMPLOYEE IN LIST");
            return;
        } else {
            System.out.println("Done!!!");
            displayList(EmployeeList);
        }

    }
    //display list
    public static void displayList(List<Employee> EmployeeList) {
        System.out.println("=====================================Employee list=======================================");
        System.out.printf("%-5s %-20s %-20s %-20s %-20s %-20s %-20s %-2s %-20s \n", "id", "firstName " + "lastName", "phone", "email", "address", "dob", "Sex", "salary", "agency");
        for (Employee e : EmployeeList) {
            System.out.println(e);
        }
    }
}
