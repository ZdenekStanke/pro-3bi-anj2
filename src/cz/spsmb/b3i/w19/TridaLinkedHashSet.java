package cz.spsmb.b3i.w19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

// Potřebujeme-li  zachovat pořadí prvků do množiny vkládaných, je možné použít právě třídu
//LinkedHashSet, resp. LinkedHashMap.
public class TridaLinkedHashSet {
    public static void main(String[] args) {
        String[] pole = {"1", "6", "2", "5", "4", "3"};
        HashSet<String> hs = new HashSet<>(Arrays.asList(pole));
        TreeSet<String> ts = new TreeSet<>(Arrays.asList(pole));
        LinkedHashSet<String> lhs = new LinkedHashSet<>(Arrays.asList(pole));
        System.out.println("Original:     " + Arrays.toString(pole));
        System.out.println("HashSet:      " + hs);
        System.out.println("TreeSet:      " + ts);
        System.out.println("LinkedHashSet:" + lhs);
    }
}
