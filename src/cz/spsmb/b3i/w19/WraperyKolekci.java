package cz.spsmb.b3i.w19;
//kolekce dávají k dispozici 3 druhy tzv. wraperů
//Synchronizační wraper:
//využívá se k synchronizaci vláken
// Collection<T> synchronizedCollection(Collection<T> c);
// Set<T> synchronizedSet(Set<T> s);
// List<T> synchronizedList(List<T> list);
// Map<K, V> synchronizedMap(Map<K, V> m);
// SortedSet<T> synchronizedSortedSet(SortedSet<T> s);
// SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m);

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Neměnitelný wraper
//použijeme, pokud potřebujeme vytvořit kolekci a dále jí nemodifikovat
// Collection<T> unmodifiableCollection(Collection<T> c);
// Set<T> unmodifiableSet(Set<T> s);
// List<T> unmodifiableList(List<T> list);
// Map<K, V> unmodifiableMap(Map<K, V> m);
// SortedSet<T> unmodifiableSortedSet(SortedSet<T> s);
// SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, V> m);

//Singleton wraper
// Set<T> Singleton(T o);
// List<T> singletonList(Y o);
// Map<K, V> singletonMap(K key, V value);
public class WraperyKolekci {
    public static void unmodified(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(5));
        List<Integer> readOnlyList = Collections.unmodifiableList(list);
        //teď už opravdu není cesta, jak zapisovat
        list = null;
        System.out.println(readOnlyList);
        //nelze, pouze pro čtení. Výjimka UnsupportedOperationException
        readOnlyList.add(Integer.valueOf(5));
    }
    public static void singleton(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5", "2");
        System.out.println(list);
        //netřeba pro removeAll vyrábět novou instanci kolekce pomocí new
        list.removeAll(Collections.singletonList("2"));
        System.out.println("Po odebrani: " + list);
    }
    public static void main(String[] args) {
        singleton();
        unmodified();
    }
}
