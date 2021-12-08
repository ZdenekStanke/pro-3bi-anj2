package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class KolekceNaPole {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("prvni");
        c.add("druhy");
        c.add("prvni");
        System.out.println("kolekce:    "+c);
        //Vlastní převod nějaké kolekce na pole objektů:
        Object[] o = c.toArray();
        System.out.println("Object:     "+ Arrays.toString(o));
        //Nelze, ClassCastException
        //String[] s = (String[]) c.toArray();
        String[] s1 = c.toArray(new String[0]);
        System.out.println("s1 pomoci c.toArray(new String[0]) "+ Arrays.toString(s1));
        String[] s2 = c.toArray(new String[c.size()]);
        System.out.println("s2 pomoci c.toArray(new String[c.size()]) "+ Arrays.toString(s2));
        String[] s3 = c.toArray(new String[c.size()+2]);
        System.out.println("s3 pomoci c.toArray(new String[c.size()+2]) "+ Arrays.toString(s3));

    }
}
