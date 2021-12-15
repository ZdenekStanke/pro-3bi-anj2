package cz.spsmb.b3i.w15.prioritni_fronta;

import java.util.ArrayList;
import java.util.Iterator;

class Hruska {
    private int cena;

    public Hruska(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Hruska{" +
                "cena=" + cena +
                '}';
    }
    public void tisk() {
        System.out.println(this.cena + ", ");
    }
}

public class IteratorZakladniPouziti {
    public static void main(String[] args) {
        ArrayList<Hruska> kosHrusek = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            kosHrusek.add(new Hruska(i + 20));
        }
        //použití iterátoru pomocí foreach
        for (Hruska h: kosHrusek) {
            h.tisk();
        }
        //použití iterátoru pomocí while
        Iterator<Hruska> ih = kosHrusek.iterator();
        while(ih.hasNext()){
            ih.next().tisk();
        }
    }
}
