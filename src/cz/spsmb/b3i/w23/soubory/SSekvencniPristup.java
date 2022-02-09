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

//implementovány známé metody read(), write(). Mj. i metody
// readBoolean, readDouble, writeBoolean ...
// writeChars(String s) a String readLine()
public class SSekvencniPristup {
}
