package map;

import list.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentMapDemo {
    public static void main(String[] args) {
        Student s1 = new Student( 101 , "Alice");
        Student s2 = new Student( 102 , "Bob");
        Student s3 = new Student( 103 , "Charlie");
        Student s4 = new Student( 104 , "David");
        Map<Integer,Student> map = new HashMap<>();
        map.put(1,s1);
        map.put(2,s2);
        map.put(3,s3);
        map.put(4,s4);
        System.out.println(map);

//        Iterate from the value -> there is two ways
//        1. get the key through keySet() method and then through that key get the values like map.get(det) (example are shown below)

        System.out.println("Using Enhance for loop");
        System.out.println("===============================");
//        We can use this enhance for each loop
        for (Integer i : map.keySet()) {
            System.out.println(i + " - " + map.get(i));
        }
        System.out.println("Using Standard way");
        System.out.println("=========================");
//        Or else you can use standard method
        Set<Integer> integers = map.keySet();
        for (Integer det : integers){
            System.out.println(det + " -> " + map.get(det));
        }
        System.out.println("=========================================");

//     2.Or else you can use entrySet() Method for both key and value
        System.out.println("Using Enhance for loop");
        System.out.println("===============================");
        for (Map.Entry<Integer, Student> integerStudentEntry : map.entrySet()) {
            System.out.println(integerStudentEntry.getKey() + " : " + integerStudentEntry.getValue());
        }
        System.out.println("Using Standard way");
        System.out.println("=========================");
        Set<Map.Entry<Integer, Student>> entries = map.entrySet();
//        using forEach method and method reference
        System.out.println("using forEach method and method reference");
        entries.forEach(System.out::println);
        System.out.println("==========================================");
        for (Map.Entry<Integer,Student>details : entries){
            System.out.println(details.getKey() + " : " + details.getValue());
        }
    }
}
