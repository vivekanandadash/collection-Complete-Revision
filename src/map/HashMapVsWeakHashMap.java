package map;

import java.util.WeakHashMap;

public class HashMapVsWeakHashMap {
    public static void main(String[] args) {
        WeakHashMap<Integer,String> whm = new WeakHashMap<>();
        whm.put(1,"Alice");
        whm.put(2,"Bob");
        whm.put(3,"charlie");
        System.out.println(whm);



    }
}
