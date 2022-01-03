package cz.spsmb.b3i.w18;

import java.util.HashMap;

//Mapy samotné neumožňují vytvořit iterátor. Děláme to přes klíče, či hodnoty.
//třetí možnost je získat pomocí metody
// Set<Map.Entry<K, V>> entrySet()
//množnu, jejíž prvky jsou objekty třídy implementující rozhraní Map.Entry. Zde
//je uložen jak objekt klíče, tak i objekt hodnoty. Rozhraní MapEntry dává
// k dispozici metody
// K getKey()
// V getValue()
public class IteratorVHashMape {
    public static void main(String[] args) {
        HashMap<String, Vaha> hm = new HashMap<>();
        // Vložení hodnot do mapy:
        hm.put("Pavel", new Vaha(85));
        hm.put("Venca", new Vaha(105));
        hm.put("Karel", new Vaha(70));
        System.out.println("Mapa: " + hm);
        //iterátor přes klíče:
    }
}
