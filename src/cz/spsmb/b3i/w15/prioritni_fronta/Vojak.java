package cz.spsmb.b3i.w15.prioritni_fronta;

public class Vojak implements Comparable<Vojak>{
    private int pocetHvezdicek;
    private String hodnost;
    private String typVojska;

    /*public int getPocetHvezdicek() {
        return pocetHvezdicek;
    }*/

    public void setPocetHvezdicek(int pocetHvezdicek) {
        this.pocetHvezdicek = pocetHvezdicek;
    }

    public Vojak(int pocetHvezdicek, String hodnost, String typVojska) {
        this.pocetHvezdicek = pocetHvezdicek;
        this.hodnost = hodnost;
        this.typVojska = typVojska;
    }

    @Override
    public int compareTo(Vojak o) {
        return o.pocetHvezdicek - this.pocetHvezdicek;
    }

    @Override
    public String toString() {
        return "Vojak{" +
                "pocetHvezdicek=" + pocetHvezdicek +
                ", hodnost='" + hodnost + '\'' +
                ", typVojska='" + typVojska + '\'' +
                '}';
    }
}