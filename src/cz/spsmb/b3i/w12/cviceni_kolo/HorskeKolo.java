package cz.spsmb.b3i.w12.cviceni_kolo;

public class HorskeKolo extends Kolo{
    private int  prevodyVzadu;
    private int  prevodyVpredu;

    public HorskeKolo(String vyrobce, int cena, int prevodyVpredu, int prevodyVzadu) {
        super(vyrobce, cena, true);
        this.prevodyVpredu = prevodyVpredu;
        this.prevodyVzadu = prevodyVzadu;

    }

    @Override
    public String toString() {
        return super.toString()+ "HorskeKolo{" +
                "prevodyVzadu=" + prevodyVzadu +
                ", prevodyVpredu=" + prevodyVpredu +
                '}';
    }
}
