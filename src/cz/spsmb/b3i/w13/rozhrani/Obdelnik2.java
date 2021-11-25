package cz.spsmb.b3i.w13.rozhrani;

//Třída Obdelnik implementuje obě rozhraní Info totiž
//dědí z úsečky
public class Obdelnik2 extends Usecka implements InfoDalsi {
    private int sirka;

    public Obdelnik2(int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    @Override
    public void kdoJsem() {
        System.out.print("Obdelnik");
    }

    @Override
    public void vlastnosti() {
        System.out.println(" = " + this.delka +", "+ this.sirka);
    }

    public int getSirka() {
        return sirka;
    }

    public void vypisSirka() {
        System.out.println(this.sirka);
    }
}
