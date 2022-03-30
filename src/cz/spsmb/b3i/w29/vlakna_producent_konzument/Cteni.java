package cz.spsmb.b3i.w29.vlakna_producent_konzument;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cteni {
    private FileReader fr;
    private BufferedReader in;
    public String jmenoSouboru;
    private int hodnota;
    private boolean precteno = false;
    private boolean konecSouboru = false;
    Cteni(String jmeno) {
        this.jmenoSouboru = new String(jmeno);
        try {
            fr = new FileReader(this.jmenoSouboru);
            in = new BufferedReader(fr);
        } catch (IOException e){
            System.out.println("Chyba pri otvirani souboru!");
        }
    }
    public synchronized void nacti() {
        while(this.precteno) {
            try {
                this.wait();
            } catch (InterruptedException e) {};
        }
        String radka;
        try{
            if((radka = this.in.readLine()) != null) {
                this.hodnota = Integer.valueOf(radka).intValue();
                System.out.println(this.jmenoSouboru + " precteno: " + this.hodnota + " ");
            } else {
                this.konecSouboru = true;
                Thread.currentThread().interrupt();
            }
        } catch (IOException e ){
            System.out.println("Chyba pri cteni souboru!");
        }
        this.precteno = true;
        notifyAll();
    }
    public synchronized int predej() {
        while (precteno == false) {
            try {
                this.wait();
            } catch (InterruptedException e ) {};
        }
        this.precteno = false;
        if(this.konecSouboru == false) {
            System.out.println(this.jmenoSouboru + " predano: " + this.hodnota + " ");
            this.notifyAll();
            return this.hodnota;
        } else {
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    protected void finalize() {
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("Chyba pri zavirani souboru!");
        }
    }
}
