package cz.spsmb.b3i.w07.excercise02;
//Řetězce
//String - konstatní , jednou inicializovaný String nelze měnit, rychlé
//StringBuffer - měnitelný, pomalejší.


import java.util.Arrays;
import java.util.Locale;

public class Strings_ {
    public static void main(String[] args) {
        //vytvoření řetězce:
        String s = "ahoj"; // netřeba operátor new
        String s1, s2, s3, s4, s5, s6, s7;
        byte[] bajty = {(byte) 'E', (byte) 'v', (byte) 'a'};
        char[] znaky = {'M', 'a', 'r', 't', 'i', 'n', 'a'};
        StringBuffer buf = new StringBuffer("Dobry den");

        s1 = new String("Ahoj");//Ahoj
        s2 = new String(s1);//Ahoj
        //Pole bajtů je kódavé 8bitově. Převod na unicode závisí na nastaveném kódování
        s3 = new String(bajty);//Eva
        //Počáteční index, délka
        s4 = new String(bajty, 1, 2);//va
        s5 = new String(znaky);//Martina
        //Počáteční index, délka
        s6 = new String(znaky, 3, 4);//tina
        s7 = new String(buf);//Dobry den

        System.out.format("s1:%s, s2:%s, s3:%s, s4:%s, s5:%s, s6:%s, s7:%s%n",
                s1, s2, s3, s3, s4, s5, s6, s7);

        //délka řetězce - metoda
        //.length()

        //Práce s řetězci:
        //porovnání dvou řetězců: Vrací záporné číslo, pokud je řetězec v parametru metody
        //větší, v případě shody 0, kladné číslo pokud je řetězec lexikograficky menší
        System.out.println(s1.compareTo(s5));
        System.out.println("a".compareTo("A"));
        //Totéž, ale nerozlišují se velká a malá písmena:
        System.out.println("a".compareToIgnoreCase("A"));
        //Vrátí true, pokud jsou řetězce shodné:
        System.out.println("jedna".equals("jedna"));
        System.out.println("jedna".equalsIgnoreCase("JEDna"));
        //Nelze porovnávat pomocí operátoru == To porovná yda jde o stejnou instanci
        System.out.println(s1==s1); //true
        System.out.println(s1==s2); //false

        //Převody na malá a velká písmena:
        System.out.println("ěýžaaSA".toLowerCase());
        System.out.println("aaSAŠÁ".toUpperCase());

        //Spojování řetězců:
        String s11 = "mala a ";
        String s12 = "VELKA";
        s3 = s11 + s12; //mala a VELKA
        s4 = s11.concat(s12);
        System.out.format("s3:%s%nS4:%s%n", s3, s4);

        //Náhrada znaků v řetězci:
        s1 = "cacao";
        s2 = s1.replace('c', 'k');
        System.out.println(s2);
        //Části řetězce - v s3 je "mala a VELKA"
        //podřetězec od indexu 5, indexuje se od 0
        s2 = s3.substring(5);//a VELKA
        //od indexu5 do indexu 9, který se však nezapočítává <idxFrom, idxTo)
        s1 = s3.substring(5, 9); //a VE
        System.out.format("s2:%s%ns1:%s%n", s2, s1);

        //porovnání začátku a konce řetězce:
        System.out.format("s3 zacina na mala:%b%ns3 konci na VELKA:%b%n", s3.startsWith("mala"),
                s3.endsWith("VELKA"));

        //oříznutí bílých znaků zleva i zprava
        String s10 = "\r\n\t ahoj\t \r\n";
        s2 = s10.trim();
        System.out.format("s10:|%s|%ns2:|%s|%n", s10, s2);

        //Získání znaku pomocí .charAt(idx) známe z třídy Scanner
        //v s3 je "mala a VELKA"
        System.out.println(s3.charAt(7));//V

        //Hledání znaku zleva
        int i = s3.indexOf('a');//1
        System.out.println(i);
        //Hledání znaku zprava
        i = s3.lastIndexOf('a');//5
        System.out.println(i);

        //Konverze základnách datových typů na řetězec
        String s20 = String.valueOf(i);
        //DALŠÍ MOŽNOST
        String s21 = "" + i;
        System.out.println(s20);
        System.out.println(s21);

        //Tisk do řetzězce:
        //String.format() - identická s System.out.format()

        //Konverze řetězce na základní datové typy:
        //pomocí ObalováTřída.xxxValue:
        double d1 = Double.valueOf("3.14").doubleValue();
        //další možnost pomocí ObalováTřída.parseXXX() - výhodnější (rychlejší),
        //neboť nevzniká další objekt
        double d2 = Double.parseDouble("123.5");

        //Vyvolání více metod jedním příkazem
        String s22 = "\r\n\t cacao\t \r\n";
        i = s22.trim().toUpperCase().substring(2).indexOf('O');//2
        System.out.println(i);

        //Dělení řetězce na části pomocí metody .split() - tzv. parsování
        String radka = "123 45 6 789";
        String[] podretezce = radka.split(" ");
        System.out.println(Arrays.toString(podretezce));


    }
}
