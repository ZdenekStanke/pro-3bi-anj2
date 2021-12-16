package cz.spsmb.b3i.w16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class EliminaceDuplicit {
    public static void main(String[] args) {
        Collection<String> d = new ArrayList<>();
        d.add("prvni");
        d.add("druhy");
        d.add("prvni");
        System.out.println("Duplicitni: " + d);
        Collection<String> nd = new ArrayList<>(new HashSet<>(d));
        System.out.println("NeDuplicitni: " + nd);
    }
}
