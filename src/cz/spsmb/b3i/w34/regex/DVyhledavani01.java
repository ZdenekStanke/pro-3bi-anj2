package cz.spsmb.b3i.w34.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVyhledavani01 {
    public static void main(String[] args) {
        String regex = "\\b([A-Za-z\\s]+),\\s([A-Z]{2,2}):\\s([0-9]{3,3})\\b";
        String input = "This is the list: Baytown, TX: 281, Chapel Hill, NC: 284, "+
                "Fort Myers, FL: 239";

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
