/*
lists are abstract data types
normally for abstract data types there is an interface involved
abstract data types don't dictate how data is organized
dictates the operations you can perform
concrete data structure is usually a concrete class
abstract data type is usually an interface
 */


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

//        employeeList.forEach(employee -> System.out.println(employee));
//
//        System.out.println(employeeList.get(1));
//
//        System.out.println(employeeList.isEmpty());

        //replacing the name of an employee, first parameter is the index of the employee
        employeeList.set(1, new Employee("John", "Adams", 4568));
        //employeeList.forEach(employee -> System.out.println(employee));

        //System.out.println(employeeList.size());

        employeeList.add(3, new Employee("John", "Doe", 4567));
        //employeeList.forEach(employee -> System.out.println(employee));

        //here we will be returning an object instead of an array list
//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee: employeeArray) {
//            System.out.println(employee);
//        }

        // this method just checks if they are exactly the same instance
        //because that is what the default equals method does
        //for it to compare the individual fields against eachother we need to employ =
        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));

        //looking for an employee based off of their index
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));

        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));

    }
}
