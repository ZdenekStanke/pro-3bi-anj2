package cz.spsmb.b3i.w25.databaze;

public class Questions {

    public static String[][] question1() {
        String[][] quest1 = new String[5][5];

        quest1[0][0] = "U koho sloužil poprvé Švejk jako vojenský sluha:";
        quest1[0][1] = "U polního kuráta Katze"; //correct answer
        quest1[0][2] = "U plukovníka Bedřicha Krause";
        quest1[0][3] = "U nadporučíka Lukáše";
        quest1[0][4] = "U generálmajora von Schwarzburga";

        quest1[1][0] = "Co je narkóza:";
        quest1[1][1] = "Uspání"; //correct answer
        quest1[1][2] = "Zánět žil";
        quest1[1][3] = "Odběr krve";
        quest1[1][4] = "Mrtvice";
        return quest1;
    }
}