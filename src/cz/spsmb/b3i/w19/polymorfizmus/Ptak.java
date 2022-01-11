package cz.spsmb.b3i.w19.polymorfizmus;

public class Ptak extends Zivocich {
    int delkaKridel;

    public Ptak(String typ, int delka) {
        super(typ);
        this.delkaKridel = delka;
    }
    @Override
    public void vypisDelku() {
        System.out.println("Delka kridel: " + this.delkaKridel);
    }
}
