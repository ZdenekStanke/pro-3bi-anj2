package cz.spsmb.b3i.w16;

public class Hruska {
    private int cena;

    public Hruska(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Hruska{" +
                "cena=" + cena +
                '}';
    }
    public void tisk() {
        System.out.println(this.cena + ", ");
    }
}
