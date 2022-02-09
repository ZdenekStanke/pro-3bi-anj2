package cz.spsmb.b3i.w23.soubory;

//Pokud potřebujeme vlastnosti kombinovat, můžeme jednoduše konstruktory "zřetězit"
//V následujícím příkladu lze používat bufferovaný i formátovaný zápis.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PSeskupovaniVlastnosti {
    public static void main(String[] args) throws IOException {
        PrintWriter pBuf = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("buf.txt")
                )
        );
        for (int i = 0; i < 500000; i++) {
            pBuf.println(i);
        }
        pBuf.close();
    }
}
