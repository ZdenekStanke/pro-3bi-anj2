package cz.spsmb.b3i.w20.vyjimky;

// Můžeme potřebovat, že vzniklá výjimka bude v metodě, ve které se vyskytla, částečně nebo úplně
// ošetřena, ale přesto bude o vzniklé situaci informovat volající metodu.
//

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OsetreniVyjimkyAPredaniVyse {
    public static int[] vytvorANactiPole() throws IOException {
        int[] pole = null;
        try {
            Scanner sc = new Scanner(new File("data0.txt"));
            int n = sc.nextInt();
            pole = new int[n];
            for (int i = 0; i < n; i++) {
                pole[i] = sc.nextInt();
            }
            return pole;
        }
        catch (IOException e){
            System.out.println("Soubor nenalezen");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            int[] abc = vytvorANactiPole();
            System.out.println(Arrays.toString(abc));
        }
        catch (Exception e) {
            System.out.println("Program neproběhl správně");
        }
    }
}
