package cz.spsmb.b3i.w20.vyjimky;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

// Pokud nechceme propagovat výjimku do nadřazené úrovně, je možné jiv metodě ošetřit.
// K této činnosti používáme jazykovou konstrukci try-catch. Do bloku try uzavřeme
// celý kód ve kterém se může výjimka vyskytnout, tzv. chráněný úsek. Blok catch, který
// bezprostředně následuje, říká, na jakou výjimku a jak budeme reagovat.
public class KompletniOsetreniVyjimky {
    public static int[] vytvorANactiPole() {
        int[] pole = null;
        String jmeno = "data1.txt";
        while(true) {
            try {
                Scanner sc = new Scanner(new File(jmeno));
                int n = sc.nextInt();
                pole = new int[n];
                for (int i = 0; i < n; i++) {
                    pole[i] = sc.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.println("Soubor neexistuje");
                System.out.println("Zadej správné jméno souboru");
                Scanner scKlavesnice = new Scanner(System.in);
                jmeno = scKlavesnice.next();
            }
        }
        return pole;
    }

    public static void main(String[] args) {
        int[] abc = vytvorANactiPole();
        System.out.println(Arrays.toString(abc));
    }
}
