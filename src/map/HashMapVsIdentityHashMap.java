package map;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class HashMapVsConcurrentHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Alice" , 101);
        map.put("Bob" , 102);
        map.put("Charlie" , 103);
        map.put("David" , 104);
        map.put(new String("Alice") , 105);

        System.out.println("Size ::"+ map.size());
        System.out.println(map);

        System.out.println("====================================================");

        IdentityHashMap<String , Integer> ihm = new IdentityHashMap<>();
        ihm.put("Alice" , 101);
        ihm.put("Bob" , 102);
        ihm.put("Charlie" , 103);
        ihm.put("David" , 104);
        ihm.put(new String("Alice") , 105);

        System.out.println("Size ::"+ ihm.size());
        System.out.println(ihm);

    }
}
