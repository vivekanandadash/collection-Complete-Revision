package set;

import list.Student;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("one");
        hs.add("two");
        hs.add("three");
        hs.add("four");
        hs.add("one");
        hs.add(null);

        System.out.println(hs);
        hs.remove("four");
        System.out.println(hs);

        Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        HashSet<Student> students = new HashSet<>();
        students.add(new Student(201,"Alice"));
        students.add(new Student(202,"Bob"));
        students.add(new Student(203,"Charlie"));
        Iterator<Student> iterator1 = students.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
