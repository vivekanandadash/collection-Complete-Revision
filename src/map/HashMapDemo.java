package map;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(100,"Alice");
        map.put(101,"Bob");
        map.put(103,"charlie");
        map.put(104,"David");
        map.put(100,"Anthony");

        System.out.println("Size of the map :: "+ map.size());
        System.out.println(map.containsKey(103));
        System.out.println(map.containsKey(102));
        System.out.println(map.isEmpty());
        System.out.println(map);

        Set<Integer> integers = map.keySet();
        for (Integer key : integers){
            System.out.print(key + " - ");
            System.out.println(map.get(key));
        }
//        map.clear();
//        System.out.println(map.size());
        System.out.println(map.get(300)); // when the given key is not available the get method will return the null value

        Collection<String> values = map.values();
        for (String v : values){
            System.out.println(v);
        }

        System.out.println("===================================");
//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, String> next = iterator.next();
//            System.out.println(next);
//        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer ,String> ent : entries){
            System.out.println(ent);
        }
        HashMap<Integer, String> trail = new HashMap<>();

        trail.put(7, "david");
        trail.put(1, "jaga");
        trail.put(5, "bob");
        trail.put(3, "subhadra");
        trail.put(2, "balia");

        System.out.println(trail);
    }
}
