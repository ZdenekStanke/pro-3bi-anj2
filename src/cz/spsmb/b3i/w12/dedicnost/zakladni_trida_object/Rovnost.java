package cz.spsmb.b3i.w12.dedicnost.zakladni_trida_object;

//Metoda equals(obj) - pomocí této metody lze zjistit, zda se dva objekty rovnají.
//Ve třídě Objekt implementováno nejpřísnějším možným způsobem - porovnávají se reference na objekt.
//Použití obj1.equals(obj2) má stjný význam jako obj1==obj2
//Překryjeme-li metodu .equals(obj), je nutné současně překrýt i metodu .hashCode(). Pokud totiž
//při porovnání objektů se má vracet true, metoda.hashCode() musí vracet stejné číslo.

public class Rovnost {
    public static void main(String[] args) {
        //.equals nepřekryto, porovnávají se pouze reference
        Pomocna p1 = new Pomocna(3.14);
        Pomocna p2 = new Pomocna(3.14);
        if(p1.equals(p2) == false){
            System.out.println("p1 != p2");
        }
        //Zde budou reference stejné
        Pomocna p3 = p1;
        if(p1.equals(p3) == true){
            System.out.println("p3 == p1");
        }
        //Třída Double metodu .equals(obj) evidentně překrytou má:
        //Double d1 = new Double(3.14); // Od JDK 9 zavrhnuto
        Double d1 = Double.valueOf(3.15);
        Double d2 = Double.valueOf(3.14);
        if(d1.equals(d2) == true){
            System.out.println("d1 == d2");
        } else {
            System.out.println("d1 != d2");
        }


    }
}
