package cz.spsmb.b3i.w34.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Regulární výrazy - https://regex101.com/
// [abc]            - nalezení jednoho znaku uvedeného uvnitř závorek
// [^abc]           - nelezení jednoho znaku neuvedeného uvnitř závorek
// [0-9]            - nalezení jedné číslice

// Metaznaky
// |                - nalezení jednoho z patternů oddělených |. Např.: cat|dog|fish
// .                - libovolný znak
// ^                - začátek řetězce
// $                - konec řetězce
// \d               - číslice
// \D               - cokoliv jiného, než číslice
// \s               - bílý znak (cokoliv, co není vidět)
// \b               - začátek slova (\bWORD), nebo konec slova (WORD\b)
// \\uxxxx           - nalezení unicode znaku, specifikovaného pomocí hexadecimálního čísla

// kvantifikátory - určují počet opakování
// n+               - jedno nebo více n
// n*               - nula nebo více n
// n?               - nula nebo jedno n
// n{x}             - přesně x n za sebou
// n{x,y}           - x až y n za sebou
// n{x,}            - x a více n za sebou



public class BMatcher {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("w3schools"/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher("Visit W3Schools!");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
