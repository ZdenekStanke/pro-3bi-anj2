package cz.spsmb.b3i.w18;

import java.util.*;

public class UbiraniZHashMapy {
    static void naplneniMapyATisk(HashMap<String, Vaha> hm) {
        hm.clear();
        for (int i = 1; i <= 4 ; i++) {
            String jmeno = "Robot" + i;
            hm.put(jmeno, new Vaha(50 + i));
        }
        System.out.println("Mapa: " + hm);
    }
    public static void main(String[] args) {
        HashMap<String, Vaha> hm = new HashMap<>();
        naplneniMapyATisk(hm);
        Set<String> kl = hm.keySet();
        //odstranění prvku z množiny klíčů a tím i z mapy:
        kl.remove("Robot1");
        kl.remove("Robot2");
        System.out.println("Mapa bez Robot1,2: " + hm);
        //odstranění prvku z kolekce hodnot a tím i z mapy:
        naplneniMapyATisk(hm);
        Collection<Vaha> hod = hm.values();
        hod.remove(new Vaha(51));
        System.out.println("Mapa bez Váhy 51:" + hm);
        //odstranění každého sudého Map.Entry a tím i prvku z množiny
        naplneniMapyATisk(hm);
        for(Iterator<Map.Entry<String, Vaha>>
            it = hm.entrySet().iterator(); it.hasNext(); ){
            String s = (String) it.next().getKey();
            char c = s.charAt(s.length() - 1);
            int i = Character.digit(c, 10);
            if(i % 2 == 0) {
                it.remove();
            }
        }
        System.out.println("Mapa bez sudých:" + hm);
        //totéž pomocí hodnoty
        naplneniMapyATisk(hm);
        for(Iterator<Map.Entry<String, Vaha>>
            it = hm.entrySet().iterator(); it.hasNext(); ){
            int i = (int) it.next().getValue().vaha;
            if(i % 2 == 0) {
                it.remove();
            }
        }
        System.out.println("Mapa bez sudých:" + hm);
    }
}
