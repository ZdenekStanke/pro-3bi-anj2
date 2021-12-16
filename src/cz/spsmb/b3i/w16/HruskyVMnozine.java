package cz.spsmb.b3i.w16;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HruskyVMnozine {
    static void praceSHruskami (String typ, Set<Hruska> st){
        for (int i = 20; i < 30; i++) {
            st.add(new Hruska(i));
        }
        //pokus o duplikaci Hrusky v mnozine
        st.add(new Hruska(25));
        System.out.print(typ + "-pocet: "+st.size()+" [");
        for (Hruska h: st) {
            System.out.print(h+", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        praceSHruskami("HashSet", new HashSet<Hruska>());
        praceSHruskami("HashSet", new TreeSet<Hruska>());
    }
}