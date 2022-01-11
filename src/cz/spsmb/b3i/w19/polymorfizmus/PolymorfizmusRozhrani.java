package cz.spsmb.b3i.w19.polymorfizmus;
class Clovek implements Vazitelny {
    int vaha;
    String profese;

    public Clovek(String profese, int vaha) {
        this.vaha = vaha;
        this.profese = profese;
    }

    public int getVaha() {
        return vaha;
    }

    @Override
    public void vypisHmotnost() {
        System.out.println(profese + ": " + vaha);

    }
}
class Kufr implements Vazitelny {
    int vaha;

    public Kufr(int vaha) {
        this.vaha = vaha;
    }

    @Override
    public void vypisHmotnost() {
        System.out.println("kufr: " + this.vaha);
    }
}
public class PolymorfizmusRozhrani {
    public static void main(String[] args) {
        int vahaLidi = 0;
        Vazitelny[] kusJakoKus = new Vazitelny[3];
        kusJakoKus[0] = new Clovek("programator", 100);
        kusJakoKus[1] = new Kufr(20);
        kusJakoKus[2] = new Clovek("modelka", 51);

        System.out.println("CD - individualni pristup");
        for (int i = 0; i < kusJakoKus.length; i++) {
            kusJakoKus[i].vypisHmotnost();
            if(kusJakoKus[i] instanceof Clovek)
                vahaLidi += ((Clovek) kusJakoKus[i]).getVaha();
        }
        System.out.println("Ziva vaha: " + vahaLidi);
    }
}
