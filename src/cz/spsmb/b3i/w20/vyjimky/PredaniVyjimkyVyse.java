package cz.spsmb.b3i.w20.vyjimky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Jedná se o tzv. propagaci, resp. šíření výjimek. Metoda, kde se výjimka ocitla
// se zříká odpovědnosti za její zpracování. Toto předání
// odpovědnosti se deklaruje  již v hlavičce metody pomocí klíčového
// slova throws. Viz případ dole. Řešení problému, co s vzniklou
// výjimkou se tak odsouvá na později...
// Z prvního pohledu se tak jedná o nejjednodušší řešení.
public class PredaniVyjimkyVyse {
    public static int[] vytvorANactiPole() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        int n = sc.nextInt();
        int [] pole = new int[n];
        for (int i = 0; i < n; i++) {
            pole[i] = sc.nextInt();
        }
        return pole;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] abc = vytvorANactiPole();
        System.out.println(Arrays.toString(abc));
    }
}
