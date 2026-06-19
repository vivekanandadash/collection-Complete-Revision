package map;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("zebra" ,108);
        map.put("yabura",3);
        map.put("libana",45);
        map.put("alice", 45);

        System.out.println(map);


    }
}
