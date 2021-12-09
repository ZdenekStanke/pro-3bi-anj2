package cz.spsmb.b3i.w15.trida_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSwap {
    public static void main(String[] args) {
        Integer[] vse = {1, 2, 3, 4, 5, 6 };
        List<Integer> list = Arrays.asList(vse);
        System.out.format("Puvodni:            %s%n", list);
        Collections.swap(list, 2,5);
        System.out.format("Po vymene:          %s%n", list);
        //NELZE, výjimka ArrayIndexOutOfBoundsException
        Collections.swap(list, 0,20);
        System.out.format("Po vymene:          %s%n", list);
    }
}
