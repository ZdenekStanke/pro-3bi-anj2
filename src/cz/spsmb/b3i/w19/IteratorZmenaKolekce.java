package cz.spsmb.b3i.w19;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorZmenaKolekce {
    public static void main(String[] args) {
        ArrayList<Integer> kont = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            kont.add(Integer.valueOf(i));
        }
        Iterator<Integer> it = kont.iterator();
        System.out.println(it.next());
        kont.add(Integer.valueOf(20));
        //výjimka ConcurentModificationException při použití it.next()
        System.out.println(it.next());
    }
}
