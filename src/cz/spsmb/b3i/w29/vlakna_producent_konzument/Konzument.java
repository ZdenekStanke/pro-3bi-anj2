package cz.spsmb.b3i.w29.vlakna_producent_konzument;

public class Konzument extends Thread {
    private Cteni c;
    private int suma = 0;

    public Konzument(Cteni c) {
        this.c = c;
    }

    @Override
    public void run() {
        int cislo;
        while(true) {
            cislo = c.predej();
            if(!interrupted()) {
                this.suma += cislo;
            } else {
                break;
            }
        }
        System.out.println(" " + this.c.jmenoSouboru + " - vysledna suma: " + this.suma);
    }
}
