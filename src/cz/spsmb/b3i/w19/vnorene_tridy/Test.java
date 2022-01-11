package cz.spsmb.b3i.w19.vnorene_tridy;

import cz.spsmb.b3i.w13.rozhrani.Info;

class Usecka {
    int delka;

    public Usecka(int delka) {
        this.delka = delka;
    }

    public Info informace() {
        return new UseckaInfo();
    }

    private class UseckaInfo implements Info {
        @Override
        public void kdoJsem() {
            System.out.println("Usecka " + delka);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Usecka u = new Usecka(5);
        //u.kdoJsem(); //nelze
        //Info i = u; // nelze
        Info i = u.informace();
        i.kdoJsem();
    }
}
