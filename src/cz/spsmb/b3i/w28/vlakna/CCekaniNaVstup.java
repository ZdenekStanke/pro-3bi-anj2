package cz.spsmb.b3i.w28.vlakna;
// Vlákno automaticky přejde do neběhuschopného stavu, pokud čeká na vstupně
// výstupní operaci. Vstup z klávesnice tak můžeme realizovat v samostatném
// vlákně, které bude mít přiřazenou nejvyšší prioritu. Po stisku klávesy se
// díky své prioritě okamžitě spustí a načte yadaný znak. Ostatní vlákna musí
// mít nižší prioritu, jinak není nutné  uvádět další mechanismus pro předání
// řízení (yeld(), sleep()).

//Následující příklad průběžně vypisuje přirozená čísla. Po zadání řetězce,
// jehož první znak je K, celý výpočet skončí. Pokud je znak jiný, výpis
// bude pokračovat.

import java.io.IOException;

class Vlakno7 extends Thread {
    @Override
    public void run() {
        long i = 0;
        while (CCekaniNaVstup.hotovo == false) {
            System.out.println(i++ + "\r");
        }
    }
}

public class CCekaniNaVstup extends  Thread {
    public static boolean hotovo = false;

    @Override
    public void run() {
        byte[] pole = new byte[10];
        Thread.currentThread().setPriority(MAX_PRIORITY);
        while(!hotovo){
            try {
                System.in.read(pole); //primitivní čtení z klávesnice
                if(pole[0] == 'K') {
                    hotovo = true;
                }
            } catch (IOException e) {
                System.out.println("Chyba vstupu");
                hotovo = true;
            }
        }
    }

    public static void main(String[] args) {
        CCekaniNaVstup vlVstup = new CCekaniNaVstup();
        vlVstup.start();
        Vlakno7 vlVypis = new Vlakno7();
        vlVypis.start();
    }
}
