package cz.spsmb.b3i.w04;
import java.util.Scanner;
public class Methods {
    public class Main {
        //proměnná třídy:
        //inicializují se v Javě vždy na 0, případně False
        //private static int promennaTridy01 = 0; //nemusí být
        private static int promennaTridy01;
        private static Scanner sc = new Scanner(System.in);
        private static void tiskniPromennouTridy(){
            int promennaTridy01=12; //lokální proměnná, neinicialiyuje se automaticky
            System.out.println(Main.promennaTridy01);
            System.out.println(promennaTridy01);//plně kvalifikované jméno (Main.)
        }
        //METODY
        //psát takové, které provádějí jasně specifikovanou činnost
        //délka metody by neměla překročit 20 řádků (Herout)
        //krátké jméno metody, výstižné, tvořené dle jednoho schématu v celém programu
        //např. otevriSoubor(), otevriOkno()
        //doporučuje se do max 5 parametrů
        //metoda s parametry, vracející typ int
        private static int min(int a, int b){
            return (a<b)?a:b;
        }
        //metoda bez parametrů
        private static int secti(){
            //Scanner sc = new Scanner(System.in);
            return Main.sc.nextInt()+Main.sc.nextInt();//S Main. plně kvalifikované jméno
        }
        //metoda bez návratového typu
        private static void tiskni(int a){
            System.out.println(a);
        }

        //metoda s více parametry různých typů - doporučuje se max 5
        //přetížená metoda - metoda se stejným názvem, ale s jinými parametry (počet, typ, pořadí)
        private static double secti(int a, double b){
            return a+b;
        }
        private static int secti2(int a, double b){
            return a+(int)b;
        }
        //rekurzivní metoda - lze vždy obejít, není nutné používat
        private static long faktorial(long n){
            if(n<=1){
                return 1;
            } else {
                return faktorial(n-1)*n;
            }
        }
        //Fibonnaciho posloupnost
        private static int f(int n){
            if(n<=1) return n;
            else return f(n-2)+f(n-1);
        }
        //Předávání parametrů metodám (primitivní datové typy)
        //final v parametru metody znemožňuje změnu proměnné v těle metody
        private static int zmena(final int i){
            int z = i;
            z++;
            return z;
        }
        private static int ctverec(int a){
            return a*a;
        }
        private static long ctverec(long a){
            return a*a;
        }
        private static double ctverec(double a){
            return a*a;
        }

        public static void main(String[] args) {
            int i=1;
            tiskniPromennouTridy();
        /*System.out.println(ctverec(2));
        System.out.println(ctverec(500L));
        System.out.println(ctverec(0.6354500));
        System.out.println(zmena(i));
        System.out.println(i);
*/


            //System.out.println(min(7,1));
            //System.out.println(secti());
            //    Main.tiskni(11);
            long n=61;
            //System.out.format("%d! = %d%n",n, faktorial(n) );
            //for(int i=0; i<100; i++){
            //    System.out.format("%d%s",f(i),(i%10!=0)?" ":"\n");
            //}
            //System.out.println(Main.secti2(123,1e9));
        }
    }
}
