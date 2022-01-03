package cz.spsmb.b3i.w18;

import java.util.HashMap;

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

        System.out.println();
    }
}
