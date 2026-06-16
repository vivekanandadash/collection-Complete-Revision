package list;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);

        System.out.println(ll);
        ll.add(1,15); // In linkedList insertion and deletion the data is recommended
        System.out.println(ll);
        System.out.println(ll.get(4)); // In linkedList retrieving the data is an expensive task , so it would be avoided
        System.out.println(ll.getLast());
    }
}
