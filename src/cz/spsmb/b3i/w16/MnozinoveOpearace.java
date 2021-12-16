package cz.spsmb.b3i.w16;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MnozinoveOpearace {
    public static void main(String[] args) {
        Set<String> m1 = new HashSet<>();
        Collections.addAll(m1, "1", "2", "3", "4");
        Set<String> m2 = new HashSet<>();
        Collections.addAll(m2, "2", "3");
        //Podmnožina:
        if (m1.containsAll(m2) == true) {
            System.out.println(m2 + "je podmnozinou " + m1);
        }

        m2.add("5");
        Set<String> sjednoceni = new HashSet<>(m1);
        //Sjednocení
        sjednoceni.addAll(m2);
        System.out.println(sjednoceni + "je sjednocenim " + m1 + " a " + m2);

        Set<String> prunik = new HashSet<>(m1);
        //prunik
        prunik.retainAll(m2);
        System.out.println(prunik + " je prunikem " + m1 + " a " + m2);
        Set<String> rozdil = new HashSet<String>(m1);
        //rozdil m1-m2
        rozdil.removeAll(m2);
        System.out.println(rozdil + " je rozdilem " + m1 + " a " + m2);
        //symetrický rozdíl -  výsledná množina obsahuje pouze prvky, které
        //nejsou společné m1 a m2. Operace: sjednocení a rozdíl průniku
        Set<String> symetrickyRozdil = new HashSet<>(m1);
        symetrickyRozdil.addAll(m2);
        symetrickyRozdil.removeAll(prunik);
        System.out.println(symetrickyRozdil + " je symetrickym rozdilem " + m1 + " a " + m2);
    }
}
