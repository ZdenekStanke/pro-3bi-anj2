package cz.spsmb.b3i.w21.soubory;

import java.io.File;
import java.io.IOException;

public class Vytvoreni {
    public static void main(String[] args) throws IOException {
        String aktDir = System.getProperty("user.dir");
        File novySoub = new File("b.txt");
        File novyAdr = new File("TMP");
        //test, zda nový soubor existuje
        if(novySoub.exists()) {
            System.out.println("b.txt existuje");
        } else {
            //neexistuje-li, vytvoříme ho
            novySoub.createNewFile();
        }
        //test, zda se jedná skutečně o soubor
        if(novySoub.isFile()) {
            System.out.println("b.txt je soubor");
        }
        if(novyAdr.exists()){
            System.out.println("TMP existuje");
        } else {
            novyAdr.mkdir();
        }
        if(novyAdr.isDirectory()) {
            System.out.println("TMP je adresář");
        }
    }
}
