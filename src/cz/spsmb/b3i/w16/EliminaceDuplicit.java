package cz.spsmb.b3i.w16;

import java.util.ArrayList;
import java.util.Collection;

public class EliminaceDuplicit {
    public static void main(String[] args) {
        Collection<String> d = new ArrayList<>();
        d.add("prvni");
        d.add("druhy");
        d.add("prvni");
        System.out.println("Duplicitni: " + d);
    }
}
