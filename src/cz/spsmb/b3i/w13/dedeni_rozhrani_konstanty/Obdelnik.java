package cz.spsmb.b3i.w13.dedeni_rozhrani_konstanty;

import cz.spsmb.b3i.w13.rozhrani.Usecka;

public class Obdelnik extends Usecka implements InfoOba {
    private int sirka;

    public Obdelnik(int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    @Override
    public void kdoJsem() {
        System.out.print(InfoOba.POCET + "Obdelnik");
    }

    @Override
    public void vlastnosti() {
        System.out.println( " = " + this.delka + ", " + this.sirka);
    }
}
