package cz.spsmb.b3i.w28.vlakna;

import cz.spsmb.b3i.w27.vlakna.ReadVl;
import cz.spsmb.b3i.w27.vlakna.Vlakno3;

// Na ukončení vlákna čekáme pouze daný čas (timeout). Metoda isAlive() informuje
// o tom, zda vlákno doběhlo, tj. je ve stavu mrtvé (false), či nikoliv (true).

public class ESynchronizaceVlaknaTimeout extends  Thread {
    public static void main(String[] args) throws InterruptedException {
        long zac = System.currentTimeMillis();
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        Vlakno3 vlVypis = new Vlakno3();
        vlVypis.start();
        while(vlVypis.isAlive()) {
            // vlákno main čeká na ukončení vlákna vlVypis max 5 sekund
            vlVypis.join(5000);
            System.out.println("\t Kde se flákáš?!");
        }
        long konec = System.currentTimeMillis();
        System.out.println("Konec: " + (konec - zac));
    }
}
