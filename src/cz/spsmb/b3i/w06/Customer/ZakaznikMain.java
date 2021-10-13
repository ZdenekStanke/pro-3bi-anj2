package cz.spsmb.b3i.w06.Customer;

public class ZakaznikMain {
    public static void main(String[] args) {
        System.out.format("Pocet zakazniku:%d%n",
                Zakaznik.pocetZakazniku);
        Zakaznik zak1 = new Zakaznik();
        System.out.format("Pocet zakazniku:%d%n",
                Zakaznik.pocetZakazniku);
        zak1.platil(15);
        Zakaznik zak2 = new Zakaznik();
        System.out.format("Pocet zakazniku:%d%n",
                Zakaznik.pocetZakazniku);
        zak1.platil(30);
        zak2.platil(20);
        System.out.format("Utratili: %d + %d%n",
                zak1.utratil, zak2.utratil);
    }
}
