package cz.spsmb.b3i.w15.trida_collections;

import java.util.Comparator;

// Komparátory pro absolutní řazení
class KomparatorOsobyPodleVysky implements Comparator<Osoba> {
    //pokud parametr v o1 je větší, než v o2, vrať kladnou hodnotu, 0, pokud jsou stejné,
    //zápornou, pokud je parametr v 02 větší, než v o1
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.getVyska()-o2.getVyska();
    }
}

class KomparatorOsobyPodleVahy implements Comparator<Osoba>{
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return (int) (o1.getVaha()-o2.getVaha());
    }
}

class KomparatorOsobyPodlePopisu implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.getPopis().compareTo(o2.getPopis());
    }
}

public class Osoba implements Comparable<Osoba> {
    private int vyska;
    private double vaha;
    private String popis;

    public Osoba(int vyska, double vaha, String popis) {
        this.vyska = vyska;
        this.vaha = vaha;
        this.popis = popis;
    }

    /*
        @Override
        public int compareTo(Osoba o) {
            if(this.vyska > o.vyska) {
                return +1;
            } else if (this.vyska == o.vyska) {
                return 0;
            } else {
                return -1;
            }
        }
    */
    @Override
    public int compareTo(Osoba o) {
        if (this.vaha > o.vaha) {
            return +1;
        } else if (this.vaha == o.vaha) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "vyska=" + vyska +
                ", vaha=" + vaha +
                ", popis='" + popis + '\'' +
                '}';
    }


    public int getVyska() {
        return vyska;
    }

    public double getVaha() {
        return vaha;
    }

    public String getPopis() {
        return popis;
    }
}
