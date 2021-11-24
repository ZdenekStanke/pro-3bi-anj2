package cz.spsmb.b3i.w11.cviceni;
//Napište statickou metodu void serad(int[] x, int[] y),
// která seřadí pole x do pole y vzestupně

import java.util.Arrays;
import java.util.Random;

//Napište statickou metodu int sude(int[] x, int[] y),
// která zkopíruje z pole x do pole y jen prvky se sudou hodnotou
// a vrátí počet těchto prvků
public class Ukoly {
    public static void serad(int[] x, int[] y){
        for (int i = 0; i < x.length; i++) {
            y[i] = x[i];
        }
        int p = 0;
        for(int i=0;i< y.length-1;i++)
        {
            //někdo používal místo y.length-i-1 toto: y.length-1
            //zbytečně řadil již seřazené položky. Srovnejte obě verze běhů
            //pomocí měření doby běhu programu
            for(int j=0;j< y.length-i-1;j++)
            {
                if (y[j]>y[j+1])
                {
                    p=y[j];
                    y[j]=y[j+1];
                    y[j+1]=p;
                }
            }
        }
    }
    public  static int sude(int[] x, int[] y){
        int out = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 == 0) {
                y[i] = x[i];
                out++;
            }
        }
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
        Ukoly.serad(x,y);
        //kontrola
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}