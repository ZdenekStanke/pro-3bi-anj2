package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;

public class ArrayListMetodyZList {
    public static void tiskni(String jmeno, ArrayList<String> al) {
        int vel = al.size();
        System.out.println(jmeno + " (" + vel + ") : ");
        for (int i = 0; i < vel; i++) {
            System.out.println("[" + i + "]="+al.get(i) + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Vytvoreni seznamu");
        ArrayList<String> ar =new ArrayList<>();
        ar.add("prvni");
        ar.add("druhy");
        ar.add("prvni");
        tiskni("ar", ar);// prvni, druhy, prvni
        System.out.println("\nPridavani, zmena, ubirani prvku");
        ar.add(2,"treti");
        tiskni("ar", ar);//prvni, druhy, treti, prvni
        ar.set(1,"DRUHY");
        tiskni("ar", ar);//prvni, DRUHY, treti, prvni
        ar.remove(2);
        tiskni("ar", ar);//prvni, DRUHY, prvni
        System.out.println("Hledani prvku");
        ar.add("ctvrty");
        tiskni("ar", ar);//prvni, DRUHY, prvni, crvrty
        System.out.println("'ctvrty' ma index: " + ar.indexOf("ctvrty"));//3
        System.out.println("posledni 'prvni' ma index: "+ar.lastIndexOf("prvni"));//2

    }
}
