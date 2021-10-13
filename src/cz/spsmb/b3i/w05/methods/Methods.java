package cz.spsmb.b3i.w05.methods;

import java.util.Scanner;

public class Methods {
    public class Main {
        //Proměnné třídy - třída představuje 1 prostor jmen. implicitní inicializace primitivních typů
        //na 0, resp. false
        //private static int cislo=0; - není třeba, 0 se inicializuje automaticky u proměnných tříd narozdíl od lokálních p.
        private static int cislo;
        private static Scanner sc = new Scanner(System.in);

        //proměnné metod - lokální proměnné
        //-platnost od místa deklarace do konce metody, resp. bloku
        //-nejsou automaticky inicializovány
        //-při zastínění nelokálních promměných lokálními používat plně kvalifikované jméno (zde Main.)
        private static int vratCislo(int a) {
            int cislo = a;//lokální proměnná číslo;
            //return cislo;
            return Main.cislo;//použití plně kvalifikovaného jména
        }

        private static int max(int a, int b) {
            return (a > b) ? a : b;
        }

        //metoda bez paramterů
        private static int secti() {
            return Main.sc.nextInt() + Main.sc.nextInt();
        }

        //metoda bez návratového typu
        private static void tiskni(int a) {
            System.out.println(a);
        }

        //metoda s více parametry různých typů - doporučuje se max 5
        //přetěžování metod - metody mají stejná jména, ale jinak parametry
        // (počet, typ, pořadí) - příklad metoda secti, nebo metoda ctverec
        private static double secti(final int a, final double b) {
            return a + b;
        }


        //rekurzivní metody - faktorial
        private static long faktorial(long n) {
            if (n > 1) {
                return faktorial(n - 1) * n;
            } else {
                return 1;
            }
        }

        //rekurzivní metody - Fibbonaciho posloupnost (0,1,1,2,3,5,8...) - odstrrašující případ
        private static long fibbonaci(final int n) {
            if (n < 2) {
                return n;
            } else {
                return fibbonaci(n - 1) + fibbonaci(n - 2);
            }
        }

        //předávání parametrů primitivních typů metodě - vždy hodnotou
        private static int zmena(/*final*/ int i) {
            //int j=i;
            i++;
            return i;
        }

        public static void main(String[] args) {
            int i = 1;
            //System.out.println(cislo);
        /*System.out.println(i);//1
        System.out.println(zmena(i));//2
        System.out.println(i);//1*/
            //System.out.println(MojeMetodz.ctverec(10));
        /*for(int i=0;i<100;i++) {
            System.out.format("f(%d)=%d%s",i,fibbonaci(i),((i%10)==0)?"\n":" ");
        }*/
            //System.out.println(faktorial(35));
            //sc.
            //System.out.println(Main.max(1,8));
            System.out.println(secti());
            //int a=50;
            //tiskni(a);

        }
    }
}
