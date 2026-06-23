package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "charlie", 46000.00));
        employees.add(new Employee(240, "victor", 54000.00));
        employees.add(new Employee(147, "levis", 58000.00));
        employees.add(new Employee(79, "johnson", 74000.00));
        employees.add(new Employee(87, "watson", 41000.00));

//        COMPARE BY ID
        Collections.sort(employees, new EmployeeIdComparator());
//        We can use directly sort method like below
//        employees.sort(new EmployeeIdComparator());

//         COMPARE BY NAME
        employees.sort(new EmployeeNameComparator());
        employees.forEach(System.out::println);
    }
}
