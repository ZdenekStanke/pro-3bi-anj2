package cz.spsmb.b3i.w19;

//Třída TreeMap se používá tehdy, potřebujeme-li mít klíče v mapě seřazené. Seřazení
//klíčů je nezbytné, kdy potřebujeme z mapy získat:
// - největší, či nejmenší klíč,
// - "podmapu" v závislosti na hodnotě klíče.

// Object firstKey() - vrací nejmenší klíč (první v pořadí)
// Object lastKey() - vrací největší klíč (poslední v pořadí)
// přirozený způsob řazení:
// Třída musí implementovat rozhraní Comparable
// absolutní způsob řazení:
// Rozhoduje použitý komparátor, metodou Comparator comparator() se dá zjistit,
// jaký komparátor je aktuálně použit. Voláním konstruktoru
// TreeMap(Comparator<? super K> c) komparátor pro absolutní řazení nastavíme

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

//Další metody ve třídě TreeMap:
// SortedMap<K,V> headMap(K doKlice) - vrací podmapu, pro kterou platí, že klíče jsou
// ostře menší než daný klíč.
// SortedMap<K,V> tailMap(K odKliceVcetne) - vrací podmapu, pro kterou platí, že klíče jsou
// větší, nebo rovny danému klíči.
// SortedMap<K,V> subMap(K odKliceVcetne, K doKlice) - umožňuje získat podmapu
// "z prostředka" stávající mapy.
class VahaKlic implements Comparable<VahaKlic> {
    double vaha;

    public VahaKlic(double vaha) {
        this.vaha = vaha;
    }

    @Override
    public int compareTo(VahaKlic o) {
        return ((int) (this.vaha - o.vaha));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //standardně vygenerováno pomocí IntelliJ
        //if (o == null || getClass() != o.getClass()) return false;
        //naše varianta, respektující i potomky z třídy VahaKlic:
        if (o instanceof VahaKlic == false) return false;
        VahaKlic vahaKlic = (VahaKlic) o;
        return Double.compare(vahaKlic.vaha, vaha) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaha);
    }
}
class VahovyKomparator implements Comparator<VahaKlic> {
    @Override
    public int compare(VahaKlic o1, VahaKlic o2) {
        return (int) (o1.vaha - o2.vaha);
    }
}
public class ClassTreeMapUvod {
    static void praceSMapou(TreeMap<VahaKlic, String> tm) {
        String s;
        Comparator<? super VahaKlic> c = tm.comparator();
        if(c == null) {
            s = "prirozene razeni";
        } else {
            s = c.getClass().getName();
        }
        System.out.println("Komparator: " + s);

        tm.put(new VahaKlic(85), "Pavel");
        tm.put(new VahaKlic(105), "Venca");
        tm.put(new VahaKlic(74), "Karel");
        System.out.println("Mapa: " + tm);
        VahaKlic v = tm.lastKey();
        System.out.println("Nejvice Vazi: " + v + "=" +tm.get(v));
        SortedMap<VahaKlic, String> pom = tm.tailMap(new VahaKlic(85));
        System.out.println("Dva nejtezsi: " + pom + "\n");
    }
    public static void main(String[] args) {
        praceSMapou(new TreeMap<VahaKlic, String>());
        praceSMapou(new TreeMap<VahaKlic, String>(new VahovyKomparator()));
    }
}
