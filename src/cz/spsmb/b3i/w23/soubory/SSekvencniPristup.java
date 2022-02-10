package cz.spsmb.b3i.w23.soubory;
//Občas je potřeba  přistupovat k souboru jinak než sekvenčně,
// tj. přímým přístupem. Typický příklad je přístup do archivu
// (.arj, .zip). Běžně v nich potřebujeme nalézt komprimovaný soubor
// a nahradit jej jiným.
// Třída RandomAccessFile je pro tento účel určena. Konstruktory:
// RandomAccessFile fr = new RandomAccessFile("a.bin", "r");
// RandomAccessFile frw = new RandomAccessFile("a.bin", "rw");

//Pohyby v souboru zajišťují metody:
// length()         - vrátí velikost souboru
// skipBytes(int n) - přeskočí následujících n bytů
// getFilePointer() - vrací aktuální pozici v souboru
// seek(long pozice)- nastaví aktuální pozici v souboru (měřeno od
//                    začátku souboru)
// setLength(long velikost) - nastaví novou velikost souboru, což
//                          umožňuje jej zvětšit, nebo oříznout.

import java.io.IOException;
import java.io.RandomAccessFile;

//implementovány známé metody read(), write(). Mj. i metody
// readBoolean, readDouble, writeBoolean ...
// writeChars(String s) a String readLine()
public class SSekvencniPristup {
    public static void main(String[] args) throws IOException {
        RandomAccessFile frw = new RandomAccessFile("a.bin", "rw");
        int k, pocet = 5;
        long posun;

        frw.writeInt(pocet);
        for (int i = 0; i < pocet; i++) {
            k = (int) (1000.0 * Math.random());
            System.out.println(k + " ");
            frw.writeInt(k);
        }
        frw.writeDouble(Math.PI);
        frw.writeDouble(Math.E);
        System.out.println("\n" + Math.PI + " " + Math.E);
        System.out.format("Velikost souboru: %d%n", frw.getFilePointer());
        System.out.format("Velikost souboru: %d%n", frw.length());

        // návrat na začátek
        frw.seek(0L);
        pocet = frw.readInt();
        //int je velký 4 byte
        posun = 4 * pocet;
        frw.skipBytes((int)(posun-4));
        //přepis posledního int v souboru
        frw.writeInt(1234);
        //návrat na pozici právě uložené hodnoty
        frw.seek(posun);
        k = frw.readInt();
        System.out.println(k);

        //double je velký 8 byte
        frw.skipBytes(8);
        double e = frw.readDouble();
        System.out.println("\nE: " + e);
        frw.close();
    }
}
