package cz.spsmb.b3i.w19.vnorene_tridy;
// Časté použití v tzv. adaptérech - tam, kde např. z pěti již hotových metod chceme
// ve vnitřní třídě měnit pouze jednu a nechce se nám čtyři zastiňovat, což by bylo
// nutné při implementaci rozhraní. Týká se to do Java verze 8, kde nebylo možné
// deklarovat implicitní těla metod v rozhraní

import cz.spsmb.b3i.w13.rozhrani.Info;

class Jmeno {
    public void kdoJeTo(Object o) {
        System.out.println(o.getClass().getName());
    }
}
class Usecka4 {
    protected int delka;

    public Usecka4(int delka) {
        this.delka = delka;
    }
}
class Obdelnik extends Usecka4 implements Info {
    private int sirka;

    public Obdelnik(int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }
    public void kdoJsem(){
        new VnitrniJmeno().kdoJsem();
    }
    class VnitrniJmeno extends Jmeno {
        void kdoJsem() {
            //Všiměte si rozdílu mezi Obdelnik.this (odkaz do vnější třídy)
            // a this (odkaz do vnitřní třídy, tedy sem)
            kdoJeTo(Obdelnik.this);
            kdoJeTo(this);
            System.out.println(" " + Obdelnik.this.delka + "x" + Obdelnik.this.sirka);
        }
    }

}
public class VnitrniTridaVytvorenaDedenim {
    public static void main(String[] args) {
        Info i = new Obdelnik(3,6);
        i.kdoJsem();
    }
}
