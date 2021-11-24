package cz.spsmb.b3i.w12.cviceni_kolo;

// Vytvořte třídu Kolo s proměnnými vyrobce, cena a boolean maPrehazovacku.
// Doplňte do této třídy příslušné metody a konstruktory. Děděním vytvořte
// třídu HorskeKolo, kterému doplňte členské proměnné int prevodyVzadu,
// prevodyVpredu. Zajistěte, aby konstruktor správně vytvářel objekty této
// třídy (např. proměnná maPrehazovacku musí být vždy true).
public class Kolo {
    private String vyrobce;
    private int cena;
    private boolean maPrehazovacku = true;

    public Kolo(String vyrobce, int cena, boolean maPrehazovacku) {
        this.vyrobce = vyrobce;
        this.cena = cena;
        this.maPrehazovacku = maPrehazovacku;
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "vyrobce='" + vyrobce + '\'' +
                ", cena=" + cena +
                ", maPrehazovacku=" + maPrehazovacku +
                '}';
    }

    public String getVyrobce() {
        return vyrobce;
    }

    public int getCena() {
        return cena;
    }

    public boolean isMaPrehazovacku() {
        return maPrehazovacku;
    }
}