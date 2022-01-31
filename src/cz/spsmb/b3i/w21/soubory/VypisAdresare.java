package cz.spsmb.b3i.w21.soubory;

import java.io.File;

//File dává k dispozici metody
//String[] list() - zjistí jména a vrátí pole Stringů
//File[]   listFiles() - vrátí pole typu File
public class VypisAdresare {
    public static void main(String[] args) {
        String jmenoAktDir = System.getProperty("user.dir");
        File aktDir = new File(jmenoAktDir);
        String[] jmena;
        jmena = aktDir.list();
        for (int i = 0; i < jmena.length; i++) {
            System.out.println(jmena[i]);
        }
        File[] soubory;
        soubory = aktDir.listFiles();
        for (int i = 0; i < soubory.length; i++) {
            System.out.println(soubory[i].getName() + "\t"
                    + soubory[i].length() + (soubory[i].isDirectory()?" D":" F"));
        }
    }
}
