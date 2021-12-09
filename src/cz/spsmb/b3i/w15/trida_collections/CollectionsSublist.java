package cz.spsmb.b3i.w15.trida_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSublist {
    public static void main(String[] args) {
        String[] vse = {"1", "2", "3", "1", "2", "3" };
        String[] cast = {"2", "3"};
        List<String> list = Arrays.asList(vse);
        System.out.println(list);
        List<String> subList = Arrays.asList(cast);
        //Hledání podseznamu
        int prvni = Collections.indexOfSubList(list, subList);
        int posledni = Collections.lastIndexOfSubList(list, subList);
        System.out.format("%s je na %d. pozici%n", subList, prvni);
        System.out.format("%s je na %d. posledni pozici%n", subList, posledni);
    }
}
