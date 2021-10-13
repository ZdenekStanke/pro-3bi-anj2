package cz.spsmb.b3i.w06.encapsculation;

public class CustomerMain {
    public static void main(String[] args) {
        System.out.format("Pocet zakazniku:%d%n",
                Customer.pocetZakazniku);
        Customer zak1 = new Customer();
        System.out.format("Pocet zakazniku:%d%n",
                Customer.pocetZakazniku);
        zak1.platil(15);
        Customer zak2 = new Customer();
        System.out.format("Pocet zakazniku:%d%n",
                Customer.pocetZakazniku);
        zak1.platil(30);
        zak2.platil(20);
        System.out.format("Utratili: %d + %d%n",
                zak1.utratil, zak2.utratil);
        //zrušení objektu - nemusí být smazáno ihned
        zak1 = null;
        //vynucení okamžitého výmazu objektu
        System.runFinalization();
        //ruční volání Garbage Collectoru
        System.gc();
        System.out.format("Pocet zakazniku:%d%n",
                Customer.pocetZakazniku);
    }
}
