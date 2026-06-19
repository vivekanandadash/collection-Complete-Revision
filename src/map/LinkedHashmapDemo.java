package map;

import java.util.LinkedHashMap;

public class LinkedHashmapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> color = new LinkedHashMap<>();

        color.put(104 ,"Blue");
        color.put(125 ,"Yellow");
        color.put(45 ,"Green");
        color.put(78 ,"White");

        System.out.println(color);

    }
}
