package cz.spsmb.b3i.w08.Cviceni;

import java.util.Scanner;

//Existují slova, která se čtou zleva doprava i zprava doleva stejně
// (např. radar).
//Napište program, který bude tato slova generovat z jejich
// první poloviny zadané
// z klávesnice.
public class GeneratorSlov {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer halfPalindrom = new StringBuffer(sc.nextLine());
        StringBuffer palindrom = new StringBuffer();
        palindrom.append(halfPalindrom);
        palindrom.append(halfPalindrom.reverse().deleteCharAt(0));
        System.out.println(palindrom);
    }
}
