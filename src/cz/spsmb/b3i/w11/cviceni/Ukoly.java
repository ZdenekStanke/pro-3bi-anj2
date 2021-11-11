package cz.spsmb.b3i.w11.cviceni;
//Napište statickou metodu void serad(int[] x, int[] y),
// která seřadí pole x do pole y vzestupně

import java.util.Random;

//Napište statickou metodu int sude(int[] x, int[] y),
// která zkopíruje z pole x do pole y jen prvky se sudou hodnotou
// a vrátí počet těchto prvků
public class Ukoly {
    public static void serad(int[] x, int[] y){

    }
    public  static int sude(int[] x, int[] y){
        int out = 0;

        return out;
    }

    public static void main(String[] args) {
        final int N = 100;
        //inicializace polí
        Random rnd = new Random();
        int[] x = new int[N];
        for (int i = 0; i < x.length; i++) {
            x[i]=rnd.nextInt(1000);
        }
        //inicializace výstupního pole
        int[] y = new int[N];
        //volání metod

        //kontrola

    }
}