package cz.spsmb.b3i.w13.rozhrani;

public class Usecka implements Info{
    private int delka;

    public Usecka(int delka) {
        this.delka = delka;
    }

    @Override
    public void kdoJsem() {
        System.out.println("Usecka");
    }
}
