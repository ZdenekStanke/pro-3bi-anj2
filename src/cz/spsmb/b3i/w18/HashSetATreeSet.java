package cz.spsmb.b3i.w18;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetATreeSet {

    public static void naplneniATisk(Set<String> st) {
        st.add("treti");
        st.add("prvni");
        st.add("druhy");
        //pokus o vložení stejného prvku
        if (st.add("treti") == false) {
            System.out.println("prvek treti nevlozen");
        }
        System.out.println(st.size() + " " + st);
        //proiterujte st
    }
    public static void main(String[] args) {
        System.out.println("HashSet:");
        naplneniATisk(new HashSet<String>());
        System.out.println("TreeSet:");
        naplneniATisk(new TreeSet<String>());
    }

}
