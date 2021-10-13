package cz.spsmb.b3i.w05;

import java.util.Scanner;

public class Excercises02 {
    public class Main {
        //Napište program, který přečte celé číslo typu long a vypíše jeho jednotlivé číslice oddělené dvěma mezerami
        //

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
        /*long in = sc.nextLong();
        //long ma max 20 cislic
        final int N_PLACES_LONG=20;
        //dame do pole jednotlive cislice
        int ar[] = new int[N_PLACES_LONG];
        long tmp;
        for (int i = ar.length-1; i >=0 ; i--) {
            //prvni zjistim cislici nejvyssiho radu (10^i)
            ar[i] = (int) (in/Math.pow(10,i));
            System.out.format("%d  ",ar[i]);
            //do in dam zbytek po deleni (10^i)
            in %= Math.pow(10,i);
        }*/
            //Napište program, který přečte celé číslo typu int a vypíše jeho binární hodnotu
        /*int in = sc.nextInt();
        int tmp;
        boolean[] bitArray = new boolean[32];//int je 32 bitovy
        for (int i = bitArray.length-1; i >=0 ; i--) {
           //konkretni bit zjistim vydelenim 2^i
            //int dvenaitou = (int)Math.pow(2,i);
            int dvenaitou = 1<<i;
            //bitArray[bitArray.length-1-i] = (in/(int)Math.pow(2,i)) > 0 ? true:false;
            //in %= Math.pow(2,i);
            //bitArray[bitArray.length-1-i] = (in/(1<<i)) > 0 ? true:false;
            //in %= (1<<i);
            bitArray[bitArray.length-1-i] = (in/dvenaitou) > 0 ? true:false;
            in %= dvenaitou;
        }
        System.out.println(Arrays.toString(bitArray));
        for(boolean val:bitArray){
            System.out.format("%d",val?1:0);
        }*/
            //Napište program, který přečte celé číslo typúu long složené jen z nul a jedniček,
            //které bude chápáno jako binární číslo. Vypište dekadicky hodnotu tohoto čísla.
            long in = sc.nextLong();
            //long ma max 20 cislic
            final int N_PLACES_LONG=20;
            int out = 0;
            int ar[] = new int[N_PLACES_LONG];
            for (int i = ar.length-1; i >=0 ; i--) {
                //prvni zjistim cislici nejvyssiho radu (10^i)
                ar[i] = (int) (in/Math.pow(10,i));
                out += ar[i]>0?(1<<i):0;
                //do in dam zbytek po deleni (10^i)
                in %= Math.pow(10,i);
            }

            System.out.format("%d%n",out);
        }
    }
}
