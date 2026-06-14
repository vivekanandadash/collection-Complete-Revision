package list;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> al = new ArrayList<>();
        al.add(24);
        al.add(200);
        al.add("Rama");
        al.add("Hari");
        al.add(25.02);
        System.out.println(al);
        System.out.println("Size of the Collections ::" + al.size());
        al.remove(0);
        System.out.println("Size of the Collections ::" + al.size());
        System.out.println(al);
    }
}
