package queue;

import java.util.ArrayDeque;

public class ArrayDequeueDemo {
    public static void main(String[] args) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.add("one");
        ad.add("two");
        ad.add("three");
        ad.addFirst("vivek");
        ad.addLast("gudulu");
        System.out.println(ad);

        ad.pollFirst();

        System.out.println(ad);
        ad.pollLast();
        System.out.println(ad);
    }
}
