package cz.spsmb.b3i.w22.soubory;

import java.io.*;

public class BIoZnaky {
    public static void main(String[] args) throws IOException {
        File frJm = new File("a.txt");
        File fwJm = new File("b.txt");
        //FileReader, FileWriter - třídy pro přesun znaků
        if(frJm.exists()) {
            FileReader fr = new FileReader(frJm);
            FileWriter fw = new FileWriter(fwJm);
            int c;
            //čtení znak po znaku
            /*
            while((c = fr.read()) != -1){
                //zápis znaku do souboru b.txt
                fw.write(c);
                //výpis znaku ven
                System.out.format("%c",c);
            }*/
            //další možnost je využít metody length instance třídy File
            //standartní chování je proudy zavírat
            for (int i = 0; i < frJm.length(); i++) {
                fw.write(fr.read());
            }
            fr.close();
            fw.close();
        }
    }
}
