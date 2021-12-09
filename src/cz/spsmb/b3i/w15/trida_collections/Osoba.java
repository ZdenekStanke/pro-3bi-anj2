package cz.spsmb.b3i.w15.trida_collections;

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
