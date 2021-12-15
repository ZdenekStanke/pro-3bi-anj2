package cz.spsmb.b3i.w15;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetATreeset {
    public static void naplneniATisk(Set<String> st) {
        st.add("treti");
        st.add("prvni");
        st.add("druhy");
        //pokus o vložení stejného prvku
        if(st.add("treti") == false){
            System.out.println("prvek treti nevlozen");
        }
        System.out.println(st.size() + " " +st);
        for (String s: st) {
            System.out.print(s + ", ");
        }
        if(st.contains("treti")) {
            System.out.println("\n'treti' je v mnozine");
        }
        st.remove("treti");
        System.out.println(st);
        st.clear();
    }
    public static void main(String[] args) {
        System.out.println("HashSet:");
        naplneniATisk(new HashSet<String>());
        System.out.println("TreeSet:");
        naplneniATisk(new TreeSet<String>());
    }
}
