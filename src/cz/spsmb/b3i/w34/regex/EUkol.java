package cz.spsmb.b3i.w34.regex;

// Napište regulární výraz, který vybere libovolnou adresu formátu IPv6.
// Např. 2345:0425:2CA1:0000:0000:0567:5673:23b5
// Rozšiřte i na následující platné formáty:
// 2001:0db8:0000:0000:0000::1428:57ab
// 2001:0db8:0:0:0:0:1428:57ab
// 2001:0db8:0:0::1428:57ab
// 2001:0db8::1428:57ab
// 2001:db8::1428:57ab

// Napište RV, který z textu vybere
// a)   tel či telefon.
// b)   telefon či telefax
// c)   čísla 0 až 99
// d) 	letopočty 1900-2099
// e)   řetězec, který končí znakem 0 (nula), kterému předchází minimálně jedna číslice
// f)   česká telefonní čísla (začínají +420)

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EUkol {
    public static void main(String[] args) {
        String regex = "";
        String input = "This is the list: 2345:0425:2CA1:0000:0000:0567:5673:23b5";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int matchCount = 0;
        while (matcher.find()) {
            matchCount++;
            System.out.printf("Match count: %s, Group Zero Text: '%s'%n", matchCount,
                    matcher.group());
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.printf("Capture Group Number: %s, Captured Text: '%s'%n", i,
                        matcher.group(i));
            }
        }
    }
}
