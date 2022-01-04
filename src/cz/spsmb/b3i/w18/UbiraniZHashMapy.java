package cz.spsmb.b3i.w18;

import java.util.HashMap;
import java.util.Set;

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
        //odstranění prvku z množiny hodnot a tím i z mapy:
    }
}
