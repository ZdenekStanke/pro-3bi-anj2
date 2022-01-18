package cz.spsmb.b3i.w20.vyjimky;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// Nejhorší možný způsob reakce na výjimku - nedělat v bloku catch nic
public class IdiotskaReakceNaVyjimku {
    public static int[] vytvorANactiPole() throws FileNotFoundException {
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
        catch (Exception e) {
            // !!! Opravdu by zde mělo něco být !!!
        }
        return pole;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] abc = vytvorANactiPole();
        System.out.println(Arrays.toString(abc));
    }
}
