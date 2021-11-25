package cz.spsmb.b3i.w12.cviceni_vozidlo;

public class Motorka extends JednostopeVozidlo{
    private int obsahNadrze;

    public Motorka(int obsahNadrze, String druh) {
        this.obsahNadrze = obsahNadrze;
        this.druh = druh;
    }

    @Override
    public String toString() {
        return "Motorka{" +
                "druh='" + druh + '\'' +
                ", obsahNadrze=" + obsahNadrze +
                '}';
    }

    @Override
    public void vypisCoJsiZac() {
        System.out.println(this.toString());

    }
}
