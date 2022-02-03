package cz.spsmb.b3i.w22.soubory;

import java.io.*;

// metoda readLine() třídy BufferedReader umožňuje číst soubor po řádcích.
// Metoda neukládá znak(y) konce řádky do výsledného řetězce.
// Proto zde používáme metotu newLine(), která při zápisu řetězce do výstupního
// souboru zajistí správné ukončení řádky.
public class GCteniPoRadcich {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        BufferedReader in = new BufferedReader(fr);
        FileWriter fw = new FileWriter("b.txt");
        BufferedWriter out = new BufferedWriter(fw);
        String radka;

        while((radka = in.readLine()) != null) {
            System.out.println(radka);
            out.write(radka);
            out.newLine();
        }
        fr.close();
        //opravdu out.close(), pokud bychom použili fw.close(), bufferovaný
        // výstup by se neuložil a b.txt by byl prázdný.
        out.close();
    }
}
