package cz.spsmb.b3i.w18;

import java.util.*;

public class HashMapZakladniPouziti {
    public static void main(String[] args) {
        HashMap<String, Vaha> hm = new HashMap<>();
        System.out.println("Mapa je prazdna: " + hm.isEmpty() + "a obsahuje prvku: " + hm.size());
        // Vložení hodnot do mapy:
        hm.put("Pavel", new Vaha(85));
        hm.put("Venca", new Vaha(105));
        hm.put("Karel", new Vaha(85));
        System.out.println("Mapa je prazdna: " + hm.isEmpty() + "a obsahuje prvku: " + hm.size());
        System.out.println("mapa: " + hm);

        // odstranění prvku:
        hm.remove("Karel");
        System.out.println("mapa: " + hm);
        hm.put("Karel", new Vaha(70));
        System.out.println("mapa: " + hm);

        //vrácení hodnoty podle klíče
        Vaha v = hm.get("Venca");
        System.out.println("Venca vazi: " + v);

        //zjištění, zda klíč je v mapě:
        if (hm.containsKey("Pavel")){
            System.out.println("Pavel váží: " + hm.get("Pavel"));
        }
        // přímé vrácení hodnoty dle neexistujícího klíče
        System.out.println(hm.get("Franta")); //null
        //zjištění, zda hodnota je v mapě:
        if(hm.containsValue(new Vaha(105))) {
            System.out.println("Nekdo vazi 105 kg");
        }
        hm.get("Pavel").vaha+=10; //Pavel ztloustnul
        //Výpis všech klíčů:
        System.out.println("Lidi: " + hm.keySet());
        //transformace na jiný typ kolekce:
        //nelze:
        //ArrayList<Vaha> alv = (ArrayList<Vaha>) hm.values();
        //toto ano
        ArrayList<Vaha> alv = new ArrayList<>(hm.values());
        Collection<Vaha> col = hm.values();
        //použijte cyklus pro iteraci všech prvků v kolekci col:
        Iterator<Vaha> it = col.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Vahy: " + col);
        System.out.println("Mapa: " + hm);
        //Převod hodnot z mapy na pole
        Vaha[] vahy = hm.values().toArray(new Vaha[0]);
        System.out.println("Pole vah: "+ Arrays.toString(vahy));
        //Převod klíčů z mapy na pole
        String[] keys = hm.keySet().toArray(new String[0]);
        System.out.println("Pole klíčů: "+ Arrays.toString(keys));


    }
}
