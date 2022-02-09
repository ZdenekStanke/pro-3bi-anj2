package cz.spsmb.b3i.w23.soubory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class QVystupDoPameti {
    public static void main(String[] args) {
        //Otevření řetězového proudu do paměti

        StringWriter sProud = new StringWriter();
        PrintWriter form = new PrintWriter(sProud);
        for (int i = 0; i <= 3 ; i++) {
            //Vždy se zapisuje na konec proudu
            form.format("%d. ahoj %d%n", i, (4-i));
            System.out.println(sProud);
        }
        form.close();
    }
}
