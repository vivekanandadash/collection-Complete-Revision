package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentObj {
    public static void main(String[] args) {
        List<Student> lst = new ArrayList<>();
        lst.add(new Student(1, "Rama"));
        lst.add(new Student(2, "Hari"));
        lst.add(new Student(3, "Krushna"));

//        when we want userInput we can use Scanner class like bellow
        Scanner s = new Scanner(System.in);
        int id = s.nextInt();
        String name = s.next();
        lst.add(new Student(id,name));

        id = s.nextInt();
        name = s.next();
        lst.add(new Student(id , name));

         id = s.nextInt();
        name = s.next();
        lst.add(new Student(id , name));

        s.close();
//
//        for (int i = 0 ; i < lst.size() ; i++){
//            System.out.println(lst.get(i));
//        }
//        lst.forEach(System.out::println);

        ListIterator<Student> studentListIterator = lst.listIterator();
        while (studentListIterator.hasNext()){
            System.out.println(studentListIterator.next());
        }
        System.out.println("====================================================");

        while (studentListIterator.hasPrevious()){
            System.out.println(studentListIterator.previous());
        }

//        for only print the collection object in backword the logic will be
//        while (studentListIterator.hasNext()){
//            studentListIterator.next();
//        }
//        System.out.println("====================================================");
//
//        while (studentListIterator.hasPrevious()){
//            System.out.println(studentListIterator.previous());
//        }
    }
}
