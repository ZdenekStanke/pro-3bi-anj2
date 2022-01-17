package cz.spsmb.b3i.w20.vyjimky;

import java.io.File;
import java.util.Scanner;

public class VyjimkyUvod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new File("cisla.txt"));
        System.out.println("Precte neco ze souboru");
        int i = sc.nextInt();
        System.out.println("Cislo je: " + i);
    }
}
