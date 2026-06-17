package set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(100);
        lhs.add(200);
        lhs.add(300);
        lhs.add(null);  // Null are allowed
        lhs.add(400);
        lhs.add(500);
        lhs.add(100); // Duplicate are not allowed

        System.out.println(lhs);

        Iterator<Integer> iterator = lhs.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
