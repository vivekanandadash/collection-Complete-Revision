package failFastAndFailSafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeWithConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer ,String> map = new ConcurrentHashMap<>();
        map.put(1,"Alice");
        map.put(2,"Bob");
        map.put(3,"Charlie");

        ConcurrentHashMap.KeySetView<Integer, String> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            map.put(4 , "David");
        }

        System.out.println(map);
    }
}
