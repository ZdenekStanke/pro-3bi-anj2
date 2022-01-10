package cz.spsmb.b3i.w19;

import java.util.*;

// Pouze ve třídě LinkedHashMap je dodrženo pořadí vkládaných prvků:
public class TridaLinkedHashMap {
    static void nastaveniATisk(Map<String, String> m) {
        String[] pole = {"1", "6", "2", "5", "4", "3"};
        for (int i = 0; i < pole.length; i++){
            m.put(pole[i], "A");
        }
        System.out.println(m.getClass().getName() + ":\t" + m);
    }

    public static void main(String[] args) {
        nastaveniATisk(new HashMap<String, String>());
        nastaveniATisk(new TreeMap<String, String>());
        nastaveniATisk(new LinkedHashMap<String, String>());
    }
}
