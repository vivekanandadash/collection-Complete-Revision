package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

//        Use direct Anonymous Implementation
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.salary > e2.salary){
                    return -1;
                } else if (e1.salary < e2.salary) {
                    return 1;
                }else {
                    return 0;
                }


            }

        });


//         COMPARE BY NAME
//        employees.sort(new EmployeeNameComparator());
        employees.forEach(System.out::println);
    }
}
