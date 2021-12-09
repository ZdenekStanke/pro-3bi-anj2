package cz.spsmb.b3i.w15.trida_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        //Řazení seznamu. Použit merge sort - stejný jako quick sort O(n log n),
        // ale ponechává prvky se stejnou hodnotou v témže pořadí (tj. je stabilní):
        //přirozené řazení (metoda compareTo())
        //void sort(List<T> list)
        //absolutní řazení (metoda compare())
        //void sort(List<T> list, Comparator<? super T> c)

        List<Osoba> sez = new ArrayList<Osoba>();
        sez.add(new Osoba(186,96.5,"muz"));
        sez.add(new Osoba(172,63.0,"zena"));
        sez.add(new Osoba(105,26.1,"dite"));
        sez.add(new Osoba(116,82.5,"obezni trpaslik"));
        sez.add(new Osoba(210,94.2,"obr"));

        //Přirozené řazení - využívá metody compareTo() v dané třídě,
        //která by tak měla implementovat rozhraní Comparable
        System.out.println(sez);
        Collections.sort(sez);
        System.out.println(sez);

        //Absolutní řazení - Využíváme pomocných tříd implementující
        //rozhraní Comparator
        Collections.sort(sez, new KomparatorOsobyPodleVysky());
        System.out.println(sez);
        Collections.sort(sez, new KomparatorOsobyPodlePopisu());
        System.out.println(sez);
        Collections.sort(sez, new KomparatorOsobyPodleVahy());
        System.out.println(sez);

        //Binární vyhledávání:
        //v seřazeném seznamu lze rychle vyhledávat
        //int binarySerach(List<? extends Comparable<? super T>> list, T klic) -
        // hledání s využitím compareTo(),

        //int binarySerach(List<? extends Comparable<? super T>> list, T klic,
        // Comparator<? super T> c) - hledání pomocí externího komparátoru c.

        //Hledání mezních hodnot
        //lze využít oba typy porovnání:
        //T max(Collection<? extends T> col)
        //T max(Collection<? extends T> col, Comparator<? super T> comp)
        //T min(Collection<? extends T> col)
        //T min(Collection<? extends T> col, Comparator<? super T> comp)

        //Otočení pořadí seznamu
        //void reverse(List<?> list)

        //Zamíchání seznamu
        //void shuffle(List<?> list)
        //lze i s generátorem pseudonáhodných čísel:
        //void shuffle(List<?> list, Random rnd)

        //Četnost prvků v seznamu
        //int frequency(Collection<?> c, Object c);

        //otočení seznamu
        Collections.reverse(sez);
        System.out.println(sez);

        //Zamíchání seznamu
        Collections.shuffle(sez);
        System.out.println(sez);

        //Stačí přirozeně, compareTo() metoda zohledňuje váhu
        System.out.format("Nejlehčí: %s%n", Collections.min(sez));
        //musím použít absolutní řazení pro hlednání nejvyšší osoby
        System.out.format("Nejvyšší: %s%n", Collections.max(sez, new KomparatorOsobyPodleVysky()));

        //Naplnění seznamu daným prvkem
        Osoba robot = new Osoba(180, 75, "robot");
        Collections.fill(sez, robot);

        System.out.println("Vyplněno: " + sez);
        //Počet stejných prvků v seznamu:
        System.out.println("Počet robotů: " +
                Collections.frequency(sez, robot));

    }
}
