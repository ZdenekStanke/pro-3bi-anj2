package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;
import java.util.List;

class CeleCislo{
    private int cislo;

    @Override
    public String toString() {
        return "CeleCislo{" +
                "cislo=" + cislo +
                '}';
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    public int getCislo() {
        return cislo;
    }

    public CeleCislo(int cislo) {
        this.cislo = cislo;
    }
}

public class VlastniTridaJakoPrvekSeznamu {
    public static void tiskni(String jmeno, List<CeleCislo> al) {
        int vel = al.size();
        System.out.println(jmeno + " (" + vel + ") : ");
        for (int i = 0; i < vel; i++) {
            System.out.println("[" + i + "]="+al.get(i) + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Vytvoreni seznamu");
        ArrayList<CeleCislo> ar = new ArrayList<CeleCislo>();
        for (int i = 0; i < 5; i++) {
            ar.add(new CeleCislo(i+10));
        }
        tiskni("ar", ar);//10,11,12,13,14
        System.out.println("Tisk celeho seznamu: " + ar);

        System.out.println("Pridavani prvku");
        ar.add(2, new CeleCislo(77));
        tiskni("ar", ar);//10,11,77,12,13,14

        //podseznam je pouze pohled do seznamu, nikoliv nový
        //seznam. Změna prvků v podseznamu se tak promítá do
        //hlavního seznamu.
        System.out.println("Vytvoreni podseznamu");
        List<CeleCislo> s1 = ar.subList(2,5);
        tiskni("s1", s1);//77,12,13

        //Změna v seznamu se automaticky promítne do podseznamu
        ar.get(3).setCislo(33);
        tiskni("ar", ar);//10,11,77,33,13,14
        tiskni("s1", s1);//77,33,13
    }

}
