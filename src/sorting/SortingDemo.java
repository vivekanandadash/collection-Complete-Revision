package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(24);
        li.add(54);
        li.add(84);
        li.add(14);
        li.add(4);
        li.add(224);
        System.out.println("With out sorting : "+li);
        Collections.sort(li);
        System.out.println("After sorting :"+li);
        Collections.reverse(li);
        System.out.println("After reverse :" + li);
    }
}
