package list;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vctr = new Vector<>();
        vctr.add(10);
        vctr.add(20);
        vctr.add(30);
        vctr.add(40);

        Enumeration<Integer> elements = vctr.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }
}
