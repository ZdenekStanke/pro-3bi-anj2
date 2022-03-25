package cz.spsmb.b3i.w28.vlakna;

// Dědění z třídy Thread má nevýhodu nemožnosti využívat vlákna u tříd, které již
// dědí jinou třídu. Vlastnosti vlákna tak může třída získat implementací rozhraní
// Runnable, které obsahuje pouze jednu metou - run()

import cz.spsmb.b3i.w27.vlakna.ReadVl;

public class BVlakno5 implements Runnable {
    private Thread zobrazVl = null;

    public void start() {
        this.zobrazVl = new Thread(this);
        this.zobrazVl.start();
    }
    @Override
    public void run() {
        while(ReadVl.hotovo == false){
            System.out.println(ReadVl.suma+"\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        BVlakno5 vlVypis = new BVlakno5();
        vlVypis.start();
    }
}
