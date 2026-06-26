package failFastAndFailSafe;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> al = new CopyOnWriteArrayList<>();
        al.add(100);
        al.add(200);
        al.add(300);
        al.add(400);

        for (Integer num : al){
            if (num == 200){
                al.add(500);
            }
        }
        System.out.println(al);
    }
}
