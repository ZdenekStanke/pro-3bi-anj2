package cz.spsmb.b3i.w18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class KontrolaAtributuVMape {
    public static void main(String[] args) {
        String[] key = {"pozadi", "popredi", "ramecek"};
        HashSet<String> atributy = new HashSet<>(Arrays.asList(key));
        HashMap<String, String> nastaveni = new HashMap<>();
        nastaveni.put("pozadi", "bila");
        //neznamy atribut
        nastaveni.put("text", "zelena");
        System.out.println("Seznam atributu:   " + atributy);
        System.out.println("Seznam nastaveni:  " + nastaveni);
        HashSet<String> chybi = new HashSet<>(atributy);

        System.out.println("Atributy chybi:    " + chybi);

    }
}
