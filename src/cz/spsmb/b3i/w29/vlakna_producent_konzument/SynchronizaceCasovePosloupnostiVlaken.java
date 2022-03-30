package cz.spsmb.b3i.w29.vlakna_producent_konzument;
// V předchozích příkladech kritických sekcí není nijak zaručeno, že z tzv.
// "překladiště dat" budou odepírány právě ty souřadnice, které byly předhozím
// nastavením uloženy. Klidně se může stát, že budou přečteny tytéž souřadnice
// nechtěně vícekrát, nebo vůbec, protože budou dříve přepsány jinými.

// Tato úloha se popisuje jako producent - konzument, kde producent musí uvědomit
// konzumenta o připravenosti nových dat a konzument musí čekat, dokud toto
// upozornění nedostane. Až poté, co data "zkonzumuje", musí upozornit producenta,
// že může pokračovat v přípravě nových dat.

// Třída Object, od které dědí všechny třídy, obsahuje metody wait() (čekej),
// notify() (uvědom) a notifyAll(), které využívají monitorů kritických sekcí.
// wait()       - zastaví vlákno až do jeho probuzení metodou notify(), nebo
//                notifyAll(), kterou volá jiné vlákno. Je důležité, že se po
//                zavolání wait() uvolní monitor objektu, protože jinak by nemohlo
//                dojít k vyvolání notify() jiným vláknem. Stejně jako u metody
//                join(), je i metoda wait() přetrížena metodami
//                void wait(long milisekund),
//                void wait(long milisekund, long nanosekund),
//                které čekají na určenou dobu timeoutu.
// notifyAll()  - probudí všechna vlákna, která byla v tomto objektu pozastavena
//                metodou wait()
// notify()     - probudí pouze jedno vlákno, přičemž není určeno které.
class Producent extends Thread {
    private Cteni c;
    Producent(Cteni c) {
        this.c = c;
    }
    public void run() {
        while(interrupted() == false) {
            c.nacti();
        }
        System.out.println(" " + c.jmenoSouboru + " - konec cteni ");
    }
}

public class SynchronizaceCasovePosloupnostiVlaken {
    public static void main(String[] args) {
        Cteni ct1 = new Cteni("data.txt");
        Producent vlPr1 = new Producent(ct1);
        Konzument vlKon1 = new Konzument(ct1);
        vlKon1.start();
        vlPr1.start(); //schválně později po konzumentu
    }
}
