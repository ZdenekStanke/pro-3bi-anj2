package cz.spsmb.b3i.w19;

import java.util.LinkedHashMap;
import java.util.Random;
//Konstruktor new LinkedHashMap<>(16, 0.75F, true) znamená definici pravděpodobného počtu prvků
//(kapacity mapy) na 16, pravděpodobnost využití celkové kapacity mapy na 75 procent a
//zapnutí parametru přístupového pořadí. Hodnota false znamenáchování popsané v TridaLinkedHashMap,
//Hodnota true znamená změnu implicitního pořadí podle vkládání (insertion order) na pořadí
//podle posledních přístupů (access-order). Pořadí prvků se mění podle toho, kdy je k prvkům
//mapy přistupováno. Platí pravidlo, že nejdéle nepřistupované prvky jsou na začátku a
//naposledy přistupovaný prvek na konci. Pořadí je ovlivňováno pouze metodami put() a get()

//Výhodné pro reprezentaci algoritmu LRU (last recently used), kdy se pro nějakou činnost přednostně
// použije nejméně používaný prvek.

public class CetnostPouzitiVMape {
    public static void main(String[] args) {
        String[] pole = {"A", "B", "C", "D", "E", "F"};
        LinkedHashMap<String, Integer> pristup = new LinkedHashMap<>(16, 0.75F, true);
        for (int i = 0; i < pole.length; i++) {
            pristup.put(pole[i], Integer.valueOf(0));
        }
        System.out.println("Po vytvoření: " + pristup);
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            String klic = "" + (char)(r.nextInt(6) + 'A');
            System.out.print(klic + " ");
            //ovlivňuji pořadí pomocí get()
            Integer hodnota = pristup.get(klic);
            //ovlivňuji pořadí pomocí put()
            pristup.put(klic, Integer.valueOf(hodnota.intValue()+1));
        }
        System.out.println();
        System.out.println("Po pristupu: " + pristup);

    }
}
