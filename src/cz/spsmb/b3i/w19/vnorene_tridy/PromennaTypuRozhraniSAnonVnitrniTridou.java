package cz.spsmb.b3i.w19.vnorene_tridy;

import cz.spsmb.b3i.w13.rozhrani.Info;

class Usecka3 {
    int delka;

    public Usecka3(int delka) {
        this.delka = delka;
    }

    public Info i = new Info() {
        @Override
        public void kdoJsem() {
            System.out.println("Usecka " + delka);
        }
    };
}

public class PromennaTypuRozhraniSAnonVnitrniTridou {
    public static void main(String[] args) {
        Usecka3 u = new Usecka3(5);
        u.i.kdoJsem();
        if(u instanceof Info) System.out.println("u implementuje Info");
        if(u.i instanceof Info) System.out.println("u.i implementuje Info");
        if(u.i instanceof Info) System.out.println(u.i.getClass().getName() +" implementuje Info");
    }
}
