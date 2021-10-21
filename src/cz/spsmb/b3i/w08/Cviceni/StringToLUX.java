package cz.spsmb.b3i.w08.Cviceni;

import java.util.Scanner;

//Napište program, který přečte řetězec a v závislosti na jeho posledním znaku provede:
//l (L) - převod řetězce na malá písmena (lower)
//u (U) - převod řetězce na velká písmena (upper)
//x (X) - prohození malých a velkých písmen (exchange)
//Změny proveďte v řetězci, nikoliv jen na výstupu
public class StringToLUX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("zadej písmena: ");
        String slovo = sc.nextLine().trim();
        char []pismena=slovo.toCharArray();
        char posledniPismeno = pismena[pismena.length-1];
        if (posledniPismeno=='l'||posledniPismeno=='L'){
            slovo=slovo.toLowerCase();
            System.out.println(slovo);
        }
        else if(posledniPismeno=='u'||posledniPismeno=='U'){
            slovo=slovo.toUpperCase();
            System.out.println(slovo);
        }
        else if(posledniPismeno=='x' || posledniPismeno=='X') {

            for (char item:pismena) {
                if (Character.isUpperCase(item)){
                    System.out.print(Character.toLowerCase(item));
                }
                else{
                    System.out.print(Character.toUpperCase(item));
                }
            }
        }
    }
}
