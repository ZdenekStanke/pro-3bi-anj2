package cz.spsmb.b3i.w34.regex;

public class FNahrazovani {
    public static void main(String[] args) {
        String s1 = "5 * x^3 - 6 * x^1 + 1";
        String replaced = s1.replaceAll("(:?\\d+) \\* x\\^(:?\\d+)", "$1x<sup>$2</sup>");
        System.out.println(replaced);

        String s2 = "www.seznam.cz";
        //nepojmenovaná skupina
        System.out.println(s2.replaceAll("^([0-9a-z]+.[0-9a-z]+).[0-9a-z]+", "$1.com"));
        //pojmenovaná skupina
        System.out.println(s2.replaceAll("^(?<site>[0-9a-z]+.[0-9a-z]+).[0-9a-z]+", "${site}.com"));
    }
}
