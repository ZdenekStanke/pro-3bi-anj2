package cz.spsmb.b3i.w23.soubory;

// Od třídy BufferedReader je odvozena třída LineNumberReader, která kromě metody readLine()
// obsahuje ještě
// setLineNumber()
// getLineNumber() - vrátí počet již přečtených řádek

import java.io.*;

public class JVyberoveCteniPoRadcich {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        LineNumberReader in = new LineNumberReader(fr);
        FileWriter fw = new FileWriter("b.txt");
        BufferedWriter out = new BufferedWriter(fw);
        String radka;

        while((radka = in.readLine()) != null) {
            System.out.format("%d. %s%n", in.getLineNumber(), radka);
            out.write(radka);
            out.newLine();
        }
        fr.close();
        //opravdu out.close(), pokud bychom použili fw.close(), bufferovaný
        // výstup by se neuložil a b.txt by byl prázdný.
        out.close();
    }
}
