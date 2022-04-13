package cz.spsmb.b3i.w28.vlakna;

import cz.spsmb.b3i.w27.vlakna.ReadVl;
import cz.spsmb.b3i.w27.vlakna.Vlakno3;
// Pokud vlákno uspíme metodou sleep(), musíme ošetřit výjimku InterruptedException, která
// je vyhozena v případě, že je vlákno násilně vzbuzeno před uplynutím plánované doby spánku.
// volání metody interrupt() na vlákno je jedna z možností, jak vlákno násilně probudit
// (a ukončit).
public class GNasilneProbuzeniVlakna extends Thread {
    public void run() {
        while(!ReadVl.hotovo) {
            System.out.println(ReadVl.suma + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Předčasně vzbuzeno.");
                System.out.flush();
                break;
            }
        }
        System.out.println(ReadVl.suma);
    }

    public static void main(String[] args) throws InterruptedException {
        long zac = System.currentTimeMillis();
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        GNasilneProbuzeniVlakna vlVypis = new GNasilneProbuzeniVlakna();
        vlVypis.start();
        //zkusíme počkat 1 vteřinu, zda se vlákno neukončí do té doby samo
        vlVypis.join(1000);
        if(vlVypis.isAlive()){
            System.out.println("\t vypršel ti čas, skonči!");
            vlVypis.interrupt();
        }
        long kon = System.currentTimeMillis();
        System.out.println("Konec: " + (kon - zac));
    }
}
