package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * E - představuje ve špičatých závorkách danou třídu
 * ? - představuje tzv. "žolíka", tj. libovolnou třídu
 * o - daný objekt se kterým v kolekci pracujeme
 * c - celá kolekce
 * Metody pro plnění kolekce:
 * boolean add(E o) - vložení jednoho prvku
 * boolean addAll(Collection<? extends E> c)
 *
 * Metody pro ubírání z kolekce:
 * void clear() - odstranění všech prvků z kolekce
 * boolean remove() -
 * boolean removeAll(Collection<?> c) - odstranění
 *      všech prvků nacházejících se současně v jiné kolekci.
 * boolean retainAll(Collection<?> c) - ponechání pouze prvků
 *      nacházejících se současně v jiné kolekci
 *
 * Dynamické vlastnosti kolekcí
 * int size() - vrátí aktuální počet prvků kolekce
 * boolean isEmpty()
 * boolean contains( Object o) - test, zda daný prvek je v kolekci obsažen
 * boolean containsAll(Collection<?> c) - test, zda jsou všechny
 *      prvky jiné kolekce obsaženy v této kolekci
 *
 * Získání přístupévho prvku
 * Iterator<E> iterator()
 *
 * Převod kolekce na běžné pole
 * Object[] toArray - převod na pole typu Objekt
 * <T> T[] toArray(T[] a) - převod na pole konkrétního typu
 *
 *
 */
public class RozhraniCollection {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList al = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            al.add(rnd.nextInt(10));
        }
        System.out.println(al);
        ArrayList al1 = new ArrayList<Integer>();
        al1.add(5);
        al1.add(6);
        al1.add(7);
        //al.removeAll(al1);
        al.retainAll(al1);
        //al1.addAll(al);
        System.out.println(al);
        //if(al.contains(5)){
        if(al.containsAll(al1)){
            //System.out.println("al obsahuje 5");
            System.out.println("al obsahuje 5,6 i 7");
        }
    }
}
