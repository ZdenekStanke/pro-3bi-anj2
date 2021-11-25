package cz.spsmb.b3i.w12.cviceni_vozidlo;

public class Kolo extends JednostopeVozidlo{
    private String vyrobce;

    public Kolo(String vyrobce, String druh) {
        this.vyrobce = vyrobce;
        this.druh = druh;
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "druh='" + druh + '\'' +
                ", vyrobce='" + vyrobce + '\'' +
                '}';
    }
    @Override
    public void vypisCoJsiZac() {
        System.out.println(this.toString());

    }
}

