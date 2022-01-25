package cz.spsmb.b3i.w21.soubory;

import java.io.File;
import java.io.FilenameFilter;

// Potřeba vytvořit třídu implementující rozhraní FilenameFilter, kde v jeho metodě
// accept rozlišíme, zda je soubor přijatelný pro náš výběr.
class FiltrPripony implements FilenameFilter {
    String maska;

    public FiltrPripony(String maska) {
        this.maska = maska;
    }

    @Override
    public boolean accept(File dir, String name) {
        if(name.lastIndexOf(maska) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
class FiltrVelikosti implements FilenameFilter {
    int velikost;

    public FiltrVelikosti(int velikost) {
        this.velikost = velikost;
    }

    @Override
    public boolean accept(File dir, String name) {
        File f = new File(dir, name);
        return (f.length() > this.velikost);
    }
}

public class SelektivniVypisAdresare {
    public static void main(String[] args) {
        String jmenoAktAdr = System.getProperty("user.dir");
        File aktDir = new File(jmenoAktAdr);

        String[] jmena;
        FiltrPripony filtrPripony = new FiltrPripony(".txt");
        jmena = aktDir.list(filtrPripony);
        for (int i = 0; i < jmena.length; i++) {
            System.out.println(jmena[i]);
        }
        File[] soubory;
        FiltrVelikosti filtrVelikosti = new FiltrVelikosti(1000);
        soubory = aktDir.listFiles(filtrVelikosti);
        for (int i = 0; i < soubory.length; i++) {
            System.out.println(soubory[i].getName() + "\t"
                    + soubory[i].length());

        }
    }
}
