package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(108,"Alice",2));
        studentList.add(new Student(105,"Evance",7));
        studentList.add(new Student(104,"Bob",4));
        studentList.add(new Student(109,"Charlie",3));
        studentList.add(new Student(101,"David",1));

        Collections.sort(studentList);
        studentList.forEach(System.out::println);
    }
}
