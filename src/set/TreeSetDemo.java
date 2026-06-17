package set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(84);
        ts.add(54);
        ts.add(44);
        ts.add(74);

        Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(ts);
    }
}
