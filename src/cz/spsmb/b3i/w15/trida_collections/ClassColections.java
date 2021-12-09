package cz.spsmb.b3i.w15.trida_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Obdoba třídy Arrays, která obsahuje statické metody pro práci s poli. Třída Collections
//obdobně funguje pro kolekce.
//Collection - rozhraní, které implementuje každá třída kolekcí
//Collections - třída se statickými metodami pro práci s kolekcemi
public class ClassColections {
    public static void main(String[] args) {


        //Plnění seznamu
        //void fill(List<? super T> list, T obj) - Hodnoty všech prvků seznamu nahradí
        //hodnotou obj
        List<String> ar = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            ar.add("");
        }
        System.out.println(ar);
        Collections.fill(ar, "hodnota");
        System.out.println(ar);
    }
}
