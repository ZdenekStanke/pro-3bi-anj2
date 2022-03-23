package cz.spsmb.b3i.w27.vlakna;
// metoda Thread.sleep(int ms) uspí dané vlákno (převede do stavu
// neběhuschopné) na dobu určenou parametrem ms v milisekundách.

public class Vlakno3 extends  Thread {

    @Override
    public void run() {
        while(ReadVl.hotovo == false ) {
            try {
                Thread.sleep(100); //100 milisekund
            }
            catch (InterruptedException e) {
                System.out.println("přerušeno");
            }
        }
        System.out.println(ReadVl.suma);
    }
    public static void main(String[] args) {
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        Vlakno2 vlVypis = new Vlakno2();
        vlVypis.start();
    }
}
