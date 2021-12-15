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
        System.out.println("Seznam pozpatku: [");
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            System.out.println(it.previous() + ", ");
        }
        System.out.println();
    }
}
