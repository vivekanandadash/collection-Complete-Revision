package failFastAndFailSafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FailFastWithHashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Alice");
        map.put(2,"Bob");
        map.put(3,"Charlie");
       map.forEach((k,v)-> System.out.println("Key :" +k + " -> " +"Value :" + v));

        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            map.put(4,"David");

        }
    }
}
