package cz.spsmb.b3i.w06.Rectangle;

public class UvodDoOOP {
    public static void main(String[] args) {
        //Vytvoření objektu, resp. vytvoření
        //instance třídy Obdelník pomocí implicitního
        // konstruktoru:
        Obdelnik obd;
        Obdelnik obd1 = new Obdelnik(3,5);
        Obdelnik obd2 = new Obdelnik();
        Obdelnik obd3 = new Obdelnik(9);
        obd=obd3;
        //přímý přístup k datům - nevhodné používat
        //obd.sirka = 3;
        //obd.vyska = 5;
        //raději použít konstruktor, či metody

        System.out.format("Vyska:%d, sirka:%d," +
                "obvod:%d, obsah:%d%n",obd.getVyska(), obd.getSirka(),
                obd.obvod(), obd.obsah());
    }
}
