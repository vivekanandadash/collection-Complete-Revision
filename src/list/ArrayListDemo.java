package list;

import java.util.ArrayList;
import java.util.List;

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

        List l = new ArrayList();
        l.add(100);
        l.add(200);
        l.add(300);
        l.add(100);
        l.add(400);
        l.add(100);
        l.add(1000);
        l.add(null);
        System.out.println(l);
        l.add(0,500);
        System.out.println(l);
        l.set(1,900);
        System.out.println(l);
        System.out.println(l.contains(400));
        System.out.println(l.get(1));
        System.out.println(l.size());
        System.out.println("duplicate as example 100 is twice is allowed in arraylist ::" + l);
        System.out.println("null value are also allowed ::" + l);
        System.out.println(l.indexOf(100));
        System.out.println(l.lastIndexOf(100));
        System.out.println(l);
        System.out.println(l.remove(4));
        System.out.println(l);
        System.out.println(l.indexOf(100));
        System.out.println(l.lastIndexOf(100));
        System.out.println("when the elements is not there in the collection then indexOf method returns as result :: "+l.indexOf(444));
        System.out.println(l);
//        l.clear();
        System.out.println(l);
        System.out.println(l.size());

        List l1 = new ArrayList();
        l1.add(24);
        l1.add("hari");
        l1.add(23.50);

//        Practice retain lall method
        List l2 = new ArrayList();
        l2.add(54);
        l2.add("rama");
        l2.add(85.78);

        l2.addAll(0,l1);
        System.out.println(l2);
        l2.retainAll(l1);
        System.out.println(l2);

//        Practice retain lall method

        List l3 = new ArrayList();
        l3.add(100);
        l3.add(200);
        l3.add(900);

        List l4 = new ArrayList();
        l4.add(100);
        l4.add(200);
        l4.add(600);

        l4.retainAll(l3);
        System.out.println(l3);
        System.out.println(l4);


    }
}
