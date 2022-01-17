package cz.spsmb.b3i.w20.vyjimky;
// Všechny výjimky implementují rozhraní Throwable
// Třída Error - věc JVM (interpreter Javy) - neumíme na
// ně reagovat. Př. OutOfMemoryError

// Třída Exception - kotrolované (checked) výjimky. Jsme nuceni
// se o ně postarat (tzv. ošetřit). Jsou to synchronní výjimky,
// pouze u některých metod. Typicky vstupně výstupní (IO) operace.
// Naše vlastní výjimky budou vždy synchronní

// Třída RuntimeException - asynchronní výjimky. Př.: ArithmeticException,
// NumberFormatException, ... Mohou se vyskytnout kdekoliv. Překladač
// nás nenutí na ně reagovat. Př.: "Zadej počet cihel: ", odpověď:
// "je mi to putna"

//Možnosti ošetření výjimky:
// 1. předání výjimky výše do nadřazené úrovně. Jedná se o tzv.
// propagaci, resp. šíření výjimek. Metoda, kde se výjimka ocitla
// se zříká odpovědnosti za její zpracování. Toto předání
// odpovědnosti se deklaruje  již v hlavičce metody pomocí klíčového
// slova throws. Viz případ dole. Řešení problému, co s vzniklou
// výjimkou se tak odsouvá na později...

import java.io.File;
import java.util.Scanner;

public class VyjimkyUvod {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        Scanner sc = new Scanner(new File("cisla.txt"));
        System.out.println("Precte neco ze souboru");
        int i = sc.nextInt();
        System.out.println("Cislo je: " + i);
    }
}
