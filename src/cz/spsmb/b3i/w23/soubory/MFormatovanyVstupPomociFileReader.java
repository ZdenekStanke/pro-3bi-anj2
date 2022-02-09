package cz.spsmb.b3i.w23.soubory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Přístup pomocí třídy Scanner má nevýhodu v pomalosti. Není zde totiž použit
// BufferedReader. Pokud je časové hledisko rozhodující, použijeme bufferovaný file
// reader. Zásadně načítáme celé řádky, které pak pomocí String.split() rozdělíme.
public class MFormatovanyVstupPomociFileReader {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(
                new FileReader("buf.txt")
        );
        String radka;
        int suma = 0;
        while((radka = bfr.readLine()) != null){
            String[] cisla = radka.split(" ");
            for (String cislo : cisla) {
                suma += Integer.parseInt(cislo);
            }
        }
        System.out.println("Soucet je: "+suma);
        bfr.close();
    }
}
