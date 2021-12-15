package cz.spsmb.b3i.w15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

//Tato třída narozdíl od klasické Iterator obsahuje i metody
// boolean hasPrevious() a E previous(). Ty umožňují i pohyb od konce seznamu na
// jeho začátek pomocí iterátoru.
public class TestListIterator {
    public static void main(String[] args) {
        String[] tmp = {"1", "2", "3", "4", "5"};
        List<String> list = new ArrayList<>(Arrays.asList(tmp));
        System.out.println("Seznam:       " + list);
        System.out.print("Seznam pozpatku: [");
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            System.out.print(it.previous() + (it.hasPrevious() ? ", ":""));
        }
        System.out.println("]");
       System.out.print("Seznam dopředu: [");
        for (ListIterator<String> it = list.listIterator(); it.hasNext(); ) {
            System.out.print(it.next() + (it.hasNext() ? ", ":""));
        }
        System.out.println("]");
    }
}
