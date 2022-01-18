package cz.spsmb.b3i.w20.vyjimky;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//koncový blok finally se vykoná vždy. A to i v případě, kdy je v blocích try a/nebo catch:
// - uveden příkaz return;
// - vyvolána jiná, i nezachycená výjimka, která je propagovaná výše.
public class TryCatchFinally {
    public static long vypisSoubor(String jmeno) throws IOException {
        File frJmeno = new File(jmeno);
        FileReader fr = null;
        try {
            fr = new FileReader(frJmeno);
            for (int i = 0; i < frJmeno.length(); i++) {
                System.out.println((char) fr.read());
            }
            //throw ArithmeticException
            return frJmeno.length();
        }
        catch(FileNotFoundException e) {
            System.out.println("Soubor neotevren");
            throw e;
        }
        catch (IOException e) {
            System.out.println("Chyba cteni");
            throw e;
        }//Zavírání souborů typické pro blok finally
        finally {
            System.out.println("Konec");
            if(fr != null)
                fr.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(vypisSoubor("data.txt"));
    }
}
