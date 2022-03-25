package cz.spsmb.b3i.w28.vlakna;

// Spolupráce vláken mezi sebou je často používaná. Synchronizace vláken pomocí proměnné třídy
// (statické) není optimální (čistota kódu, přístup více vláken k jedné proměnné).
// Možnosti:
// Vlákno čeká na konec jiného vlákna:
// - z algoritmu úlohy je nutné, aby bylo nějaké vlákno spuštěno až po skončení jiného vlákna.
//   Metoda join() toto zajišťuje.

import cz.spsmb.b3i.w27.vlakna.ReadVl;
import cz.spsmb.b3i.w27.vlakna.Vlakno3;

public class DSynchronizaceVlaken extends  Thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        long zac = System.currentTimeMillis();
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        Vlakno3 vlVypis = new Vlakno3();
        vlVypis.start();
        // vlákno main čeká na ukončení vlákna vlVypis
        vlVypis.join();
        long konec = System.currentTimeMillis();
        System.out.println("Konec: " + (konec - zac));
    }
}
