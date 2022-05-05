package cz.spsmb.b3i.w34.regex;

import java.util.Arrays;

public class AUvod {
    // S regulárními výrazy jsme se setkali v cz.spsmb.b3i.w07.excercise02.Strings_. Jejich účel je vybrat, či označit
// část řetězce.

        public static void main(String[] args) {
            //Rozdělení řetězce na podřetězce (parsování) metoda .split()
            //výsledkem je pole Strigů
            String radka = "123 45 6 789";
            String radka2 = "123;45;6;789";
            String[] podretezce = radka.split(" ");
            String[] podretezce2 = radka.split(";");
            System.out.println(Arrays.toString(podretezce));
            System.out.println(Arrays.toString(podretezce2));
            //Úvod do regulárních výrazů
            //plné použití regulárních výrazů - viz balík java.util.regex.*
            //Množinu znaků, která mě zajímá dávám do []
            //mimo tyto závorky platí
            //. -- jakýkoliv znak
            //+ -- jedno, či více opakování předchozího znaku
            //* -- žádné, či libovolné opakování předchozího znaku
            //? -- žádné, či jedno opakování předchozího znaku
            // \p{Alpha} -- malá a velká písmena, dá se zapsat i jako [A-Za-z]
            // \p{Digit} -- číslice, dá se zapsat i jako [0-9]
            // \p{Alnum} -- malá a velká písmena a číslice, dá se zapsat i jako [0-9A-Za-z]
            // \p{Space} -- bílé znaky (mezera, tab, \r, \n, nová stránka)
            String aaa = "jedna; dvě, tři/čtyři";
            String[] podretezce3 = aaa.split("[; ,/]+");
            System.out.println(Arrays.toString(podretezce3));
            String aaa2 = "123as56aAd654asd6345";
            System.out.println(Arrays.toString(aaa2.split("\\p{Alpha}+")));
            System.out.println(Arrays.toString(aaa2.split("[A-Za-z]+")));
        }
}
