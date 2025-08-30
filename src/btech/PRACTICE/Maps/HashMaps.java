package JAVA.PRACTICE.Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String,Integer> s = new HashMap<>();
        s.put("Radhe",3);
        s.put("radhe",2);
        s.put("keshav",33);
        s.put("no",11);
        s.put("L",453);

        System.out.println(s.get(""));
        System.out.println(s.getOrDefault("Radhe",34));
        System.out.println(s.getOrDefault("Bruh",4523));
        System.out.println(s.size());
        System.out.println();
//        s.clear();
        System.out.println(s.isEmpty());
        System.out.println(s.containsKey("radhe"));
        System.out.println(s.containsValue(54));
        System.out.println();
//        s.put("no",23);
        System.out.println(s.get("no"));
//        s.remove("no");
        System.out.println(s.keySet());
        System.out.println(s.values());
//        System.out.println(s.entrySet());
        for (HashMap.Entry<String,Integer> m : s.entrySet()){
            System.out.print(m+" ");
        }
        for (Map.Entry<String,Integer> now : s.entrySet()){
            System.out.println(now);
        }
        System.out.println();

        HashMap<String , Integer> s2 = new HashMap<>();
        s2.put("Radhe",10);
        s2.put("kento",10);
        s2.put("rohit",10);

        System.out.println(s.entrySet().equals(s2.entrySet()));
        Map<String, Integer> map = new LinkedHashMap<>();
        Map ma = new HashMap<>();

        System.out.println(s.entrySet());
        System.out.println(s);

    }
}
