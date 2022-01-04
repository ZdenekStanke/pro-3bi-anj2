package cz.spsmb.b3i.w18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

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
        for (String key:hm.keySet()) {
            System.out.println(key);
        }
        for(Iterator<String> it = hm.keySet().iterator(); it.hasNext();){
            System.out.println(it.next());
        }
        //iterátor přes hodnoty
        for (Vaha v:hm.values()) {
            System.out.println(v);
        }
        for(Iterator<Vaha> it =hm.values().iterator(); it.hasNext();){
            System.out.println(it.next());
        }
        //iterátor přes dvojice
        //iterátor záznamu z mapy
        for(Iterator<Map.Entry<String, Vaha>> it = hm.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Vaha> e = it.next();
            System.out.print(e.getKey() + "=" + e.getValue() + (it.hasNext()?", ":""));
        }
        //for-each
        System.out.println();
        for (Map.Entry<String, Vaha> e: hm.entrySet()) {
            System.out.print(e.getKey() + "=" + e.getValue() + ", ");
        }
        System.out.println();
        // další možnost (od JDK 1.8) - třída BiConsumer<String, Vaha>
        hm.forEach(new BiConsumer<String, Vaha>() {
            @Override
            public void accept(String s, Vaha vaha) {
                System.out.println(s + "=" + vaha);
            }
        });
        //totéž s lambda funkcí
        hm.forEach((k, v) -> System.out.println(k + "=" + v));

    }
}
