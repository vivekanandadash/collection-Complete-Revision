package list;

import java.util.Enumeration;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10); // Pushes an item onto the top of this stack. This has exactly the same effect as addElement(item)
        stk.push(20);
        stk.push(30);
        stk.push(40);

        System.out.println(stk);

        System.out.println(stk.peek()); // giving the las value from the collection
        System.out.println(stk.pop()); // Removes the object at the top of this stack and returns that object as the value of this function.
        System.out.println(stk);
        Enumeration<Integer> elements = stk.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }

    }
}
