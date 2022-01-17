package cz.spsmb.b3i.w19.vnorene_tridy;

import cz.spsmb.b3i.w13.rozhrani.Info;

class Usecka2 {
    int delka;

    public Usecka2(int delka) {
        this.delka = delka;
    }
    //anonymní vnitřní třída implementující rozhraní Info
    public Info informace() {
        return new Info() {
            @Override
            public void kdoJsem() {
                System.out.println("Usecka " + delka);
            }
        };

    }

}
public class AnonymniVnitrniTrida {
    public static void main(String[] args) {
        Usecka2 u = new Usecka2(5);
        //u.kdoJsem(); // nelze
        Info i = u.informace();
        i.kdoJsem();
    }
}
