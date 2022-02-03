package cz.spsmb.b3i.w22.soubory;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FBezpecnaPraceSeSouborem {
    public static String prectiObsahSouboru(String jmenoSouboru) {
        StringBuffer obsahSouboru = new StringBuffer("");
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader( new FileReader(new File(jmenoSouboru)));
            String radka = null;
            while ((radka = bfr.readLine()) != null){
                obsahSouboru.append(radka);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getLocalizedMessage(),
                    "Chyba při práci se souborem",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            if(bfr != null) {
                try { //uzavírání souboru, pokud byl předtím otevřen. I zde je však
                    //potřeba ošetřit výjimka
                    bfr.close();
                } catch (IOException ex ){
                    // pokud nastane, změníme jí na nekontrolovanou a vyhodíme
                    throw new RuntimeException(ex);
                }
            }
            if(obsahSouboru.length() == 0) {
                //ukončení programu, pokud nebyla načtena žádná data
                System.exit(1);
            }
            return obsahSouboru.toString();
        }
    }

    public static void main(String[] args) {
        String text = prectiObsahSouboru("data.txt");
        System.out.println(text);
        text = prectiObsahSouboru("blbost.txt");
        System.out.println(text);
    }
}
