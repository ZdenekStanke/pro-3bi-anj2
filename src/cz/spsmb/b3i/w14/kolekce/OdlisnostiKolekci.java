package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class OdlisnostiKolekci {
    public static void main(String[] args) {
        //seznam
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("prvni");
        ar.add("druhy");
        ar.add("prvni");
        System.out.println("ArrayList: " + ar);
        //množina
        HashSet<String> hs = new HashSet<String>();
        hs.add("prvni");
        hs.add("druhy");
        hs.add("prvni");
        System.out.println("HashSet: " + hs);
        //mapa (asociativní pole)
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("prvni","objekt");
        hm.put("druhy","objekt");
        hm.put("prvni","pivo");
        System.out.println("HashMap: " + hm);

    }
}
