package cz.spsmb.b3i.w23.soubory;

//důležité jsou také metody
//hasNext() - existuje další řetězec?
//hasNextInt() - existuje další celé číslo?
//hasNextDouble()
//hasNextLine() - existuje další řádka?

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class LFormatovanyVstupPomociScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data-scanner.txt"));
        //formát desetinné čárky jako .
        sc.useLocale(Locale.US);
        int i = sc.nextInt();
        double d = sc.nextDouble();
        String s = sc.next();
        System.out.format("i=%d, d=%f, s=%s", i, d, s);

    }
}
