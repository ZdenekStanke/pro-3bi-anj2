package cz.spsmb.b3i.w23.soubory;

import java.io.*;

// třídy DataInputStream a DataOutputStream slouží pro čtení zápis
// binární (neformátované) podoby znaků.
public class NNeformatovanyVstupAVystupZaklDatTypu {
    public static void main(String[] args) throws IOException {
        FileOutputStream fwJm = new FileOutputStream("data.bin");
        DataOutputStream fw = new DataOutputStream(fwJm);
        int pocet = 2 + (int) (Math.random() * (10 - 2));
        fw.writeInt(pocet);

        for (int i = 0; i < pocet; i++) {
            int k = (int) (1000.0 * Math.random());
            System.out.print(k + " ");
            fw.writeInt(k);
        }
        fw.writeDouble(Math.PI);
        fw.writeDouble(Math.E);
        System.out.println("\n" + Math.PI+ " " + Math.E);
        fwJm.close();
        //Cteni
        FileInputStream frJm = new FileInputStream("data.bin");
        DataInputStream fr = new DataInputStream(frJm);
        pocet = fr.readInt();
        for (int i = 0; i < pocet; i++) {
            int k = fr.readInt();
            System.out.print(k + " ");
        }
        double pi = fr.readDouble();
        double e = fr.readDouble();
        System.out.println();
        System.out.println("\n" + pi + " " + e);
        frJm.close();
    }
}
