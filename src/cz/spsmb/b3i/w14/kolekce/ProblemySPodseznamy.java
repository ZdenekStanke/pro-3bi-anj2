package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;
import java.util.List;

public class ProblemySPodseznamy {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            ar.add(Integer.valueOf(i + 100));
        }
        System.out.println("Cely seznam: " + ar);//100,101,102,103,104
        //Vytvořím-li jednou sublist, nemohu pak do původního seznamu přidávat ani
        // z něj ubírat hodnoty
        List<Integer> sl = ar.subList(2, 5);
        System.out.println("Podseznam: " + sl);//102,103,104
        System.out.println("Ubrani prvku z celeho seznamu");
        //Nelze, poškodí se sublist - výjimka ConcurrentModificationException
        //ar.remove(2);
        //Nelze, poškodí se sublist - výjimka ConcurrentModificationException
        //ar.add(2, Integer.valueOf(77));
        //toto je OK
        sl.remove(0);
        //toto je OK
        sl.add(2, Integer.valueOf(77));
        System.out.println("Cely seznam: " + ar);//100, 101, 103, 104, 77
        System.out.println("Podseznam: " + sl);//103, 104, 77
    }
}
