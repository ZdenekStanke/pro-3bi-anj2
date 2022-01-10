package cz.spsmb.b3i.w19;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FrekvenceSlovVMape {
    public static void cetnost(Map<String, Integer> m ){
        String[] s = {"lesni", "vily", "vence", "vily", "a", "psi", "z", "vily", "na", "ne","vyli"};
        for (int i = 0; i < s.length; i++) {
            Integer cetnost = (Integer) m.get(s[i]);
            cetnost = (cetnost == null ? Integer.valueOf(1):Integer.valueOf(cetnost.intValue()+1));
            m.put(s[i], cetnost);
        }
        System.out.print(m.getClass().getName());
        System.out.println(" --- nalezeno " + m.size() + "rozdilnych slov");
        System.out.println(m);
    }
    public static void main(String[] args) {
        cetnost(new HashMap<String, Integer>());
        cetnost(new TreeMap<String, Integer>());
    }
}
