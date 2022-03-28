package cz.spsmb.b3i.w28.vlakna;

import cz.spsmb.b3i.w27.vlakna.ReadVl;
import cz.spsmb.b3i.w27.vlakna.Vlakno3;
// Přerušení vlákna je možné docílit metodou interrupt(). Metoda iterrupted()
// pak vrací true, pokud bylo vlákno touto metodou ukončeno (může být ukončeno)
// i z jiného vlákna.
public class FPředčasnéUkončeníVlákna extends Thread {
    public void run() {
        while(ReadVl.hotovo == false) {
            System.out.println(ReadVl.suma + "\r");
            this.yield();
            if(this.interrupted()) {
                return;
            }
        }
        System.out.println(ReadVl.suma);
    }

    public static void main(String[] args) throws InterruptedException {
        long zac = System.currentTimeMillis();
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        FPředčasnéUkončeníVlákna vlVypis = new FPředčasnéUkončeníVlákna();
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
