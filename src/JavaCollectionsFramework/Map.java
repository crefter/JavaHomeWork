package JavaCollectionsFramework;

import java.util.HashMap;

public class Map {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        hashMap.put("Aloha", 8500);
        hashMap.put("No[one]", 9000);
        hashMap.put("Miracle~", 10000);

        System.out.println(hashMap);
        System.out.println(hashMap.get("Miracle~"));
    }
}
