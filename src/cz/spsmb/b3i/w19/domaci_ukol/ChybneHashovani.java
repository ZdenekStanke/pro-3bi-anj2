package cz.spsmb.b3i.w19.domaci_ukol;

import java.util.HashSet;

class Ovoce {
    private int cena;
    private String typ;

    public Ovoce(int cena) {
        this.cena = cena;
        this.typ = "Jablko";
    }
    @Override
    public String toString() {
        return  "{cena=" + cena +
                "Kč, typ='" + typ + '\'' +
                '}';
    }
}
public class ChybneHashovani {
    public static void main(String[] args) {
        System.out.println("Toto hashovani funguje:");
        HashSet<Integer> intSet = new HashSet<>();
        for (int i = 6; i <= 8; i++) {
            intSet.add(Integer.valueOf(i));
        }
        System.out.println("intSet: " + intSet);
        System.out.println("obsahuje 7:" + intSet.contains(Integer.valueOf(7)));

        System.out.println("Toto hashovani nefunguje, opravte:");
        HashSet<Ovoce> ovoceSet = new HashSet<>();
        for (int i = 6; i <= 8; i++) {
            ovoceSet.add(new Ovoce(i));
        }
        System.out.println("ovoceSet: " + ovoceSet);
        System.out.println("obsahuje 7:" + ovoceSet.contains(new Ovoce(7)));
    }
}
