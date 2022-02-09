package cz.spsmb.b3i.w23.soubory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Bývá zvykem, že se výstup provede až po vytisknutí znaků konce řádky. Tzv.
// řádkového bufferování dosáhneme púři použití konstruktoru
// PrintWriter(Writer out, boolean autoFlush)
// s parametrem autoFlush = false
public class KFormatovaniVystupuSRadkovymBufferovanim {
    public static void main(String[] args) throws IOException {
        FileWriter fwForm = new FileWriter("form.txt");
        //autoFlush = false, rychlejší, ale zápis do souboru jen v případě znaku
        // konce řádky
        PrintWriter form = new PrintWriter(fwForm, false);
        FileWriter fwNeForm = new FileWriter("neform.txt");
        for (int i = 1; i < 75; i++) {
            System.out.println(i + " ");
            form.format(" tohle je znak %d", i);
            System.exit(0);
            form.println();
            fwNeForm.write(i);
        }
        fwNeForm.close();
        //
        form.close();
    }
}
