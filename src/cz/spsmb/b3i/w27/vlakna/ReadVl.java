package cz.spsmb.b3i.w27.vlakna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadVl extends Thread {
    FileReader fr;
    BufferedReader in;
    String jmenoSouboru;
    static public long suma = 0;
    static public boolean hotovo = false;

    public ReadVl(String jmenoSouboru) {
        super("Vlakno pro cteni");
        this.jmenoSouboru = jmenoSouboru;
    }

    @Override
    public void run() {
        String radka;
        try{
            fr = new FileReader(this.jmenoSouboru);
            in = new BufferedReader(fr);
            while ((radka = in.readLine()) != null) {
                suma += Integer.parseInt(radka);
                Thread.yield();
            }
            fr.close();
            hotovo = true;
        }
        catch (IOException e) {
            System.out.println("Chyba b souboru");
            hotovo = true;
        }
    }
}
