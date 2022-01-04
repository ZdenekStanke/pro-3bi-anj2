package cz.spsmb.b3i.w18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StejneMapyAPodmapy {
    static HashMap<String, Integer> vytvoreniANaplneniMapy () {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 1; i <= 3 ; i++) {
            String jmeno = "Robot" + i;
            hm.put(jmeno, Integer.valueOf(50 + i));
        }
        return hm;
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hmOrig = vytvoreniANaplneniMapy();
        HashMap<String, Integer> hmStejna = vytvoreniANaplneniMapy();
        HashMap<String, Integer> hmMensi = vytvoreniANaplneniMapy();
        Set kl = hmMensi.keySet();
        kl.remove("Robot1");
        HashMap<String, Integer> hmVetsi = vytvoreniANaplneniMapy();
        hmVetsi.put("Robot5", Integer.valueOf(55));
        System.out.println("hmOrig:    " + hmOrig);
        boolean b1, b2, b3;
        //jsou mapy hmStejna a hmOrig stejné?
        //Map<String, Integer> tmp = hmOrig;
        Map<String, Integer> tmp = hmMensi;
        //Map<String, Integer> tmp = hmVetsi;
        b1 = hmStejna.entrySet().containsAll(tmp.entrySet());
        b2 = hmStejna.entrySet().equals(tmp.entrySet());
        b3 = hmStejna.equals(tmp);
        System.out.format("b1: %b, b2: %b, b3:%b%n", b1, b2, b3);
    }
}
