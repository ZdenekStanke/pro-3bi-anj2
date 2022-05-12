package cz.spsmb.b3i.w34.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Regulární výrazy - https://regex101.com/
// skupiny znaků
// [abc]            - nalezení jednoho znaku uvedeného uvnitř závorek
// [^abc]           - nelezení jednoho znaku neuvedeného uvnitř závorek
// [0-9]            - nalezení jedné číslice
// [a-zA-Z]	        - a až z nebo A až Z, včetně (rozsah)
// [a-d[m-p]]	    - a až d, nebo m až p: [a-dm-p](sjednocení)
// [a-z&&[def]]	    - d, e, nebo f (průnik)
// [a-z&&[^bc]]	    - a až z, kromě b ac: [ad-z](rozdíl)

// metaznaky
// |                - nalezení jednoho z patternů oddělených |. Např.: cat|dog|fish
// .                - libovolný znak

// hranice
// ^                - začátek řetězce
// $                - konec řetězce
// \b               - začátek slova (\bWORD), nebo konec slova (WORD\b)
// \B	            - opak hranice slova (negace)

// předdefinované skupiny znaků
// \d               - číslice [0-9]
// \D               - cokoliv jiného, než číslice [^0-9]
// \s               - bílý znak (cokoliv, co není vidět) [ \t\n\x0B\f\r]
// \S               - opak bílého znaku [^\s]
// \w	            - slovo: [a-zA-Z0-9]
// \W               - opak slova [^\w]

// \\uxxxx           - nalezení unicode znaku, specifikovaného pomocí hexadecimálního čísla

// kvantifikátory - určují počet opakování
// n+               - jedno nebo více n (greedy)
// n+?               - jedno nebo více n (non-greedy)
// n*               - nula nebo více n  (greedy)
// n*?               - nula nebo více n  (non-greedy)
// n?               - nula nebo jedno n
// n{x}             - přesně x n za sebou
// n{x,y}           - x až y n za sebou
// n{x,}            - x a více n za sebou

// greedy (chamtivý) vs non-greedy (líný) kvantifikátor
// greedy           - standartní chování (např.: .*), označí nejdelší možný řetězec
// non greedy       - po přidání otazníku (např.: .*?), označí nejkratší možný řetězec

// logické spojky
// XY	            - X ihned za Y
// X|Y	            - X neboY

// seskupování:
// (X)                - skupina, slouží k zapamatování při nahrazování pomocí \1 až \\n/p>
//                      reference při nahrazování pomocí $n
// (?'jmeno_skupiny') - pojmenování skupiny. V Javě potřeba použít (?<jmeno_skupiny>)
//                      reference pak pomocí \k<name>, resp. ${name}
// (?:X)              - seskupí, ale nezapamatuje

// příklady:
// .*1
// \bpro\b
// \b(a|i|o|u)\b
// \d+\.\d+\.\d+\.\d+
// \d{1,3}\.){3}\d{1,3}
// http://[a-zA-Z_.]+
//  (http://)?w{3}[a-zA-Z_.]+\.cz
// [a-zA-Z_.]+@[a-zA-Z_.]+
//  <p>.*<\/p>      pro greedy/lazy <p>Hello</p><span>Awesome</span><p>World</p>



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
