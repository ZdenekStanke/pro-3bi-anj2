package cz.spsmb.b3i.w13.rozhrani;

public class Test {
    public static void main(String[] args) {
        Usecka u = new Usecka(5);
        Koule k = new Koule(3);
        u.kdoJsem();
        k.kdoJsem();
        Info i = new Usecka(5);
        i.kdoJsem();
        //změním referenci na kouli (úvod do polymorfismu)
        i = k;
        i.kdoJsem();
    }
}
