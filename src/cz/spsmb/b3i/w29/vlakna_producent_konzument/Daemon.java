package cz.spsmb.b3i.w29.vlakna_producent_konzument;
// Vlákno typu Démon (daemon) je speciální typ vlákna. Pokud program používá běžná vlákna,
// nemůže skončit dříve, než jsou ukončena všechna jeho vlákna. Pokud však některé vlákno
// označíme jako démona, program může skončit bez ohledu, zda démon vlákno doběhlo, či ne.

// Této vlastnosti můžeme s výhodou využít, pokud máme v programu vlákna, která
// pouze poskytují služby, a když už o tyto služby není zájem, mohou klidně
// skončit. To je právě příklad producenta z tohoto týdne. Označíme-li ho jako
// démona, nemusíme si dělat starosti s jeho ukončením.

public class Daemon extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <=10 ; i++) {
            System.out.println(i + ". daemon je tu");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("probuzeno...");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Začátek programu");
        Daemon v1D = new Daemon();
        //nastavení vlákna jako démon
        //v1D.setDaemon(true);
        v1D.start();
        if(v1D.isDaemon()){
            System.out.println("Program hned skončí");
        } else {
            System.out.println("Program poběží dlouho");
        }
        System.out.println("Konec programu");

    }
}
